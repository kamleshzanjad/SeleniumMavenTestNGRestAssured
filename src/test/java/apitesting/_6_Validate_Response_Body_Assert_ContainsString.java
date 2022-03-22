package apitesting;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _6_Validate_Response_Body_Assert_ContainsString {
    @Test
    public void IteratingHeaders()
    {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();

        String bodyAsString = body.asString();

        // convert the body into lower case and then do a comparison to ignore casing.
        Assert.assertEquals(bodyAsString.toLowerCase().contains("isbn"), true , "Response body contains isbn");

    }
}
