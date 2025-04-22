package com.n26.monefy.app.scenario;

import com.n26.monefy.app.core.base.BaseTest;
import com.n26.monefy.app.core.dataprovider.MonefyDataProvider;
import com.n26.monefy.app.core.pages.SetupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MonefyTest extends BaseTest {

    @Test(groups = {"Monefy Income/Expense Group"}, dataProvider = "incomeDataProvider", dataProviderClass = MonefyDataProvider.class, priority = 1)
    public void AsAUserIWantToAddIncome(String balance, String amount, String note) {
        SetupPage setupPage = new SetupPage(driver);
        homePage = setupPage.closePremiumTab();
        incomeAndExpensePage = homePage.addIncome();
        homePage = incomeAndExpensePage.enterIncome(note);
        Assert.assertEquals(homePage.getAddedIncome(), amount);
        Assert.assertEquals(homePage.getBalanceAmount(), balance);
    }

    @Test(groups = {"Monefy Income/Expense Group"}, dataProvider = "searchDataProvider", dataProviderClass = MonefyDataProvider.class, priority = 2)
    public void AsAUserIWantToSearchIncome(String amount, String title, String note, String locale) {
        SetupPage setupPage = new SetupPage(driver);
        homePage = setupPage.closePremiumTab();
        searchResultPage = homePage.performSearch(title);
        Assert.assertEquals(searchResultPage.getAmountText(), amount);
        Assert.assertEquals(searchResultPage.getTitleText(), title);
        Assert.assertEquals(searchResultPage.getNoteText(), note);
        Assert.assertEquals(searchResultPage.getDateText(), commonUtility.getCurrentDate(locale));
    }

    @Test(groups = {"Monefy Income/Expense Group"}, dataProvider = "homePageDataProvider", dataProviderClass = MonefyDataProvider.class, priority = 3)
    public void AsAUserIWantToAddExpenseFromHomePage(String balance, String amount) {
        SetupPage setupPage = new SetupPage(driver);
        homePage = setupPage.closePremiumTab();
        incomeAndExpensePage = homePage.addExpenseFromHomePage();
        homePage = incomeAndExpensePage.enterExpenseFromHomePage();
        Assert.assertEquals(homePage.getAddedExpense(), amount);
        Assert.assertEquals(homePage.getBalanceAmount(), balance);
    }

    @Test(groups = {"Monefy Income/Expense Group"}, dataProvider = "expenseDataProvider", dataProviderClass = MonefyDataProvider.class, priority = 4)
    public void AsAUserIWantToAddExpense(String balance, String amount) {
        SetupPage setupPage = new SetupPage(driver);
        homePage = setupPage.closePremiumTab();
        incomeAndExpensePage = homePage.addExpense();
        homePage = incomeAndExpensePage.enterExpense();
        Assert.assertEquals(homePage.getAddedExpense(), amount);
        Assert.assertEquals(homePage.getBalanceAmount(), balance);
    }
}
