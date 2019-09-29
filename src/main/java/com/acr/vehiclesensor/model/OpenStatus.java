package com.acr.vehiclesensor.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.ToString;

@ToString
public enum OpenStatus {
    OPEN("OPEN"),

    CLOSED("CLOSED");

    private String value;

    OpenStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static OpenStatus fromValue(String text) {
        for (OpenStatus openStatus : OpenStatus.values()) {
            if (String.valueOf(openStatus.value).equals(text)) {
                return openStatus;
            }
        }
        return null;
    }

}