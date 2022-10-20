package ui.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ui.driver.DriverFactory;
import ui.pages.LoginPage;
import ui.pages.MainPage;

public class TestSetup {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    DriverFactory customWebDriver = new DriverFactory();

    private String baseUrl = "https://ws-test.keepit.com/";

    @BeforeTest
    public void beforeTest() {
        customWebDriver.initDriver(DriverFactory.Browser.CHROME);
        DriverFactory.getDriver().navigate().to(baseUrl);
    }

    @AfterTest
    public void AfterTest() {
        if (DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
        }
    }
}
