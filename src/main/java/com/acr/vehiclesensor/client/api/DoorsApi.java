package com.acr.vehiclesensor.client.api;

import com.acr.vehiclesensor.configuration.MBApiConfiguration;
import com.acr.vehiclesensor.model.DoorsLockChangeRequest;
import com.acr.vehiclesensor.model.Doors;
import com.acr.vehiclesensor.model.DoorsLockChangedStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "DoorsApiClient", url = "${api.endpoint}", configuration = MBApiConfiguration.class)
public interface DoorsApi {

    @RequestMapping(method = RequestMethod.GET, path = "/vehicles/{vehicleId}/doors", produces = APPLICATION_JSON_VALUE)
    Doors findDoors(@PathVariable("vehicleId") String vehicleId);

    @RequestMapping(method = RequestMethod.POST, path = "/vehicles/{vehicleId}/doors", produces = APPLICATION_JSON_VALUE)
    DoorsLockChangedStatus updateDoorsLockStatus(@PathVariable("vehicleId") String vehicleId, DoorsLockChangeRequest doorsLockChangeRequest);

}
