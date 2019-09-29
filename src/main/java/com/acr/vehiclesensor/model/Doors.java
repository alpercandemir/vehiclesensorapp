package com.acr.vehiclesensor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doors {

    @JsonProperty("doorstatusfrontleft")
    private DoorOpenStatus doorStatusFrontLeft;

    @JsonProperty("doorstatusfrontright")
    private DoorOpenStatus doorStatusFrontRight;

    @JsonProperty("doorstatusrearleft")
    private DoorOpenStatus doorStatusRearLeft;

    @JsonProperty("doorstatusrearright")
    private DoorOpenStatus doorStatusRearRight;

    @JsonProperty("doorlockstatusfrontleft")
    private DoorLockStatus doorLockStatusFrontLeft;

    @JsonProperty("doorlockstatusfrontright")
    private DoorLockStatus doorLockStatusFrontRight;

    @JsonProperty("doorlockstatusrearleft")
    private DoorLockStatus doorLockStatusRearLeft;

    @JsonProperty("doorlockstatusrearright")
    private DoorLockStatus doorLockStatusRearRight;

    @JsonProperty("doorlockstatusdecklid")
    private DoorLockStatus doorLockStatusDecklid;

    @JsonProperty("doorlockstatusgas")
    private DoorLockStatus doorLockStatusGas;

    @JsonProperty("doorlockstatusvehicle")
    private DoorLockStatus doorLockStatusVehicle;

}
