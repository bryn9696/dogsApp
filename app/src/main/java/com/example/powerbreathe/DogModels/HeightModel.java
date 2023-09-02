package com.example.powerbreathe.DogModels;

import com.google.gson.annotations.SerializedName;

public class HeightModel {
    @SerializedName("metric")
    private String metric;

    public HeightModel(String metric) {
        this.metric = metric;
    }

    public String getMetric() {
        return metric;
    }
}
