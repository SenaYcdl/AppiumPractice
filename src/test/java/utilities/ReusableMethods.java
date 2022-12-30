package utilities;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utilities.Driver.getAppiumDriver;


public class ReusableMethods {


    //hard wait THREAD.SLEEP
    //waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //elementlerin textlerine gore tiklar
    public static void tapOnElementWithText(String text) {
        List<MobileElement> mobileElementList = getAppiumDriver().findElementsByClassName("android.widget.TextView");
        for (MobileElement page : mobileElementList) {
            if (page.getText().equals(text)) {
                page.click();
            } else {
                scrollWithUiScrollable(text);
            }
            break;
        }
    }

    //ikinci alternatif bir method
    public static void clickOnElementWithText(String elementText) throws InterruptedException {
        Thread.sleep(4000);
        List<MobileElement> mobileElementList = getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='" + elementText + "']");
        if (mobileElementList.size() > 0) {
            mobileElementList.get(0).click();
        } else scrollWithUiScrollable(elementText);
    }


    //butun elementleri aldim text olarak elementimi tanimladim
    //eger text elementimi iceriyorsa
    //visible olmasini bekle true don
    public static boolean isElementPresent(String text) {
        boolean elementFound = false;
        List<MobileElement> mobileElementList = getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='" + text + "']");
        for (MobileElement el : mobileElementList) {
            if (el.getText().equals(text)) {
                waitToBeVisible(el, 10);
                if (el.isDisplayed()) {
                    elementFound = true;
                }
            }
        }
        return elementFound;
    }

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //element gorunene kadar bekler click yapar
    public static void tapOn(MobileElement element) {
        waitToBeClickable(element, 10);
        element.click();
    }

    //sendkeys
    public static void enterText(MobileElement element, String text) {
        waitToBeClickable(element, 10);
        element.sendKeys(text);
    }

    //sendkeys 3 parametreli text dolu ise siliyor sonra send yapıyor
    public static void enterText(MobileElement element, String text, boolean needClear) {
        waitToBeClickable(element, 10);
        if (needClear) {
            element.clear();
        }
        element.sendKeys(text);
    }

    //element gorunuyor mu gorunmuyor mu
    //akıllı waitler 6. saniyede elementi bulursa geciyor 10 saniye beklemiyor
    public static boolean isElementPresent(MobileElement mobileElement) {
        boolean elementFound = false;
        waitToBeVisible(mobileElement, 10);
        if (mobileElement.isDisplayed()) {
            elementFound = true;
        }
        return elementFound;
    }

    //element gorunene kadar bekle
    public static void waitToBeVisible(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getAppiumDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitToBeClickable(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getAppiumDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver<MobileElement> driver = (AndroidDriver) getAppiumDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        tapOn(driver.findElementByXPath("//android.widget.TextView[@text='" + elementText + "']"));
    }


    public static void setNumber(String no) {
        TouchAction touchAction = new TouchAction<>(getAppiumDriver());
        String[] sayi = no.split("");
        System.out.println(Arrays.toString(sayi));
        for (int i = 0; i < sayi.length; i++) {
            ReusableMethods.waitFor(2);
            switch (sayi[i]) {
                case "0":
                    touchAction.tap(PointOption.point(414, 2138)).perform();
                    break;
                case "1":
                    touchAction.tap(PointOption.point(133, 1797)).perform();
                    break;
                case "2":
                    touchAction.tap(PointOption.point(402, 1797)).perform();
                    break;
                case "3":
                    touchAction.tap(PointOption.point(680, 1797)).perform();
                    break;
                case "4":
                    touchAction.tap(PointOption.point(133, 1916)).perform();
                    break;
                case "5":
                    touchAction.tap(PointOption.point(402, 1916)).perform();
                    break;
                case "6":
                    touchAction.tap(PointOption.point(680, 1916)).perform();
                    break;
                case "7":
                    touchAction.tap(PointOption.point(133, 2064)).perform();
                    break;
                case "8":
                    touchAction.tap(PointOption.point(402, 2064)).perform();
                    break;
                case "9":
                    touchAction.tap(PointOption.point(680, 2064)).perform();
                    break;

            }

        }
    }

    public static void waitToast(MobileElement element, int timeout) {
        // Set the implicit wait timeout to 10 seconds
        WebDriverWait wait = new WebDriverWait(getAppiumDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));

        // Wait until the toast message becomes visible
        getAppiumDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Toast[1]")));
        String toastMessage = getAppiumDriver().findElement(By.xpath("//android.widget.Toast[1]")).getText();
    }

    public static void scrollUp() {
        Dimension dimension = Driver.getAppiumDriver().manage().window().getSize();

        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * 0.2);
        TouchAction touchAction = new TouchAction<>(Driver.getAppiumDriver());
        touchAction.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y)).perform();

    }


}
// public static void scrollToElement(String elementText, String direction)  {
//     AndroidDriver  driver = (AndroidDriver) getAppiumDriver();
//     // Find the element using the text
//     MobileElement element = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + elementText + "\").instance(0));");

//     // Get the location of the element
//     Point location = element.getLocation();

//     // Get the size of the element
//     Dimension size = element.getSize();

//     // Calculate the center point of the element
//     int centerX = location.x + size.width / 2;
//     int centerY = location.y + size.height / 2;

//     // Get the screen size
//     Dimension screenSize = driver.manage().window().getSize();
//     int screenWidth = screenSize.width;
//     int screenHeight = screenSize.height;

//     // Calculate the start and end points for the swipe gesture
//     int startX = screenWidth / 2;
//     int startY = screenHeight * 3 / 4;
//     int endX = startX;
//     int endY = screenHeight / 4;

//     // If direction is down, swap the start and end points
//     if (direction.equals("down")) {
//         startY = screenHeight / 4;
//         endY = screenHeight * 3 / 4;
//     }

//     // Perform the swipe gesture
//     driver.swipe(startX, startY, endX, endY, 1000);

//     // Check if the element is still not visible
//     while (!element.isDisplayed()) {
//         // If the element is not visible, swipe again
//         driver.swipe(startX, startY, endX, endY, 1000);
//     }
// }
//}

// Use the scroll method
//scrollToElement(driver, "Item 5","down");


//You can use the screen dimensions to scroll down:
//You can store all the images into a list using its available locator.
// Then use driver.scrollToExact(list.get(list.size()).getAttribute("name"));
//
//Example:
//
//List<mobileElement> images = driver.findElementsByClass("<locator>");
//driver.scrollToExact(images.get(images.size()).getAttribute("name"));
//or
//
//driver.scrollToExact(images.get(images.size()).getText());


//  @Test
//  public void testScroll()throws Exception
//  {
//      for(int i=0;i<4;i++)
//      {
//          Thread.sleep(2000);
//          if (driver.findElement(By.name("end_item")).isDisplayed())
//          {
//              driver.findElement(By.name("end_item")).click();
//              break;
//          }
//          else
//          {
//              horizontalScroll();
//          }
//
//      }
//  }
//  public void verticalScroll()
//  {
//      size=driver.manage().window().getSize();
//      int y_start=(int)(size.height*0.60);
//      int y_end=(int)(size.height*0.30);
//      int x=size.width/2;
//      driver.swipe(x,y_start,x,y_end,4000);
//  }



    /*
# Get the size of the screen
screenSize = driver.get_window_size()
# Calculate the start and end coordinates for the swipe gesture
startX = screenSize["width"] * 0.5
startY = screenSize["height"] * 0.75
endX = startX
endY = screenSize["height"] * 0.25
# Perform the swipe gesture
driver.swipe(startX, startY, endX, endY)
     */