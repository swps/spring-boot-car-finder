package com.dietsodasoftware.carfinder.service;

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

    public VehicleOffering createOffering(String title, String description,Double price){

        VehicleOffering offering = VehicleOffering.newOffering(title, description, price);

        offering = offeringDbRepository.save(offering);


        return offering;
    }

    public VehicleOffering loadOffering(Long id){
        return offeringDbRepository.findOne(id);
    }

    public List<VehicleOffering> list(){
        return offeringDbRepository.findAll();
    }
}
