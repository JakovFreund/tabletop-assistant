package com.freund.tabletop_assistant.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.model.GameState;
import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.device.Device;
import com.freund.tabletop_assistant.model.device.DeviceMapping;

@Service
public class GameStateService {
    @Autowired
    private GameState gameState;

    public GameState getGameState(){
        return gameState;
    }

    public boolean saveGameState(){
        return gameState.saveGameState();
    }

    public Creature getCreature(UUID id){
        return gameState.getCreature(id);
    }

    public Device getDevice(UUID id){
        return gameState.getDevice(id);
    }

    public void addCreature(Creature creature){
        gameState.getCreatures().add(creature);
    }

    public boolean saveDevice(UUID deviceId, String deviceNickname){
        if(gameState.getDevice(deviceId)==null){
            gameState.getDevices().add(new Device(deviceId, deviceNickname));
        } else {
            gameState.getDevice(deviceId).setDeviceNickname(deviceNickname);
        }
        return true;
    }

    public boolean saveDeviceMapping(String deviceNickname, UUID creatureId, boolean dungeonMaster){
        if(gameState.getDeviceMapping(deviceNickname)==null){
            gameState.getDeviceMappings().add(new DeviceMapping(deviceNickname, creatureId, dungeonMaster));
        } else {
            DeviceMapping deviceMapping = gameState.getDeviceMapping(deviceNickname);
            deviceMapping.setCreatureId(creatureId);
            deviceMapping.setDungeonMaster(dungeonMaster);
        }
        return true;
    }
}
