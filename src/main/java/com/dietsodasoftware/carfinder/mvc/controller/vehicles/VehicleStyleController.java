package com.dietsodasoftware.carfinder.mvc.controller.vehicles;

import com.dietsodasoftware.carfinder.model.VehicleMake;
import com.dietsodasoftware.carfinder.model.VehicleStyle;
import com.dietsodasoftware.carfinder.mvc.view.ListResults;
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
@RequestMapping("/vehicles/styles")
public class VehicleStyleController {

    @Autowired
    private VehicleStyleService typeService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public VehicleStyle createMake(@RequestBody VehicleMake make){
        return typeService.createVehicleMake(make.getName());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public VehicleStyle load(@PathVariable("id") Long id){
        return typeService.find(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ListResults<VehicleStyle> list(){
        return new ListResults<VehicleStyle>(typeService.findAll());
    }


}
