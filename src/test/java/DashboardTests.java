import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.DashboardPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static util.TestUtil.generateRandomEmail;

public class DashboardTests extends BaseTest{

    private RegisterAccountPage registerAccountPage;
    private DashboardPage dashboardPage;
    private String registerUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeClass
    public void setUpPreconditions() {
        System.out.println("Creating new account to be logged in...");
        registerAccountPage =  new RegisterAccountPage(driver);
        createAccount();
        System.out.println("Creating new account to be logged in ... Done");
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void verifyDashboardFirstSection() {
        String expectedFirstSectionHeaderText = "My Account";
        String expectedEditAccountElementText = "Edit your account information";

        Assert.assertEquals(dashboardPage.getFirstSectionHeaderText(), expectedFirstSectionHeaderText,
                "First section header text is not the expected one");
        Assert.assertEquals(dashboardPage.getEditAccountElementText(), expectedEditAccountElementText,
                "Edit account element text is not the expected one");

        String expectedChangePasswordElementText = "Change your password";
        Assert.assertEquals(dashboardPage.getChangePasswordElementText(), expectedChangePasswordElementText,
                "Change password element text is not the expected one");

        String expectedModifyAddressElementText = "Modify your address book entries";
        Assert.assertEquals(dashboardPage.getModifyAddressElementText(), expectedModifyAddressElementText,
                "Modify your address element text is not the expected one");

        String expectedMyWishlistElementText = "Modify your wish list";
        Assert.assertEquals(dashboardPage.getMyWishlistElementText(), expectedMyWishlistElementText,
                "Modify your wishlist element text is not the expected one");

        String expectedNewsletterElementText = "Subscribe / unsubscribe to newsletter";
        Assert.assertEquals(dashboardPage.getNewsletterElementText(), expectedNewsletterElementText,
                "Subscribe / unsubscribe to newsletter text is not the expected one");
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
