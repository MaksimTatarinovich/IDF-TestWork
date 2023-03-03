package API;

import Config.Configuration;
import PageObjects.BookPage;
import Utils.CreateUserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest {

    public static WebDriver driver;
    public static CreateUserUtil createUserUtil;

    @BeforeMethod()
    public void setUp() {
        createUserUtil = new CreateUserUtil();
    }

    @Test(description = "POST")
    public void reg() {
        createUserUtil.newUserRegistration();
    }
}

