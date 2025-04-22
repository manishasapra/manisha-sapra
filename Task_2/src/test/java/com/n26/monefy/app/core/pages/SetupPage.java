package com.n26.monefy.app.core.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetupPage extends AbstractPage {

    //OR for Setup Page.
    @FindBy(id = "com.monefy.app.lite:id/buttonContinue")
    private WebElement btnSetup;

    @FindBy(id = "com.monefy.app.lite:id/buttonClose")
    private WebElement btnClose;

    public SetupPage(AppiumDriver driver) {
        super(driver);
    }

    public void setupApp() {
        log.infoMSG("Setting up the application");
        for(int i = 0; i <=3 ; i++) {
            waitAndReturnElementClickable(btnSetup).click();
        }
    }

    public HomePage closePremiumTab() {
        log.infoMSG("Closing the paywall screen");
        waitAndReturnElementClickable(btnClose).click();
        return new HomePage(driver);
    }
}
