package com.auth.Pages;

import com.auth.Browser.BrowserConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends BrowserConfiguration {

    @FindBy(id = "adminEmail")
    WebElement loginEmail;
    @FindBy(id = "adminPass")
    WebElement loginPassword;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    public loginPage() {
        PageFactory.initElements(driver, this);
    }

    public productSeclectionPage loginAction(String loginUserName, String loginUserPassword) {
        loginEmail.sendKeys(loginUserName);
        loginPassword.sendKeys(loginUserPassword);
        loginButton.click();
        return new productSeclectionPage();
    }
}
