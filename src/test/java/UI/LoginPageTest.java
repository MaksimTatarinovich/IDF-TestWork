package UI;

import Config.Configuration;
import PageObjects.LoginPage;
import PageObjects.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginPageTest {
    private static final Logger log = Logger.getLogger(LoginPageTest.class);
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profile;

    @BeforeMethod(description = "Перед началом сценария запускаем веб-драйвер")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profile = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(Configuration.LOGIN_URL);
    }

    @Test(description = "Тест с логинацией существующего юзера")
    public void successLoginTest() {
        loginPage.setUserName(Configuration.EXIST_USER_NAME);
        loginPage.setPassword(Configuration.EXIST_USER_PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertEquals(Configuration.EXIST_USER_NAME, profile.userName(), "Успешная логинация");
    }

    @Test(description = "Тест с логинацией несуществующего юзера")
    public void userNotExistTest() {
        loginPage.setUserName(Configuration.NOT_EXIST_USER_NAME);
        loginPage.setPassword(Configuration.NOT_EXIST_USER_PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertNotNull(loginPage.invLogOrPass());
    }

    @Test(description = "Тест с логинацией с пустым поле имени юзера")
    public void loginWithEmptyUserNameFieldTest() {
        loginPage.setUserName("");
        loginPage.setPassword(Configuration.EXIST_USER_PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertNotNull(loginPage.emptyUserNameField());
    }

    @Test(description = "Тест с логинацией с пустым полем пароля")
    public void loginWithEmptyPasswordFieldTest() {
        loginPage.setUserName(Configuration.EXIST_USER_NAME);
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        Assert.assertNotNull(loginPage.emptyPasswordField());
    }

    @AfterMethod(description = "После выполнения всех тестов закрываем драйвер")
    public void close() {
        driver.quit();
        log.info("Веб-драйвер закрыт!");
    }
}
