package com.freund.tabletop_assistant.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.model.GameState;
import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.device.DeviceMapping;
import com.freund.tabletop_assistant.model.item.Item;
import com.freund.tabletop_assistant.util.JsonHandler;

import jakarta.annotation.PostConstruct;

@Service
public class GameStateService {
    private static final String FILE_PATH = "gamestate.json";
    @Autowired
    private GameState gameState;

    public boolean saveGameState() {
        try {
            JsonHandler.saveGameStateToFile(gameState, FILE_PATH);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostConstruct
    public boolean loadGameState() {
        try {
            GameState loaded = JsonHandler.loadGameStateFromFile(FILE_PATH);
            gameState.setCreatures(loaded.getCreatures());
            gameState.setDeviceMappings(loaded.getDeviceMappings());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public GameState getGameState(){
        return gameState;
    }

    public Creature getCreature(UUID id){
        return gameState.getCreature(id);
    }

    public void addCreature(Creature creature){
        gameState.getCreatures().add(creature);
    }

    public Item getItem(UUID itemId) {
        for (Creature creature : gameState.getCreatures()){
            for (Item item : creature.getInventory()){
                if (item.getItemId().equals(itemId)){
                    return item;
                }
            }
        }
        return null;
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
