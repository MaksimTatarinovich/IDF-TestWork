package Utils;

import Config.RegInfo;
import Config.Configuration;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class CreateUserUtil {

    private static final Logger log = Logger.getLogger(CreateUserUtil.class);


    public void newUserRegistration() {

        /*
        ДАННЫЙ ТЕСТ ПРОХОДИТ ТОЛЬКО ПРИ ОДНОКРАТНОМ ИСПОЛЬЗОВАНИИ, так как создаётся юзер.
        Для следующего использования надо удалить юзера или изменить пароль и имя.
        */

        /*Создание экземпляра класса RegInfo*/
        RegInfo user = new RegInfo(Configuration.EXIST_USER_NAME, Configuration.EXIST_USER_PASSWORD);

        /*Отправка запроса + описание его тела*/
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.body(user);
        Response response = request.post(Configuration.API_ACCOUNT + Configuration.API_ACCOUNT_ENDPOINT);
        String body = response.getBody().asString();
        int statusCode = response.getStatusCode();

        if (statusCode == 201)
            log.info("Код ответа: " + statusCode + ";" + " Аккаунт создан: " + body);
        else
            log.error("Код ответа: " + statusCode + ";" + " Ошибка в создании аккаунта: " + body);

        Assert.assertEquals(statusCode, 201);
    }


}
