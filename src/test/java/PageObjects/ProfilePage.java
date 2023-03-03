package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    private final String userNameXPath = "//label[@id='userName-value']";
    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String userName() {
        return driver.findElement(By.xpath(userNameXPath)).getText();
    }
}
