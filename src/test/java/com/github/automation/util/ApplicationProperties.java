package com.github.automation.util;

import java.io.FileInputStream;
import java.util.Properties;

public class ApplicationProperties {

    private static ApplicationProperties instance;

    public static ApplicationProperties getInstance() {
        if(instance == null) {
            instance = new ApplicationProperties();
        }

        return instance;
    }

    static Properties prop = null;

    public static Properties load(String propertiesPath) {

        prop = new Properties();
        try {
            prop.load(new FileInputStream(propertiesPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String getPropertyValue(String key) {
        prop = load("src/test/resources/properties/config.properties");
        return prop.getProperty(key);
    }

    public static String getRightPath(String key) {
        if(key != null) {
            if(isWindows()){
                key = key.replace("\\", "\\\\");
            }else {
                key = key.replace("\\", "/"); //unix
            }
        }
        return key;
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("windows");
    }

}
