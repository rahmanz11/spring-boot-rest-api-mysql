package com.rest.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rest.api.payload.BadRequestException;
import com.rest.api.payload.GetAvailableItemCountResponse;
import com.rest.api.payload.ReceiveOrderRequest;
import com.rest.api.payload.ReceiveOrderResponse;
import com.rest.api.service.ApiService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ApiController {

    private final ApiService service;

    @PostMapping("/order")
    public ResponseEntity<ReceiveOrderResponse> receiveOrder(@RequestBody ReceiveOrderRequest request) throws BadRequestException {
        try {
            return ResponseEntity.ok(service.receiveOrder(request));
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @GetMapping("/item/{number}")
    public ResponseEntity<GetAvailableItemCountResponse> getItemsAvailableUnits(@PathVariable Integer number) throws BadRequestException {
        try {
            return ResponseEntity.ok(service.getItemsAvailableUnits(number));
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
