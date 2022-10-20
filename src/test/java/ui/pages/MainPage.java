package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends AbstractPage {
    By addConnectorButton = By.xpath("//button[text()='Add connector']");

    By addMicrosoftConnectorFrame = By.xpath("//div[text()='Add Microsoft 365 connector']");

    @Step("Add new connector with type - ({0})")
    public void addConnector(String connectorType) {
        clickOnElement(addConnectorButton);
        By connectorLocator = By.xpath(String.format(
                "//div[contains(@class, 'item')]/span[contains(text(), \"%s\")]", connectorType));

        clickOnElement(connectorLocator);
    }

    @Step("Check if main page is opened")
    public boolean isMainPageOpened() {
        return isElementDisplayed(addConnectorButton);
    }

    @Step("Check that microsoft connector frame is visible")
    public boolean isMicrosoftConnectorFrameVisible() {
        return isElementDisplayed(addMicrosoftConnectorFrame);
    }
}
