package com.acr.vehiclesensor.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.ToString;

@ToString
public enum LockStatus {
    LOCKED("LOCKED"),

    UNLOCKED("UNLOCKED");

    private String value;

    LockStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static LockStatus fromValue(String text) {
        for (LockStatus lockStatus : LockStatus.values()) {
            if (String.valueOf(lockStatus.value).equals(text)) {
                return lockStatus;
            }
        }
        return null;
    }

}