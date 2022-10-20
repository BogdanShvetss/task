package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {
    By loginInput = By.cssSelector("input[placeholder='Email']");

    By passwordInput = By.cssSelector("input[placeholder='Password']");

    By submitButton = By.cssSelector("button[type='submit']");

    @Step("Log in on site with credentials {0}, {1}")
    public MainPage loginOnSite(String email, String password) {
        sendKeysInElement(email, loginInput);
        sendKeysInElement(password, passwordInput);
        clickOnElement(submitButton);

        return new MainPage();
    }

}
