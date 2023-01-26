package com.rest.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rest.api.SpringBootRestApiMysqlApplication;
import com.rest.api.payload.BadRequestException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootRestApiMysqlApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void receiveOrderItemUnavailableTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/order")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"itemNumber\": \"2222\", \"orderQuantity\": \"5\", \"logisticsCompany\": \"DHL\"}")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
        .andExpect(result -> assertEquals("Cannot find any item with given item number", result.getResolvedException().getMessage()));
    }
    
    @Test
    void receiveOrderItemInsufficientTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/order")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"itemNumber\": \"1234\", \"orderQuantity\": \"51\", \"logisticsCompany\": \"DHL\"}")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
        .andExpect(result -> assertEquals("Item not available for the given quantity", result.getResolvedException().getMessage()));
    }

    @Test
    void receiveOrderTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/order")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"itemNumber\": \"1234\", \"orderQuantity\": \"1\", \"logisticsCompany\": \"DHL\"}")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.shippingCostSubTotal").exists())
        .andExpect(jsonPath("$.total").exists())
        .andReturn();
    }

    @Test
    void getItemsAvailableUnitsFailedTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/item/5555")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
                .andExpect(result -> assertEquals("Cannot find any item with given item number", result.getResolvedException().getMessage()));
    }

    @Test
    void getItemsAvailableUnitsTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/item/5678")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.availableCount").value("6"))
                .andReturn();
    }
}
