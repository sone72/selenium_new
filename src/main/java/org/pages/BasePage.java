package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasePage {
    WebDriver driver;

    private By errorMessage = By.xpath(".//div[@class= 'alert alert-danger alert-dismissible']");
    private By wishlistHeartElement = By.xpath(".//a[@aria-label = 'Wishlist']");
    private By searchInput = By.name("search");
    private By shoppingCartElement = By.xpath("//*[@id=\"entry_217825\"]/a/div[1]/span");
    private By editCartElement = By.xpath("//*[@id=\"entry_217850\"]/a");
    private By checkoutElement = By.xpath("//*[@id=\"entry_217851\"]/a/i");



    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clickWishlist() {
        driver.findElement(wishlistHeartElement).click();
    }

    public void enterTextToSearch(String searchText) {
        driver.findElement(searchInput).sendKeys(searchText);
    }
    public void clickShoppingCart() {
        driver.findElement(shoppingCartElement).click();
    }
    public void clickEditCart() {
        driver.findElement(editCartElement).click();
    }
    public void clickCheckoutElement() {
        driver.findElement(checkoutElement).click();

    }

}
