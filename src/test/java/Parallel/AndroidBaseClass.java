package Parallel;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidBaseClass {


    @Test
    public AndroidDriver<MobileElement> androidDriver(String deviceName, String platformVersion, String udid, String port, String systemPort) throws MalformedURLException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\sena_\\IdeaProjects\\newMobilTesting\\src\\Apps\\apiDemos.apk");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("systemPort", systemPort);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60000);


        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


}