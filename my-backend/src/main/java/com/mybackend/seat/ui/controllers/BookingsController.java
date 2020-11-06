package com.mybackend.seat.ui.controllers;

import com.mybackend.seat.application.models.BookingsModel;
import com.mybackend.seat.application.models.VehiclesModel;
import com.mybackend.seat.application.services.BookingsService;
import com.mybackend.seat.application.services.VehiclesService;
import com.mybackend.seat.ui.dto.BookingsDTO;
import com.mybackend.seat.utils.DiscountUtilImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bookings")
public class BookingsController {
    BookingsService bookingsService;
    DiscountUtilImplementation discountUtilImplementation;
    VehiclesService vehiclesService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public BookingsController(BookingsService bookingsService, DiscountUtilImplementation discountUtilImplementation, VehiclesService vehiclesService) {
        this.bookingsService = bookingsService;
        this.vehiclesService = vehiclesService;
        this.discountUtilImplementation = discountUtilImplementation;
    }

    @GetMapping("/")
    public List<BookingsModel> getAllBookings() {
        return bookingsService.findAll();
    }

    @GetMapping("/{id}")
    public BookingsModel getBookingById(@PathVariable("id") long id) {
        return bookingsService.findById(id);
    }

    @PostMapping("/post-booking")
    @ResponseBody
    public BookingsModel postBooking(@RequestBody BookingsDTO dto) {
        VehiclesModel vehicle = vehiclesService.findById(dto.id_vehicle);

        double price = 5;
        BookingsModel model = new BookingsModel(dto.checkIn, dto.checkOut, price, dto.client, dto.email, vehicle);
        bookingsService.save(model);
        return model;
    }

}
