package com.example.powerbreathe.DogModels;

import com.google.gson.annotations.SerializedName;

public class WeightModel {
    @SerializedName("metric")
    private String metric;

    public WeightModel(String metric) {
        this.metric = metric;
    }

    public String getMetric() {
        return metric;
    }
}