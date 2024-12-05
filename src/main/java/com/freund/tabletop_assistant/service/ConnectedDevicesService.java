package com.freund.tabletop_assistant.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.model.device.ConnectedDevices;


@Service
public class ConnectedDevicesService {
    @Autowired
    ConnectedDevices connectedDevices;
    @Autowired
    GameStateService gameStateService;

    public ArrayList<UUID> getCurrentlyConnectedDeviceIds(){
        return new ArrayList<UUID>(connectedDevices.getCurrentlyConnectedDeviceIds());
    }

    public boolean connectDevice(UUID id){ //TODO add try-catch
        connectedDevices.addDevice(id);
        String deviceNickname = "";
        if(gameStateService.getDevice(id)!=null){
            deviceNickname = gameStateService.getDevice(id).getDeviceNickname()+" ";
        }
        System.out.println("Connected device: " + deviceNickname + id);
        return true;  
    }

    public boolean saveDevice(UUID deviceId, String deviceNickname){
        return gameStateService.saveDevice(deviceId, deviceNickname);
    }


    
}
