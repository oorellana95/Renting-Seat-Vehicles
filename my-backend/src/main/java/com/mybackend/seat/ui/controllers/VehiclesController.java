package com.mybackend.seat.ui.controllers;

import com.mybackend.seat.application.models.VehiclesModel;
import com.mybackend.seat.application.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
