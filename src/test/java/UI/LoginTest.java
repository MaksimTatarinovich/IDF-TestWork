package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class LoginTest {

    private static final Logger log = Logger.getLogger(LoginTest.class);

    WebDriver driver;

    /*
    Перед началом сценария запускаем веб-драйвер
    */
    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        log.info("Веб-драйвер запущен!");

    }

    @Test
    public void count(){
        int a = 5;
        int b = 7;
        int c = a+b;
        System.out.println(c);
        log.info("Тест завершён");
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
