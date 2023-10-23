package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAccountPage extends BasePage{

    public RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameInput = By.id("input-firstname");
    private By lastNameInput = By.id("input-lastname");
    private By emailInput = By.id("input-email");
    private By telephoneInput = By.id("input-telephone");
    private By passwordInput = By.id("input-password");
    private By passwordConfirmInput = By.id("input-confirm");
    private By privacyPolicyCheckbox = By.xpath("//label[@for='input-agree']");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By firstNameErrorElement = By.xpath(".//input[@name = 'firstname']/following-sibling::div");
    private By lastNameErrorElement = By.xpath(".//input[@name = 'lastname']/following-sibling::div");
    private By emailErrorElement = By.xpath("//*[@id=\"account\"]/div[4]/div/div");
    private By phoneNumberErrorElement = By.xpath("//*[@id=\"account\"]/div[5]/div/div");
    private By passwordErrorElement = By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div");
    private By passwordConfirmErrorElement = By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div");
    private By newsletterSubscribeCheckbox = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/div[1]/label");

    public void insertFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void insertEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void insertPhoneNumber(String phoneNumber){
        driver.findElement(telephoneInput).sendKeys(phoneNumber);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void setPasswordConfirm(String passwordConfirm) {
        driver.findElement(passwordConfirmInput).sendKeys(passwordConfirm);
    }

    public void checkPrivacyPolicy() {
        driver.findElement(privacyPolicyCheckbox).click();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getFirstNameErrorMessage() {
        return driver.findElement(firstNameErrorElement).getText();
    }

    public String getLastNameErrorMessage () {
        return driver.findElement(lastNameErrorElement).getText();
    }

    public String getEmailErrorMessage () {
        return driver.findElement(emailErrorElement).getText();
    }

    public String getPhoneNumberErrorMessage () {
        return driver.findElement(phoneNumberErrorElement).getText();
    }

    public String getPasswordErrorMessage () {
        return driver.findElement(passwordErrorElement).getText();
    }

    public String getPasswordConfirmErrorMessage () {
        return driver.findElement(passwordConfirmErrorElement).getText();
    }

    public void checkNewsletterSubscribe () {
        driver.findElement(newsletterSubscribeCheckbox).click();
    }

}

