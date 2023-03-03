package API;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest {

    private static final Logger log = Logger.getLogger(CreateUserTest.class);

    private final String request_url = "https://demoqa.com/Account/v1/User";


    //private String first_name = "MAKSIMKA";
    //private String password = "Makimazmakimaz2!1";

    @Test(description = "POST")
    public void successReg() {

        //JSONObject requestBody = new JSONObject();

        /*Создание экземпляра класса RegInfo*/
        RegInfo user = new RegInfo("MAKSIMKA1", "PrizivnoiVozrast12!");

        //requestBody.put("userName", name);
        //requestBody.put("password", password);

        /*Отправка запроса + описание его тела*/
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.body(user);
        Response response = request.post(request_url);
        String body = response.getBody().asString();

        /*Проверка статус кода ответа*/
        int statusCode = response.getStatusCode();
        if (statusCode == 201)
            log.info("Код ответа: " + statusCode + ";" + " Аккаунт создан: " + body);
        else
            log.error("Код ответа: " + statusCode + ";" + " Ошибка в создании аккаунта: " + body);

        Assert.assertEquals(statusCode, 201);
    }
}

