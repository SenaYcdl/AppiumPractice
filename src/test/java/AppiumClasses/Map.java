package AppiumClasses;

import Appium.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Map {

    private static Logger logger = (Logger) LogManager.getLogger(Map.class.getName());

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP, "C:\Users\sena_\IdeaProjects\newMobilTesting\src\Apps\Google Maps_11.64.0701_Apkpure.apk");
        capabilities.setCapability("appPackage", "com.google.android.apps.maps");
        capabilities.setCapability("appActivity", "com.google.android.maps.MapsActivity");
        capabilities.setCapability("disableAndroidWatchers", true);
        capabilities.setCapability("autoGrantPermissions",true);
        capabilities.setCapability("noReset", true);


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        logger.info("---Kullanıcı app e giris yapar---");

        Thread.sleep(5000);


        MobileElement yolTarifiButton=driver.findElementById("com.google.android.apps.maps:id/on_map_directions_button");
        yolTarifiButton.click();
        logger.info("Kullanıcı yol tarifi butonuna click yapar");

        Thread.sleep(3000);

        MobileElement metro= driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Toplu taşıma modu']");
        metro.click();
        //Assert.assertTrue(metro.isDisplayed());
        System.out.println(metro.getAttribute("content-desc"));
        Assert.assertEquals(metro.getAttribute("content-desc"),"Toplu taşıma modu");
        logger.info("Kullanıcı metro iconun gorunurlugunu dogrular");

    }
}