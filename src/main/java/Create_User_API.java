import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;


import java.util.Date;

public class Create_User_API {

    private static final Logger log = Logger.getLogger(Create_User_API.class);


    String url = "https://demoqa.com/Account/v1/User";
    String first_name = "MAKSIMKA";
    String password = "Makimazmakimaz2!1";

    @Test(description = "POST")
    public void postRequestExampleTest() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", first_name);
        requestBody.put("password", password);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post(url);

        int statusCode = response.getStatusCode();
        if(statusCode == 201)
            log.info("Аккаунт создан!");
        else
            log.info("Ошибка в создании аккаунта!");

        Assert.assertEquals(statusCode, 201);
        System.out.println(response.getBody().asString());
    }
}
