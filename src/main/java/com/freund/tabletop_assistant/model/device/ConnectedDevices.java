package com.freund.tabletop_assistant.model.device;

import java.util.HashSet;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class ConnectedDevices {
    private HashSet<UUID> currentlyConnectedDeviceIds = new HashSet<UUID>();

    public void addDevice(UUID deviceId){
        this.currentlyConnectedDeviceIds.add(deviceId);
    }

    /*
    public void removeDevice(UUID deviceId){
        if (this.currentlyConnectedDeviceIds.contains(deviceId)){
            this.currentlyConnectedDeviceIds.remove(deviceId);
        } else {
            System.out.println("Can't remove device because it isn't connected.");
        }
    }
    */
}
