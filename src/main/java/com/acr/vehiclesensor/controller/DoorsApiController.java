package com.acr.vehiclesensor.controller;

import com.acr.vehiclesensor.client.api.DoorsApi;
import com.acr.vehiclesensor.model.DoorsLockChangeRequest;
import com.acr.vehiclesensor.model.Doors;
import com.acr.vehiclesensor.model.DoorsLockChangedStatus;
import com.acr.vehiclesensor.util.MockDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/doors/")
public class DoorsApiController {

    @Autowired
    private DoorsApi doorsApi;

    @GetMapping(value = "{vehicleId}", produces = APPLICATION_JSON_VALUE)
    public Doors getDoors(@PathVariable String vehicleId, @RequestParam(required = false) boolean isMockData){
        try {
            if (isMockData) {
                return MockDataGenerator.generateMockData();
            }

            return doorsApi.findDoors(vehicleId);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PostMapping(value = "{vehicleId}", produces = APPLICATION_JSON_VALUE)
    public DoorsLockChangedStatus updateDoorsLockStatus(@PathVariable String vehicleId,
                                                        @RequestBody DoorsLockChangeRequest doorsLockChangeRequest) {
        DoorsLockChangedStatus doorsLockChangedStatus = null;

        try {
            doorsLockChangedStatus = doorsApi.updateDoorsLockStatus(vehicleId, doorsLockChangeRequest);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return doorsLockChangedStatus;
    }


}
