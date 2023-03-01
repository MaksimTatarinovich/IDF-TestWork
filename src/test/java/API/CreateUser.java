package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class CreateUser {

        private static final Logger log = Logger.getLogger(CreateUser.class);


        private String url = "https://demoqa.com/Account/v1/User";
        //private String first_name = "MAKSIMKA";
        //private String password = "Makimazmakimaz2!1";

        @Test(description = "POST")
        public void successReg() {

            //JSONObject requestBody = new JSONObject();
            RegInfo user = new RegInfo("MAKSIMKA1", "Makimazmakimaz21!");

            //requestBody.put("userName", name);
            //requestBody.put("password", password);

            RequestSpecification request = given();
            request.header("Content-Type", "application/json");
            request.body(user);
            Response response = request.post(url);
            String body = response.getBody().asString();


            int statusCode = response.getStatusCode();
            if(statusCode == 201)
                log.info("Код ответа: " + statusCode + ";" + " Аккаунт создан: " + body);
            else
                log.info("Код ответа: " + statusCode + ";" + " Ошибка в создании аккаунта: " + body);

             Assert.assertEquals(statusCode, 201);
        }
    }

