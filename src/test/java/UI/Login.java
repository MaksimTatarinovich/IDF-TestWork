package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Login {

    private static final Logger log = Logger.getLogger(Login.class);

    WebDriver driver;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /*Буду использовать разные способы(xPath, byID чтобы разнообразить)*/
    private final String UserNameFieldXPath = "//input[@id='userName']";
    private final String PasswordFieldID = "password";
    private final String LoginButtonXPath = "//button[text()='Login']";
    private final String LoginButtonID = "login";
    private final String InvalidLoginOrPasswordXPath = "//p[@id='name']";
    private final String EmptyUserNameFieldXPath = "//input[contains(@class, 'is-invalid') and @id = 'userName']";
    private final String EmptyPasswordFieldXPath = "//input[contains(@class, 'is-invalid') and @id = 'password']";
    private final String URL = "https://demoqa.com/login";


    /*Метод ввода имени юзера в поле для ввода имени*/
    public String setUserName(String userName) {
        driver.findElement(By.xpath(UserNameFieldXPath)).sendKeys(userName);
        //log.info("Имя пользователя введено успешно");
        return userName;
    }

    /*Метод ввода пароля в строку для пароля*/
    public void setPassword(String password) {
        driver.findElement(By.id(PasswordFieldID)).sendKeys(password);
        //log.info("Пароль введён успешно");
    }


    public String getURL(){
        log.info("Веб-драйвер запущен");
        return URL;
    }

    /*Метод нажатия на кнопку Login*/
    public void clickLoginButton() {
        driver.findElement(By.xpath(LoginButtonXPath)).click();
        log.info("Кнопка Login нажата");
    }

    /*Метод, в котором достаётся ответ при неверном вводе логина или пароля*/
    public String invLogOrPass() {
        log.error("Введён неверный логин или пароль. Такого пользователя не существует");
        return driver.findElement(By.xpath(InvalidLoginOrPasswordXPath)).getText();
    }

    public WebElement emptyUserNameField() {
        log.error("Поле имени пользователя пустое");
        return driver.findElement(By.xpath(EmptyUserNameFieldXPath));
    }

    public WebElement emptyPasswordField() {
        log.error("Поле пароля пустое");
        return driver.findElement(By.xpath(EmptyPasswordFieldXPath));
    }

}
