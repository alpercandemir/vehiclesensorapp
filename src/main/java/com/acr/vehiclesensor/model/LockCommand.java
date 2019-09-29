package com.acr.vehiclesensor.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.ToString;

@ToString
public enum LockCommand {
    LOCK("LOCK"),

    UNLOCK("UNLOCK");

    private String value;

    LockCommand(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static LockCommand fromValue(String text) {
        for (LockCommand lockCommand : LockCommand.values()) {
            if (String.valueOf(lockCommand.value).equals(text)) {
                return lockCommand;
            }
        }
        return null;
    }

}