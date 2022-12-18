package AppiumClasses;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\sena_\\Downloads\\Gesture Tool_1.3_Apkpure.apk");
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset",true);
        //aplikasyonun izinleri atlayarak ana sayfada acilmasini istiyorsak ustteki komutu kullaniniz

        AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        System.out.println("app yuklendi");

        Thread.sleep(5);
        driver.findElementById("com.android.permissioncontroller:id/continue_button").click();

        Thread.sleep(5);
        MobileElement okButton=driver.findElementByXPath("//android.widget.Button[@text='OK']");
        okButton.click();
        System.out.println("Izinler Onaylandi");

        MobileElement homeScreenTitle= driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Anasayfa acildi");
    }
}
