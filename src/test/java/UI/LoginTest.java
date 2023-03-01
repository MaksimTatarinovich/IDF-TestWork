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


    /*
    Перед началом сценария запускаем веб-драйвер
    */
    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        login = new Login(driver);
        profile = new Profile(driver);

        driver.manage().window().maximize();



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/login");





        log.info("Веб-драйвер запущен!");

    }

    @Test
    public void successLogin(){
        String name = login.setUserName("MAKSIMKA1");
        login.setPassword("Makimazmakimaz21!");
        login.clickLoginButton();
        Assert.assertEquals(name, profile.userName());

    }

    /*
    После выполнения всех тестов закрываем драйвер
    */
    @AfterTest
    public void close(){
        driver.quit();
        log.info("Веб-драйвер закрыт!");
    }
}
