package com.dietsodasoftware.carfinder.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
@Entity
public class Vehicle {

    Vehicle(){}

    public Vehicle(String year){
        this.year = year;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private VehicleMake make;

    @ManyToOne
    private VehicleStyle style;

    @Column
    private String year;

    public Long getId() {
        return id;
    }

    public VehicleMake getMake() {
        return make;
    }

    public void setMake(VehicleMake make) {
        this.make = make;
    }

    public VehicleStyle getStyle() {
        return style;
    }

    public void setStyle(VehicleStyle style) {
        this.style = style;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("make", make)
                .append("style", style)
                .append("year", year)
                .toString();
    }
}
