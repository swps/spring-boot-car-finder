package com.dietsodasoftware.carfinder.service;

import com.dietsodasoftware.carfinder.model.VehicleMake;
import com.dietsodasoftware.carfinder.service.dao.VehicleMakeDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
@Service
public class VehicleMakeService {

    @Autowired
    private VehicleMakeDbRepository repo;

    public VehicleMake createVehicleMake(String name){
        VehicleMake make = new VehicleMake(name);

        return repo.save(make);
    }

    public VehicleMake find(Long id){
        return repo.findOne(id);
    }

    public List<VehicleMake> findAll(){
        return repo.findAll();
    }
}
