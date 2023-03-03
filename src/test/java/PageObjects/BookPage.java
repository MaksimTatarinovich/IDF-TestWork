package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BookPage {
    private final String fldBookTitleXPath = "//span[contains(@id,'see-book')]";
    WebDriver driver;

    public BookPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<String> getBookTitles() {
        return driver.findElements(By.xpath(fldBookTitleXPath)).stream().map(value -> value.getText()).collect(Collectors.toList());
    }
}