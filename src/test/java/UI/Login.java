package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Login {


    WebDriver driver;
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    /*Буду использовать разные способы(xPath, byID чтобы разнообразить)*/
    private final String UserNameFieldXPath = "//input[@id='userName']";
    private final String PasswordFieldID = "password";
    private final String LoginButtonXPath = "//button[text()='Login']";
    private final String LoginButtonID = "login";
    private final String InvalidLoginOrPasswordXPath = "//p[@id='name']";
    private final String EmptyUserNameFieldXPath = "//input[contains(@class, 'is-invalid') and @id = 'userName']";
    private final String EmptyPasswordFieldXPath = "//input[contains(@class, 'is-invalid') and @id = 'password']";


    /*Метод ввода имени юзера в поле для ввода имени*/
    public String setUserName(String userName) {
        driver.findElement(By.xpath(UserNameFieldXPath)).sendKeys(userName);
        return userName;
    }

    /*Метод ввода пароля в строку для пароля*/
    public void setPassword(String password) {
        driver.findElement(By.id(PasswordFieldID)).sendKeys(password);
    }

    /*Метод нажатия на кнопку Login*/
    public void clickLoginButton(){
        driver.findElement(By.xpath(LoginButtonXPath)).click();
    }

    /*Метод, в котором достаётся ответ при неверном вводе логина или пароля*/
    public String invLogOrPass(){
        WebElement Inv = driver.findElement(By.xpath(InvalidLoginOrPasswordXPath));
        String mess = Inv.getText();
        return mess;
    }

    public WebElement emptyUserNameField(){
        WebElement emptUsNameField = driver.findElement(By.xpath(EmptyUserNameFieldXPath));
        return emptUsNameField;
    }

    public WebElement emptyPasswordField(){
        WebElement emptpassField = driver.findElement(By.xpath(EmptyPasswordFieldXPath));
        return emptpassField;
    }

}
