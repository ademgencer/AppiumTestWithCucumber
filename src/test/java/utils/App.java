package utils;

public enum App {

    APIDEMOS(
            "com.touchboarder.android.api.demos",
            "com.touchboarder.androidapidemos.MainActivity",
            "ApiDemos.zip"
    ),

    CALCULATOR(
            "com.sec.android.app.popupcalculator",
            "Calculator",
            ""
    )
    ;

    String appPackage;
    String appActivity;
    String app;

    App(String appPackage, String appActivity, String app) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.app = app;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }
}
