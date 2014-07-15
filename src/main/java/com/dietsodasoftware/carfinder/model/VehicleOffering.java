package com.dietsodasoftware.carfinder.model;

import com.infusionsoft.search.api.schema.annotation.IndexField;
import com.infusionsoft.search.api.schema.annotation.IndexIdField;
import com.infusionsoft.search.api.schema.annotation.IndexSchema;
import com.infusionsoft.search.api.schema.annotation.MinimalSearchResultField;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
@IndexSchema
@Entity
public class VehicleOffering {

    VehicleOffering(){}

    public static VehicleOffering newOffering(Vehicle vehicle, String title, String description, Double price){
        final VehicleOffering offering = new VehicleOffering();

        offering.title = title;
        offering.description = description;
        offering.price = price;
        offering.vehicle = vehicle;

        return offering;
    }

    @IndexIdField
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @IndexField
    @MinimalSearchResultField
    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Double price;

    @ManyToOne
    private Vehicle vehicle;

    private Long indexVersion = 0L;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Long getIndexVersion() {
        return indexVersion;
    }

    public void incrementVersion() {
        this.indexVersion++;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("title", title)
                .append("description", description)
                .append("price", price)
                .append("vehicle", vehicle)
                .append("indexVersion", indexVersion)
                .toString();
    }
}
