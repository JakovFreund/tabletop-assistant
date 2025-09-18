package com.freund.tabletop_assistant.model.device;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class DeviceRegistry {
    private List<Device> devices = new ArrayList<>();

    public Device getDevice(UUID deviceId){
        for (Device device : devices){
            if (device.getDeviceId().equals(deviceId)){
                return device;
            }
        }
        return null;
    }
}
