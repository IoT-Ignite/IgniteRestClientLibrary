# IgniteRestClientLibrary
A useful Retrofit based Android library for REST API calls.

## Usage

Get **IgniteRestClientManager** instance by passing application context.

`mIgniteRestClientManager = IgniteRestClientManager.getInstance(appContext);`


Then user your login credentials to create rest client.

` mIgniteRestClient = mIgniteRestClientManager.createClient(user, password, true);`


The third parameter refreshes access token automatically. If handle it yourself just pass it **false**.
