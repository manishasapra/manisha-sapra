package com.n26.petstore.api.core.dataprovider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.n26.petstore.api.core.models.Pet;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * This class is responsible for providing data to tests
 */
public class PetDataProvider {

    @DataProvider(name = "petData")
    public Object[][] getCreatePetDataFromJson() throws Exception {
        return selectJsonBasedOnDataProvider("src/test/resources/testdata/pet.json");
    }

    @DataProvider(name = "getPetData")
    public Object[][] getPetDataFromJson() throws Exception {
        return selectJsonBasedOnDataProvider("src/test/resources/testdata/getPetData.json");
    }

    @DataProvider(name = "filterTagData")
    public Object[][] getFilterTagPetDataFromJson() throws Exception {
        return selectJsonBasedOnDataProvider("src/test/resources/testdata/filterData.json");
    }

    @DataProvider(name = "filterByStatusData")
    public Object[][] getFilterByStatusPetDataFromJson() throws Exception {
        return selectJsonBasedOnDataProvider("src/test/resources/testdata/filterByStatusData.json");
    }

    @DataProvider(name = "updatePetData")
    public Object[][] updatePetDataFromJson() throws Exception {
        return selectJsonBasedOnDataProvider("src/test/resources/testdata/updatePetData.json");
    }

    @DataProvider(name = "updatePetWithIdData")
    public Object[][] updatePetWithIdDataFromJson() throws Exception {
        return selectJsonBasedOnDataProvider("src/test/resources/testdata/updatePetWithIdData.json");
    }

    @DataProvider(name = "uploadImageData")
    public Object[][] uploadImageDataFromJson() throws Exception {
        return selectJsonBasedOnDataProvider("src/test/resources/testdata/uploadImageData.json");
    }

    @DataProvider(name = "deletePetData")
    public Object[][] deletePetDataFromJson() throws Exception {
        return selectJsonBasedOnDataProvider("src/test/resources/testdata/deletePetData.json");
    }

    public Object[][] selectJsonBasedOnDataProvider(String filename) throws Exception {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Pet>>() {}.getType();
        List<Pet> pets = gson.fromJson(new FileReader(filename), type);

        Object[][] data = new Object[pets.size()][1];
        for (int i = 0; i < pets.size(); i++) {
            data[i][0] = pets.get(i);
        }
        return data;
    }
}
