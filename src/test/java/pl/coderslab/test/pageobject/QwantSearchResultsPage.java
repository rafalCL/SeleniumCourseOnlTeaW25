package pl.coderslab.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class QwantSearchResultsPage {
    private WebDriver driver;

    public QwantSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getResultsHeaders() {
        List<WebElement> elements = driver.findElements(By.cssSelector("div[data-testid=webResult] a"));
        List<String> result = new ArrayList<>();
        for (WebElement element : elements) {
            result.add(element.getText());
        }
        return result;
    }
}
