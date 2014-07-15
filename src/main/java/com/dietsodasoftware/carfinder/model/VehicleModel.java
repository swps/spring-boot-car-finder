package com.dietsodasoftware.carfinder.model;

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
@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private VehicleMake make;

    @ManyToOne
    private VehicleStyle style;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public VehicleModel setName(String name) {
        this.name = name;
        return this;
    }

    public VehicleMake getMake() {
        return make;
    }

    public VehicleModel setMake(VehicleMake make) {
        this.make = make;
        return this;
    }

    public VehicleStyle getStyle() {
        return style;
    }

    public VehicleModel setStyle(VehicleStyle style) {
        this.style = style;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}
