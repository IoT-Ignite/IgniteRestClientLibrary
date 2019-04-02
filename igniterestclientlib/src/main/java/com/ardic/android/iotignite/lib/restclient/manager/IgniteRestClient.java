package com.ardic.android.iotignite.lib.restclient.manager;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.ardic.android.iotignite.lib.restclient.api.IgniteAPIService;
import com.ardic.android.iotignite.lib.restclient.api.TokenService;
import com.ardic.android.iotignite.lib.restclient.constant.Api;
import com.ardic.android.iotignite.lib.restclient.constant.ErrorMessages;
import com.ardic.android.iotignite.lib.restclient.constant.ResponseCode;
import com.ardic.android.iotignite.lib.restclient.exception.IgniteRestClientException;
import com.ardic.android.iotignite.lib.restclient.exception.IgniteRestClientThrowable;
import com.ardic.android.iotignite.lib.restclient.listeners.RefreshTokenTaskListener;
import com.ardic.android.iotignite.lib.restclient.model.AccessToken;
import com.ardic.android.iotignite.lib.restclient.model.ActionMessage;
import com.ardic.android.iotignite.lib.restclient.model.AppKey;
import com.ardic.android.iotignite.lib.restclient.model.CreateRestrictedUser;
import com.ardic.android.iotignite.lib.restclient.model.Device;
import com.ardic.android.iotignite.lib.restclient.model.DeviceNodeInventory;
import com.ardic.android.iotignite.lib.restclient.model.DromConfiguration;
import com.ardic.android.iotignite.lib.restclient.model.DromDevice;
import com.ardic.android.iotignite.lib.restclient.model.EndUser;
import com.ardic.android.iotignite.lib.restclient.model.HotspotConfigsData;
import com.ardic.android.iotignite.lib.restclient.model.LastThingData;
import com.ardic.android.iotignite.lib.restclient.model.MqttUserInfo;
import com.ardic.android.iotignite.lib.restclient.model.ModeAppsDTO;
import com.ardic.android.iotignite.lib.restclient.model.ModeCertificatesDTO;
import com.ardic.android.iotignite.lib.restclient.model.ModeContentsDTO;
import com.ardic.android.iotignite.lib.restclient.model.ModeConfigsDTO;
import com.ardic.android.iotignite.lib.restclient.model.PolicyCodeResource;
import com.ardic.android.iotignite.lib.restclient.model.PolicyStoreDTO;
import com.ardic.android.iotignite.lib.restclient.model.ShortcutConfigsData;
import com.ardic.android.iotignite.lib.restclient.model.SpecificDeviceInfoResult;
import com.ardic.android.iotignite.lib.restclient.model.SysUserInfo;
import com.ardic.android.iotignite.lib.restclient.model.ThingDataHistory;
import com.ardic.android.iotignite.lib.restclient.model.UserCreateCredentials;
import com.ardic.android.iotignite.lib.restclient.model.VpnConfigsData;
import com.ardic.android.iotignite.lib.restclient.model.WifiConfigsData;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yavuz.erzurumlu on 07/07/2017.
 */

public class IgniteRestClient implements RefreshTokenTaskListener {

    private static final String TAG = IgniteRestClient.class.getSimpleName();
    private boolean autoRefresh = true;
    private static final String AUTH_REQUEST_TOKEN = "Basic ZnJvbnRlbmQ6";
    private static final String GRANT_TYPE = "password";

    private Retrofit.Builder mRetrofitBuilder = new Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private Retrofit mRetrofit;

    private OkHttpClient.Builder httpClientBuilder;

    private Call<AccessToken> callAccess;

    private TokenService mTokenService;

    private IgniteAPIService mIgniteService;

    private AccessToken accessToken;
    private long refreshTimeInMillis = -1L;

    private String dromConfigId;

    private String username;
    private String password;

    private Runnable tokenWatchDog = new Runnable() {
        @Override
        public void run() {

            if (Api.DEBUG) {
                Log.i(TAG, "Refresh token watchdog on duty.");
            }
            refreshToken();

        }
    };

    private Handler tokenWatchdogHandler = new Handler(Looper.getMainLooper());


    private <S> S createTokenService(Class<S> serviceClass, final String authToken) {

        if (!TextUtils.isEmpty(authToken)) {
            httpClientBuilder = new OkHttpClient.Builder();
            ServiceAuthenticationInterceptor serviceAuthenticationInterceptor =
                    new ServiceAuthenticationInterceptor(authToken);

            if (!httpClientBuilder.interceptors().contains(serviceAuthenticationInterceptor)) {
                httpClientBuilder.addInterceptor(serviceAuthenticationInterceptor);

                mRetrofitBuilder.client(httpClientBuilder.build());
                mRetrofit = mRetrofitBuilder.build();
            }
        }

        return mRetrofit.create(serviceClass);
    }

    private <S> S createService(Class<S> serviceClass, final String token) {

        if (!TextUtils.isEmpty(token)) {
            ApiAccessAuthenticatorInterceptor apiAccessAuthenticatorInterceptor = new ApiAccessAuthenticatorInterceptor(token);
            httpClientBuilder = new OkHttpClient.Builder();

            if (!httpClientBuilder.interceptors().contains(apiAccessAuthenticatorInterceptor)) {
                httpClientBuilder.addInterceptor(apiAccessAuthenticatorInterceptor);
            }
        }
        httpClientBuilder.connectTimeout(Api.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(Api.READ_TIMEOUT, TimeUnit.SECONDS);

        mRetrofitBuilder.client(httpClientBuilder.build());
        mRetrofit = mRetrofitBuilder.build();

        return mRetrofit.create(serviceClass);
    }

    private IgniteRestClient(String userName, String userPassword, boolean autoRefreshToken) {
        this.autoRefresh = autoRefreshToken;
        this.username = userName;
        this.password = userPassword;
        mTokenService = createTokenService(TokenService.class, AUTH_REQUEST_TOKEN);
        callAccess = mTokenService.getAccessToken(GRANT_TYPE, userName, userPassword);
        mIgniteService = createService(IgniteAPIService.class, getAccessToken().getAccessToken());
        if (autoRefresh) {
            if (Api.DEBUG) {
                Log.i(TAG, "Scheduling refresh token handler...");
            }
            tokenWatchdogHandler.postDelayed(tokenWatchDog, refreshTimeInMillis);
        }
    }


    private synchronized AccessToken getAccessToken() throws IgniteRestClientException {

        int responseCode;
        try {
            Response<AccessToken> accessTokenResponse = callAccess.execute();
            responseCode = accessTokenResponse.code();
            if (responseCode == ResponseCode.SUCCESS) {
                accessToken = accessTokenResponse.body();
                if (accessToken != null) {
                    accessToken.setResponseCode(responseCode);

                    refreshTimeInMillis = (accessToken.getExpiresIn() * 1000) - 1000L;

                    if (Api.DEBUG) {
                        Log.d(TAG, "AccessToken: \n" + accessToken.getAccessToken());
                        Log.d(TAG, "Token Type: \n" + accessToken.getTokenType());
                        Log.d(TAG, "Refresh Token: \n" + accessToken.getRefreshToken());
                        Log.d(TAG, "Expires In: \n" + accessToken.getExpiresIn());
                        Log.d(TAG, "Scope: \n" + accessToken.getScope());
                        Log.d(TAG, "Response Code: " + accessToken.getResponseCode());
                    }
                }
            } else {
                throwIgniteException("Response Code: " + responseCode + " - " + accessTokenResponse.message());
            }
        } catch (IOException e) {
            Log.e(TAG, "getAccessToken(): " + e);
            throw new IgniteRestClientException(e);
        }

        return accessToken;
    }

    public synchronized void refreshToken() {
        new RefreshTokenAsyncTask(mTokenService, accessToken, username, password, this).execute();
    }

    public AppKey getAppKey() throws IgniteRestClientException {
        AppKey appKeyModel = null;
        int responseCode;
        if (accessToken != null && !TextUtils.isEmpty(accessToken.getAccessToken())) {
            Call<AppKey> appKeyCall = mIgniteService.getAppKey();
            try {
                Response<AppKey> appKeyResponse = appKeyCall.execute();
                responseCode = appKeyResponse.code();

                if (responseCode == ResponseCode.SUCCESS) {
                    appKeyModel = appKeyResponse.body();
                    if (appKeyModel != null) {
                        appKeyModel.setResponseCode(responseCode);
                        if (Api.DEBUG) {
                            Log.d(TAG, "AppKey: \n" + appKeyModel.getAppKey());
                            Log.d(TAG, "Enabled: \n" + appKeyModel.isEnabled());
                            Log.d(TAG, "Link: \n" + appKeyModel.getLinks());
                            Log.d(TAG, "Response Code: " + appKeyModel.getResponseCode());
                        }
                    }
                } else {
                    throwIgniteException("Response Code: " + responseCode + " - " + appKeyResponse.message());
                }
            } catch (IOException e) {
                Log.e(TAG, "IOException on getAppKey() function:  " + e);
                throw new IgniteRestClientException(e);
            }
        } else {
            Log.e(TAG, "Access token is NULL");
            throwIgniteException("Access token is NULL");
        }

        return appKeyModel;
    }

    public CreateRestrictedUser createRestrictedUser(UserCreateCredentials userCredentials) throws IgniteRestClientException {
        CreateRestrictedUser createRestrictedUser = null;
        int responseCode;
        if (userCredentials != null && !TextUtils.isEmpty(userCredentials.getMail())) {
            if (!isSysUserExists(userCredentials.getMail())) {
                Call<CreateRestrictedUser> mCreateRestrictedUserCall = mIgniteService.createRestrictedUser(userCredentials);
                try {
                    if (mCreateRestrictedUserCall != null) {
                        Response<CreateRestrictedUser> mCreateRestrictedUserResponse = mCreateRestrictedUserCall.execute();
                        responseCode = mCreateRestrictedUserResponse.code();

                        if (Api.DEBUG) {
                            Log.i(TAG, "User Response Code:" + responseCode);
                        }
                        if (responseCode == ResponseCode.USER_CREATE_SUCCESS) {
                            createRestrictedUser = mCreateRestrictedUserResponse.body();
                            if (Api.DEBUG) {
                                Log.i(TAG, "RestrictedUSER:" + createRestrictedUser);
                            }
                        } else {
                            throwIgniteException("Response Code: " + responseCode + " - " + mCreateRestrictedUserResponse.message());
                        }
                    } else {
                        throwIgniteException("mCreateRestrictedUserCall is NULL");
                    }

                } catch (IOException e) {
                    Log.e(TAG, "IOException on createRestrictedUser() function: " + e);
                    throw new IgniteRestClientException(e);
                }
            } else {
                throwIgniteException("User is already exists");
            }
        }
        return createRestrictedUser;
    }

    public SysUserInfo getSystemUserInfo() throws IgniteRestClientException {

        SysUserInfo mSysUserInfo = null;
        int responseCode;
        Call<SysUserInfo> mSysUserInfoCall = mIgniteService.getSysUserInfo();
        try {

            if (mSysUserInfoCall != null) {
                Response<SysUserInfo> mSysUserInfoResponse = mSysUserInfoCall.execute();
                responseCode = mSysUserInfoResponse.code();

                if (responseCode == ResponseCode.SUCCESS) {
                    mSysUserInfo = mSysUserInfoResponse.body();
                    if (mSysUserInfo != null) {
                        mSysUserInfo.setResponseCode(responseCode);
                        if (Api.DEBUG) {
                            Log.i(TAG, "Response Code: " + responseCode);
                            Log.i(TAG, "SysUserInfo: \n" + mSysUserInfo);
                        }
                    }
                } else {
                    throwIgniteException("Response Code:" + responseCode + " - " + mSysUserInfoResponse.message());
                }
            }

        } catch (IOException e) {
            Log.e(TAG, "IOException on createRestrictedUser() function: " + e);
            throw new IgniteRestClientException(e);
        }
        return mSysUserInfo;
    }

    public boolean isSysUserExists(String email) throws IgniteRestClientException {

        int responseCode;
        Call<ResponseBody> mUserCall = mIgniteService.isUserExists(email);

        try {

            if (mUserCall != null) {
                Response<ResponseBody> mUserExistsResponse = mUserCall.execute();
                responseCode = mUserExistsResponse.code();

                if (responseCode == ResponseCode.SUCCESS) {
                    return true;
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "IOException on isSysUserExists() function: " + e);
            throw new IgniteRestClientException(e);
        }
        return false;

    }


    public EndUser getEndUser(String email) throws IgniteRestClientException {

        EndUser endUser = null;
        int responseCode;

        if (!TextUtils.isEmpty(email)) {
            Call<EndUser> endUserCall = mIgniteService.getEndUser(email);

            Log.d(TAG, "REQ : " + endUserCall.request().toString());

            if (endUserCall != null) {
                try {

                    Response<EndUser> endUserResponse = endUserCall.execute();
                    responseCode = endUserResponse.code();

                    if (responseCode == ResponseCode.SUCCESS) {
                        endUser = endUserResponse.body();
                        if (Api.DEBUG) {
                            Log.i(TAG, "Response Code: " + responseCode);
                            Log.i(TAG, "EndUsers: \n" + endUser);
                        }
                    } else {
                        throwIgniteException("Response Code:" + responseCode + " - " + endUserResponse.message());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on getEndUser() function :" + e);
                    throw new IgniteRestClientException(e);
                }
            }
        } else {
            throw new IgniteRestClientException(new IgniteRestClientThrowable(ErrorMessages.EMPTY_MAIL));
        }

        return endUser;
    }

    public Device getDeviceInfo() {

        Device device = null;
        int responseCode;
        Call<Device> deviceCall = mIgniteService.getDeviceInfo();

        try {
            if (deviceCall != null) {

                Response<Device> deviceResponse = deviceCall.execute();

                responseCode = deviceResponse.code();

                if (responseCode == ResponseCode.SUCCESS) {
                    device = deviceResponse.body();
                } else {
                    throwIgniteException("Response Code:" + responseCode + " - " + deviceResponse.message());
                }
            } else {
                throwIgniteException(ErrorMessages.NULL_PARAMETER);
            }
        } catch (IOException e) {
            Log.e(TAG, "IOException on getDeviceInfo() function :" + e);
            throw new IgniteRestClientException(e);
        }
        return device;

    }

    public Device getDeviceSummary(String username) {

        Device device = null;

        int responseCode;

        Call<Device> deviceCall = mIgniteService.getDeviceSummary(username);

        Log.i(TAG, "DEVICE CALL : " + deviceCall.request().toString());
        try {
            Response<Device> deviceResponse = deviceCall.execute();

            responseCode = deviceResponse.code();
            Log.i(TAG, "response Code : " + responseCode);

            if (ResponseCode.SUCCESS == responseCode) {
                device = deviceResponse.body();
            }
        } catch (IOException e) {
            Log.e(TAG, "getDeviceSummary() :" + e);
        }

        return device;
    }

    public Device getDeviceSummaryByDeviceId(String deviceId) {

        Device device = null;

        int responseCode;

        Call<Device> deviceCall = mIgniteService.getDeviceSummary2(deviceId);

        Log.i(TAG, "getDeviceSummaryByDeviceId : " + deviceCall.request().toString());
        try {
            Response<Device> deviceResponse = deviceCall.execute();

            responseCode = deviceResponse.code();
            Log.i(TAG, "response Code : " + responseCode);

            if (ResponseCode.SUCCESS == responseCode) {
                device = deviceResponse.body();
            }
        } catch (IOException e) {
            Log.e(TAG, "getDeviceSummaryByDeviceId() :" + e);
        }

        return device;
    }


    public boolean pushActionMessageToThing(String deviceCode, ActionMessage actionMessage) {

        int responseCode;
        Call<ResponseBody> pushCall = mIgniteService.pushSensorAgentMessage(deviceCode, actionMessage);
        if (pushCall != null) {
            try {
                Response<ResponseBody> pushActionResponse = pushCall.execute();

                responseCode = pushActionResponse.code();

                if (responseCode == ResponseCode.THING_ACTION_MESSAGE_SUCCESS) {

                    if (Api.DEBUG) {
                        Log.i(TAG, "Action message success. Response Code: " + responseCode);
                    }
                    return true;
                } else {
                    Log.i(TAG, "Action message failure. Response Code: " + responseCode);

                }
            } catch (IOException e) {
                Log.e(TAG, "IOException on pushActionMessageToThing() function :" + e);
                throw new IgniteRestClientException(e);
            }
        } else {
            throwIgniteException(ErrorMessages.NULL_PARAMETER);
        }

        return false;

    }

    public String createDromConfiguration(DromConfiguration dromConfiguration) {

        int responseCode;

        Call<ResponseBody> createDrom = mIgniteService.createDromConfiguration(dromConfiguration);

        if (createDrom != null) {
            try {

                Response<ResponseBody> createDromResponse = createDrom.execute();

                responseCode = createDromResponse.code();

                if (ResponseCode.DROM_CREATE_SUCCESS == responseCode) {

                    if (Api.DEBUG) {
                        Log.i(TAG, "DROM Created Successfully !! " + responseCode);
                    }

                    String configurationIdJsonString = createDromResponse.body().string();
                    try {
                        JSONObject object = new JSONObject(configurationIdJsonString);

                        dromConfigId = object.getString("configurationId");
                        if (Api.DEBUG) {
                            Log.i(TAG, "dromConfigId  : \n" + dromConfigId);
                        }

                    } catch (JSONException e) {
                        Log.e(TAG, "JSONException on createDromConfiguration() function :" + e);
                        throw new IgniteRestClientException(e);
                    }
                    return dromConfigId;
                }
            } catch (IOException e) {
                Log.e(TAG, "IOException on createDromConfiguration() function :" + e);
                throw new IgniteRestClientException(e);
            }
        } else {
            throwIgniteException(ErrorMessages.NULL_PARAMETER);
        }

        return dromConfigId;
    }


    public boolean addDromDevice(DromDevice dromDevice) {

        int responseCode;

        Call<ResponseBody> dromResponseCall = mIgniteService.assingDromToDevice(dromDevice);

        try {
            Response<ResponseBody> dromResponse = dromResponseCall.execute();

            responseCode = dromResponse.code();

            if (Api.DEBUG) {
                Log.i(TAG, "DROM Response Code: " + responseCode);
            }

            if (responseCode == ResponseCode.DROM_CREATE_SUCCESS) {

                if (Api.DEBUG) {
                    Log.i(TAG, "DROM Response :\n " + dromResponse.body().string());
                }
                return true;
            }

        } catch (IOException e) {
            Log.e(TAG, "IOException on pushDromToDevice() function :" + e);
            throw new IgniteRestClientException(e);
        }

        return false;
    }

    public boolean pushDromToDevice(String deviceId) {

        int responseCode;

        if (!TextUtils.isEmpty(deviceId)) {

            Call<ResponseBody> deviceDromCall = mIgniteService.pushDromToDevice(deviceId);

            if (deviceDromCall != null) {
                try {
                    Response<ResponseBody> deviceDromResponse = deviceDromCall.execute();

                    responseCode = deviceDromResponse.code();

                    Log.i(TAG, "Response Code DROM PUSH : " + responseCode);
                    if (responseCode == ResponseCode.SUCCESS) {

                        Log.i(TAG, "Response Code DROM PUSH : " + responseCode);

                        Log.i(TAG, "Response Code DROM PUSH : " + deviceDromResponse.message());
                        return true;
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on pushDromToDevice() function :" + e);
                    throw new IgniteRestClientException(e);
                }
            }

        }

        return false;

    }


    public DeviceNodeInventory getDeviceNodeInventory(String deviceId) {

        DeviceNodeInventory deviceNodeInventory = null;
        int responseCode;


        Call<DeviceNodeInventory> mDeviceNodeInventoryCall = mIgniteService.getDeviceNodeInventory(deviceId);


        try {
            Response<DeviceNodeInventory> mDeviceNodeInventoryResponse = mDeviceNodeInventoryCall.execute();

            responseCode = mDeviceNodeInventoryResponse.code();

            if (responseCode == ResponseCode.SUCCESS) {
                deviceNodeInventory = mDeviceNodeInventoryResponse.body();
            }
        } catch (IOException e) {
            Log.e(TAG, "getDeviceNodeInventory: " + e);
        }


        return deviceNodeInventory;
    }


    public LastThingData getLastData(String deviceId, String nodeId, String thingId) {

        LastThingData lastThingData = null;
        int responseCode;

        Call<LastThingData> mLastThingDataCall = mIgniteService.getLastData(deviceId, nodeId, thingId);


        try {
            Response<LastThingData> mLastThingDataResponse = mLastThingDataCall.execute();


            responseCode = mLastThingDataResponse.code();

            if (responseCode == ResponseCode.SUCCESS) {

                lastThingData = mLastThingDataResponse.body();
            }
        } catch (IOException e) {
            Log.e(TAG, "getLastData: " + e);
        }

        return lastThingData;
    }

    public ThingDataHistory getThingDataHistory(String deviceId, String nodeId, String thingId,
                                                long startDate, long endDate, int dataLimit) {


        ThingDataHistory mThingDataHistory = null;
        int responseCode;

        Call<ThingDataHistory> mThingDataHistoryCall = mIgniteService.getThingDataHistory(deviceId,
                nodeId, thingId, startDate, endDate, dataLimit);


        try {
            Response<ThingDataHistory> mThingDataHistoryResponse = mThingDataHistoryCall.execute();
            responseCode = mThingDataHistoryResponse.code();

            if (responseCode == ResponseCode.SUCCESS) {

                mThingDataHistory = mThingDataHistoryResponse.body();
            }
        } catch (IOException e) {
            Log.e(TAG, "getThingDataHistory: " + e);
        }


        return mThingDataHistory;
    }

    public boolean removeCurrentUser(String deviceCode) {

        int responseCode;

        Call<ResponseBody> responseBodyCall = mIgniteService.removeCurrentUser(deviceCode);

        try {
            Response<ResponseBody> responseBodyResponse = responseBodyCall.execute();

            responseCode = responseBodyResponse.code();

            if (responseCode == ResponseCode.SUCCESS || responseCode == ResponseCode.USER_CREATE_SUCCESS) {


                try {
                    JSONObject object = new JSONObject(responseBodyResponse.body().string());

                    Log.i(TAG, "RESPONSE : " + object.toString());
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int deactivateGateway(String deviceCode) {

        int responseCode = -1;

        Call<ResponseBody> responseBodyCall = mIgniteService.deactivateGateway(deviceCode);


        try {
            Response<ResponseBody> responseBodyResponse = responseBodyCall.execute();

            responseCode = responseBodyResponse.code();

            Log.i(TAG, "RESPONSE CODE " + responseCode);

            if (responseCode == ResponseCode.SUCCESS) {

                try {
                    JSONObject object = new JSONObject(responseBodyResponse.body().string());
                    Log.i(TAG, "RESPONSE JSON " + object.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseCode;

    }

    /**
     * MQTT API'S START
     */

    public int registerMqttDevice(MqttUserInfo mqttUserInfo) {

        int responseCode = -1;

        Call<ResponseBody> responseBodyCall = mIgniteService.registerMqttDevice(mqttUserInfo);

        try {
            Response<ResponseBody> responseBodyResponse = responseBodyCall.execute();

            responseCode = responseBodyResponse.code();

            //Log.i(TAG, "RESPONSE CODE " + responseCode);

            if (responseCode == ResponseCode.USER_CREATE_SUCCESS) {
                try {

                    JSONObject object = new JSONObject(responseBodyResponse.body().string());

                    //Log.i(TAG, "RESPONSE JSON " + object.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return responseCode;
    }


    public int updateMqttDevice(MqttUserInfo mqttUserInfo) {

        int responseCode = -1;

        Call<ResponseBody> responseBodyCall = mIgniteService.updateMqttUser(mqttUserInfo);

        try {
            Response<ResponseBody> responseBodyResponse = responseBodyCall.execute();

            responseCode = responseBodyResponse.code();

            //Log.i(TAG, "RESPONSE CODE " + responseCode);

            if (responseCode == ResponseCode.USER_CREATE_SUCCESS) {
                try {

                    JSONObject object = new JSONObject(responseBodyResponse.body().string());

                    //Log.i(TAG, "RESPONSE JSON " + object.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return responseCode;
    }

    public int getMqttDeviceUser(String deviceId) {

        int responseCode = -1;

        Call<ResponseBody> responseBodyCall = mIgniteService.getMqttUser(deviceId);

        try {
            Response<ResponseBody> responseBodyResponse = responseBodyCall.execute();

            responseCode = responseBodyResponse.code();

            //Log.i(TAG, "RESPONSE CODE " + responseCode);

            if (responseCode == ResponseCode.USER_CREATE_SUCCESS) {
                try {

                    JSONObject object = new JSONObject(responseBodyResponse.body().string());

                    //Log.i(TAG, "RESPONSE JSON " + object.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return responseCode;
    }

    // POLICY API'S START

    public boolean pushModeToDevice(String profileCode, String deviceCode, PolicyCodeResource policyCodeResource) {

        int responseCode;
        Log.i(TAG, "Push mode to device function is started...");

        if (!TextUtils.isEmpty(deviceCode) && !TextUtils.isEmpty(profileCode)) {

            if(mIgniteService == null){
                Log.i(TAG, "Cloud service is null...");
            }

            Call<Void> deviceModePushCall = mIgniteService.pushModeToDevice(profileCode,deviceCode,policyCodeResource);

            if (deviceModePushCall != null) {
                try {
                    Response<Void> deviceModePushResponse = deviceModePushCall.execute();
                    responseCode = deviceModePushResponse.code();

                    if (responseCode == 200) {
                        Log.i(TAG, "Response Code for MODE_PUSH : " +responseCode);
                        Log.i(TAG, "Response message for MODE_PUSH : " +deviceModePushResponse.message());
                        return true;
                    }

                    else {
                        Log.d(TAG,"Response Code for pushModeToDevice(): " +responseCode+ " - " +deviceModePushResponse.message());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on pushModeToDevice() function : " +e);
                }
            }
            else if(deviceModePushCall == null){
                Log.i(TAG, "Push mode to device response is null...");
            }
        }
        return false;
    }

    public List<PolicyStoreDTO> getProfilePolicies(String profileCode){
        List<PolicyStoreDTO> resourceModel = null;
        int responseCode;
        Log.i(TAG, "Get profile default policy function is started...");

        if (!TextUtils.isEmpty(profileCode)) {

            if(mIgniteService == null){
                Log.i(TAG, "Cloud service is null");
            }

            Call<List<PolicyStoreDTO>> getDefaultPolicyCall = mIgniteService.getProfilePolicies(profileCode);

            if (getDefaultPolicyCall != null) {
                try {
                    Response<List<PolicyStoreDTO>> profileDefaultPolicyResponse = getDefaultPolicyCall.execute();
                    responseCode = profileDefaultPolicyResponse.code();

                    if (responseCode == 200) {

                        resourceModel = profileDefaultPolicyResponse.body();
                        if (resourceModel != null) {
                            Log.d(TAG, "Defult Policy Code : " +resourceModel.get(0).getCode());
                        }
                    }
                    else {
                        Log.d(TAG,"Response Code for getProfilePolicies(): " +responseCode+ " - " +profileDefaultPolicyResponse.message());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on getProfilePolicies() function : " +e);
                }
            }
        }
        return resourceModel;

    }

    public List<ModeAppsDTO> getProfileApplications(String profileCode){
        List<ModeAppsDTO> resourceModel = null;
        int responseCode;
        Log.i(TAG, "Get profile applications function is started...");

        if (!TextUtils.isEmpty(profileCode)) {

            if(mIgniteService == null){
                Log.i(TAG, "Cloud service is null");
            }

            Call<List<ModeAppsDTO>> getApplicationsCall = mIgniteService.getProfileApplications(profileCode);

            if (getApplicationsCall != null) {
                try {
                    Response<List<ModeAppsDTO>> profileApplicationsResponse = getApplicationsCall.execute();
                    responseCode = profileApplicationsResponse.code();

                    if (responseCode == 200) {
                        resourceModel = profileApplicationsResponse.body();
                    }
                    else {
                        Log.d(TAG,"Response Code for getProfileApplications(): " +responseCode+ " - " +profileApplicationsResponse.message());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on getProfileApplications() function : " +e);
                }
            }
        }
        return resourceModel;

    }

    public List<ModeContentsDTO> getProfileContents(String profileCode){
        List<ModeContentsDTO> resourceModel = null;
        int responseCode;
        Log.i(TAG, "Get profile contents function is started...");

        if (!TextUtils.isEmpty(profileCode)) {

            if(mIgniteService == null){
                Log.i(TAG, "Cloud service is null");
            }

            Call<List<ModeContentsDTO>> getContentsCall = mIgniteService.getProfileContents(profileCode);

            if (getContentsCall != null) {
                try {
                    Response<List<ModeContentsDTO>> profileContentsResponse = getContentsCall.execute();
                    responseCode = profileContentsResponse.code();

                    if (responseCode == 200) {
                        resourceModel = profileContentsResponse.body();
                    }
                    else {
                        Log.d(TAG,"Response Code for getProfileContents(): " +responseCode+ " - " +profileContentsResponse.message());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on getProfileContents() function : " +e);
                }
            }
        }
        return resourceModel;

    }

    public List<ModeCertificatesDTO> getProfileCertificates(String profileCode){
        List<ModeCertificatesDTO> resourceModel = null;
        int responseCode;
        Log.i(TAG, "Get profile certificates function is started...");

        if (!TextUtils.isEmpty(profileCode)) {

            if(mIgniteService == null){
                Log.i(TAG, "Cloud service is null");
            }

            Call<List<ModeCertificatesDTO>> getCertificatesCall = mIgniteService.getProfileCertificates(profileCode);

            if (getCertificatesCall != null) {
                try {
                    Response<List<ModeCertificatesDTO>> profileCertificatesResponse = getCertificatesCall.execute();
                    responseCode = profileCertificatesResponse.code();

                    if (responseCode == 200) {
                        resourceModel = profileCertificatesResponse.body();
                    }
                    else {
                        Log.d(TAG,"Response Code for getProfileCertificates(): " +responseCode+ " - " +profileCertificatesResponse.message());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on getProfileCertificates() function : " +e);
                }
            }
        }
        return resourceModel;

    }

    public List<ModeConfigsDTO<WifiConfigsData>> getProfileWifiConfigs(String profileCode){
        List<ModeConfigsDTO<WifiConfigsData>> resourceModel = null;
        int responseCode;
        Log.i(TAG, "Get profile wifi configuration function is started...");

        if (!TextUtils.isEmpty(profileCode)) {

            if(mIgniteService == null){
                Log.i(TAG, "Cloud service is null");
            }

            Call<List<ModeConfigsDTO<WifiConfigsData>>> getWifiConfigsCall = mIgniteService.getProfileWifiConfigs(profileCode);

            if (getWifiConfigsCall != null) {
                try {
                    Response<List<ModeConfigsDTO<WifiConfigsData>>> profileWifiConfigsResponse = getWifiConfigsCall.execute();
                    responseCode = profileWifiConfigsResponse.code();

                    if (responseCode == 200) {
                        resourceModel = profileWifiConfigsResponse.body();
                    }
                    else {
                        Log.d(TAG,"Response Code for getProfileWifiConfigs(): " +responseCode+ " - " +profileWifiConfigsResponse.message());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on getProfileWifiConfigs() function : " +e);
                }
            }
        }
        return resourceModel;

    }

    public List<ModeConfigsDTO<ShortcutConfigsData>> getProfileShortcutConfigs(String profileCode){
        List<ModeConfigsDTO<ShortcutConfigsData>> resourceModel = null;
        int responseCode;
        Log.i(TAG, "Get profile shortcut configuration function is started...");

        if (!TextUtils.isEmpty(profileCode)) {

            if(mIgniteService == null){
                Log.i(TAG, "Cloud service is null");
            }

            Call<List<ModeConfigsDTO<ShortcutConfigsData>>> getShortcutConfigsCall = mIgniteService.getProfileShortcutConfigs(profileCode);

            if (getShortcutConfigsCall != null) {
                try {
                    Response<List<ModeConfigsDTO<ShortcutConfigsData>>> profileShortcutConfigsResponse = getShortcutConfigsCall.execute();
                    responseCode = profileShortcutConfigsResponse.code();

                    if (responseCode == 200) {
                        resourceModel = profileShortcutConfigsResponse.body();
                    }
                    else {
                        Log.d(TAG,"Response Code for getProfileShortcutConfigs(): " +responseCode+ " - " +profileShortcutConfigsResponse.message());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on getProfileShortcutConfigs() function : " +e);
                }
            }
        }
        return resourceModel;

    }

    public List<ModeConfigsDTO<HotspotConfigsData>> getProfileHotspotConfigs(String profileCode){
        List<ModeConfigsDTO<HotspotConfigsData>> resourceModel = null;
        int responseCode;
        Log.i(TAG, "Get profile hotspot configuration function is started...");

        if (!TextUtils.isEmpty(profileCode)) {

            if(mIgniteService == null){
                Log.i(TAG, "Cloud service is null");
            }

            Call<List<ModeConfigsDTO<HotspotConfigsData>>> getHotspotConfigsCall = mIgniteService.getProfileHotspotConfigs(profileCode);

            if (getHotspotConfigsCall != null) {
                try {
                    Response<List<ModeConfigsDTO<HotspotConfigsData>>> profileHotspotConfigsResponse = getHotspotConfigsCall.execute();
                    responseCode = profileHotspotConfigsResponse.code();

                    if (responseCode == 200) {
                        resourceModel = profileHotspotConfigsResponse.body();
                    }
                    else {
                        Log.d(TAG,"Response Code for getProfileHotspotConfigs(): " +responseCode+ " - " +profileHotspotConfigsResponse.message());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on getProfileHotspotConfigs() function : " +e);
                }
            }
        }
        return resourceModel;

    }

    public List<ModeConfigsDTO<VpnConfigsData>> getProfileVpnConfigs(String profileCode){
        List<ModeConfigsDTO<VpnConfigsData>> resourceModel = null;
        int responseCode;
        Log.i(TAG, "Get profile vpn configuration function is started...");

        if (!TextUtils.isEmpty(profileCode)) {

            if(mIgniteService == null){
                Log.i(TAG, "Cloud service is null");
            }

            Call<List<ModeConfigsDTO<VpnConfigsData>>> getVpnConfigsCall = mIgniteService.getProfileVpnConfigs(profileCode);

            if (getVpnConfigsCall != null) {
                try {
                    Response<List<ModeConfigsDTO<VpnConfigsData>>> profileVpnConfigsResponse = getVpnConfigsCall.execute();
                    responseCode = profileVpnConfigsResponse.code();

                    if (responseCode == 200) {
                        resourceModel = profileVpnConfigsResponse.body();
                    }
                    else {
                        Log.d(TAG,"Response Code for getProfileVpnConfigs(): " +responseCode+ " - " +profileVpnConfigsResponse.message());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on getProfileVpnConfigs() function : " +e);
                }
            }
        }
        return resourceModel;

    }


    public SpecificDeviceInfoResult getSpecificDeviceInfo(String deviceCode, String command){
        SpecificDeviceInfoResult deviceInfoModel = null;
        int responseCode;
        Log.i(TAG, "Get deviceProfileInfo function is started...");

        if (!TextUtils.isEmpty(deviceCode) && !TextUtils.isEmpty(command)) {

            if(mIgniteService == null){
                Log.i(TAG, "Cloud service is null");
            }

            Call<SpecificDeviceInfoResult> getInfoCall = mIgniteService.getSpecificDeviceInfo(deviceCode,command);

            if (getInfoCall != null) {
                try {
                    Response<SpecificDeviceInfoResult> deviceProfileInfoResponse = getInfoCall.execute();
                    responseCode = deviceProfileInfoResponse.code();

                    if (responseCode == 200) {
                        deviceInfoModel = deviceProfileInfoResponse.body();
                    }
                    else {
                        Log.d(TAG,"Response Code for getSpecificDeviceInfo(): " +responseCode+ " - " +deviceProfileInfoResponse.message());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException on getSpecificDeviceInfo() function : " +e);
                }
            }
        }
        return deviceInfoModel;

    }


    // POLICY API'S END

    @Override
    public void onTokenRefreshed(AccessToken refreshToken) {
        accessToken = refreshToken;
        refreshTimeInMillis = (accessToken.getExpiresIn() * 1000) - 1000L;
        tokenWatchdogHandler.postDelayed(tokenWatchDog, refreshTimeInMillis);
    }

    public static class IgniteRestClientBuilder {

        private String builderUsername = null;
        private String builderPassword = null;
        private boolean builderAutoRefresh = false;


        protected IgniteRestClientBuilder() {
        }


        public IgniteRestClientBuilder userName(String usrName) {
            this.builderUsername = usrName;
            return this;
        }

        public IgniteRestClientBuilder password(String password) {
            this.builderPassword = password;
            return this;
        }


        public IgniteRestClientBuilder autoRefreshToken(boolean autoRefresh) {
            this.builderAutoRefresh = autoRefresh;
            return this;
        }

        public IgniteRestClient build() throws IgniteRestClientException {

            if (!TextUtils.isEmpty(builderUsername) && !TextUtils.isEmpty(builderPassword)) {
                return new IgniteRestClient(builderUsername, builderPassword, builderAutoRefresh);
            }

            throw new IgniteRestClientException(new IgniteRestClientThrowable(ErrorMessages.NULL_PARAMETER));
        }

    }

    private void throwIgniteException(String msg) {
        throw new IgniteRestClientException(new IgniteRestClientThrowable(msg));
    }
}
