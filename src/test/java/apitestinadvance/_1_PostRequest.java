package apitestinadvance;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class _1_PostRequest {
    @Test
    public void UserRegistrationSuccessful()
    {
        RestAssured.baseURI ="https://demoqa.com/Account/v1";
        RequestSpecification request = RestAssured.given();

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "test_rest");
        requestParams.put("password", "Testrest@123");

        request.body(requestParams.toJSONString());
        Response response = request.put("/User");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }
}
