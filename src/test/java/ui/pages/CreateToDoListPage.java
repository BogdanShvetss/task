package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CreateToDoListPage extends AbstractPage {
    By textArea = By.cssSelector("textarea[name='tasks']");
    By saveTasksButton = By.cssSelector("input[value='Save tasks']");

    @Step("Set keys {0} to text area")
    public CreateToDoListPage sendKeysToTextArea(String text) {
        sendKeysInElement(text, textArea);

        return this;
    }

    @Step("Clear text area")
    public CreateToDoListPage clearTextArea() {
        clearTextField(textArea);

        return this;
    }

    @Step("Click on the \"Save Tasks\" button")
    public TodoListPage clickOnSaveTasksButton() {
        clickOnElement(saveTasksButton);

        return new TodoListPage();
    }
}