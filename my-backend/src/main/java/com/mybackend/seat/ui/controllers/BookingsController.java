package com.mybackend.seat.ui.controllers;

import com.mybackend.seat.application.models.BookingsModel;
import com.mybackend.seat.application.services.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BookingsController {
    BookingsService bookingsService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public BookingsController(BookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }

    @GetMapping("/bookings")
    public List<BookingsModel> getAllBookings() {
        return bookingsService.findAll();
    }

    @GetMapping("/bookings/{id}")
    public BookingsModel getBookingById(@PathVariable("id") long id) {
        return bookingsService.findById(id);
    }
}
