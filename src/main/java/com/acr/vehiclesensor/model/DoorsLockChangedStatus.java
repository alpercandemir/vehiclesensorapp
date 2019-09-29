package com.acr.vehiclesensor.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoorsLockChangedStatus {

    @JsonProperty("status")
    private LockChangedStatus lockChangedStatus;

    @ToString
    public enum LockChangedStatus {
        INITIATED("INITIATED"),

        REJECTED("REJECTED");

        private String value;

        LockChangedStatus(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @JsonCreator
        public static LockChangedStatus fromValue(String text) {
            for (LockChangedStatus lockChangedStatus : LockChangedStatus.values()) {
                if (String.valueOf(lockChangedStatus.value).equals(text)) {
                    return lockChangedStatus;
                }
            }
            return null;
        }
    }


}
