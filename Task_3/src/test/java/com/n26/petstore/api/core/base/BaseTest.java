package com.n26.petstore.api.core.base;

import com.n26.petstore.api.core.config.TestConfig;
import com.n26.petstore.api.core.utils.LoggerUtility;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeClass;

/**
 * This is the base class which is responsible for passing crucial dependencies
 */
public class BaseTest {

    protected final LoggerUtility log = new LoggerUtility(LogManager.getLogger(getClass()));
    protected final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());

    /**
     * This method is responsible for setting up base URI before test runs
     */
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = testConfig.baseUri();
    }
}
