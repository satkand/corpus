#!/usr/bin/python

import requests
import json
import os
import csv
import sys
from dotenv import load_dotenv

'''
Author	: Calum Hunter
Date	: 21-06-2018
Version : 0.1.2

 This script gives you the build_url from hockeyapp with the "build_number-environment" version tag.
   It is designed to be run within Jenkins build environment.
   Usage example: 
     ./get_hockeyapp_url.py PipeLine(A/B) Platform(iOS/Android) JenkinsBuildNumber
     ./get_hockeyapp_url.py a ios 1549
   The arguments are what hockeyapp appends to the end of the build version.
   In the example above, the build URL would be returned for iOS build 1549 from the iOS-app-QA jenkins pipeline

CHANGES:
21-06-18: Handle cases where downloads have been disabled for a particular build in hockeyapp
          display an error indicating the failure mode, as well as the full json output for that build for debug purposes.
   
'''

# Global Variables
debug = False
hockeyapp_api_url = "https://rink.hockeyapp.net/api"
hockeyapp_title = "Marketplace"
hockeyapp_api_version = "2"
default_proxy = "http://127.0.0.1:3128"

# ========= Functions ============ #
# Output debug messages if debug mode is enabled
def log(message):
	if debug == True:
		print ("%s") % message

def handle_arguments(arguments):
	if len(arguments) < 4:
		print "[ERROR] - Insufficient arguments supplied."
		useage_help()
	elif len(arguments) > 4:
		print "[ERROR] - Too many arguments supplied."
		useage_help()

def useage_help():
	print ""
	print "Useage:"
	print "Provide the release stream 'a' or 'b' then the platform name 'android' or 'ios' then the build number ie: '302' as arguments."
	exit(1)

def get_all_apps(token, api_url, api_version, proxy_var):
	url = api_url + '/' + api_version + '/apps'
	headers = {'X-HockeyAppToken' : token}
	proxies = {
				"http" : proxy_var,
				"https" : proxy_var,
			}
	request = requests.get(url, headers=headers, proxies=proxies)
	response = json.loads(request.text)
	log(("[DEBUG] - API response status code: %s") % request.status_code)
	return response

def get_public_id(json_data, app_name):
	log(("[DEBUG] - Searching response for app with name: %s") % app_name)
	for app in json_data['apps']:
		log(("[DEBUG] - Found app: %s") % app['title'])
		if app_name in app['title']:
			public_id = app['public_identifier']
			log(("[DEBUG] - MATCH! Located our app: %s") % app_name)
			log(("[DEBUG] - Getting public ID for app %s ") % app_name)
			log(("[DEBUG] - Public ID: %s") % public_id)
			break
		else:
			log(("[DEBUG] - No match, next."))	
	if public_id is not None:
		return public_id
	else:
		print("[ERROR] - Unable to locate a public ID for app: %s") % app_name
		sys.exit(1)

def get_all_versions(token, api_url, api_version, proxy_var, public_id):
	# set up a request to get a list of all versions for our app
	url = api_url + '/' + api_version + '/apps/' +  public_id + '/' + 'app_versions'
	headers = {'X-HockeyAppToken' : token}
	params = {'include_build_urls' : 'true'}
	proxies = {
				"http" : proxy_var,
				"https" : proxy_var,
			}
	request = requests.get(url, headers=headers, params=params, proxies=proxies)
	response = json.loads(request.text)
	log(("[DEBUG] - API response status code: %s ") % request.status_code)
	#print(json.dumps(response, indent=4, sort_keys=True))
	return response

# Note that we are only going to search through the first 500 results, we are not going to handle
# paging
def search_for_version(all_app_versions, jenkins_build_number, version_key, stream_tag):
	# define the matched_version var and make it none, it'll get populated later if we have a match
	matched_version = None
	search_term = jenkins_build_number + '-' + stream_tag
	#search_term = jenkins_build_number
	# log for debug
	log(("[DEBUG] - Searching for: %s") % search_term)
	# Loop through all the returned app builds/versions
	# if we find one whos 'shortversion' string contains the build
	# and stream tag we should display that result
	for version in all_app_versions['app_versions']:
		if version[version_key].find(search_term) != -1: 
		# -1 will be returned if search_term is not in version['version_key']
			matched_version = version
			break
	# if we have gone through every returned result but haven't broken out of the loop
	# it means we did not set the value of matched_version so we can use that to check if we
	# should return our result or just bail out and let the people know we didnt find a match
	if matched_version is not None:
		# Prettify the output for debug
		#if debug == True:
		#log(json.dumps(version, indent=4, sort_keys=True)) 
		return matched_version
	else:
		print ("[ERROR] - Unable to locate an app whose %s matches search string: %s") % (version_key,search_term)
		print ("[ERROR] - This could be because you are searching for a build that is very old, we search through the last 500 builds")
		sys.exit(1)

# This is disabled for now, the use of a top is unlikely to be required and provides inconsistent reults
#def return_top_result(all_app_versions, stream_tag):
#	return all_app_versions['app_versions'][1]

# ============= Start Script ================= #
# Sanity check the passed in arguments
handle_arguments(sys.argv)
# Assign the arguments to vars
pipeline = sys.argv[1]
pipeline = pipeline.lower()
platform = sys.argv[2]
platform = platform.lower()
jenkins_build_number = sys.argv[3]

# I did not choose this qa vs uat thing.
if platform == 'android':
	version_key = 'shortversion'
	if pipeline == 'a':
		stream_tag = 'QA'
		hockey_app_token_key = 'HOCKEYAPP_QA_API_TOKEN'
		jenkins_pipeline_name = 'Suncorp-Android-app-QA'
	elif pipeline == 'b':
		stream_tag = 'UAT'
		hockey_app_token_key = 'HOCKEYAPP_REL_API_TOKEN'
		jenkins_pipeline_name = 'Suncorp-Android-app-release'
elif platform == 'ios':
	version_key = 'version'
	if pipeline == 'a':
		stream_tag = 'QA'
		hockey_app_token_key = 'HOCKEYAPP_IOS_QA_API_TOKEN'
		jenkins_pipeline_name = 'Suncorp-iOS-app-QA'
	elif pipeline == 'b':
		stream_tag = 'UAT'
		hockey_app_token_key = 'HOCKEYAPP_IOS_REL_API_TOKEN'
		jenkins_pipeline_name = 'Suncorp-iOS-app-release'

# Set the workspace folder
# Use the environmental variable if it exists
# Else use the current working dir
if os.getenv("WORKSPACE") is not None:
	workspace_folder = os.getenv("WORKSPACE")
	workspace_var = "ENV"
else:
	workspace_folder = os.getcwd()
	workspace_var = "Current Working Dir"
log(("[DEBUG] - Workspace var derived from: %s") % workspace_var)
log(("[DEBUG] - Workspace folder: %s") % workspace_folder)

env_file_path = os.path.join(workspace_folder, '.env')
if debug:
	log(('[DEBUG] - Using .env file: %s') % env_file_path)
	load_dotenv(dotenv_path=env_file_path,verbose=True)
else:
	load_dotenv(dotenv_path=env_file_path)
# Set up the proxy server address
# try and load it from an environmental var, otherwise use the default proxy set here
if os.getenv("http_proxy") is not None:
	proxy_var_loaded = "ENV"
	proxy = os.getenv("http_proxy")
else:
	proxy_var_loaded = "Default"
	proxy = default_proxy
log(("[DEBUG] - Proxy server found from: %s") % proxy_var_loaded)
log(("[DEBUG] - Proxy server address: %s") % proxy)
log(("[DEBUG] - Platform: %s") % platform)
log(("[DEBUG] - Jenkins Build Pipeline Name: %s") % jenkins_pipeline_name)
log(("[DEBUG] - Build Number: %s") % jenkins_build_number)

# Get the hockey app token
log(("[DEBUG] - Retrieving HockeyApp token for stream: %s") % pipeline)

if os.getenv(hockey_app_token_key) is not None:
	hockeyapp_token = os.getenv(hockey_app_token_key)
	log(("[DEBUG] - Hockey App Token: %s") % hockeyapp_token)
else:
	print (("[ERROR] - Unable to locate value for key: %s") % hockey_app_token_key)
	print ("[ERROR] - Ensure that it is being provided as an ENV var through the use of the .env file or a globally accessible ENV variable.")   		

# Get a list of all apps on hockey app - there should be just one 'Marketplace'
apps = get_all_apps(hockeyapp_token, hockeyapp_api_url, hockeyapp_api_version, proxy)
# get the public id for our app so we can query the API using the public ID
public_id = get_public_id(apps, hockeyapp_title)
# return all the app versions or builds for our app (Marketplace)
all_app_versions = get_all_versions(hockeyapp_token, hockeyapp_api_url, hockeyapp_api_version, proxy, public_id)

log(("[DEBUG] - Version Key: %s") % version_key)

### Disabled as need for  top is unlikely.
# If we were asked to get the 'top' (as the jenkins build number) result then we should just return the top
# result, and not actually bother to search
#top = "top"
#if top.find(jenkins_build_number.lower()) != -1:
#	log("[DEBUG] - Request for the 'top' result.")
#	version_result = return_top_result(all_app_versions)
#else:
#	version_result = search_for_version(all_app_versions, jenkins_build_number, version_key, stream_tag)

version_result = search_for_version(all_app_versions, jenkins_build_number, version_key, stream_tag)

# Check that we actual get a build url returned from our JSON
# otherwise the download for this build is probably disabled in hockeyapp
if not 'build_url' in version_result:
	print (("[ERROR] - No BUILD URL returned for this build from hockeyapp." ))
	print (("[ERROR] - It is most likely that this build has the download disabled." ))
	print (("[ERROR] - Check that downloads are enabled for this build in hockey app and try again." ))
	print ((" "))
	print (("[ERROR] - The returned API response for this build is below:" ))
	print ((" "))
	print(json.dumps(version_result, indent=4, sort_keys=True))
	exit(1)

log(("[OK] - Jenkins Build Requested: %s") % jenkins_build_number)
log(("[OK] - API Returned Build Version: %s") % version_result[version_key])
log(("[OK] - Pipeline: %s") % jenkins_pipeline_name)
log(("[OK] - Hockey App Name: %s") % version_result['title'])
log(("[OK] - Uploaded date: %s") % version_result['created_at'])
log(("[OK] - Hockey App Build URL: %s") % version_result['build_url'])

# finally just return the build url as thats all we care about
print version_result['build_url']
#print(json.dumps(version_result, indent=4, sort_keys=True))

