package com.acr.vehiclesensor.controller;

import com.acr.vehiclesensor.client.api.VehiclesApi;
import com.acr.vehiclesensor.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/vehicles/")
public class VehiclesApiController {

    @Autowired
    private VehiclesApi vehiclesApi;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            vehicles = vehiclesApi.findVehicles();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vehicles;
    }

}
