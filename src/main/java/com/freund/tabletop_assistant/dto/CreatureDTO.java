package com.freund.tabletop_assistant.dto;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.freund.tabletop_assistant.model.statuseffect.StatusEffectInstance;
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
    private HashMap<Ability, Integer> abilityScores;
    private HashMap<Skill, Boolean> skillProficiencies;
    private HashMap<Ability, Boolean> savingThrowProficiencies;
    private HashMap<GameClass, Integer> classes;
    private ArrayList<Subclass> subclasses;
    private ArrayList<StatusEffectInstance> statusEffectInstances;
    private ArrayList<TurnResource> turnResources;
    //private ArrayList<ItemStack> inventory;
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
