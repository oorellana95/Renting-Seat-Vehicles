package com.mybackend.seat.api.controllers;

import com.mybackend.seat.application.models.MobilitytypesModel;
import com.mybackend.seat.application.services.MobilitytypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MobilitytypesController {

    //--- Services & Variables used ---------------------------------------
    MobilitytypesService mobilitytypesService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public MobilitytypesController(MobilitytypesService mobilitytypesService) {
        this.mobilitytypesService = mobilitytypesService;
    }

    //--- Mappings -----------------------------------------------------
    @GetMapping("/mobilitytypes")
    List<MobilitytypesModel> allMobilityTypes() {
        return mobilitytypesService.findAll();
    }
}
