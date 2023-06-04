package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends AbstractPage {
    By createTodoListButton = By.cssSelector("input[value='Create your Daily Todo list']");

    @Step("Click on the create your daily todo list button")
    public CreateToDoListPage clickOnCreateTodoListButton() {
        clickOnElement(createTodoListButton);

        return new CreateToDoListPage();
    }
}