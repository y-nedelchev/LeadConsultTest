package com.leadconsult.pages;

import com.leadconsult.utils.UserActions;
import com.leadconsult.utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected String url;
    protected WebDriver driver;
    public UserActions actions;
    protected String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\";

    public BasePage(String urlKey) {
        String pageUrl = Utils.getConfigPropertyByKey(urlKey);
        this.driver = Utils.getWebDriver();
        this.url = pageUrl;
        actions = new UserActions();
    }

    public String getUrl() {
        return url;
    }

    public void navigateToPage() {
        this.driver.get(url);
    }

    public void assert_PageNavigated() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Landed URL is not as expected. Actual URL: "
                + currentUrl + ". Expected URL: " + url, currentUrl.contains(url));
    }
}
