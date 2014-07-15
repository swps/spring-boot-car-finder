package com.dietsodasoftware.carfinder.mvc.view;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
public class VehicleOfferingSubmission {

    @JsonProperty("vehicle_id")
    private Long vehicleId;

    @JsonProperty
    private String title;

    @JsonProperty
    private String description;

    @JsonProperty
    private Double price;

    public Long getVehicleId() {
        return vehicleId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
