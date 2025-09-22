package com.freund.tabletop_assistant.dto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.freund.tabletop_assistant.model.creature.gameclass.GameClass;
import com.freund.tabletop_assistant.model.creature.gameclass.Subclass;
import com.freund.tabletop_assistant.model.ability.Ability;
import com.freund.tabletop_assistant.model.ability.Skill;
import com.freund.tabletop_assistant.model.creature.Alignment;
import com.freund.tabletop_assistant.model.creature.Background;
import com.freund.tabletop_assistant.model.creature.CreatureSize;
import com.freund.tabletop_assistant.model.creature.race.Race;
import com.freund.tabletop_assistant.model.creature.race.Subrace;
import com.freund.tabletop_assistant.model.turnresource.TurnResource;

import lombok.Data;

@Data
public class CreatureDTO {
    // BASE ATTRIBUTES
    private UUID creatureId;
    private String name;
    private Subrace subrace;
    private String concentratingOn;
    private Background background;
    private Alignment alignment;
    // Tool/Armour/Weapon Proficiencies ?
    private Map<Ability, Integer> abilityScores;
    private Map<Skill, Boolean> skillProficiencies;
    private Map<Ability, Boolean> savingThrowProficiencies;
    private Map<GameClass, Integer> classes;
    private List<Subclass> subclasses;
    private List<ConditionInstanceDTO> conditionInstances;
    private List<TurnResource> turnResources;
    //private List<ItemStack> inventory;
    private UUID equiped[];

    // DERIVED ATTRIBUTES
    private Race race;
    private CreatureSize creatureSize;
    private int level;
    private int proficiencyBonus;
    private int passivePerception;
    private int initiativeModifier;
    private int carryingCapacity;
    private int pushDragLiftCapacity;
    private int ArmourClass;
    private int jumpLength;
    private int jumpHeight;
}
