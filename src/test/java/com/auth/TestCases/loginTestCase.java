package com.auth.TestCases;

import com.auth.Browser.BrowserConfiguration;
import com.auth.Pages.loginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginTestCase extends BrowserConfiguration {
    loginPage lPage;

    public loginTestCase() {
        super();
        lPage = new loginPage();
    }

    @BeforeTest
    public void openbrowser() {
        openBrowser();
        lPage = new loginPage();
    }

    @Test
    public void loginApplication() {
        lPage.loginAction(properties.getProperty("EmailId"), properties.getProperty("Password"));
    }
}
