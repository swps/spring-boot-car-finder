package com.dietsodasoftware.carfinder.mvc.view;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
public class VehicleModelSubmission {

    @JsonProperty
    private String name;

    @JsonProperty("vehicle_make_id")
    private Long vehicleMakeId;

    @JsonProperty("vehicle_style_id")
    private Long vehicleStyleId;

    public String getName() {
        return name;
    }

    public Long getVehicleMakeId() {
        return vehicleMakeId;
    }

    public Long getVehicleStyleId() {
        return vehicleStyleId;
    }

}
