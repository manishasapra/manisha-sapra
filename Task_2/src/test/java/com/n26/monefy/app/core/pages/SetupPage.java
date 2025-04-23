package com.n26.monefy.app.core.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class is responsible for Keeping OR and methods for initial setup of app
 */
public class SetupPage extends AbstractPage {

    //OR for initial setup
    @FindBy(id = "com.monefy.app.lite:id/buttonContinue")
    private WebElement btnSetup;

    @FindBy(id = "com.monefy.app.lite:id/buttonClose")
    private WebElement btnClose;

    public SetupPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * This method is responsible for accepting the initial app tour
     */
    public void setupApp() {
        log.infoMSG("Setting up the application");
        for(int i = 0; i <=3 ; i++) {
            waitAndReturnElementClickable(btnSetup).click();
        }
    }

    /**
     * This method is responsible for closing the paywall screen
     *
     * @return HomePage
     */
    public HomePage closePremiumTab() {
        log.infoMSG("Closing the paywall screen");
        waitAndReturnElementClickable(btnClose).click();
        return new HomePage(driver);
    }
}
