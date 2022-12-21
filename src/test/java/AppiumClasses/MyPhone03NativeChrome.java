package AppiumClasses;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MyPhone03NativeChrome {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12 SKQ1.211019.001");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "626c3e64");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
      // capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\sena_\\Downloads\\Gesture Tool_1.3_Apkpure.apk");
       capabilities.setCapability("appPackage", "com.android.chrome");
       capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
       capabilities.setCapability("noReset", "true");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //asagidaki kod tel kilitli ise acmamizi sagliyor
        if(driver.isDeviceLocked()){
            driver.unlockDevice();
        }











    }
}