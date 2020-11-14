package com.mybackend.seat.application.controllers;


import com.mybackend.seat.SeatRentingApplication;
import com.mybackend.seat.application.models.MobilitytypesModel;
import com.mybackend.seat.application.services.MobilitytypesService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.google.gson.Gson;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SeatRentingApplication.class)
@AutoConfigureMockMvc
public class MobilityTypesControllerTest {

    @MockBean
    MobilitytypesService mockService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before("")
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }
    @Test
    void ShouldReturnOkWhenVisitVehicles() throws Exception{
        MockHttpServletResponse response = mvc.perform(get("/api/mobilitytypes")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void ShouldReturnTheMobilityTypesMocked() throws Exception{
        List<MobilitytypesModel> mt = new ArrayList<>();
        mt.add(new MobilitytypesModel(1, "Type 1", "Type 1 Description"));
        mt.add(new MobilitytypesModel(2, "Type 2", "Type 2 Description"));
        when(mockService.findAll()).thenReturn(mt);

        MockHttpServletResponse response = mvc.perform(get("/api/mobilitytypes")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        String json = new Gson().toJson(mt);
        assertThat(response.getContentAsString()).isEqualTo(json);

    }
}
