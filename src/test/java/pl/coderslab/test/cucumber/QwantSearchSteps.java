package pl.coderslab.test.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.test.pageobject.QwantMainPage;
import pl.coderslab.test.pageobject.QwantSearchResultsPage;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class QwantSearchSteps {
    private WebDriver driver;
    private QwantMainPage qwantMainPage;
    private QwantSearchResultsPage resultsPage;
    private String searchPhrase = "W pustyni i w puszczy";

    @Given("An url https:\\/\\/www.qwant.com opened in browser")
    public void openUrlInBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get("https://www.qwant.com/");

        this.qwantMainPage = new QwantMainPage(this.driver);
        this.resultsPage = new QwantSearchResultsPage(this.driver);
    }

    @When("Search phrase <<W pustyni i w puszczy>> typed into search input box")
    public void typeSearchPhrase() {
        qwantMainPage.appendSearchPhrase(searchPhrase);
    }

    @And("Search button clicked")
    public void clickSearchButton() {
        qwantMainPage.clickSearchIcon();
    }

    @Then("First 3 results contain phrase <<W pustyni i w puszczy>>")
    public void firstResultsContainPhrase() {
        List<String> resultsHeaders = resultsPage.getResultsHeaders();
        String lowercaseSearchPhrase = searchPhrase.toLowerCase();
        for (int i = 0; i<4; i++) {
            String lowerCaseActualPhrase = resultsHeaders.get(i).toLowerCase();
            if(!lowerCaseActualPhrase.contains(lowercaseSearchPhrase)) {
                fail(String.format("Element sholud contain %s, but was: %s", lowercaseSearchPhrase, lowerCaseActualPhrase));
            }
        }
    }
}
