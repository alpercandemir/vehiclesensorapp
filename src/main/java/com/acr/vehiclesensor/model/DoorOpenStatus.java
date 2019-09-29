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
public class DoorOpenStatus {

    @JsonProperty("value")
    private OpenStatus openStatus;

    @JsonProperty("retrievalstatus")
    private RetrievalStatus retrievalStatus;

    @JsonProperty("timestamp")
    private long timeStamp;

}
