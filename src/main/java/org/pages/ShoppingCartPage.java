package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emptyCartElement = By.xpath("//*[@id=\"entry_217847\"]/p");
    private By emptyEditCartElement = By.xpath("//*[@id=\"content\"]/p");
    private By emptyCheckoutElement = By.xpath("//*[@id=\"content\"]/p");
    public String getEmptyCartElementText() {
        return driver.findElement(emptyCartElement).getText();
    }
    public String getEditCartElementText() {
        return driver.findElement(emptyEditCartElement).getText();
    }
    public String getCheckoutElementText() {
        return driver.findElement(emptyCheckoutElement).getText();
    }


}

