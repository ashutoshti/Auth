package com.auth.TestCases;

import com.auth.Browser.BrowserConfiguration;
import com.auth.Pages.loginPage;
import com.auth.Pages.productSeclectionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class productSelectionTestCase extends BrowserConfiguration {

    loginPage lPage;
    productSeclectionPage productSeclectionPage;

    public productSelectionTestCase() {
        super();
    }

    @BeforeTest
    public void openbrowser() {
        openBrowser();
        lPage = new loginPage();
        productSeclectionPage = new productSeclectionPage();
        lPage.loginAction(properties.getProperty("EmailId"), properties.getProperty("Password"));
    }

    @Test(priority = 1, enabled = true)
    public void verifyPageTitle() {
        String title = productSeclectionPage.getTitle();
        Assert.assertEquals("50 Hertz Limited", title);
    }

    @Test(priority = 2, enabled = true)
    public void openAssertAdminUI() {
        productSeclectionPage.selectAssertAdminUI();
    }

    @Test(priority = 3, enabled = false)
    public void openAssertDashboard() {
        productSeclectionPage.selectAssertDashboard();
    }
}
