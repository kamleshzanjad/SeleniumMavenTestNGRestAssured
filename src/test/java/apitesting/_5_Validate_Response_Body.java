package apitesting;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class _5_Validate_Response_Body {
    @Test
    public void IteratingHeaders()
    {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();
        System.out.println(body);
        // By using the ResponseBody.asString() method, we can convert the  body
        // into the string representation.
        System.out.println("Response Body is: " );
        System.out.println(body.asString());

    }
}
