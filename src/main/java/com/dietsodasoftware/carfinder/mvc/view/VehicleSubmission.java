package com.dietsodasoftware.carfinder.mvc.view;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
public class VehicleSubmission {

    @JsonProperty("vehicle_model_id")
    private Long vehicleModelId;

    @JsonProperty
    private String year;

    public Long getVehicleModelId() {
        return vehicleModelId;
    }

    public String getYear() {
        return year;
    }
}
