package com.auth.Utilities;

import com.auth.Browser.BrowserConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util extends BrowserConfiguration {

    public static long PAGE_LOAD_TIMEOUT = 50;
    public static long IMPLICIT_WAIT = 20;

    public static void screenshot() throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss'.png'").format(new Date());
        String currentDir = System.getProperty("user.dir");
        File Destination = new File(currentDir + "/src/Screenshots/" + filename);
        org.apache.commons.io.FileUtils.copyFile(source, Destination);
        System.out.println("ScreenShot taken");
    }
}
