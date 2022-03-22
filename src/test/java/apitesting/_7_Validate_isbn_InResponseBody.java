package apitesting;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _7_Validate_isbn_InResponseBody {
    @Test
    public void IteratingHeaders()
    {
        RestAssured.baseURI = "https://reqres.in/api/products/3";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
        //System.out.println(jsonPathEvaluator);

        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: isbn (Note: You should not put $. in the Java code)
        int id = jsonPathEvaluator.get("data.id");

        // Let us print the city variable to see what we got
        System.out.println("id received from Response " + id);
    }
}

//{"data":{"id":3,"name":"true red","year":2002,"color":"#BF1932","pantone_value":"19-1664"},"support":{"url":"https://reqres.in/#support-heading","text":"To keep ReqRes free, contributions towards server costs are appreciated!"}}