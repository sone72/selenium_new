import org.pages.AccountCreatedPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static util.TestUtil.generateRandomEmail;


public class RegisterAccountTests extends BaseTest{

    private RegisterAccountPage registerAccountPage;
    private String registerPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + registerPageURL);
        driver.get(registerPageURL);
        registerAccountPage =  new RegisterAccountPage(driver);
    }

    @Test
    public void registerNewAccountMandatoryFields() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        String actualText = accountCreatedPage.getParagraphText();
        String expectedText = "Congratulations! Your new account has been successfully created!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }

    @Test
    public void registerWithoutPrivacyPolicy() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getErrorMessage();
        String expectedValue = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }

    @Test
    public void registerAccountWithoutFirstName() {
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getFirstNameErrorMessage();
        String expectedValue = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }
    @Test
    public void registerAccountWithoutLastName () {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("12345677");
        registerAccountPage.setPassword("Password777!");
        registerAccountPage.setPasswordConfirm("Password777!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getLastNameErrorMessage();
        String expectedValue ="Last Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }

    @Test
    public void registerWithoutEmail () {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertPhoneNumber("12345677");
        registerAccountPage.setPassword("Password777!");
        registerAccountPage.setPasswordConfirm("Password777!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getEmailErrorMessage();
        String expectedValue ="E-Mail Address does not appear to be valid!";
        Assert.assertEquals(actualValue, expectedValue,"Error message is not the expected one.");

    }

    @Test
    public void registerWithoutPhoneNumber () {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.setPassword("Password777!");
        registerAccountPage.setPasswordConfirm("Password777!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getPhoneNumberErrorMessage();
        String expectValue ="Telephone must be between 3 and 32 characters!";
        Assert.assertEquals(actualValue, expectValue, "Error message is not the expected one.");

    }

    @Test
    public void registerWithoutPassword () {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("123345677");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getPasswordErrorMessage();
        String expectedValue="Password must be between 4 and 20 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");
    }

    @Test
    public void registerWithoutPasswordConfirm () {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("123345677");
        registerAccountPage.setPassword("Password777!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getPasswordConfirmErrorMessage();
        String expectedValue ="Password confirmation does not match password!";
        Assert.assertEquals(actualValue, expectedValue, "Error Message is not the expected one");
    }

    @Test
    public void registerWithNewsletterSubscribe () {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("12334567");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.checkNewsletterSubscribe();
        registerAccountPage.clickContinue();
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        String actualText = accountCreatedPage.getParagraphText();
        String expectedText = "Congratulations! Your new account has been successfully created!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");

    }
}

