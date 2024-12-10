package com.freund.tabletop_assistant.mapper;

import com.freund.tabletop_assistant.dto.CreatureDTO;
import com.freund.tabletop_assistant.model.creature.Creature;

public class CreatureMapper {

    public static CreatureDTO toDTO(Creature creature) {
        CreatureDTO dto = new CreatureDTO();
        // base attributes
        dto.setCreatureId(creature.getCreatureId());
        dto.setName(creature.getName());
        dto.setSubrace(creature.getSubrace());
        if (creature.getConcentratingOn() == null) {
            dto.setConcentratingOn("");
        } else {
            dto.setConcentratingOn(creature.getConcentratingOn().getName());
        }
        dto.setBackground(creature.getBackground());
        dto.setAlignment(creature.getAlignment());
        // Tool/Armour/Weapon Proficiencies ?
        dto.setAbilityScores(creature.getAbilityScores());
        dto.setSkillProficiencies(creature.getSkillProficiencies());
        dto.setSavingThrowProficiencies(creature.getSavingThrowProficiencies());
        dto.setClasses(creature.getClasses());
        dto.setSubclasses(creature.getSubclasses());
        dto.setStatusEffectInstances(creature.getStatusEffectInstances());
        dto.setTurnResources(creature.getTurnResources());
        //dto.setInventory(creature.getInventory());
        dto.setEquiped(creature.getEquiped());

        // derived attributes
        dto.setRace(creature.getRace());
        dto.setCreatureSize(creature.getCreatureSize());
        dto.setLevel(creature.getLevel());
        dto.setProficiencyBonus(creature.getProficiencyBonus());
        dto.setPassivePerception(creature.getPassivePerception());
        dto.setInitiativeModifier(creature.getInitiativeModifier());
        dto.setCarryingCapacity(creature.getCarryingCapacity());
        dto.setPushDragLiftCapacity(creature.getPushDragLiftCapacity());
        dto.setArmourClass(creature.getArmourClass());
        dto.setJumpLength(creature.getJumpLength());
        dto.setJumpHeight(creature.getJumpHeight());

        return dto;
    }
}
