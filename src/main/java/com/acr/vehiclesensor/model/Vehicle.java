package com.acr.vehiclesensor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @JsonProperty("id")
    private String id;

    @JsonProperty("licenseplate")
    private String licensePlate;

    @JsonProperty("finorvin")
    private String finorvin;

}
