package AppiumClasses;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Appium04Gesture {
    @Test
    public void testGesture() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // deviceName Andrid'te onemli degil
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        Actions actions = new Actions(driver);

        System.out.println("App acildi");
        MobileElement homeScreen = driver.findElementById("android:id/title");
        Assert.assertEquals("Gesture Tool",homeScreen.getText());

        MobileElement addGestureButton = driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        addGestureButton.click();

        Thread.sleep(1500);
        MobileElement nameTextBox = driver.findElementById("com.davemac327.gesture.tool:id/gesture_name");
        nameTextBox.sendKeys("oooooooooooo ne sekil beee!");

        MobileElement spaceArea = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout");
        actions.dragAndDropBy(spaceArea,0,500).perform();
        actions.dragAndDropBy(spaceArea,500,0).perform();
        actions.dragAndDropBy(spaceArea,-500,0).perform();
        actions.dragAndDropBy(spaceArea,0,-500).perform();
        actions.dragAndDropBy(spaceArea,500,-500).perform();
        actions.dragAndDropBy(spaceArea,-500,500).perform();
        actions.dragAndDropBy(spaceArea,-500,-500).perform();
        Thread.sleep(1500);


        MobileElement doneButton = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]");
        doneButton.click();

        Thread.sleep(1500);
        MobileElement firstGesture = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[2]");
        actions.clickAndHold(firstGesture).perform();

        Thread.sleep(1500);
        MobileElement deleteButton = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView");deleteButton.click();

        Thread.sleep(5000);

        driver.closeApp();






    }


}