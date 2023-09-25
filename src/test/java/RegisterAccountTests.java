import org.pages.AccountCreatedPage;
import org.pages.RegisterAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;



import static util.TestUtil.generateRandomEmail;


public class RegisterAccountTests {

    private WebDriver driver;
    RegisterAccountPage registerAccountPage;
    private String loginPageURl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeClass
    public void setUp() {
        System.out.println("Initialize driver.");
        driver = new ChromeDriver();

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to " + loginPageURl);
        driver.get(loginPageURl);
        registerAccountPage = new RegisterAccountPage(driver);

    }

    @Test
    public void registerNewAccountMandatoryFieldsTest() throws Exception {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01234567");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        // Thread.sleep(5000)
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.getParagraphText();
        String actualText = accountCreatedPage.getParagraphText();
        String expectedText = "Congratulations! Your new account has been successfully created!";
        Assert.assertEquals(actualText, expectedText , "Actual text is not the expected one.");

    }


    @Test
    public void registerWithoutPrivacyPolicyTest() {


        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01234567");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");

        registerAccountPage.clickContinue();

        String actualValue = registerAccountPage.getErrorMessage();
        String expectedValue = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");

    }
    @Test public void setRegisterAccountWithoutFirstNameTest(){

        registerAccountPage.insertLastName("Doe");

        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01234567");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setPasswordConfirm("Password123!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getFirstErrorMessage();
        String expectedValue = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one.");
    }



    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
