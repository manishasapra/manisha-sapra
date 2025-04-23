package com.n26.monefy.app.core.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class is responsible for Keeping OR and methods for search result page
 */
public class SearchResultPage extends AbstractPage {

    //OR for Search Result Page
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

    /**
     * This method is responsible for fetching titile text from the search result
     *
     * @return String
     */
    public String getTitleText() {
        return waitAndReturnElementAvailable(titleTextView).getText();
    }

    /**
     * This method is responsible for fetching amount from the search result
     *
     * @return String
     */
    public String getAmountText() {
        return waitAndReturnElementAvailable(amountTextView).getText();
    }

    /**
     * This method is responsible for fetching note from the search result
     *
     * @return String
     */
    public String getNoteText() {
        return waitAndReturnElementAvailable(noteTextView).getText();
    }

    /**
     * This method is responsible for fetching date from the search result
     *
     * @return String
     */
    public String getDateText() {
        return waitAndReturnElementAvailable(dateTextView).getText();
    }
}
