package com.dietsodasoftware.carfinder.service;

import com.dietsodasoftware.carfinder.model.VehicleStyle;
import com.dietsodasoftware.carfinder.service.dao.VehicleStyleDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
@Service
public class VehicleStyleService {

    @Autowired
    private VehicleStyleDbRepository repo;


    public VehicleStyle createVehicleMake(String name){
        VehicleStyle make = new VehicleStyle(name);

        return repo.save(make);
    }

    public VehicleStyle find(Long id){
        return repo.findOne(id);
    }

    public List<VehicleStyle> findAll(){
        return repo.findAll();
    }
}
