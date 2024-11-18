package com.freund.tabletop_assistant.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.model.Creature;
import com.freund.tabletop_assistant.model.GameState;
import com.freund.tabletop_assistant.model.device.Device;

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
}
