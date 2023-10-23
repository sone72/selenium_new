import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.RegisterAccountPage;
import org.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static util.TestUtil.generateRandomEmail;

public class ShoppingCartTests  {

    private WebDriver driver;
    private RegisterAccountPage registerAccountPage;
    private ShoppingCartPage shoppingCartPage;
    private String loginPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeClass
    public void setUp(){
        System.out.println("Initialize driver.");
        driver = new ChromeDriver();
        registerAccountPage = new RegisterAccountPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        createAccount();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + loginPageUrl);

    }

    @Test
    public void viewShoppingCart() {
        shoppingCartPage.clickShoppingCart();
        String actualResult = shoppingCartPage.getEmptyCartElementText();
        String expectedResult = "Your shopping cart is empty!";
        Assert.assertEquals(actualResult, expectedResult , "Text is not the expected one.");
    }

    @Test
    public void editCart() {
        shoppingCartPage.clickEditCart();
        String actualResult = shoppingCartPage.getEditCartElementText();
        String expectedResult = "Your shopping cart is empty!";
        Assert.assertEquals(actualResult, expectedResult, "Text is not the expected one");
    }

    @Test
    public void goToCheckout() {
        shoppingCartPage.clickCheckoutElement();
        String actualResult = shoppingCartPage.getCheckoutElementText();
        String expectedResult = "Your shopping cart is empty!";
        Assert.assertEquals(actualResult, expectedResult, "Text is not the expected one");

    }

    //@Test
    //public void addItemToShoppingCart

    public void createAccount() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Closing the driver ...");
        driver.quit();
    }

}
