package com.n26.petstore.api.core.controller;

import com.n26.petstore.api.core.models.Pet;
import com.n26.petstore.api.core.dataprovider.DataProviderConstants;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.*;

/**
 * This class is responsible for calling the actual endpoints
 */
public class EndpointActions {

    /**
     * This class is responsible for creating a PET
     *
     * @param pet
     * @return Response
     */
    public Response createPet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post()
                .then()
                .extract()
                .response();
    }

    /**
     * This class is responsible for fetching a PET with id
     *
     * @param petId
     * @return Response
     */
    public Response getPetById(long petId) {
        return given()
                .pathParam("petId", petId)
                .when()
                .get(ControllerConstants.PET_ID_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    /**
     * This class is responsible for updating a PET
     *
     * @param pet
     * @return Response
     */
    public Response updatePet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put()
                .then()
                .extract()
                .response();
    }

    /**
     * This class is responsible for updating a PET with Id
     *
     * @param pet
     * @return Response
     */
    public Response updatePetById(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .pathParam("petId", pet.getId())
                .queryParam("name", DataProviderConstants.UPDATED_NAME)
                .queryParam("status", DataProviderConstants.UPDATED_STATUS)
                .when()
                .post(ControllerConstants.PET_ID_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    /**
     * This class is responsible for fetching PETs with tag
     *
     * @param filterTag
     * @return Response
     */
    public Response getPetByFilterTag(String filterTag) {
        return given()
                .queryParam("tags", filterTag)
                .when()
                .get(ControllerConstants.FIND_BY_TAGS_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    /**
     * This class is responsible for fetching PETs with status
     *
     * @param status
     * @return Response
     */
    public Response getPetByStatus(String status) {
        return given()
                .queryParam("status", status)
                .when()
                .get(ControllerConstants.FIND_BY_STATUS_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    /**
     * This class is responsible for uploading image to a created PET
     *
     * @param petId
     * @param file
     * @return Response
     */
    public Response uploadImageAsOctetStream(long petId, File file) {
        EncoderConfig encoderconfig = new EncoderConfig();
        return given().log().all()
                .config(RestAssured.config()
                        .encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .pathParam("petId", petId)
                .header("Content-Type", "application/octet-stream")
                .body(file.getAbsoluteFile())
                .when()
                .post(ControllerConstants.PET_ID_ENDPOINT + ControllerConstants.UPLOAD_IMAGE_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    /**
     * This class is responsible for deleting a created PET
     *
     * @param petId
     * @return Response
     */
    public Response deletePet(long petId) {
        return given()
                .pathParam("petId", petId)
                .when()
                .delete(ControllerConstants.PET_ID_ENDPOINT)
                .then()
                .extract()
                .response();
    }
}
