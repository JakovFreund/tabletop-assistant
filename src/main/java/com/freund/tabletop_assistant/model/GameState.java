package com.freund.tabletop_assistant.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import lombok.Data;

import com.freund.tabletop_assistant.model.device.Device;
import com.freund.tabletop_assistant.model.device.DeviceMapping;
import com.freund.tabletop_assistant.util.JsonHandler;


@Component
@Data
public class GameState {
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

    public GameState(){
        this.creatures = new ArrayList<Creature>();
    }

    public Creature getCreature (UUID id){
        for (Creature creature : this.getCreatures()){
            if (creature.getCreatureId().equals(id)){
                return creature;
            }
        }
        return null;
    }

    public void addCreature(Creature creature){
        creatures.add(creature);
    }

    public DeviceMapping getDeviceMapping(UUID deviceId){
        for (DeviceMapping deviceMapping : deviceMappings){
            if (deviceMapping.getDeviceId().equals(deviceId)){
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
