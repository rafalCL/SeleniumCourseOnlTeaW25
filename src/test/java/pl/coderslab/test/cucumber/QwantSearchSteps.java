package pl.coderslab.test.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.test.pageobject.QwantMainPage;
import pl.coderslab.test.pageobject.QwantSearchResultsPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class QwantSearchSteps {
    private WebDriver driver;
    private QwantMainPage qwantMainPage;
    private QwantSearchResultsPage resultsPage;

    @Given("^An url (.*) opened in browser$")
    public void openUrlInBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(url);

        this.qwantMainPage = new QwantMainPage(this.driver);
        this.resultsPage = new QwantSearchResultsPage(this.driver);
    }

    @When("^Search phrase (.*) typed into search input box$")
    public void typeSearchPhrase(String searchPhrase) {
        qwantMainPage.appendSearchPhrase(searchPhrase);
    }

    @And("Search button clicked")
    public void clickSearchButton() {
        qwantMainPage.clickSearchIcon();
    }

    @Then("^First (.*) results contain phrase (.*)$")
    public void firstResultsContainPhrase(int meaningfulResultsCount, String searchPhrase) {
        List<String> resultsHeaders = resultsPage.getResultsHeaders();
        String lowercaseSearchPhrase = searchPhrase.toLowerCase();
        for (int i = 0; i < meaningfulResultsCount; i++) {
            String lowerCaseActualPhrase = resultsHeaders.get(i).toLowerCase();
            if(!lowerCaseActualPhrase.contains(lowercaseSearchPhrase)) {
                fail(String.format("Element sholud contain %s, but was: %s", lowercaseSearchPhrase, lowerCaseActualPhrase));
            }
        }
    }

    @And("Save screenshot")
    public void saveScreenshot() throws IOException {
//Take screenshot (will be saved in default location) and automatically removed after test
        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//Copy the screenshot to desired location
//Path to the location to save screenshot
//(directory for screenshots MUST exist: C:\test-evidence) e.g.:
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "qwant-search-"+currentDateTime+".png"));
    }

    @And("Quit browser")
    public void quitBrowser() {
        driver.quit();
    }
}
