package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //this class helping us to read data from configuration properties file
    private static Properties properties;

    static {
        String path = "deviceConfig.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {
            System.out.println("Configuration file is not exist.");
        }
    }

    //will return value from config
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}