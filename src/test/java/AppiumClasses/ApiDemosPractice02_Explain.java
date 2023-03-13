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

public class ApiDemosPractice02_Explain {

    //API Demos app'ini android cihazda baslat ve API DEMOS simgesine tiklayarak animasyonu ekranda 5 sn boyunca goster
    //'API Demos" butununa tikla
    //"API Demos" sayfasinda olundugunu dogrula
    //"Views" butununa tikla
    //"Views" sayfasinda olundugunu dogrula
    //"Expandable Lists" butununa tikla
    //"Views/Expandable Lists" ekranini dogrula
    //"1. Custom Adapter" butununa tikla
    //"People Names" butununa tikla
    //"Chuck" butununa uzun bas
    //"Sample menu" ekranini dogrula

    @Test
    public void testApiDemos02() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "null");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("Api Demos app has opened and now main page");
        Actions actions = new Actions(driver);

        //API Demos app'ini android cihazda baslat ve API DEMOS simgesine tiklayarak animasyonu ekranda 5 sn boyunca goster
        MobileElement mainPageAPIDemos = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.ImageView\").index(0)");
        mainPageAPIDemos.click();
        Thread.sleep(1000);
        MobileElement animationPage = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.view.View\")");
        animationPage.click();
        //'API Demos" butununa tikla
        Thread.sleep(1000);
        MobileElement apiDemosButton = driver.findElementByAndroidUIAutomator("UiSelector().text(\"API Demos\")");
        apiDemosButton.click();
        //"API Demos" sayfasinda olundugunu dogrula
        MobileElement apiDemosTitle= driver.findElementByAndroidUIAutomator("UiSelector().text(\"API Demos\")");
        Assert.assertEquals(apiDemosTitle.getText(), "API Demos");
        //"Views" butununa tikla
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Views\"))").click(); //scroll down to the element and click
        //"Views" sayfasinda olundugunu dogrula
        MobileElement viewsTitle= driver.findElementByAndroidUIAutomator("UiSelector().text(\"Views\")");
        Assert.assertEquals(viewsTitle.getText(), "Views");
        //"Expandable Lists" butununa tikla
        MobileElement expandableListsButton= driver.findElementByAndroidUIAutomator("UiSelector().textContains(\"pandable\")");
        expandableListsButton.click();
        //"Views/Expandable Lists" ekranini dogrula
        MobileElement viewsExpandableListsTitle= driver.findElementByAndroidUIAutomator("UiSelector().textContains(\"Views/Expandable\")");
        Assert.assertEquals(viewsExpandableListsTitle.getText(), "Views/Expandable Lists");
        //"1. Custom Adapter" butununa tikla
        MobileElement customAdaptor = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").index(0)");
        customAdaptor.click();
        //"People Names" butununa tikla
        MobileElement peopleNamesButton = driver.findElementByAndroidUIAutomator("UiSelector().text(\"People Names\")");
        peopleNamesButton.click();
        //"Chuck" butununa uzun bas
        MobileElement chuckButton = driver.findElementByAndroidUIAutomator("UiSelector().text(\"Chuck\")");
        actions.clickAndHold(chuckButton).perform();
        //"Sample menu" ekranini dogrula
        Thread.sleep(1000);
        MobileElement sampleMenuTitle = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/alertTitle\")");
        Assert.assertEquals(sampleMenuTitle.getText(), "Sample menu");

        Thread.sleep(5000);
        driver.closeApp();
    }
}