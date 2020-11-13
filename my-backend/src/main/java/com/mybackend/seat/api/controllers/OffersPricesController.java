package com.mybackend.seat.api.controllers;

import com.mybackend.seat.application.services.OffersPricesService;
import com.mybackend.seat.api.dto.BookingsDTO;
import com.mybackend.seat.api.dto.OffersPricesDTO;
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
    public OffersPricesDTO getFinalPrice(@RequestBody BookingsDTO dto) {
        return offersPricesService.getOffersAndPrice(dto.id_vehicle, dto.checkIn, dto.checkOut);
    }
}
