package com.ardic.android.iotignite.lib.restclient.constant;

/**
 * Created by oguzcakir on 05.10.2018.
 */

public class Profiles {

    private Profiles() {

    }


    public static class InfoCommand {
        public static final String PROFILE_INFO = "ProfileInfo";
        public static final String OSPROFILE_INFO = "OSProfile";
        public static final String MODIVERSE_INFO = "ModiverseInfo";
        public static final String APPLICATION_INFO = "ApplicationInfo";
        public static final String ROOTED_INFO = "RootedInfo";
        public static final String LOCATION_INFO = "LocationInfo";
        public static final String NETWORK_INFO = "NetworkInfo";
        public static final String USAGE_INFO = "UsageInfo";
        public static final String BATTERY_INFO = "BatteryInfo";
        public static final String PROCESS_INFO = "ProcessInfo";
        public static final String STORAGE_INFO = "StorageInfo";
        public static final String STATUS_INFO = "StatusInfo";
        public static final String NODE_INVENTORY = "DeviceNodeInventory";
        public static final String RULE_INVENTORY = "DeviceFlowInventory";
        public static final String CONFIG_INVENTORY = "DeviceConfigInventory";
        private InfoCommand() {

        }
    }
}
