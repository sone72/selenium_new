package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    public SearchResultPage (WebDriver driver) {
        this.driver = driver;
    }
    private By resultItems = By.xpath(".//a[contains(@class,'text-ellipsis-2')]");

    public void clickFirstItem() {
        driver.findElements(resultItems).get(0).click();
    }
}
