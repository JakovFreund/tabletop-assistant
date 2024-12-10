package com.freund.tabletop_assistant.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.turnresource.TurnResourceType;

@Service
public class CreatureService {
    @Autowired
    private GameStateService gameStateService;

    public Creature getCreature(UUID id){
        return gameStateService.getCreature(id);
    }

    public boolean updateCreatureHP(UUID id, int hp){
        Creature creature = gameStateService.getCreature(id);
        if (creature == null) {
            return false;
        }
        return creature.setTurnResourceAmount(TurnResourceType.HP, hp);
    }

    public void giveItemTo(Creature creature, int index){
        // TODO
    }

    public void damageCreature(UUID id, int damageAmount) {
        Creature creature = getCreature(id);
        if (creature == null) {
            throw new IllegalArgumentException("Creature not found");
        }
        creature.damage(damageAmount);
    }
    
}
