package utils;

public enum Device {
    // Cihaza IP adresiyle kablosuz bağlanacaksak udid IP yazılır.
    SAMSUNG_GALAXY_FAN(
            "ce10171a1be3db2f01",
            "12",
            "Samsung Galaxy Fan",
            "Android"
    ),

    EMULATOR(
            "emulator-5554",
            "12",
            "Samsung Emulator",
            "Android"
    );


    private String udid;
    private String version;
    private String deviceName;
    private String platformName;

    Device(String udid, String version, String deviceName, String platformName) {
        this.udid = udid;
        this.version = version;
        this.deviceName = deviceName;
        this.platformName = platformName;
    }

    public String getUdid() {
        return udid;
    }

    public String getVersion() {
        return version;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getPlatformName() {
        return platformName;
    }

}
