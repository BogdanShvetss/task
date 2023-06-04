package ui.tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.driver.DriverFactory;

public class BasicTest extends TestSetup {
    @Test(description = "Check that user can create a new task")
    public void checkThatUserCanCreateNewTasks() {
        String taskName = "learn " + Faker.instance().programmingLanguage().name();

        mainPage.clickOnCreateTodoListButton()
                .sendKeysToTextArea(taskName)
                .clickOnSaveTasksButton();

        Assert.assertTrue(todoListPage.isTaskWithNameVisible(taskName),
                String.format("Task with name - (%s) wasn't found in a list", taskName));
    }


    @Test(description = "Check that user can edit an existing task")
    public void checkThatUserCanEditExistingTasks() {
        SoftAssert softly = new SoftAssert();

        String taskName = "learn " + Faker.instance().programmingLanguage().name();
        String newTaskName = "learn " + Faker.instance().music().chord();

        mainPage.clickOnCreateTodoListButton()
                .sendKeysToTextArea(taskName)
                .clickOnSaveTasksButton();

        softly.assertTrue(todoListPage.isTaskWithNameVisible(taskName),
                String.format("Task with name - (%s) wasn't found in a list", taskName));

        todoListPage.clickOnTheEditButton()
                .clearTextArea()
                .sendKeysToTextArea(newTaskName)
                .clickOnSaveTasksButton();

        softly.assertTrue(todoListPage.isTaskWithNameVisible(newTaskName),
                String.format("Task with name - (%s) wasn't found in a list (after editing)", taskName));

        softly.assertAll();
    }

    @Test(description = "Check that user can see a history of tasks completion")
    public void checkHistoryOfTasksCompletion() {
        SoftAssert softly = new SoftAssert();
        String taskName = "learn " + Faker.instance().programmingLanguage().name();

        mainPage.clickOnCreateTodoListButton()
                .sendKeysToTextArea(taskName)
                .clickOnSaveTasksButton()
                .clickOnTodayTaskCheckbox()
                .openPageWithTasksHistory();

        softly.assertTrue(tasksHistory.hasFinishedTodayTaskExpectedColor(),
                "Finished today task doesn't have expected color in history page");

        DriverFactory.getDriver().navigate().back();
        todoListPage.clickOnTodayTaskCheckbox()
                .openPageWithTasksHistory();

        softly.assertTrue(tasksHistory.hasUnfinishedTodayTaskExpectedColor(),
                "Unfinished today task doesn't have expected color in history page");

        softly.assertAll();
    }
}