package com.auth.Browser;

import com.auth.Utilities.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BrowserConfiguration {
    public static WebDriver driver;
    public static Properties properties;

    public BrowserConfiguration() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/Properties/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            System.out.println("Property File Not Found");
        }
    }

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/Driver/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(properties.getProperty("URL"));
    }

    @AfterSuite(enabled = true)
    public void closeBrowser() {
        driver.quit();
    }
}
