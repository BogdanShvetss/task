package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import testData.Constants;

public class RequestSpecifications {

    RequestSpecification getRequestSpecification() {
        return RestAssured.given()
                .log()
                .all()
                .contentType(ContentType.XML)
                .auth()
                .basic(Constants.LOGIN, Constants.PASSWORD);
    }
}
