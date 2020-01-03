package com.auth.Pages;

import com.auth.Browser.BrowserConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class assetAdminUIPage extends BrowserConfiguration {

    @FindBy(xpath = "//span[contains(text(),'Data')]")
    WebElement data;
    @FindBy(xpath = "//span[contains(text(),'Schema')]")
    WebElement schema;

    public assetAdminUIPage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public dataPage selectDataTab() {
        data.click();
        return new dataPage();
    }

    public schemaPage selectSchemaTab() {
        schema.click();
        return new schemaPage();
    }
}
