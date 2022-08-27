package pl.coderslab.test.zad1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelAuthenticationPage {
    @FindBy(css = "input#email_create")
    private WebElement emailInput;
    @FindBy(id = "SubmitCreate")
    private WebElement submitButton;

    public HotelAuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void submitCreateAnAccountForm(String email) {
        emailInput.sendKeys(email);
        submitButton.click();
    }
}
