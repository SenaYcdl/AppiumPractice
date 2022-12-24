package AppiumClasses;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MyPhone06UiSelectorTestCase {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12 SKQ1.211019.001");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "626c3e64");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\sena_\\IdeaProjects\\newMobilTesting\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset", "true");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //Add butonuna tiklar
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Add\")").click();
        Thread.sleep(5000);


        String isFalse = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)").getAttribute("enabled");
        Assert.assertEquals(isFalse,"false");

        MobileElement textBox= driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/gesture_name\")");
        textBox.sendKeys("Hello World");

        Thread.sleep(3000);
        MobileElement blackScreen= driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/gestures_overlay\")");
        blackScreen.click();

        String isTrue = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(true)").getAttribute("enabled");
        Assert.assertEquals(isTrue,"true");
        System.out.println("Done button enabled");

        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\")").click();
        Thread.sleep(3000);

        //close the session
        driver.closeApp();



    }
}