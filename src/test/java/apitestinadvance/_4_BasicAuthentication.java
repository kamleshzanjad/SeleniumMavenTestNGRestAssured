package apitestinadvance;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _4_BasicAuthentication {
    String userId= "de5d75d1-59b4-487e-b632-f18bc0665c0d";
    String baseUrl="https://demoqa.com/swagger/";

    @Test
    public void getUserData() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given();
        ///.header("Authorization", "Bearer " + token).header("Content-Type", "application/json");

        Response response = httpRequest.get("/Account/v1/User/"+userId);
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Status message " + response.body().asString());
    }
}

/*
Status code: 401
Status message:
{
    "StatusID": "FAULT_USER_INVALID_USER_PASSWORD",
    "Status": "Invalid or expired Authentication key provided"
}
 */