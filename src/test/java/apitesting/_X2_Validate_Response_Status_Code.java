package apitesting;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _X2_Validate_Response_Status_Code {
    @Test
    public void GetWeatherDetails()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a GET request call directly by using RequestSpecification.get() method.
        // Make sure you specify the resource name.
        Response response = httpRequest.get("/Hyderabad");

        // Response.asString method will directly return the content of the body
        // as String.
        System.out.println("Response Body is =>  " + response.asString());

        // Get the status code from the Response. In case of
        // a successfull interaction with the web service, we
        // should get a status code of 200.
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
    }
}
