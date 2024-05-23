package com.inetbanking.utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig() {
        File src = new File("./Configuration/Config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is : " + e.getMessage());
        }
    }

    //implementation of key value pairs of config properties file
    public String getApplicationURL() {
        String url = pro.getProperty("baseURL");
        System.out.println(url);
        return url;
    }

    public String getUsername() {
        return pro.getProperty("username");
    }

    public String getPassword() {
        return pro.getProperty("password");
    }

    public String getChromePath() {
        return pro.getProperty("chromepath");
    }

    public String getFirefoxPath() {
        return pro.getProperty("firefoxpath");
    }

    public String getIEPath() {
        return pro.getProperty("iepath");
    }

}
