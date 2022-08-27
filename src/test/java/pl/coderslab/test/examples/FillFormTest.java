package pl.coderslab.test.examples;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class FillFormTest {
    @Test
    public void fillFormTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(" https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        dateOfBirth.sendKeys("2/2/2022");
        dateOfBirth.sendKeys(Keys.ESCAPE);
        WebElement male = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]/input"));
        male.click();
    }
}
