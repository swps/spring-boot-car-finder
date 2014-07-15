package com.dietsodasoftware.carfinder.service;

import com.dietsodasoftware.carfinder.model.Vehicle;
import com.dietsodasoftware.carfinder.model.VehicleOffering;
import com.dietsodasoftware.carfinder.search.IndexService;
import com.dietsodasoftware.carfinder.service.dao.VehicleOfferingDbRepository;
import com.infusionsoft.search.api.InfusionsoftSearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
@Service
public class VehicleOfferingService {

    @Autowired
    private VehicleOfferingDbRepository offeringDbRepository;

    @Autowired
    private IndexService indexer;

    @Transactional
    public VehicleOffering createOffering(Vehicle vehicle, String title, String description,Double price) throws InfusionsoftSearchException {

        VehicleOffering offering = VehicleOffering.newOffering(vehicle, title, description, price);
        offering.incrementVersion();

        offering = offeringDbRepository.save(offering);

        indexer.index(offering);

        return offering;
    }

    public VehicleOffering find(Long id){
        return offeringDbRepository.findOne(id);
    }

    public List<VehicleOffering> findAll(){
        return offeringDbRepository.findAll();
    }

    public List<VehicleOffering> findAll(Iterable<Long> ids){
        return offeringDbRepository.findAll(ids);
    }
}
