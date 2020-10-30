package com.mybackend.seat.ui.controllers;

import com.mybackend.seat.application.models.VehiclesModel;
import com.mybackend.seat.application.services.VehiclesService;
import com.mybackend.seat.ui.dto.BookingsDTO;
import com.mybackend.seat.utils.PricesUtilImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PricesController {

    //--- Services & Variables used ---------------------------------------
    PricesUtilImplementation pricesUtilImplementation;
    VehiclesService vehiclesService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public PricesController(PricesUtilImplementation pricesUtilImplementation, VehiclesService vehiclesService) {
        this.pricesUtilImplementation = pricesUtilImplementation;
        this.vehiclesService = vehiclesService;
    }

    //--- Mappings -----------------------------------------------------
    @PostMapping("/finalprice")
    @ResponseBody
    public double postResponseController(@RequestBody BookingsDTO dto) {
        VehiclesModel vehicle = vehiclesService.findById(dto.id_vehicle);
        return pricesUtilImplementation.calculateTotalPrice(dto.checkIn, dto.checkOut, vehicle.pricePerDay);
    }
}
