package com.freund.tabletop_assistant.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.model.Creature;
import com.freund.tabletop_assistant.model.TurnResourceType;

@Service
public class CreatureService {
    @Autowired
    private GameStateService gameStateService;

    public boolean updateCreatureHP(UUID id, int hp){
        Creature creature = gameStateService.getCreature(id);
        if (creature == null) {
            return false;
        }
        creature.setTurnResourceAmount(TurnResourceType.HP, hp);
        return true;
    }

    public Creature getCreature(UUID id){
        return gameStateService.getCreature(id);
    }
    
}
