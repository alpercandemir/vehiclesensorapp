package com.acr.vehiclesensor.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.ToString;

@ToString
public enum RetrievalStatus {
    VALID("VALID"),

    INITIALIZED("INITIALIZED"),

    INVALID("INVALID"),

    NOT_SUPPORTED("NOT_SUPPORTED");

    private String value;

    RetrievalStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static RetrievalStatus fromValue(String text) {
        for (RetrievalStatus retrievalStatus : RetrievalStatus.values()) {
            if (String.valueOf(retrievalStatus.value).equals(text)) {
                return retrievalStatus;
            }
        }
        return null;
    }

}
