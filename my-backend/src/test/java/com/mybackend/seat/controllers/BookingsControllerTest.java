package com.mybackend.seat.controllers;

import com.mybackend.seat.application.models.BookingsModel;
import com.mybackend.seat.application.services.BookingsService;
import com.mybackend.seat.ui.controllers.BookingsController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetById() throws Exception{
        BookingsModel bookingsModel = new BookingsModel();
        bookingsModel.setId(1);
        bookingsModel.setTotalPrice(20.00);

        var bookingService = Mockito.mock(BookingsService.class);
        Mockito.when(bookingService.findById(1)).thenReturn(bookingsModel);
        BookingsController bookingsController = new BookingsController(bookingService);
        assertEquals(bookingsController.getBookingById(1), bookingsModel);
    }

    /*@Test
    void testGetAll() throws Exception{
        this.mockMvc.perform(get("api/bookings/{id}").param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPrice").value(20.00));
    }

    @Test
    void testGetById() throws Exception{
        this.mockMvc.perform(post("/greeting")
                .content("Manuel"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Manuel!"));
    }*/

}