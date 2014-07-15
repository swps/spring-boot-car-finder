package com.dietsodasoftware.carfinder.mvc.controller.vehicles;

import com.dietsodasoftware.carfinder.model.VehicleMake;
import com.dietsodasoftware.carfinder.model.VehicleModel;
import com.dietsodasoftware.carfinder.model.VehicleStyle;
import com.dietsodasoftware.carfinder.mvc.exception.HttpInvalidRequestError;
import com.dietsodasoftware.carfinder.mvc.view.ListResults;
import com.dietsodasoftware.carfinder.mvc.view.VehicleModelSubmission;
import com.dietsodasoftware.carfinder.service.VehicleMakeService;
import com.dietsodasoftware.carfinder.service.VehicleModelService;
import com.dietsodasoftware.carfinder.service.VehicleStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
@Controller
@RequestMapping("/vehicles/models")
public class VehicleModelController {


    @Autowired
    private VehicleModelService modelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleStyleService vehicleStyleService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public VehicleModel create(@RequestBody VehicleModelSubmission submission){

        if(submission.getVehicleMakeId() == null){
            throw new HttpInvalidRequestError("Missing vehicle make ID");
        }

        if(submission.getVehicleStyleId() == null){
            throw new HttpInvalidRequestError("Missing vehicle style ID");
        }

        VehicleMake make = vehicleMakeService.find(submission.getVehicleMakeId());

        if(make == null){
            throw new HttpInvalidRequestError("Unknown vehicle make id: " + submission.getVehicleMakeId());
        }

        VehicleStyle style = vehicleStyleService.find(submission.getVehicleStyleId());

        if(style == null){
            throw new HttpInvalidRequestError("Unknown vehicle style id: " + submission.getVehicleStyleId());
        }

        return modelService.createVehicleModel(make, style, submission.getName());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public VehicleModel load(@PathVariable("id") Long id){
        return modelService.find(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ListResults<VehicleModel> list(){
        return new ListResults<VehicleModel>(modelService.findAll());
    }

}
