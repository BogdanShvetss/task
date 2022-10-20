package ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();
    private WebDriver driver;

    private static int timeout = 10;

    public void initDriver(Browser browser) {

        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions());
                break;
            case FIREFOX:
                WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        driver.manage().window().setSize(new Dimension(1024, 768));

        threadLocalWebDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return threadLocalWebDriver.get();
    }

    public enum Browser {
        CHROME, FIREFOX, EDGE
    }
}
