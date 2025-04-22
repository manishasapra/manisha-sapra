package com.n26.monefy.app.core.pages;

import com.n26.monefy.app.core.base.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage extends BaseTest {

    public AppiumDriver driver;

    private final WebDriverWait wait;

    public AbstractPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(testConfig.longWait()));
    }

    /*
     * Wait for element to be available and return with specified wait time.
     * Using explicit wait.
     *
     * @param		None			None
     * @return		MobileElement	element after available
     *
     */
    protected WebElement waitAndReturnElementAvailable(WebElement elementToWait) {
        return wait.until(ExpectedConditions.visibilityOf(elementToWait));
    }


    /*
     * Wait for element to be clickable and return with specified wait time.
     * Using explicit wait.
     *
     * @param		None			None
     * @return		MobileElement	element after clickable
     *
     */
    protected WebElement waitAndReturnElementClickable(WebElement elementToWait) {
        return wait.until(ExpectedConditions.elementToBeClickable(elementToWait));
    }
}
