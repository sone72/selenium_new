import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.RegisterAccountPage;
import org.pages.SearchResultPage;
import org.pages.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static util.TestUtil.generateRandomEmail;

public class WishlistFlowsTest {

    private WebDriver driver;
    RegisterAccountPage registerAccountPage;
    WishlistPage wishlistPage;
    private SearchResultPage searchResultPage;

    private String loginPageURl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeClass
    public void setUp() {
        System.out.println("Initialize driver.");
        driver = new ChromeDriver();
        registerAccountPage = new RegisterAccountPage(driver);
        wishlistPage = new WishlistPage(driver);
        searchResultPage = new SearchResultPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        createAccount();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + loginPageURl);
        driver.get(loginPageURl);

    }


    @Test
    public void addItemToWishlist(){
        wishlistPage.clickWishlist();
        String actualResult = wishlistPage.getNoResultsElementText();
        String expectedResult = "No results!";
        Assert.assertEquals(actualResult, expectedResult, "Text from element is not the expected one.");
        wishlistPage.enterTextToSearch("Apple Cinema 30\"");
        wishlistPage.clickSearchButton();
        searchResultPage.clickFirstItem();

    }


    public void createAccount() {
        System.out.println("Creating new account to be used in tests ...");
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01234567");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        System.out.println("Creating new account to be used in tests ... Done");
    }
}
