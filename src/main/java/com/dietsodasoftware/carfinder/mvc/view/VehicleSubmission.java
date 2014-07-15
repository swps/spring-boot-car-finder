package com.dietsodasoftware.carfinder.mvc.view;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
public class VehicleSubmission {

    @JsonProperty("vehicle_make_id")
    private Long vehicleMakeId;

    @JsonProperty("vehicle_style_id")
    private Long vehicleStyleId;

    @JsonProperty
    private String year;

    public Long getVehicleMakeId() {
        return vehicleMakeId;
    }

    public Long getVehicleStyleId() {
        return vehicleStyleId;
    }

    public String getYear() {
        return year;
    }
}
