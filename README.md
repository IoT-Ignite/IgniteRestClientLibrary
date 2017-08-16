# IgniteRestClientLibrary
A useful Retrofit based Android library for REST API calls.


## Add to Android Studio Project as External Module

To add the library your project just download the source and add the following to **settings.gradle**

`include ':igniterestclientlib'
project(':igniterestclientlib').projectDir = new File(settingsDir, 'path-to-project-module')`



And add it to your **module build.gradle** dependencies :

` compile project(':igniterestclientlib')`

Sync project and the library will be ready to use.


## Usage

Get **IgniteRestClientManager** instance by passing application context.

`mIgniteRestClientManager = IgniteRestClientManager.getInstance(appContext);`


Then user your login credentials to create rest client.

` mIgniteRestClient = mIgniteRestClientManager.createClient(user, password, true);`


The third parameter refreshes access token automatically. If handle it yourself just pass it **false**.
