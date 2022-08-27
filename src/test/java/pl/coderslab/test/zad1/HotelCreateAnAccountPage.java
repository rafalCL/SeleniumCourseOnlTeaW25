package pl.coderslab.test.zad1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelCreateAnAccountPage {
    private WebDriver driver;

    public HotelCreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerAnAccount(AccountData accountData) {
        WebElement isMr = driver.findElement(By.cssSelector("input#id_gender1"));
        WebElement isMrs = driver.findElement(By.cssSelector("input#id_gender2"));
        if(accountData.isMr()) {
            isMr.click();
        } else {
            isMrs.click();
        }
        WebElement firstNameInput = driver.findElement(By.cssSelector("input#customer_firstname"));
        firstNameInput.sendKeys(accountData.getFirstName());
        WebElement lastNameInput = driver.findElement(By.cssSelector("input#customer_lastname"));
        lastNameInput.sendKeys(accountData.getLastName());
        WebElement passwordInput = driver.findElement(By.cssSelector("input#passwd"));
        passwordInput.sendKeys(accountData.getPassword());
        WebElement newsletterCheckbox = driver.findElement(By.cssSelector("input#newsletter"));
        Utils.setCheckbox(newsletterCheckbox, accountData.isSignForNewsletter());

        WebElement registerButton = this.driver.findElement(
                By.cssSelector("button#submitAccount")
        );
        registerButton.click();
    }
}
