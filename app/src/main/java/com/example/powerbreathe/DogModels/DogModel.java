package com.example.powerbreathe.DogModels;

import com.google.gson.annotations.SerializedName;

public class DogModel {
    private final String name;

    private final String id;
    @SerializedName("reference_image_id")
    private final String referenceImageId;

    @SerializedName("weight")
    private WeightModel weight;

    @SerializedName("height")
    private HeightModel height;

    public DogModel(String name, WeightModel weight, HeightModel height, String id, String referenceImageId) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.id = id;
        this.referenceImageId = referenceImageId;
    }

    public String getName() {
        return name;
    }

    public WeightModel getWeight() {
        return weight;
    }

    public HeightModel getHeight() {
        return height;
    }

    public String getId() {
        return id;
    }

    public String getReferenceImageId() {
        return referenceImageId;
    }

    public String getImageUrl() {
        return "https://cdn2.thedogapi.com/images/" + referenceImageId + ".jpg";
    }
}