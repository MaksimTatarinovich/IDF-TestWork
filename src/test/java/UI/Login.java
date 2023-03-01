package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver;
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //Буду использовать разные способы(xPath, byID чтобы разнообразить)
    private final String UserNameFieldXPath = "//input[@id='userName']";
    private final String PasswordFieldID = "password";
    private final String LoginButtonXPath = "//button[text()='Login']";
    private final String LoginButtonID = "login";


    public String setUserName(String userName) {
        driver.findElement(By.xpath(UserNameFieldXPath)).sendKeys(userName);
        return userName;
    }

    public void setPassword(String password) {
        driver.findElement(By.id(PasswordFieldID)).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(By.xpath(LoginButtonXPath)).click();
    }

}
