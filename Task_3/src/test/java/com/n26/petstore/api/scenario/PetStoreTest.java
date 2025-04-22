package com.n26.petstore.api.scenario;

import com.n26.petstore.api.core.base.BaseTest;
import com.n26.petstore.api.core.controller.EndpointActions;
import com.n26.petstore.api.core.models.Pet;
import com.n26.petstore.api.core.dataprovider.DataProviderConstants;
import com.n26.petstore.api.core.dataprovider.PetDataProvider;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Test cases for pet shop
 */
public class PetStoreTest extends BaseTest {

    EndpointActions endpointActions = new EndpointActions();

    @Test(groups = {"Pet Shop Group"}, dataProvider = "petData", dataProviderClass = PetDataProvider.class)
    public void validatePetCreation(Pet pet) {

        log.infoMSG("Creating pet with : " + pet);
        Response response = endpointActions.createPet(pet);
        Pet petCreateResponse = response.as(Pet.class);

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_OK);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        log.infoMSG("Validating response payload to be : " + pet);
        Assert.assertEquals(petCreateResponse, pet);
    }

    @Test(groups = {"Pet Shop Group"}, dataProvider = "getPetData", dataProviderClass = PetDataProvider.class)
    public void validateGetPet(Pet pet) {

        log.infoMSG("Creating pet with : " + pet);
        endpointActions.createPet(pet);
        log.infoMSG("Fetching pet with : " + pet);
        Response response = endpointActions.getPetById(pet.getId());
        Pet getPetResponse = response.as(Pet.class);

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_OK);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        log.infoMSG("Validating response payload to be : " + pet);
        Assert.assertEquals(getPetResponse, pet);
    }

    @Test(groups = {"Pet Shop Group"}, dataProvider = "updatePetData", dataProviderClass = PetDataProvider.class)
    public void validateUpdatePet(Pet pet) {

        log.infoMSG("Creating pet with : " + pet);
        endpointActions.createPet(pet);
        log.infoMSG("Updating the name to : " + DataProviderConstants.UPDATED_NAME);
        pet.setName(DataProviderConstants.UPDATED_NAME);
        log.infoMSG("updating pet with : " + pet);
        Response response = endpointActions.updatePet(pet);
        Pet getPetResponse = response.as(Pet.class);

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_OK);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        log.infoMSG("Validating response payload to be : " + pet);
        Assert.assertEquals(getPetResponse, pet);
    }

    @Test(groups = {"Pet Shop Group"})
    public void validateInvalidPetGet() {

        log.infoMSG("Fetching pet with : " + DataProviderConstants.INVALID_PET_ID);
        Response response = endpointActions.getPetById(DataProviderConstants.INVALID_PET_ID);

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_NOT_FOUND);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NOT_FOUND);
        log.infoMSG("Validating response payload to be : Pet not found");
        Assert.assertEquals(response.getBody().asString(), "Pet not found");
    }

    @Test(groups = {"Pet Shop Group"}, dataProvider = "updatePetWithIdData", dataProviderClass = PetDataProvider.class)
    public void validateInvalidPetUpdate(Pet pet) {

        pet.setId(DataProviderConstants.INVALID_PET_ID);
        log.infoMSG("Updating pet with : " + DataProviderConstants.INVALID_PET_ID);
        Response response = endpointActions.updatePetById(pet);

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_NOT_FOUND);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NOT_FOUND);
        log.infoMSG("Validating response payload to be : " + DataProviderConstants.NOT_FOUND_RESPONSE);
        Assert.assertEquals(response.getBody().asString(), DataProviderConstants.NOT_FOUND_RESPONSE);
    }

    @Test(groups = {"Pet Shop Group"}, dataProvider = "updatePetWithIdData", dataProviderClass = PetDataProvider.class)
    public void validateUpdatePetWithId(Pet pet) {

        log.infoMSG("Creating pet with : " + pet);
        endpointActions.createPet(pet);
        log.infoMSG("Updating pet name with : " + DataProviderConstants.UPDATED_NAME);
        pet.setName(DataProviderConstants.UPDATED_NAME);
        log.infoMSG("Updating pet status with : " + DataProviderConstants.UPDATED_STATUS);
        pet.setStatus(DataProviderConstants.UPDATED_STATUS);
        log.infoMSG("Fetching pet with : " + pet);
        Response response = endpointActions.updatePetById(pet);
        Pet getPetResponse = response.as(Pet.class);

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_OK);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        log.infoMSG("Validating response payload to be : " + pet);
        Assert.assertEquals(getPetResponse, pet);
    }

    @Test(groups = {"Pet Shop Group"}, dataProvider = "deletePetData", dataProviderClass = PetDataProvider.class)
    public void validateDeletePet(Pet pet) {

        log.infoMSG("Creating pet with : " + pet);
        endpointActions.createPet(pet);

        log.infoMSG("Validating if the pet present : " + pet);
        Assert.assertEquals(pet, endpointActions.getPetById(pet.getId()).as(Pet.class));

        log.infoMSG("Deleting pet : " + pet);
        Response response = endpointActions.deletePet(pet.getId());

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_OK);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        log.infoMSG("Validating response payload to be : " + DataProviderConstants.DELETED_RESPONSE);
        Assert.assertEquals(response.getBody().asString(), DataProviderConstants.DELETED_RESPONSE);
    }

    @Test(groups = {"Pet Shop Group"}, dataProvider = "uploadImageData", dataProviderClass = PetDataProvider.class)
    public void validateUploadImage(Pet pet) {

        log.infoMSG("Creating pet with : " + pet);
        endpointActions.createPet(pet);
        File imageFile = new File(DataProviderConstants.IMAGE_PATH);

        log.infoMSG("Updating the image : " + imageFile.getName());
        Response response = endpointActions.uploadImageAsOctetStream(pet.getId(), imageFile);
        Pet uploadImageResponse = response.as(Pet.class);

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_OK);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        log.infoMSG("Validating if 'PhotoUrls' are present");
        Assert.assertFalse(uploadImageResponse.getPhotoUrls().isEmpty());
    }

    @Test(groups = {"Pet Shop Group"}, dataProvider = "filterTagData", dataProviderClass = PetDataProvider.class)
    public void validateGetPetByFilterTag(Pet pet) {

        log.infoMSG("Creating pet with : " + pet);
        endpointActions.createPet(pet);

        log.infoMSG("Fetching pets with filter tag : " + DataProviderConstants.FILTER_TAG);
        Response response = endpointActions.getPetByFilterTag(DataProviderConstants.FILTER_TAG);
        List<Pet> findPets = response.as(new TypeRef<List<Pet>>() {});

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_OK);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        List<Long> foundIds = findPets.stream().map(Pet::getId).collect(Collectors.toList());

        log.infoMSG("Validating if pets with specified filters are available");
        Assert.assertTrue(foundIds.contains(pet.getId()),
                "Created pet with ID " + pet.getId() + " not found in tag filter results");
    }

    @Test(groups = {"Pet Shop Group"}, dataProvider = "filterByStatusData", dataProviderClass = PetDataProvider.class)
    public void validateGetPetByStatus(Pet pet) {

        log.infoMSG("Creating pet with : " + pet);
        endpointActions.createPet(pet);

        log.infoMSG("Fetching pets with status : " + DataProviderConstants.FILTER_STATUS);
        Response response = endpointActions.getPetByStatus(DataProviderConstants.FILTER_STATUS);
        List<Pet> findPets = response.as(new TypeRef<List<Pet>>() {});

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_OK);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        List<Long> foundIds = findPets.stream().map(Pet::getId).collect(Collectors.toList());
        log.infoMSG("Validating pets based on the status should be available in the response : " + pet);
        if(pet.getStatus().equals(DataProviderConstants.FILTER_STATUS)) {
            Assert.assertTrue(foundIds.contains(pet.getId()),
                    "Created pet with ID " + pet.getId() + " not found in status filter results");
        } else {
            Assert.assertFalse(foundIds.contains(pet.getId()),
                    "Created pet with ID " + pet.getId() + " found in status filter results");
        }
    }
}
