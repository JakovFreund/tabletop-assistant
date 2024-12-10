package com.freund.tabletop_assistant.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.device.Device;
import com.freund.tabletop_assistant.model.device.DeviceMapping;
import com.freund.tabletop_assistant.util.JsonHandler;


@Component
@Data
@NoArgsConstructor
public class GameState {
    // fantasy datetime
    private ArrayList<Creature> creatures;
    private ArrayList<DeviceMapping> deviceMappings;
    private ArrayList<Device> devices;

    @PostConstruct
    public void loadGameState(){
        try {
            GameState loadedGameState = JsonHandler.loadGameStateFromFile("gamestate.json");
            this.creatures = loadedGameState.getCreatures();
            this.deviceMappings = loadedGameState.getDeviceMappings();
            this.devices = loadedGameState.getDevices();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean saveGameState(){
        try {
            JsonHandler.saveGameStateToFile(this, "gamestate.json");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Creature getCreature (UUID id){
        for (Creature creature : this.getCreatures()){
            if (creature.getCreatureId().equals(id)){
                return creature;
            }
        }
        return null;
    }

    public DeviceMapping getDeviceMapping(String deviceNickname){
        for (DeviceMapping deviceMapping : deviceMappings){
            if (deviceMapping.getDeviceNickname().equals(deviceNickname)){
                return deviceMapping;
            }
        }
        return null;
    }

    public Device getDevice(UUID deviceId){
        for (Device device : devices){
            if (device.getDeviceId().equals(deviceId)){
                return device;
            }
        }
        return null;
    }
}
