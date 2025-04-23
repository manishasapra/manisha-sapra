package com.n26.monefy.app.core.base;

import com.n26.monefy.app.core.config.TestConfig;
import com.n26.monefy.app.core.pages.HomePage;
import com.n26.monefy.app.core.pages.IncomeAndExpensePage;
import com.n26.monefy.app.core.pages.SearchResultPage;
import com.n26.monefy.app.core.pages.SetupPage;
import com.n26.monefy.app.core.utils.CommonUtility;
import com.n26.monefy.app.core.utils.LoggerUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.*;

import java.net.URL;

/**
 * This is the base class which is responsible for passing cruical dependencies
 */
public class BaseTest {

    public AppiumDriver driver;
    protected final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());
    public final LoggerUtility log = new LoggerUtility(LogManager.getLogger(getClass()));
    protected CommonUtility commonUtility = new CommonUtility();

    protected SetupPage setupPage;
    protected HomePage homePage;
    protected IncomeAndExpensePage incomeAndExpensePage;
    protected SearchResultPage searchResultPage;

    /**
     * This method is responsible for launching and setting up the app initially
     *
     * @throws Exception
     */
    @BeforeSuite
    protected void setUpApp() throws Exception {
        driver = getAppiumDriver();
        setupPage = new SetupPage(driver);
        setupPage.setupApp();
    }

    /**
     * This method is responsible for setup before every test method call
     */
    @BeforeMethod
    protected void setUp() {
        ((InteractsWithApps) driver).activateApp(testConfig.appPackage());
    }

    /**
     * This method is responsible for tearDown after every test method call
     */
    @AfterMethod
    protected void tearDown() {
        ((InteractsWithApps) driver).terminateApp(testConfig.appPackage());
    }

    /**
     * This method is responsible for quitting the driver after suite
     */
    @AfterSuite
    protected void TearDownApp() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * This method is responsible for setting up the AppiumDriver to use further in the tests
     *
     * @return
     * @throws Exception
     */
    public AppiumDriver getAppiumDriver() throws Exception {

        log.infoMSG("Initializing common capabilities.");

        switch (testConfig.platform().toLowerCase()) {
            case "android":
                log.infoMSG("Platform is Android, initializing Android specific capabilities.");

                UiAutomator2Options androidOptions = new UiAutomator2Options();
                androidOptions.setDeviceName(testConfig.deviceName());
                androidOptions.setPlatformVersion(testConfig.platformVersion());
                androidOptions.setPlatformName(testConfig.platform());
                androidOptions.setAppPackage(testConfig.appPackage());
                androidOptions.setAppActivity(testConfig.appActivity());


                driver = new AndroidDriver(new URL(testConfig.appiumUrl()), androidOptions);
                break;

            case "ios":
                log.infoMSG("Platform is iOS, initializing iOS specific capabilities.");
                //We can place the IOS related initialization here.
                break;

            default:
                throw new Exception("Invalid platform! - " + testConfig.platform());
        }

        log.infoMSG("Driver initialized, application launch successful.");
        return driver;
    }
}
