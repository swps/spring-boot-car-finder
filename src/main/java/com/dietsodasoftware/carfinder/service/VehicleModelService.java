package com.dietsodasoftware.carfinder.service;

import com.dietsodasoftware.carfinder.model.VehicleMake;
import com.dietsodasoftware.carfinder.model.VehicleModel;
import com.dietsodasoftware.carfinder.model.VehicleStyle;
import com.dietsodasoftware.carfinder.service.dao.VehicleModelDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelDbRepository repo;

    public VehicleModel createVehicleModel(VehicleMake make, VehicleStyle style, String name){
        VehicleModel model = new VehicleModel();
        model.setName(name);
        model.setMake(make);
        model.setStyle(style);

        return repo.save(model);
    }

    public VehicleModel find(Long id){
        return repo.findOne(id);
    }

    public List<VehicleModel> findAll(){
        return repo.findAll();
    }
}
