package com.dietsodasoftware.carfinder.service;

import com.dietsodasoftware.carfinder.model.Vehicle;
import com.dietsodasoftware.carfinder.model.VehicleOffering;
import com.dietsodasoftware.carfinder.service.dao.VehicleOfferingDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
@Service
public class VehicleOfferingService {

    @Autowired
    private VehicleOfferingDbRepository offeringDbRepository;

    public VehicleOffering createOffering(Vehicle vehicle, String title, String description,Double price){

        VehicleOffering offering = VehicleOffering.newOffering(vehicle, title, description, price);

        offering = offeringDbRepository.save(offering);


        return offering;
    }

    public VehicleOffering find(Long id){
        return offeringDbRepository.findOne(id);
    }

    public List<VehicleOffering> findAll(){
        return offeringDbRepository.findAll();
    }
}
