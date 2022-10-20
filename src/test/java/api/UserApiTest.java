package api;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserApiTest {
    RequestSpecifications requestSpecifications = new RequestSpecifications();
    private final String userId = "zhc4v6-5ev7di-9hhhlm";


    @BeforeTest
    public void beforeTest() {
        RestAssured.baseURI = "https://ws-test.keepit.com/";
    }


    @Test(description = "Validate response of user endpoint")
    public void validateUserEndpointResponse() {
        SoftAssert softly = new SoftAssert();

        String response = requestSpecifications.getRequestSpecification()
                .when()
                .get("users/" + userId)
                .then()
                .extract()
                .asString();

        XmlPath xmlPath = new XmlPath(response);

        softly.assertEquals(Boolean.parseBoolean(xmlPath.get("user.enabled")), true,
                "Unexpected \"enabled\" value is present in response");
        softly.assertEquals(xmlPath.get("user.created"), "2019-02-28T13:07:49Z",
                "Unexpected \"created\" value is present in response");
        softly.assertEquals(xmlPath.get("user.product"), "7dwqnq-5cvrcm-1z3ehj",
                "Unexpected \"product\" value is present in response");
        softly.assertEquals(xmlPath.get("user.parent"), "80ltks-yhfls5-24zyf2",
                "Unexpected \"parent\" value is present in response");
        softly.assertEquals(Boolean.parseBoolean(xmlPath.get("user.subscribed")), true,
                "Unexpected \"subscribed\" value is present in response");

        softly.assertAll();
    }

    @Test(description = "Check that user is able to log in")
    public void checkLogIn() {
        int statusCode = requestSpecifications.getRequestSpecification()
                .when()
                .get("users/" + userId)
                .then()
                .extract()
                .statusCode();

        Assert.assertEquals(statusCode, 200,
                String.format("Unexpected status code in response after log in - (%s)", statusCode));
    }
}
