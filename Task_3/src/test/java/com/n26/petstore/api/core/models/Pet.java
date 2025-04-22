package com.n26.petstore.api.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pet {

    @SerializedName("id")
    long id;

    @SerializedName("name")
    String name;

    @SerializedName("category")
    Category category;

    @SerializedName("photoUrls")
    List<String> photoUrls;

    @SerializedName("tags")
    List<Tag> tags;

    @SerializedName("status")
    String status;
}
