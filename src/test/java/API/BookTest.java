package API;

import Config.Configuration;
import PageObjects.BookPage;
import Utils.BooksApiUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTest {
    public static BookPage bookPage;
    public static WebDriver driver;

    @BeforeMethod()
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        bookPage = new BookPage(driver);
        driver.get(Configuration.UI_BOOK_URL);
    }

    @Test(description = "Проверка тайтлов")
    public void getTittleOfBooks() {
        Assert.assertEquals(BooksApiUtil.getListOfBooks(), bookPage.getBookTitles(), "Book titles should be equal");
    }

    @AfterMethod()
    public void close() {
        driver.quit();
    }
}