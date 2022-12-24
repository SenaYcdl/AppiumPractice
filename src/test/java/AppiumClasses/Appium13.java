package AppiumClasses;

import Appium.BaseClass;
import io.appium.java_client.android.AndroidDriver;


import java.net.MalformedURLException;

public class Appium13 extends BaseClass {

    public Appium13() throws MalformedURLException, InterruptedException {

        AndroidDriver driver= getAndroidDriver();
    }
}
