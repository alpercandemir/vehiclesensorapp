package com.acr.vehiclesensor.controller;

import com.acr.vehiclesensor.client.api.DoorsApi;
import com.acr.vehiclesensor.model.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.acr.vehiclesensor.model.DoorsLockChangedStatus.LockChangedStatus;
import static com.acr.vehiclesensor.model.RetrievalStatus.VALID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoorsApiControllerTest {

    @InjectMocks
    private DoorsApiController doorsApiController;

    @Mock
    private DoorsApi doorsApi;

    @Test
    @Ignore
    public void shouldReturnDoorsStatus() {
        String vehicleId = "2ABN3483";

        DoorLockStatus doorLockStatus = new DoorLockStatus().builder()
                .lockStatus(LockStatus.LOCKED)
                .retrievalStatus(VALID)
                .timeStamp(1343443534)
                .build();

        Doors expectedDoors = new Doors().builder()
                .doorLockStatusDecklid(doorLockStatus)
                .build();

        when(doorsApi.findDoors(vehicleId)).thenReturn(expectedDoors);

        Doors doors = doorsApiController.getDoors(vehicleId, true);

        assertThat(doors, equalTo(expectedDoors));
    }

    @Test
    @Ignore
    public void shouldReturnChangedDoorsLockStatus() {
        String vehicleId = "2832ANM5232";

        DoorsLockChangeRequest doorsLockChangeRequest = new DoorsLockChangeRequest(LockCommand.LOCK);

        DoorsLockChangedStatus expectedStatus = new DoorsLockChangedStatus(LockChangedStatus.INITIATED);

        when(doorsApi.updateDoorsLockStatus(vehicleId, doorsLockChangeRequest)).thenReturn(expectedStatus);

        DoorsLockChangedStatus doorsLockChangedStatus = doorsApi.updateDoorsLockStatus(vehicleId, doorsLockChangeRequest);

        assertThat(doorsLockChangedStatus, equalTo(expectedStatus));
    }

}
