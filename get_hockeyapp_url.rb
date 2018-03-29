#!/usr/bin/ruby
# This script gives you the build_url from hockeyapp with the "build_number-environment" version tag.
#   It is designed to be run within Jenkins build environment.
#   Usage example: 
#     ruby get_hockeyapp_url.rb "QA"
#   The arguments are what hockeyapp appends to the end of the build version.
#   Typically these are Dev, QA, or Release.
#   This script relies on the $BUILD_NUMBER and $WORKSPACE environment variables being set
# Assumptions: 
#   the returned json object from hockeyapp API contains a sorted list (sorted by timestamp) of all the versions of all the builds that you can access using the given token.  
require 'json'
require 'net/http'
require 'uri'

# Set variables.
hockeyapp_api_url = "https://rink.hockeyapp.net/api"
#hockeyapp_title = "Marketplace - OMQA"
hockeyapp_title = "Marketplace"

unless ENV['WORKSPACE'].nil?
	workspace_folder = ENV['WORKSPACE']
else
	workspace_folder = Dir.pwd
end

env_file_path = "#{workspace_folder}/.env"
env_file = File.read("#{env_file_path}")
default_proxy = "http://localhost:3128"
hockeyapp_api_version = "2"

# Usage help method. 
def usage_help()
  puts "Usage: ruby " + $PROGRAM_NAME + ' "BUILD_VERSION_TYPE" ' + '"BUILD_NUMBER_TO_SEARCH_FOR"'
  puts "BUILD_NUMBER_TO_SEARCH_FOR can be 'top'. This will return the top most result returned from hockeyapp"
  puts "Example: "
  puts "ruby " + $PROGRAM_NAME + ' "QA" ' + '"302"'
  exit
end

# Make sure we have 2 arguments and if not, exit with usage help message
def handle_arguments(arguments)
  if arguments.count < 2
    puts "Invalid or insufficient arguments supplied."
    usage_help
  elsif arguments.count > 2
    puts "Invalid or too many arguments supplied."
    usage_help
  else
    arguments
  end
end

# Extract a usable set of proxy details.
def extract_proxy_details(proxy_var, default)
  if "#{proxy_var}" =~ /\A#{URI::regexp(['http', 'https'])}\z/
    return URI("#{proxy_var}")
  elsif "#{proxy_var}".start_with?('localhost')
    return URI("http://#{proxy_var}")
  else
    return URI("#{default}")
  end
end

# Extracts the hockey app token out of the file passed to it.
def extract_hockeyapp_token(file)
  return file[/((?<=HOCKEYAPP_QA_API_TOKEN\=\")[0-9a-zA-Z]*)/]
end

# Get all apps in the list using the hockeyapp token.
def get_all_apps(token, api_url, api_version, proxy_var)
  url = URI.parse("#{api_url}/#{api_version}/apps")
  req = Net::HTTP::Get.new(url)
  req['X-HockeyAppToken'] = "#{token}"
  unless proxy_var.nil?
    res = Net::HTTP::Proxy((proxy_var.host + proxy_var.path), proxy_var.port).start(url.host, url.port,
    use_ssl: url.scheme == 'https') {|http| http.request req}
  else
    res = Net::HTTP.start(url.host, url.port,
    use_ssl: url.scheme == 'https') {|http| http.request req}
  end
  return res.body
end

# Go through json data and find public id if the title matches.
def get_public_id(json_data, title)
  data = JSON.parse("#{json_data}")
  for app in data['apps']
    return app['public_identifier'] if app['title'] == "#{title}"
  end
end

# Get all app versions from hockeyapp that use a particular public ID.
def get_all_versions(id, token, api_url, api_version, proxy_var)
  url = URI.parse("#{api_url}/#{api_version}/apps/#{id}/app_versions?include_build_urls=true")
  req = Net::HTTP::Get.new(url)
  req['X-HockeyAppToken'] = "#{token}"
  unless proxy_var.nil?
    res = Net::HTTP::Proxy((proxy_var.host + proxy_var.path), proxy_var.port).start(url.host, url.port,
    use_ssl: url.scheme == 'https') {|http| http.request req}
  else
    res = Net::HTTP.start(url.host, url.port,
    use_ssl: url.scheme == 'https') {|http| http.request req}
  end
  return JSON.parse(res.body)
end

# Find any build urls that match our build version.
def find_matching_build_url(json_data, version_to_match)
  json_versions = JSON.parse("#{json_data}")
  for version in json_versions['app_versions']
    return version['build_url'] if version['version'] == "#{version_to_match}"
  end
  return
end

# Find the top most build returned from hockeyapp API
def find_top_version(json_data)
  return JSON.parse(json_data)
end
# Run our functions.
parsed_arguments = handle_arguments(ARGV)
build_type = parsed_arguments[0]
jenkins_build_number = parsed_arguments[1]

unless ENV['http_proxy'].nil?
  environment_proxy = URI(ENV['http_proxy'])
  proxy = extract_proxy_details("#{environment_proxy}", "#{default_proxy}")
end
expected_build_version = "#{jenkins_build_number}-#{build_type}"
hockeyapp_token = extract_hockeyapp_token("#{env_file}")
all_apps_response = get_all_apps("#{hockeyapp_token}", "#{hockeyapp_api_url}", "#{hockeyapp_api_version}", proxy)
public_id = get_public_id("#{all_apps_response}", "#{hockeyapp_title}")
all_versions = get_all_versions("#{public_id}", "#{hockeyapp_token}", "#{hockeyapp_api_url}", "#{hockeyapp_api_version}", proxy)

if jenkins_build_number == "top"
  puts all_versions['app_versions'][0]['build_url']
else
  matching_versions = find_matching_build_url("#{all_versions}", "#{expected_build_version}")
  unless matching_versions.nil?
    puts matching_versions
  else
    puts "NOTSET"
  end
end
