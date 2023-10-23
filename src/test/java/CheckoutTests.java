import org.openqa.selenium.interactions.Actions;
import org.pages.CheckoutPage;
import org.pages.RegisterAccountPage;
import org.pages.SearchResultsPage;
import org.pages.WishlistPage;
import org.testng.annotations.BeforeClass;

import static util.TestUtil.generateRandomEmail;

public class CheckoutTests extends BaseTest {

    private CheckoutPage checkoutPage;

    private RegisterAccountPage registerAccountPage;
    private WishlistPage wishlistPage;
    private SearchResultsPage searchResultsPage;
    private Actions action;
    private String registerUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeClass
    public void setUpPreconditions() {
        registerAccountPage = new RegisterAccountPage(driver);
        wishlistPage = new WishlistPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        action = new Actions(driver);
        System.out.println("Creating new account to be logged in...");
        registerAccountPage = new RegisterAccountPage(driver);
        createAccount();
        System.out.println("Creating new account to be logged in... Done");
    }



    public void createAccount() {
        driver.get(registerUrl);
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
    }
}
