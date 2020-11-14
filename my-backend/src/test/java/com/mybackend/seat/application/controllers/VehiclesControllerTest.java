package com.mybackend.seat.application.controllers;

import com.mybackend.seat.SeatRentingApplication;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SeatRentingApplication.class)
@AutoConfigureMockMvc
public class VehiclesControllerTest {

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
    public void ShouldReturnOkWhenVisitVehicles() throws  Exception{
        mvc.perform(get("/api/vehicles").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void ShouldReturnVehicleWithId0() throws Exception{
        MockHttpServletResponse response = mvc.perform(get("/api/vehicles/sfwesdf")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(new JSONObject(response.getContentAsString()).get("id")).isEqualTo(0);
    }

    @Test
    void ShouldReturnOkWhenVisitOneVehicle() throws Exception{
        MockHttpServletResponse response = mvc.perform(get("/api/vehicles/1")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Object id = new JSONObject(response.getContentAsString()).get("id");
        assertTrue(id.equals(1) || id.equals(0));
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
