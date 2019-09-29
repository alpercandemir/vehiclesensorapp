package com.acr.vehiclesensor.client.api;

import com.acr.vehiclesensor.configuration.MBApiConfiguration;
import com.acr.vehiclesensor.model.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "VehiclesApiClient", url = "${api.endpoint}", configuration = MBApiConfiguration.class)
public interface VehiclesApi {

    @RequestMapping(method = RequestMethod.GET, path = "/vehicles", produces = APPLICATION_JSON_VALUE)
    List<Vehicle> findVehicles();

}


