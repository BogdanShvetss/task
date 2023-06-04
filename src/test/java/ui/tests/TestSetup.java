package ui.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import testData.Constants;
import ui.driver.DriverFactory;
import ui.pages.CreateToDoListPage;
import ui.pages.MainPage;
import ui.pages.TasksHistory;
import ui.pages.TodoListPage;

public class TestSetup {
    DriverFactory customWebDriver = new DriverFactory();

    MainPage mainPage = new MainPage();
    CreateToDoListPage createToDoListPage = new CreateToDoListPage();
    TodoListPage todoListPage = new TodoListPage();
    TasksHistory tasksHistory = new TasksHistory();

    @BeforeTest
    public void beforeTest() {
        customWebDriver.initDriver(DriverFactory.Browser.CHROME);
        DriverFactory.getDriver().navigate().to(Constants.BASE_URL);
    }

    @AfterTest
    public void AfterTest() {
        if (DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
        }
    }
}