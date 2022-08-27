package pl.coderslab.test.pageobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QwantSearchPageObjectTest {
    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://www.qwant.com/");
    }

    @Test
    public void qwantSearchTest() {
        QwantMainPage qwantMainPage = new QwantMainPage(this.driver);
        qwantMainPage.appendSearchPhrase("W pustyni i w puszczy");
        qwantMainPage.clickSearchIcon();
        // driver.quit();
    }
}
