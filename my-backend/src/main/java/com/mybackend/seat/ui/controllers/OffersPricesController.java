package com.mybackend.seat.ui.controllers;

import com.mybackend.seat.application.models.VehiclesModel;
import com.mybackend.seat.application.services.OffersPricesService;
import com.mybackend.seat.application.services.VehiclesService;
import com.mybackend.seat.ui.dto.BookingsDTO;
import com.mybackend.seat.utils.PricesUtilImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class OffersPricesController {

    //--- Services & Variables used ---------------------------------------
    OffersPricesService offersPricesService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public OffersPricesController(OffersPricesService offersPricesService) {
        this.offersPricesService = offersPricesService;
    }

    //--- Mappings -----------------------------------------------------
    @PostMapping("/finalprice")
    @ResponseBody
    public double getFinalPrice(@RequestBody BookingsDTO dto) {
        offersPricesService.applyOffersToPrice(dto.id_vehicle, dto.checkIn, dto.checkOut);
        return 5;
    }
}
