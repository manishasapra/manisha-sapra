package com.n26.petstore.api.core.base;

import com.n26.petstore.api.core.config.TestConfig;
import com.n26.petstore.api.core.utils.LoggerUtility;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected final LoggerUtility log = new LoggerUtility(LogManager.getLogger(getClass()));
    protected final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = testConfig.baseUri();
    }
}
