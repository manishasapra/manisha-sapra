package com.n26.monefy.app.core.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends AbstractPage {

    @FindBy(id = "com.monefy.app.lite:id/title_text_view")
    private WebElement titleTextView;

    @FindBy(id = "com.monefy.app.lite:id/amount_text_view")
    private WebElement amountTextView;

    @FindBy(id = "com.monefy.app.lite:id/note_text_view")
    private WebElement noteTextView;

    @FindBy(id = "com.monefy.app.lite:id/date_text_view")
    private WebElement dateTextView;

    public SearchResultPage(AppiumDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return waitAndReturnElementAvailable(titleTextView).getText();
    }

    public String getAmountText() {
        return waitAndReturnElementAvailable(amountTextView).getText();
    }

    public String getNoteText() {
        return waitAndReturnElementAvailable(noteTextView).getText();
    }

    public String getDateText() {
        return waitAndReturnElementAvailable(dateTextView).getText();
    }
}
