package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest {

    private static final Logger log = Logger.getLogger(LoginTest.class);

    public static WebDriver driver;

    public static Login login;
    public static Profile profile;


    @BeforeSuite(description = "Перед началом сценария запускаем веб-драйвер")
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        login = new Login(driver);
        profile = new Profile(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://demoqa.com/login");

        log.info("Веб-драйвер запущен!");

    }

    @Test(description = "Тест с логинацией существующего юзера")
    public void successLogin(){
        String name = login.setUserName("MAKSIMKA1");
        log.info("Имя пользователя введено успешно");
        login.setPassword("Makimazmakimaz21!");
        log.info("Пароль введён успешно");
        login.clickLoginButton();
        log.info("Кнопка Login нажата успешно");
        Assert.assertEquals(name, profile.userName());
        log.info("Тест №1 завершён");
    }

    @Test(description = "Тест с логинацией несуществующего юзера")
    public void notExistUser(){
        login.setUserName("Aue");
        login.setPassword("NotAue");
        login.clickLoginButton();
        Assert.assertNotNull(login.invLogOrPass());
    }

    @Test(description = "Тест с логинацией с пустым поле имени юзера")
    public void loginWithEmptyUserNameField(){
        login.setUserName("");
        login.setPassword("Maksik");
        login.clickLoginButton();
        Assert.assertNotNull(login.emptyUserNameField());
    }

    @Test(description = "Тест с логинацией с пустым полем пароля")
    public void loginWithEmptyPasswordField(){
        login.setUserName("MAKSIMKA1");
        login.setPassword("");
        login.clickLoginButton();
        Assert.assertNotNull(login.emptyPasswordField());
    }



    @AfterTest(description = "После выполнения всех тестов закрываем драйвер")
    public void close(){
        driver.quit();
        log.info("Веб-драйвер закрыт!");
    }
}
