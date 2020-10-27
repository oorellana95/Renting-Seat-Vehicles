package com.mybackend.seat.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void TestGet() throws Exception{
        this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, world"));
    }

    @Test
    void TestPost() throws Exception{
        this.mockMvc.perform(post("/greeting")
                .content("Manuel"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Manuel!"));
    }

}