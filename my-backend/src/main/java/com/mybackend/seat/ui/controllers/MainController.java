package com.mybackend.seat.ui.controllers;

import com.mybackend.seat.application.models.MobilitytypesModel;
import com.mybackend.seat.application.services.FuelsourcesService;
import com.mybackend.seat.application.services.MobilitytypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    //--- Services & Variables used ---------------------------------------
    MobilitytypesService mobilitytypesService;
    FuelsourcesService fuelsourcesService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public MainController(MobilitytypesService mobilitytypesService, FuelsourcesService fuelsourcesService) {
        this.mobilitytypesService = mobilitytypesService;
        this.fuelsourcesService = fuelsourcesService;
    }

    //--- Mappings -----------------------------------------------------
    @GetMapping("/mobilitytypes")
    List<MobilitytypesModel> allMobilityTypes() {
        return mobilitytypesService.findAll();
    }

}
