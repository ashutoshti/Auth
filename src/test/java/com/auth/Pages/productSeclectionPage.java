package com.auth.Pages;

import com.auth.Browser.BrowserConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productSeclectionPage extends BrowserConfiguration {

    @FindBy(xpath = "//div[@class='container1 demo-1 flex-hight']//center[1]//div[1]//a[1]")
    WebElement selectAssetDashboard;
    @FindBy(xpath = "//div[@class='product-parent-block row']//div[@class='product-text'][contains(text(),'Asset Admin UI')]")
    WebElement selectAssetAdminUI;

    public productSeclectionPage() {
        PageFactory.initElements(driver, this);
    }

    public assetDashboardPage selectAssertDashboard() {
        selectAssetDashboard.click();
        return new assetDashboardPage();
    }

    public assetAdminUIPage selectAssertAdminUI() {
        selectAssetAdminUI.click();
        return new assetAdminUIPage();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
