package com.auth.TestCases;

import com.auth.Browser.BrowserConfiguration;
import com.auth.Pages.dataPage;
import com.auth.Pages.loginPage;
import com.auth.Pages.productSeclectionPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dataPageTestCase extends BrowserConfiguration {
    loginPage lPage;
    productSeclectionPage productSeclectionPage;
    dataPage dataPage;

    public dataPageTestCase() {
        super();
    }

    @BeforeTest
    public void openbrowser() {
        openBrowser();
        lPage = new loginPage();
        productSeclectionPage = new productSeclectionPage();
        lPage.loginAction(properties.getProperty("EmailId"), properties.getProperty("Password"));
        productSeclectionPage.selectAssertAdminUI();
        dataPage = new dataPage();
    }

    @Test
    public void dropDownAction() {
        dataPage.selectDropDown();
        dataPage.uploadAddButton();
    }

}
