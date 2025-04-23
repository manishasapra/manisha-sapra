package com.n26.monefy.app.core.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

/**
 * This class is responsible for Keeping OR and methods for home page
 */
public class HomePage extends AbstractPage {

    //OR for Home Page
    @FindBy(id = "com.monefy.app.lite:id/income_button")
    private WebElement incomeBtn;

    @FindBy(id = "com.monefy.app.lite:id/expense_button")
    private WebElement expenseBtn;

    @FindBy(id = "com.monefy.app.lite:id/income_amount_text")
    private WebElement incomeAmountText;

    @FindBy(id = "com.monefy.app.lite:id/expense_amount_text")
    private WebElement expenseAmountText;

    @FindBy(id = "com.monefy.app.lite:id/balance_amount")
    private WebElement balanceAmount;

    @FindBy(id = "com.monefy.app.lite:id/menu_search")
    private WebElement menuSearch;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView[1]")
    private WebElement category;

    @FindBy(id = "com.monefy.app.lite:id/et_search")
    private WebElement searchTextBox;

    @FindBy(id = "com.monefy.app.lite:id/tv_str")
    private WebElement salarySuggestion;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * This method is responsible for clicking on add income button
     *
     * @return IncomeAndExpensePage
     */
    public IncomeAndExpensePage addIncome() {
        log.infoMSG("Clicking the income button");
        waitAndReturnElementClickable(incomeBtn).click();
        return new IncomeAndExpensePage(driver);
    }

    /**
     * This method is responsible for clicking on add expense button
     *
     * @return IncomeAndExpensePage
     */
    public IncomeAndExpensePage addExpense() {
        log.infoMSG("Clicking the expense button");
        waitAndReturnElementClickable(expenseBtn).click();
        return new IncomeAndExpensePage(driver);
    }

    /**
     * This method is responsible for fetching added income
     *
     * @return String
     */
    public String getAddedIncome() {
        log.infoMSG("Fetching the total income");
        return waitAndReturnElementAvailable(incomeAmountText).getText();
    }

    /**
     * This method is responsible for fetching added expense
     *
     * @return String
     */
    public String getAddedExpense() {
        log.infoMSG("Fetching the total expense");
        return waitAndReturnElementAvailable(expenseAmountText).getText();
    }

    /**
     * This method is responsible for fetching balance amount
     *
     * @return String
     */
    public String getBalanceAmount() {
        log.infoMSG("Fetching the balance amount");
        return waitAndReturnElementAvailable(balanceAmount).getText();
    }

    /**
     * This method is responsible for clicking and searching a title
     *
     * @param title
     * @return SearchResultPage
     */
    public SearchResultPage performSearch(String title) {
        log.infoMSG("Clicking on search icon");
        waitAndReturnElementClickable(menuSearch).click();
        log.infoMSG("Entering title : " + title);
        waitAndReturnElementAvailable(searchTextBox).sendKeys(title);
        log.infoMSG("Clicking on title");
        waitAndReturnElementClickable(salarySuggestion).click();
        return new SearchResultPage(driver);
    }

    /**
     * This method is responsible for clicking on expense button on home page
     *
     * @return IncomeAndExpensePage
     */
    public IncomeAndExpensePage addExpenseFromHomePage() {
        log.infoMSG("Clicking on expense category icon on home page");
        waitAndReturnElementClickable(category).click();
        return new IncomeAndExpensePage(driver);
    }
}
