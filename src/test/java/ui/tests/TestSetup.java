package ui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

    @BeforeMethod
    public void beforeTest() {
        customWebDriver.initDriver(DriverFactory.Browser.CHROME);
        DriverFactory.getDriver().navigate().to(Constants.BASE_URL);
    }

    @AfterMethod
    public void AfterTestMethod() {
        if (DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
        }
    }
}