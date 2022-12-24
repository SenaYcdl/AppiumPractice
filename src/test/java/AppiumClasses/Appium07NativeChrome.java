package AppiumClasses;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium07NativeChrome {

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

        driver.get("https://www.amazon.com");

        //asagidaki kod tel kilitli ise acmamizi sagliyor
        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }


        System.out.println(driver.getContext() + "<===app acildiginda");
        //burda aplikasyonu hangi turleri oldugunu gormek icin getContextHandles() kullaniyoruz
        Set<String> butunTurler = driver.getContextHandles();
        for (String tur : butunTurler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                driver.context(tur);
            }

        }

        System.out.println(driver.getContext() + "<===app degistiginde");
        Thread.sleep(5000);
        MobileElement homeScreenLogo = driver.findElementByAccessibilityId("Amazon");
        Assert.assertTrue(homeScreenLogo.isDisplayed());

        //System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        MobileElement signInButton = driver.findElementByAccessibilityId("Sign in ›");
        signInButton.click();

        MobileElement welcomeText = driver.findElementByXPath("//android.widget.TextView[@text='Welcome']");
        Assert.assertEquals(welcomeText.getText(), "Welcome");

        Thread.sleep(3);
        //close session
        driver.closeApp();


    }
}