package pl.coderslab.test.zad1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.test.pageobject.QwantMainPage;
import pl.coderslab.test.pageobject.QwantSearchResultsPage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class HotelTest {
    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void hotelTest() {
        HotelMainPage hotelMainPage = new HotelMainPage(driver);
        hotelMainPage.clickSignIn();

        HotelAuthenticationPage authenticationPage = new HotelAuthenticationPage(driver);
        String randomEmail = UUID.randomUUID().toString() + "@mail.pl";
        authenticationPage.submitCreateAnAccountForm(randomEmail);

        HotelCreateAnAccountPage createAnAccountPage = new HotelCreateAnAccountPage(driver);
        AccountData accountData = new AccountData()
                .setMr(true)
                .setFirstName("aleksander")
                .setLastName("makota")
                .setPassword("tajnehaslo")
                .setDateOfBirth(LocalDate.of(1995, 2, 14))
                .setSignForNewsletter(true)
                .setRecieveSpecialOffers(false);
        createAnAccountPage.registerAnAccount(accountData);

        HotelMyAccountPage myAccountPage = new HotelMyAccountPage(driver);
        assertTrue(myAccountPage.isAccountCreationSuccessConfirmed());
    }
}
