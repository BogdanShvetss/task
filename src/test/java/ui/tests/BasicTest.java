package ui.tests;

import testData.Constants;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BasicTest extends TestSetup {
    @Test(description = "Validate that user can create an Office 365 Admin")
    public void checkPossibilityAddingMicrosoftConnector() {
        SoftAssert softly = new SoftAssert();
        loginPage.loginOnSite(Constants.LOGIN, Constants.PASSWORD);

        softly.assertTrue(mainPage.isMainPageOpened(), "Main page isn't opened");

        mainPage.addConnector("Microsoft");

        softly.assertTrue(mainPage.isMicrosoftConnectorFrameVisible(), "Adding microsoft connector frame isn't visible");

        softly.assertAll();
    }
}
