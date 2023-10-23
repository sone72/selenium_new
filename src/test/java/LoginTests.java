import org.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static util.TestUtil.generateRandomEmail;

public class LoginTests extends BaseTest{

    LoginPage loginPage;
    private String loginPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/login";

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + loginPageURL);
        driver.get(loginPageURL);
        driver.manage().window().fullscreen();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void invalidCredentialsTest() {
        loginPage.insertEmail(generateRandomEmail());
        loginPage.insertPassword("randomPassword");
        loginPage.clickLogin();
        String actualValue = loginPage.getErrorMessage();
        String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }
    @Test
    public void validCredentialsTest () {
        loginPage.insertEmail(generateRandomEmail());
        loginPage.insertPassword("Password123!");
        loginPage.clickLogin();
    }
    @Test
    public void validEmailTest() {
        loginPage.insertEmail("johndow-8039842604272496244@email.com");
        loginPage.insertPassword("pas123");
        loginPage.clickLogin();
        String actualValue = loginPage.getErrorMessage();
        String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }
}
