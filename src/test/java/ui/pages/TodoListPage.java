package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TodoListPage extends AbstractPage {
    By showHistoryOfTaskCompletion = By.cssSelector("td[class='trend more']");
    By editButton = By.xpath("//a[text()='Edit']");
    By todayTaskCheckBox = By.xpath("//td[contains(@class, 'trend current')]");

    @Step("Check that task with name {0} is visible")
    public boolean isTaskWithNameVisible(String taskName) {
        By taskElement =
                By.xpath(String.format("//tr[contains(@class, 'tasktr')]/td[normalize-space() = '%s']", taskName));

        return isElementDisplayed(taskElement);
    }

    @Step("Click on the \"Edit\" button")
    public CreateToDoListPage clickOnTheEditButton() {
        clickOnElement(editButton);

        return new CreateToDoListPage();
    }

    @Step("Open page with history of tasks completion")
    public TasksHistory openPageWithTasksHistory() {
        clickOnElement(showHistoryOfTaskCompletion);

        return new TasksHistory();
    }

    @Step("Click on today task checkbox")
    public TodoListPage clickOnTodayTaskCheckbox() {
        clickOnElement(todayTaskCheckBox);

        return this;
    }
}