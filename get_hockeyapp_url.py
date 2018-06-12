#!/usr/bin/python

import requests
import json
import os
import csv
import sys
from dotenv import load_dotenv

'''
Author	: Calum Hunter
Date	: 12-06-2018
Version : 0.1.0

 This script gives you the build_url from hockeyapp with the "build_number-environment" version tag.
   It is designed to be run within Jenkins build environment.
   Usage example: 
     ./get_hockeyapp_url.py QA 302
   The arguments are what hockeyapp appends to the end of the build version.
   In the example above, the build URL would be returned for Jenkins Build number 302
   of the QA (Android) stream
   For iOS, use UAT instead of QA

   If you wish to retrieve the 'latest' or top most build from hockey app, use 'top' instead of a build number
   ie:
   ./get_hockeyapp_url.py QA top

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
	if len(arguments) < 3:
		print "[ERROR] - Insufficient arguments supplied. You must supply both the stream name and the build number"
		useage_help()
	elif len(arguments) > 3:
		print "[ERROR] - Too many arguments supplied. You must supply the stream name and build number only"
		useage_help()

def useage_help():
	print ""
	print "Useage:"
	print "Provide the stream name ie: 'QA' or 'UAT' and the build number ie: '302' as arguments."
	print "you may also use the word 'top' instead of the build number if you wish to return the latest build"
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
	return response

# Note that we are only going to search through the first 500 results, we are not going to handle
# paging
def search_for_version(all_app_versions, jenkins_build_number):
	# define the matched_version var and make it none, it'll get populated later if we have a match
	matched_version = None
	# Loop through all the returned app builds/versions
	# if we find one whos 'shortversion' string contains the build
	# and stream name we were passed on the CLI, then we should display that result
	for version in all_app_versions['app_versions']:
		if version['shortversion'].find(jenkins_build_number) != -1: 
		# -1 will be returned if jenkins_build_number is not in version['shortversion']
			matched_version = version
			break
	# if we have gone through every returned result but haven't broken out of the loop
	# it means we did not set the value of matched_version so we can use that to check if we
	# should return our result or just bail out and let the people know we didnt find a match
	if matched_version is not None:
		# Prettify the output for debug
		log(json.dumps(version, indent=4, sort_keys=True)) 
		return matched_version
	else:
		print ("[ERROR] - Unable to locate an app whose 'shortversion' matches search string: %s") % jenkins_build_number
		print ("[ERROR] - This could be because you are searching for a build that is very old, we search through the last 500 builds")
		sys.exit(1)

def return_top_result(all_app_versions):
	return all_app_versions['app_versions'][0]

# ============= Start Script ================= #
# Sanity check the passed in arguments
handle_arguments(sys.argv)
# Assign the arguments to vars
build_stream = sys.argv[1]
jenkins_build_number = sys.argv[2]

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



# I did not choose this qa vs uat thing.
if build_stream.lower() == 'qa':
	platform = 'Android'
elif build_stream.lower() == 'uat':
	platform = 'iOS'

log(("[DEBUG] Platform: %s") % platform)
log(("[DEBUG] Build Stream: %s") % build_stream)
log(("[DEBUG] Build Number: %s") % jenkins_build_number)

# Get the hockey app token
# Yes for some reason even the iOS (UAT) .env file uses the same 'HOCKEYAPP_QA_API_TOKEN' variable name.
# The joys of OPC
if os.getenv("HOCKEYAPP_QA_API_TOKEN") is not None:
	hockeyapp_token = os.getenv("HOCKEYAPP_QA_API_TOKEN")
	log(("[DEBUG] - Hockey App Token: %s") % hockeyapp_token)
else:
	print ("[ERROR] - Unable to locate value for key: HOCKEYAPP_QA_API_TOKEN")
	print ("[ERROR] - Ensure that it is being provided as an ENV var through the use of the .env file or a globally accessible ENV variable.")   		

# Get a list of all apps on hockey app - there should be just one 'Marketplace'
apps = get_all_apps(hockeyapp_token, hockeyapp_api_url, hockeyapp_api_version, proxy)
# get the public id for our app so we can query the API using the public ID
public_id = get_public_id(apps, hockeyapp_title)
# return all the app versions or builds for our app (Marketplace)
all_app_versions = get_all_versions(hockeyapp_token, hockeyapp_api_url, hockeyapp_api_version, proxy, public_id)

# If we were asked to get the 'top' (as the jenkins build number) result then we should just return the top
# result, and not actually bother to search
top = "top"
if top.find(jenkins_build_number.lower()) != -1:
	log("[DEBUG] - Request for the 'top' result.")
	version_result = return_top_result(all_app_versions)
else:
	version_result = search_for_version(all_app_versions, jenkins_build_number)

log(("[OK] - Jenkins Build: %s") % jenkins_build_number)
log(("[OK] - App ID (build): %s") % version_result['id'])
log(("[OK] - Stream Name: %s") % build_stream)
log(("[OK] - App Name: %s") % version_result['app_owner'])
log(("[OK] - Uploaded at: %s") % version_result['created_at'])
log(("[OK] - Build URL: %s") % version_result['build_url'])

# finally just return the build url as thats all we care about
print version_result['build_url']




























































