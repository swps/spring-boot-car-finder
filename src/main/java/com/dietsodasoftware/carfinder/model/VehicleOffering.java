package com.dietsodasoftware.carfinder.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
@Entity
public class VehicleOffering {

    VehicleOffering(){}

    public static VehicleOffering newOffering(String title, String description, Double price){
        final VehicleOffering offering = new VehicleOffering();

        offering.title = title;
        offering.description = description;
        offering.price = price;

        return offering;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Double price;

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("title", title)
                .append("description", description)
                .append("price", price)
                .toString();
    }
}
