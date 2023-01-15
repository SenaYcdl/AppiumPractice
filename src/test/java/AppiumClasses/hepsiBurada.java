package AppiumClasses;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class hepsiBurada {

    Robot robot;
        @Test
        public void test() throws MalformedURLException, InterruptedException {

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "626c3e64");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability("appPackage","org.chromium.webview_shell");
            capabilities.setCapability("appActivity","org.chromium.webview_shell.WebViewBrowserActivity");
            //capabilities.setCapability("appPackage", "com.android.chrome");
            //capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");


            AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            Thread.sleep(3000);
            driver.get("https://www.hepsiburada.com");


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
            MobileElement homeScreenLogo = driver.findElementByXPath("//android.widget.Image[@text='Desktop-Logo']");
            Assert.assertTrue(homeScreenLogo.isDisplayed());


            Thread.sleep(5000);

            WebElement signInButton = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
            signInButton.click();
            signInButton.sendKeys("canta+\n");
            Thread.sleep(3000);
           /*


    try {
        robot = new Robot();
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
    } catch (AWTException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
            */






        }

}
