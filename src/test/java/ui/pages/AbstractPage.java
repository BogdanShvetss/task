package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.DriverFactory;

import java.time.Duration;

public abstract class AbstractPage {

    protected boolean isElementDisplayed(By locator) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
            webDriverWait.until(ExpectedConditions.visibilityOf(DriverFactory.getDriver().findElement(locator)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected void sendKeysInElement(String keys, By locator) {
        DriverFactory.getDriver().findElement(locator).sendKeys(keys);
    }

    protected void clickOnElement(By element) {
        DriverFactory.getDriver().findElement(element).click();
    }
}
