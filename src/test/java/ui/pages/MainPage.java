package ui.pages;

import org.openqa.selenium.By;

public class MainPage extends AbstractPage {
    By addConnectorButton = By.xpath("//button[text()='Add connector']");

    By addMicrosoftConnectorFrame = By.xpath("//div[text()='Add Microsoft 365 connector']");


    public void addConnector(String connectorType) {
        clickOnElement(addConnectorButton);
        By connectorLocator = By.xpath(String.format(
                "//div[contains(@class, 'item')]/span[contains(text(), \"%s\")]", connectorType));

        clickOnElement(connectorLocator);
    }

    public boolean isMainPageOpened() {
        return isElementDisplayed(addConnectorButton);
    }

    public boolean isMicrosoftConnectorFrameVisible() {
        return isElementDisplayed(addMicrosoftConnectorFrame);
    }
}
