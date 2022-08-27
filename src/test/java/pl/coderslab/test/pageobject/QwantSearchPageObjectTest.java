package pl.coderslab.test.pageobject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QwantSearchPageObjectTest {
    @Test
    public void qwantSearchTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.qwant.com/");
        QwantMainPage qwantMainPage = new QwantMainPage(driver);

        qwantMainPage.enterSearchPhrase("W pustyni i w puszczy");
        qwantMainPage.clickSearchIcon();
        // driver.quit();
    }
}
