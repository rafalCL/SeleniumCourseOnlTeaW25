package pl.coderslab.test.zad1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelMainPage {
    private WebDriver driver;

    public HotelMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        WebElement signIn = this.driver.findElement(
                By.cssSelector("a.user_login")
        );
        signIn.click();
    }
}
