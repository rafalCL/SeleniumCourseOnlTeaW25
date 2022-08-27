package pl.coderslab.test.zad1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelMyAccountPage {
    private WebDriver driver;

    public HotelMyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountCreationSuccessConfirmed() {
        WebElement confirmationPanel = this.driver.findElement(
                By.cssSelector("p.alert.alert-success")
        );
        String panelText = confirmationPanel.getText();

        return panelText.equals("Your account has been created.");
    }
}
