package com.n26.monefy.app.core.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IncomeAndExpensePage extends AbstractPage {

    @FindBy(id = "com.monefy.app.lite:id/buttonKeyboard0")
    private WebElement amount0Key;

    @FindBy(id = "com.monefy.app.lite:id/buttonKeyboard1")
    private WebElement amount1Key;

    @FindBy(id = "com.monefy.app.lite:id/textViewNote")
    private WebElement noteText;

    @FindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
    private WebElement chooseCategory;

    @FindBy(xpath = "//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[2]/android.widget.LinearLayout")
    private WebElement salaryCategory;

    @FindBy(xpath = "//android.widget.GridView[@resource-id='com.monefy.app.lite:id/gridViewCategories']/android.widget.FrameLayout[1]/android.widget.LinearLayout")
    private WebElement category;

    public IncomeAndExpensePage(AppiumDriver driver) {
        super(driver);
    }

    public HomePage enterIncome(String note) {
        log.infoMSG("Entering income");
        waitAndReturnElementClickable(amount1Key).click();
        amount0Key.click();
        amount0Key.click();
        amount0Key.click();
        log.infoMSG("Entering income note : " + note);
        noteText.sendKeys(note);
        log.infoMSG("Clicking on category icon");
        chooseCategory.click();
        waitAndReturnElementClickable(salaryCategory).click();
        return new HomePage(driver);
    }

    public HomePage enterExpense() {
        log.infoMSG("Entering expense");
        waitAndReturnElementClickable(amount1Key).click();
        amount0Key.click();
        amount0Key.click();
        chooseCategory.click();
        log.infoMSG("Clicking on expense create button");
        waitAndReturnElementClickable(category).click();
        return new HomePage(driver);
    }

    public HomePage enterExpenseFromHomePage() {
        log.infoMSG("Clicking on expense category from home page");
        waitAndReturnElementClickable(amount1Key).click();
        amount0Key.click();
        amount0Key.click();
        log.infoMSG("Clicking on expense create button");
        chooseCategory.click();
        return new HomePage(driver);
    }
}
