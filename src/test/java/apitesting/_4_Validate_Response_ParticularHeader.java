package apitesting;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class _4_Validate_Response_ParticularHeader {
    @Test
    public void IteratingHeaders()
    {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        // Access header with a given name.
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);

        // Access header with a given name.
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);

        // Access header with a given name. Header = Content-Encoding
        String acceptLanguage = response.header("Content-Encoding");

        System.out.println("Content-Encoding: " + acceptLanguage);

        String accLang = response.getHeader("Content-Encoding");

    }
}
