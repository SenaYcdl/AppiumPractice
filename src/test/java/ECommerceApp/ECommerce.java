package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ECommerce extends BaseECommerceApp {

     /*
    //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
    //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin
//2-Shop the items in the app by scrolling to specific Product and add to cart
//3-Validate if the items selected in the page 2 are matching with the items displayed in check out page
//4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
//5-Validate Mobile gestures working for link (long press) and navigate to WebView //6-Verify if user can do operations on Web view and navigate back to native app if needed.
(go to google and search “appium” then navigate to NATIVE APP and verify it)
     */

    @Test
    public void negativeTest() throws MalformedURLException, InterruptedException {

        AndroidDriver<MobileElement> driver = getAndroidDriver();
        Thread.sleep(5000);

        //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
        //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin


        MobileElement maleButton = driver.findElementById("com.androidsample.generalstore:id/radioMale");

        //anasayfa da miyiz
        MobileElement homeScreenTitle = driver.findElementById("com.androidsample.generalstore:id/toolbar_title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());

        //ulkeyi secmek icin ulke butununa bastik
        MobileElement countrySpinner = driver.findElementById("com.androidsample.generalstore:id/spinnerCountry");
        countrySpinner.click();

        //ulkeyi sececegiz
        Thread.sleep(5000);
        MobileElement expectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='Angola']");
        expectedCountry.click();
        Thread.sleep(3000);

        //istedigimiz ulkeyi dogru olarak sectik mi?
        MobileElement selectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='Angola']");
        System.out.println(selectedCountry.getText());
        Assert.assertEquals(selectedCountry.getText(), "Angola");
        Thread.sleep(3000);

        //negative case icin name bos olmali
        MobileElement nameBox = driver.findElementById("com.androidsample.generalstore:id/nameField");
        nameBox.clear();

        //female sec
        MobileElement femaleButton = driver.findElementById("com.androidsample.generalstore:id/radioFemale");
        femaleButton.click();

        //shop butonuna tikla
        MobileElement letsShopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
        letsShopButton.click();

        //hata mesajini onayla
        MobileElement errorPopUpText = driver.findElement(By.xpath(".//android.widget.Toast"));
        Thread.sleep(5000);
        String errorText = errorPopUpText.getText();
        Assert.assertEquals(errorText, "Please enter your name");
        Thread.sleep(5000);
        // Assert.assertTrue(errorPopUpText.isDisplayed());

        //close app
        driver.closeApp();


    }
}
