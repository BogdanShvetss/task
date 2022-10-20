package ui.pages;

import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {
    By loginInput = By.cssSelector("input[placeholder='Email']");

    By passwordInput = By.cssSelector("input[placeholder='Password']");

    By submitButton = By.cssSelector("button[type='submit']");


    public MainPage loginOnSite(String email, String password) {
        sendKeysInElement(email, loginInput);
        sendKeysInElement(password, passwordInput);
        clickOnElement(submitButton);

        return new MainPage();
    }

}
