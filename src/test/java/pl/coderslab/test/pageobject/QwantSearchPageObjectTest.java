package pl.coderslab.test.pageobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class QwantSearchPageObjectTest {
    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get("https://www.qwant.com/");
    }

    @Test
    public void qwantSearchTest() {
        QwantMainPage qwantMainPage = new QwantMainPage(this.driver);
        // given
        String searchPhrase = "W pustyni i w puszczy";
        // when
        qwantMainPage.appendSearchPhrase(searchPhrase);
        qwantMainPage.clickSearchIcon();
        // then
        QwantSearchResultsPage resultsPage = new QwantSearchResultsPage(this.driver);
        List<String> resultsHeaders = resultsPage.getResultsHeaders();
        String lowercaseSearchPhrase = searchPhrase.toLowerCase();
        for (int i = 0; i<4; i++) {
            String lowerCaseActualPhrase = resultsHeaders.get(i).toLowerCase();
            if(!lowerCaseActualPhrase.contains(lowercaseSearchPhrase)) {
                fail(String.format("Element sholud contain %s, but was: %s", lowercaseSearchPhrase, lowerCaseActualPhrase));
            }
        }
        // driver.quit();
    }
}
