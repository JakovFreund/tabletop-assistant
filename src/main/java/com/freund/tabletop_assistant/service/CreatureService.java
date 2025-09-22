package com.freund.tabletop_assistant.service;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.turnresource.TurnResourceType;
import com.freund.tabletop_assistant.util.TabletopAssistantUtil;

@Service
public class CreatureService {
    @Autowired
    private GameStateService gameStateService;
    private final static Map<Integer, String> BARDIC_INSPIRATION_DICE = Map.ofEntries(Map.entry(1, "1d6"),
            Map.entry(5, "1d8"), Map.entry(10, "1d10"));
    private final static Map<Integer, Integer> BARBARIAN_RAGE_DAMAGE = Map.ofEntries(Map.entry(1, 2), Map.entry(9, 3));
    private final static Map<Integer, Integer> PROFICIENCY_BONUS = Map.ofEntries(Map.entry(1, 2), Map.entry(5, 3), Map.entry(9, 4));

    public Creature getCreature(UUID id) {
        return gameStateService.getCreature(id);
    }

    public boolean setCreatureHP(UUID id, int hp) {
        Creature creature = gameStateService.getCreature(id);
        if (creature == null) {
            return false;
        }
        return creature.setTurnResourceAmount(TurnResourceType.HP, hp);
    }

    public void giveItemTo(Creature creature, int index) {
        // TODO
    }

    public void damageCreature(UUID id, int damageAmount) {
        Creature creature = getCreature(id);
        if (creature == null) {
            throw new IllegalArgumentException("Creature not found");
        }
        creature.damage(damageAmount);
    }

    public static String getBardicInspirationDice(Creature creature) {
        // find bardicInspirationAtCreatureLevel's max key < creatureLevel
        Integer key = TabletopAssistantUtil.findMaxNumberSmallerOrEqualThan(BARDIC_INSPIRATION_DICE.keySet(),
                creature.getLevel());
        if (key != null) {
            return BARDIC_INSPIRATION_DICE.get(key);
        } else {
            System.out.println("Bardic inspiration level not defined.");
            return null;
        }
    }

    public static Integer getBarbarianRageDamage(Creature creature) {
        Integer key = TabletopAssistantUtil.findMaxNumberSmallerOrEqualThan(BARBARIAN_RAGE_DAMAGE.keySet(),
                creature.getLevel());
        if (key != null) {
            return BARBARIAN_RAGE_DAMAGE.get(key);
        } else {
            System.out.println("Barbarian Rage Damage level not defined.");
            return null;
        }
    }

    public static Integer getProficiencyBonus(Creature creature) {
        Integer key = TabletopAssistantUtil.findMaxNumberSmallerOrEqualThan(PROFICIENCY_BONUS.keySet(),
                creature.getLevel());
        if (key != null) {
            return PROFICIENCY_BONUS.get(key);
        } else {
            System.out.println("Proficiency bonus level not defined.");
            return null;
        }
    }

}
