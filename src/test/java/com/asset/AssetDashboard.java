package com.asset;

import com.auth.Utilities.Util;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class AssetDashboard {
    public static WebDriver driver;
    public static Properties properties;
    public static FileInputStream fis;


    public static void main(String[] args) {
        int length = listofCollection();
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/Properties/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            System.out.println("Property File Not Found");
        }
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(properties.getProperty("URL"));

        driver.findElement(By.id("adminEmail")).sendKeys(properties.getProperty("EmailId"));
        driver.findElement(By.id("adminPass")).sendKeys(properties.getProperty("Password"));

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        driver.findElement(By.xpath("//div[@class='product-parent-block row']//div[@class='product-text'][contains(text(),'Asset Admin UI')]")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Data')]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <length ; i++) {
            driver.findElement(By.xpath("//div[contains(@class,'css-1hwfws3')]")).click();
            String dropDownValue = driver.findElement(By.xpath("//div[@id='react-select-2-option-" + i + "']")).getText();
            System.out.println("Value of DropDown: " + dropDownValue);
            driver.findElement(By.xpath("//div[@id='react-select-2-option-" + i + "']")).click();
            driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String modalTitle = driver.findElement(By.xpath("//h5[@class='modal-title']")).getText();
            if (modalTitle.equals("root")){
                System.out.println("Hello im @ root");
                driver.findElement(By.xpath("//input[@placeholder='root']")).sendKeys("Hello");
                driver.findElement(By.xpath("//input[@placeholder='child']")).sendKeys("Hello");
                Select statusMode = new Select(driver.findElement(By.xpath("//select[@name='status']")));
                statusMode.selectByIndex(1);//Active
                }
                else{
                System.out.println("Hello im @ other master");
            }
                driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        }


        driver.quit();
    }
    private static int listofCollection() {
        MongoClientURI uri = new MongoClientURI(
                "mongodb://asset_user:asset%405050@13.235.134.79:27017/assetmgmt?3t.uriVersion=2&3t.connectionMode=direct&3t.connection.name=assetmgmtDB&readPreference=primary");
        MongoClient mongoClient = new MongoClient(uri);

        DB db = mongoClient.getDB("assetmgmt");
        Set<String> collection = db.getCollectionNames();
        return collection.size();
    }

}
