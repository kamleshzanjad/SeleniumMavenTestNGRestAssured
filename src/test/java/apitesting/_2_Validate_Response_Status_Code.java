package apitesting;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
public class _2_Validate_Response_Status_Code {
    @Test
    public void GetBookDetails()
    {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");

        // Get the status code from the Response. In case of
        // a successfull interaction with the web service, we
        // should get a status code of 200.
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");

    }
}
