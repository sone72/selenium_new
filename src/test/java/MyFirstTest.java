import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class MyFirstTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void firstTest() {
        driver.get("http://testfasttrackit.info/magento-test/");
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("Youtube");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[1]/button"));
        searchButton.click();
        WebElement searchResultTextElement = driver.findElement(By.className("note-msg"));
        String actualText = searchResultTextElement.getText();
        String expectedText = "Your search returns no results.";

        Assert.assertEquals(actualText, expectedText, "Search result text is not the expected one");
    }

    @Test
    public void secondTest() {
        driver.get("http://testfasttrackit.info/magento-test/");
        WebElement searchLogo = driver.findElement(By.xpath("//*[@id=\"header\"]/div/a/img[1]"));
        searchLogo.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://testfasttrackit.info/magento-test/";

        Assert.assertEquals(actualUrl, expectedUrl, "Clicking on logo doesn't return main page");
    }

    //Test to show how to access image by link
    @Test
    public void accessingImageLinksTest() throws Exception {
        driver.get("https://www.facebook.com/pages/create/?ref_type=registration_form");
        Thread.sleep(5000);
        WebElement allowAllCookiesButton = driver.findElement(By.xpath("//button[text()='Allow all cookies']"));
        if (allowAllCookiesButton.isDisplayed()) {
            allowAllCookiesButton.click();
        }
        WebElement facebookLogo = driver.findElement(By.cssSelector("a[title=\"Go to Facebook home\"]"));
        facebookLogo.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - log in or sign up";
        Assert.assertEquals(actualTitle, expectedTitle, "Title of the page is not the expected one after log is clicked");
    }

    //Select Value from DropDown using Selenium WebDriver
    @Test
    public void selectValueFromDropdownTest() {
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
        Select dropDown = new Select(driver.findElement(By.id("select-demo")));
        dropDown.selectByValue("Tuesday");
        WebElement element = driver.findElement(By.xpath("//p[@class='selected-value text-size-14']"));
        Assert.assertTrue(element.getText().contains("Tuesday"), "Selected value is not Tuesday");
    }

    //Select Value from DropDown using Selenium WebDriver
    @Test
    public void selectValueFromMultiselectDropdownTest() throws Exception {
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
        Thread.sleep(5000);
        List<WebElement> Selectable = driver.findElements(By.xpath("//select[@id='multi-select']/option"));
        Actions x = new Actions(driver);

        x.keyDown(Keys.CONTROL)
                .click(Selectable.get(0))
                .click(Selectable.get(4))
                .keyUp(Keys.CONTROL)
                .build().perform();

        WebElement getLastSelectedElement = driver.findElement(By.id("printAll"));
        getLastSelectedElement.click();
        WebElement element = driver.findElement(By.xpath("//p[@class='text-size-14 mt-20']"));
        Assert.assertTrue(element.getText().contains("California,Ohio"), "Selected values are not the expected ones");
    }

    //Test to show how to locate elements by Link Text & Partial Link Text in Selenium
    @Test
    public void locateElementsByLinkAndPartialLinkTest() throws Exception {
        String actualUrl;
        String expectedUrl;

        //element located by linkText()
        Thread.sleep(5000);
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement elementByLink = driver.findElement(By.linkText("Fake Alerts"));
        elementByLink.click();
        actualUrl = driver.getCurrentUrl();
        expectedUrl = "https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html";
        Assert.assertEquals(actualUrl, expectedUrl, "Url is not the expected one");

        //element located by partialLinkText()
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement elementByPartialLink = driver.findElement(By.partialLinkText("Frames Test"));
        elementByPartialLink.click();
        actualUrl = driver.getCurrentUrl();
        expectedUrl = "https://testpages.herokuapp.com/styled/frames/frames-test.html";
        Assert.assertEquals(actualUrl, expectedUrl, "Url is not the expected one");
    }

    //Action Class in Selenium – Mouse Click & Keyboard Events
    @Test
    public void actionClassSeleniumTest() throws Exception {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        Thread.sleep(5000);
        //Actions class method to drag and drop
        Actions builder = new Actions(driver);
        // It is always advisable to Maximize the window before performing DragNDrop action driver.manage().window().maximize();
        driver.manage().window().maximize();
        WebElement from = driver.findElement(By.xpath("//*[text()='Drag me to my target']"));
        WebElement to = driver.findElement(By.id("droppable"));
        //Perform drag and drop
        builder.dragAndDrop(from, to).build().perform();
//        Thread.sleep(5000);
        WebElement dropZoneText = driver.findElement(By.xpath("//*[@id='droppable']/p"));
        Assert.assertEquals(dropZoneText.getText(), "Dropped!", "Text from the dropzone is not the expected one");
    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}

