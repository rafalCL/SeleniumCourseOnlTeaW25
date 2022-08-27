package pl.coderslab.test.zad1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelAuthenticationPage {
    private WebDriver driver;

    public HotelAuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void submitCreateAnAccountForm(String email) {
        WebElement emailInput = this.driver.findElement(By.cssSelector("input#email_create"));
        emailInput.sendKeys(email);

        WebElement submitButton = this.driver.findElement(By.cssSelector("button#SubmitCreate"));
        submitButton.click();
    }
}
