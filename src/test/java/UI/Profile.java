package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Profile {

    WebDriver driver;

    public Profile(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private final String userNameXPath = "//label[@id='userName-value']";

    public String userName() {
        WebElement userNameValue = driver.findElement(By.xpath(userNameXPath));
        String name = userNameValue.getText();
        return name;
    }



   /* public String getUserName(){
        String userName = userNameValue.getText();
        return userName;
    }
    */

}
