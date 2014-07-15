package com.dietsodasoftware.carfinder.service;

import com.dietsodasoftware.carfinder.model.Vehicle;
import com.dietsodasoftware.carfinder.model.VehicleMake;
import com.dietsodasoftware.carfinder.model.VehicleStyle;
import com.dietsodasoftware.carfinder.service.dao.VehicleDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
@Service
public class VehicleService {

    @Autowired
    private VehicleDbRepository repo;

    public Vehicle createVehicle(VehicleMake make, VehicleStyle style, String year){

        Vehicle v = new Vehicle(year);
        v.setMake(make);
        v.setStyle(style);

        v = repo.save(v);

        return v;

    }

    public Vehicle find(Long id){

        return repo.findOne(id);

    }

    public List<Vehicle> findAll(){

        return repo.findAll();

    }
}
