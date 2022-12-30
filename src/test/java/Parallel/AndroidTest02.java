package Parallel;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidTest02 extends AndroidBaseClass {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        AndroidDriver<MobileElement> driver = androidDriver("emulator-5554", "10.0", "emulator-5554", "10001", "4724");


        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        Thread.sleep(5000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"))");
        driver.findElementByXPath("//android.widget.TextView[@text='Switches']").click();

        driver.quit();

    }


    @Test
    public void test2() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = androidDriver("RealDevice", "10.0", "1312d4f50606", "10001", "4723");


        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        Thread.sleep(5000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"))");
        driver.findElementByXPath("//android.widget.TextView[@text='Switches']").click();
        Thread.sleep(3000);
        driver.quit();


    }
}
