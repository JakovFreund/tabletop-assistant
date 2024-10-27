package com.freund.tabletop_assistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

import com.freund.tabletop_assistant.model.Creature;
import com.freund.tabletop_assistant.model.GameState;
import com.freund.tabletop_assistant.model.TurnResourceType;

@Service
public class CreatureService {
    @Autowired
    private GameState gameState;

    public boolean updateCreatureHP(UUID id, int hp){
        Creature creature = gameState.getCreature(id);
        if (creature == null) {
            return false;
        }
        creature.setTurnResourceAmount(TurnResourceType.HP, hp);
        return true;
    }
    
}
