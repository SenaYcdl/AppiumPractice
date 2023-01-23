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

public class WebAppChrome {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "626c3e64");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "6000");

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        //chrome driver eski ise bunu yazcaksınız
        capabilities.setCapability("chromeDriverExecutable", "C:\\Users\\Administrator\\IdeaProjects\\AppiumPractise\\src\\driver\\chromedriver.exe");

        //web app de artik browser ile calısıyoruz
        //chrome driver versiyonu buradan indirebilirsiniz
        //https://chromedriver.storage.googleapis.com/index.html
        //sonrasında driver in absolute path bir alt satirda tanimliyoruz
        //capabilities.setCapability("chromeDriverExecutable","path");
        //chrome://inspect/#devices -> devtools acar
        //web sitesindeki gibi locate alabiliriz

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.get("https://www.amazon.com");


        //asagidaki kod tel kilitli ise acmamizi sagliyor
        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }

        //burda aplikasyonu hangi turleri oldugunu gormek icin getContextHandles() kullaniyoruz
        //web ve native turlerini içerebilir bu durumda hybrid app olur.
        //Bu kontrol etmek için inspectorden
        //actions->context->context->get context hangi tur oldugunu gosterir
        //
        //amazon app açılırken native olarak açılıyor fakat içerisine webview app koymuşlar
        //bu yuzden hybrid app olur.

        System.out.println(driver.getContext() + "<===app acildiginda");
        //burda aplikasyonu hangi turleri oldugunu gormek icin getContextHandles() kullaniyoruz
        Set<String> butunTurler = driver.getContextHandles();
        for (String tur : butunTurler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                driver.context(tur);  //o turu set et ve ondan devam et
            }

            //mevcut olan tum turleri set içine koyup bir appin contextlerini verir.
            //app açıldığında neredeyiz web mi native mi
            //web app e geçtiğimizde selenium devreye giriyor
            //switch yapmak lazım web app de çalışlırken selenium ile çalışıyoruz çünkü
            //
            //google->inspect->dev tools da üç nokta->more tools->remote device
            //eğer yoksa aşağıdaki link e git tel de google sayfasının açık olması lazım
            //chrome://inspect/#devices
        }

        //MobileElement logo = driver.findElementByXPath("//span[@class='nav-sprite nav-logo-base']");
        MobileElement amazon = driver.findElementByCssSelector(".nav-left");
        Assert.assertTrue(amazon.isDisplayed());
        //Assert.assertTrue(logo.isDisplayed());

        //MobileElement signIn = driver.findElementByXPath("//*[@class='nav-a nav-show-sign-in']");
        //signIn.click();
        MobileElement signIn = driver.findElementByCssSelector("#nav-logobar-greeting");
        signIn.click();


        //MobileElement welcome = driver.findElementByXPath("//*[@id='outer-accordion-signin-signup-page']");
        ////h2[normalize-space()='Welcome']

        MobileElement welcome = driver.findElementByTagName("h2");
        Assert.assertTrue(welcome.isDisplayed());


        System.out.println(driver.getContext() + "<=== app degistiginde");
        Thread.sleep(5000);

        //close session
        driver.closeApp();


    }

}
