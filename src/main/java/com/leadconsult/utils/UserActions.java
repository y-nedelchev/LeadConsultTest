package com.leadconsult.utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class UserActions {

    public WebDriver getDriver() {
        return driver;
    }

    final WebDriver driver;

    public UserActions() {
        this.driver = Utils.getWebDriver();
    }

    public static void loadBrowser(String baseUrlKey) {
        Utils.getWebDriver().get(Utils.getConfigPropertyByKey(baseUrlKey));
    }

    public static void quitDriver() {
        Utils.tearDownWebDriver();
    }

    //----ELEMENT OPERATIONS----

    public void clickElement(String key, Object... arguments) {
        String locator = Utils.getUIMappingByKey(key, arguments);

        Utils.LOG.info("Clicking on element " + key);
        WebElement element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void moveToNewsroom(String key) {
        String locator = Utils.getUIMappingByKey(key);
        WebElement newsroom = driver.findElement(By.xpath(locator));
        Actions action = new Actions(driver);
        action.moveToElement(newsroom).perform();
    }



    public void typeValueInField(String value, String field, Object... fieldArguments) {
        String locator = Utils.getUIMappingByKey(field, fieldArguments);
        WebElement element = driver.findElement(By.xpath(locator));
        element.sendKeys(value);
    }


    //---- WAITS ----

    public boolean waitForElementPresentTillTimeout(String locator, int timeout, Object... arguments) {
        try {
            String xpath = Utils.getUIMappingByKey(locator, arguments);
            Integer defaultTimeout = Integer.parseInt(Utils.getConfigPropertyByKey("config.defaultTimeoutSeconds"));
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    //----ASSERTS----
    public void assertPageNavigated(String url) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Landed URL is not as expected. Actual URL: " + currentUrl
                + ". Expected URL: " + url, currentUrl.contains(url));
    }

    public void assertElementPresent(String locator) {
        Utils.LOG.info("Asserting element is present");
        Assert.assertNotNull(driver.findElement(By.xpath(Utils.getUIMappingByKey(locator))));
    }


    public void assertElementPresentAfterWait(String locator) {
        waitForElementPresentTillTimeout(locator, 30);
        assertElementPresent(locator);
    }

}
