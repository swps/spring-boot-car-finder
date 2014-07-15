package com.dietsodasoftware.carfinder.mvc.view;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
public class VehicleOfferingSearch {

    @JsonProperty
    private String q;

    public String getQ() {
        return q;
    }
}
