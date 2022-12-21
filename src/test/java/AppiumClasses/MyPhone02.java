package AppiumClasses;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
public class MyPhone02 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12 SKQ1.211019.001");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "626c3e64");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\sena_\\IdeaProjects\\newMobilTesting\\src\\Apps\\Calculator_8.3 (477856174)_Apkpure.apk");
        capabilities.setCapability("noReset", "true");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //asagidaki kod tel kilitli ise acmamizi sagliyor
        if(driver.isDeviceLocked()){
            driver.unlockDevice();
        }

        Thread.sleep(5);

        MobileElement num1= driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2= driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3= driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4= driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5= driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6= driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7= driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8= driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9= driver.findElementById("com.google.android.calculator:id/digit_9");
        MobileElement num0= driver.findElementById("com.google.android.calculator:id/digit_0");

        MobileElement arti=driver.findElementByAccessibilityId("artı");
        MobileElement bolu=driver.findElementByAccessibilityId("bölü");
        MobileElement carpi=driver.findElementByAccessibilityId("çarpı");
        MobileElement cikarma=driver.findElementByAccessibilityId("eksi");
        MobileElement esittir=driver.findElementByAccessibilityId("eşittir");


        //64+71
        num6.click();
        num4.click();
        arti.click();
        num7.click();
        num1.click();

        Thread.sleep(3);

        MobileElement preResult=driver.findElementById("com.google.android.calculator:id/result_preview");
        System.out.println("Result " + preResult);
        String preResultText= preResult.getText();

        esittir.click();

        Thread.sleep(3);

        MobileElement finalResult=driver.findElementById("com.google.android.calculator:id/result_final");
        System.out.println("Result " + finalResult);

        Assert.assertEquals(finalResult.getText(),preResultText);




    }
}