package com.n26.petstore.api.core.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

/**
 * This interferface is responsible for providing property values to the tests
 */
@LoadPolicy(LoadType.MERGE)
@Sources("classpath:env.properties")
public interface TestConfig extends Config {

    @Key("url")
    String baseUri();
}
