package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstSectionHeader = By.xpath(".//div[@id = 'content']/div[1]/h2");
    private By editAccountElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/edit')]");
    private By changePasswordElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/password')]");
    private By modifyAddressElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/address')]");
    private By myWishlistElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/wishlist')]");
    private By newsletterElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/newsletter')]");

    public String getFirstSectionHeaderText() {
        return driver.findElement(firstSectionHeader).getText();
    }

    public String getEditAccountElementText() {
        return driver.findElement(editAccountElement).getText();
    }

    public String getChangePasswordElementText() {
        return driver.findElement(changePasswordElement).getText();
    }

    public String getModifyAddressElementText() {
        return driver.findElement(modifyAddressElement).getText();
    }

    public String getMyWishlistElementText() {
        return driver.findElement(myWishlistElement).getText();
    }

    public String getNewsletterElementText() {
        return driver.findElement(newsletterElement).getText();
    }
}