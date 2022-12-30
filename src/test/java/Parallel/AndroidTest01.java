package Parallel;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidTest01 extends AndroidBaseClass {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        AndroidDriver<MobileElement> driver = androidDriver("emulator", "11.0", "emulator-5554", "10001", "4724");


        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(300);

        //preference butonuna tikla
        MobileElement preferenceButton = driver.findElementByXPath("//android.widget.TextView[@text='Preference']");
        preferenceButton.click();

        //preference dependencies butonuna tikla
        MobileElement preferenceDependencies = driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']");
        preferenceDependencies.click();

        //click to check box
        MobileElement checkBoxButton = driver.findElementById("android:id/checkbox");
        checkBoxButton.click();

        //WiFi settings click
        MobileElement wifiSettingsButton = driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']");
        wifiSettingsButton.click();

        driver.quit();

    }


    @Test
    public void test2() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = androidDriver("RealDevice", "10.0", "1312d4f50606", "10001", "4723");


        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(300);

        //preference butonuna tikla
        MobileElement preferenceButton = driver.findElementByXPath("//android.widget.TextView[@text='Preference']");
        preferenceButton.click();

        //preference dependencies butonuna tikla
        MobileElement preferenceDependencies = driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']");
        preferenceDependencies.click();

        //click to check box
        MobileElement checkBoxButton = driver.findElementById("android:id/checkbox");
        checkBoxButton.click();


        //WiFi settings click
        MobileElement wifiSettingsButton = driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']");
        wifiSettingsButton.click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("Appium");
        Thread.sleep(3000);
        driver.findElementById("android:id/button1").click();
        Thread.sleep(3000);
        driver.quit();


    }
}
