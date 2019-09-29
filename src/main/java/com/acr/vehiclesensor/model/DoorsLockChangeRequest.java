package com.acr.vehiclesensor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoorsLockChangeRequest {

    @JsonProperty("command")
    private LockCommand lockCommand;

}
