package com.n26.petstore.api.core.helper;

import com.n26.petstore.api.core.controller.EndpointActions;
import com.n26.petstore.api.core.models.Pet;
import io.restassured.response.Response;

public class TestHelper {

    EndpointActions endpointActions = new EndpointActions();

    public Response createPet(Pet pet) {
        return endpointActions.createPet(pet);
    }
}
