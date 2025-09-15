package com.freund.tabletop_assistant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.model.device.ConnectedDevices;
import com.freund.tabletop_assistant.model.device.Device;


@Service
public class DeviceService {
    @Autowired
    private ConnectedDevices connectedDevices;
    @Autowired
    private GameStateService gameStateService;

    public List<UUID> getCurrentlyConnectedDeviceIds(){
        return new ArrayList<UUID>(connectedDevices.getCurrentlyConnectedDeviceIds());
    }

    public Device getDevice(UUID deviceId){
        return gameStateService.getDevice(deviceId);
    }

    public boolean connectDevice(UUID id){ //TODO add try-catch
        connectedDevices.addDevice(id);
        String deviceNickname = "(device not mapped to nickname)";
        if(gameStateService.getDevice(id)!=null){
            deviceNickname = gameStateService.getDevice(id).getDeviceNickname();
        }
        System.out.println("Connected device: " + deviceNickname + " " + id);
        return true;  
    }

    public boolean saveDevice(UUID deviceId, String deviceNickname){
        return gameStateService.saveDevice(deviceId, deviceNickname);
    }

    public boolean saveDeviceMapping(String deviceNickname, UUID creatureId, boolean dungeonMaster){
        return gameStateService.saveDeviceMapping(deviceNickname, creatureId, dungeonMaster);
    }
    
}
