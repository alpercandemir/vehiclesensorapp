package com.acr.vehiclesensor.util;

import com.acr.vehiclesensor.model.*;

import java.util.Random;

public class MockDataGenerator {

    public static Doors generateMockData() {
        Doors doors = new Doors().builder()
                .doorLockStatusFrontLeft(DoorLockStatus.builder()
                        .lockStatus(generateLockStatus())
                        .retrievalStatus(RetrievalStatus.VALID)
                        .timeStamp(generateTimeStamp())
                        .build())
                .doorLockStatusFrontRight(DoorLockStatus.builder().
                        lockStatus(generateLockStatus()).
                        retrievalStatus(RetrievalStatus.VALID).
                        timeStamp(generateTimeStamp())
                        .build())
                .doorLockStatusRearLeft(DoorLockStatus.builder().
                        lockStatus(generateLockStatus()).
                        retrievalStatus(RetrievalStatus.VALID).
                        timeStamp(generateTimeStamp())
                        .build())
                .doorLockStatusRearRight(DoorLockStatus.builder()
                        .lockStatus(generateLockStatus())
                        .retrievalStatus(RetrievalStatus.VALID)
                        .timeStamp(generateTimeStamp())
                        .build())
                .doorStatusFrontLeft(DoorOpenStatus.builder()
                        .openStatus(generateOpenStatus())
                        .retrievalStatus(RetrievalStatus.VALID)
                        .timeStamp(generateTimeStamp())
                        .build())
                .doorStatusFrontRight(DoorOpenStatus.builder()
                        .openStatus(generateOpenStatus())
                        .retrievalStatus(RetrievalStatus.VALID)
                        .timeStamp(generateTimeStamp())
                        .build())
                .doorStatusRearLeft(DoorOpenStatus.builder()
                        .openStatus(generateOpenStatus())
                        .retrievalStatus(RetrievalStatus.VALID)
                        .timeStamp(generateTimeStamp())
                        .build())
                .doorStatusRearRight(DoorOpenStatus.builder()
                        .openStatus(generateOpenStatus())
                        .retrievalStatus(RetrievalStatus.VALID)
                        .timeStamp(generateTimeStamp())
                        .build())
                .doorLockStatusGas(DoorLockStatus.builder()
                        .lockStatus(generateLockStatus())
                        .retrievalStatus(RetrievalStatus.VALID)
                        .timeStamp(generateTimeStamp())
                        .build())
                .doorLockStatusDecklid(DoorLockStatus.builder()
                        .lockStatus(generateLockStatus())
                        .retrievalStatus(RetrievalStatus.VALID)
                        .timeStamp(generateTimeStamp())
                        .build())
                .doorLockStatusVehicle(DoorLockStatus.builder()
                        .lockStatus(generateLockStatus())
                        .retrievalStatus(RetrievalStatus.VALID)
                        .timeStamp(generateTimeStamp())
                        .build())
                .build();


        return doors;
    }

    private static int generateTimeStamp() {
        Random random = new Random();

        int low = 1555954815;
        int high = (int) (System.currentTimeMillis() / 1000L);
        int result = random.nextInt(high-low) + low;

        return result;
    }

    private static LockStatus generateLockStatus() {
        final LockStatus[] lockStates = {
                LockStatus.LOCKED,
                LockStatus.UNLOCKED
        };

        Random random = new Random();

        return lockStates[random.nextInt(lockStates.length)];
    }

    private static OpenStatus generateOpenStatus() {
        final OpenStatus[] openStates = {
                OpenStatus.OPEN,
                OpenStatus.CLOSED
        };

        Random random = new Random();

        return openStates[random.nextInt(openStates.length)];
    }


}
