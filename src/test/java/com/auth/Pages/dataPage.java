package com.auth.Pages;

import com.auth.Browser.BrowserConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class dataPage extends BrowserConfiguration {

    @FindBy(xpath = "//div[contains(@class,'css-1hwfws3')]")
    WebElement dropDown;
    @FindBy(xpath = "//button[contains(text(),'Upload CSV')]")
    WebElement uploadCSVBtn;
    @FindBy(xpath = "//button[contains(text(),'Add ')]")
    WebElement uploadAddBtn;
    @FindBy(xpath = "//span[contains(text(),'Data')]")
    WebElement dataPaneLeftSide;
    @FindBy(xpath = "//input[@id='file']")
    WebElement uploadFileBtn;
    @FindBy(xpath = "//span[contains(text(),'×')]")
    WebElement closeBtnonAddBtn;


    public dataPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectDropDown() {
        for (int i = 0; i < 10; i++) {
            dataPaneLeftSide.click();
            dropDown.click();
            String dropDownValue = driver.findElement(By.xpath("//div[@id='react-select-2-option-" + i + "']")).getText();
            System.out.println("Value of DropDown: " + dropDownValue);
            driver.findElement(By.xpath("//div[@id='react-select-2-option-" + i + "']")).click();
            if (i==0)
            {
                continue;
            }
            else {
                uploadAddButton();
            }
            WebDriverWait wait=new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(dataPaneLeftSide))));
        }
    }

    public void uploadAddButton(){
        uploadAddBtn.click();
        closeBtnonAddBtn.click();
    }
}
