package com.mybackend.seat.api.controllers;

import com.mybackend.seat.application.models.VehiclesModel;
import com.mybackend.seat.application.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class VehiclesController {
    //--- Services & Variables used ---------------------------------------
    VehiclesService vehiclesService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public VehiclesController(VehiclesService vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

    //--- Mappings -----------------------------------------------------
    @GetMapping("/vehicles")
    List<VehiclesModel> allVehicles() {
        return vehiclesService.findAll();
    }

    @GetMapping("/vehicles/{id}")
    VehiclesModel vehicleById(@PathVariable String id) {
        try {
            long idl = Long.parseLong(id);
            VehiclesModel model = vehiclesService.findById(idl);
            return model;
        }
        catch (Exception e){
            VehiclesModel model = new VehiclesModel();
            return model;
        }
    }
}
