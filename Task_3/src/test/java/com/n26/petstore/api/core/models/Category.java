package com.n26.petstore.api.core.models;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {

    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;
}
