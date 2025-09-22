package com.freund.tabletop_assistant.model.creature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.freund.tabletop_assistant.model.creature.gameclass.GameClass;
import com.freund.tabletop_assistant.model.creature.gameclass.Subclass;
import com.freund.tabletop_assistant.model.ability.Ability;
import com.freund.tabletop_assistant.model.ability.Skill;
import com.freund.tabletop_assistant.model.castable.Castable;
import com.freund.tabletop_assistant.model.condition.Condition;
import com.freund.tabletop_assistant.model.condition.ConditionInstance;
import com.freund.tabletop_assistant.model.creature.race.Race;
import com.freund.tabletop_assistant.model.creature.race.Subrace;
import com.freund.tabletop_assistant.model.duration.DurationType;
import com.freund.tabletop_assistant.model.item.Item;
import com.freund.tabletop_assistant.model.source.EffectSource;
import com.freund.tabletop_assistant.model.source.EffectSourceType;
import com.freund.tabletop_assistant.model.turnresource.RefillRate;
import com.freund.tabletop_assistant.model.turnresource.TurnResource;
import com.freund.tabletop_assistant.model.turnresource.TurnResourceType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Creature {
    private UUID creatureId;
    private String name;
    private Subrace subrace;
    private Background background;
    private Alignment alignment;
    private Castable concentratingOn;
    // Armour/Weapon Proficiencies ? Derived from class/race ?
    private Map<Ability, Integer> abilityScores = new HashMap<>();
    private Map<Skill, Boolean> skillProficiencies = new HashMap<>(); //ˇˇ TODO change these two to Lists with only true elements inside
    private Map<Ability, Boolean> savingThrowProficiencies = new HashMap<>();
    private Map<GameClass, Integer> classes = new HashMap<>(); // TODO change to list because i need to know first class for proficiencies and whatnot
    private List<Subclass> subclasses = new ArrayList<>();
    private List<ConditionInstance> conditionInstances = new ArrayList<>();
    private List<TurnResource> turnResources = new ArrayList<>();
    private List<Item> inventory = new ArrayList<>();
    private UUID equiped[] = new UUID[EquipSlot.values().length]; // stores ids of equiped items from inventory


    // init block runs after field initializers, before constructors
    {
        for (Ability ability : Ability.getAll()) {
            abilityScores.put(ability, 0);
            savingThrowProficiencies.put(ability, false);
        }
        for (Skill skill : Skill.values()) {
            skillProficiencies.put(skill, false);
        }
    }

    // ### SPECIAL

    
    // never works like this (always Damage object)
    // move this to creatureService instead
    public void damage(int damageAmount) {
        if (getTurnResource(TurnResourceType.TEMPORARY_HP).getAmount() > 0) {
            if (getTurnResource(TurnResourceType.TEMPORARY_HP).getAmount() > damageAmount) {
                getTurnResource(TurnResourceType.TEMPORARY_HP)
                        .setAmount(getTurnResource(TurnResourceType.TEMPORARY_HP).getAmount() - damageAmount);
                if (this.hasCondition(Condition.ARMOUR_OF_AGATHYS)) {
                    // TODO armour of agahtys proc
                }
                // TODO other cases

            }
        }

        getTurnResource(TurnResourceType.HP).setAmount(getTurnResource(TurnResourceType.HP).getAmount() - damageAmount);
    }

    public void consumeItem(int inventoryIndex) {
        // TODO if type.CONSUMABLE
    }

    public void levelUp(GameClass gameClass) { // TODO optional add subclasses
        if (this.classes.containsKey(gameClass)) {
            this.classes.put(gameClass, this.classes.get(gameClass) + 1);
        } else {
            this.classes.put(gameClass, 1);
        }
    }

    // TODO void resetLevel() also reset classes and subclasses

    // ### TURN

    public void myTurn() {
        // refresh action, bonus action, reaction
        for (TurnResource turnResource : getTurnResources(RefillRate.TURN)) {
            turnResource.setAmount(turnResource.getMaxAmount());
        }

        // TODO proc Conditions, saving throws or whatever, if tree

        // ˇˇremoves 1 duration from effects, check if works
        ArrayList<ConditionInstance> toRemove = new ArrayList<ConditionInstance>();
        for (ConditionInstance conditionInstance : getConditionInstances()) {
            if (conditionInstance.getDuration().getDurationType() == DurationType.TURNS) {
                conditionInstance.getDuration()
                        .setTurnsDuration(conditionInstance.getDuration().getTurnsDuration() - 1);
                if (conditionInstance.getDuration().getTurnsDuration() == 0) {
                    toRemove.add(conditionInstance);
                }
            }
        }
        conditionInstances.removeAll(toRemove);
    }

    public void endTurn() {
        // proc the rare end of turn effects
    }

    public void endCombat() {
        // don't proc all turnDuration effects since some may last days, proc them as they travel (10 turns = 1 minute)
        // TODO prompt auto go into turn based mode on death saving throws
    }

    // ### REST

    public void shortRest() {
        // TODO HP, SPELLSLOTS...
        ArrayList<ConditionInstance> toRemove = new ArrayList<ConditionInstance>();
        for (ConditionInstance conditionInstance : getConditionInstances()) {
            if (conditionInstance.getDuration().getDurationType() == DurationType.SHORT_REST) {
                toRemove.add(conditionInstance);
            }
        }
        conditionInstances.removeAll(toRemove);
    }

    public void longRest() {
        // TODO HP, SPELLSLOTS...
        ArrayList<ConditionInstance> toRemove = new ArrayList<ConditionInstance>();
        for (ConditionInstance conditionInstance : getConditionInstances()) {
            if (conditionInstance.getDuration().getDurationType() == DurationType.LONG_REST) { //probably need to refresh all, not just LONG_REST
                toRemove.add(conditionInstance);
            }
        }
        conditionInstances.removeAll(toRemove);
    }

    // ### GETTERS, SETTERS, ADDERS 

    public void addSubclass(Subclass subclass) {
        this.subclasses.add(subclass);
    }

    @JsonIgnore
    public Race getRace() {
        return this.getSubrace().RACE;
    }

    @JsonIgnore
    public CreatureSize getCreatureSize() {
        return this.getSubrace().CREATURE_SIZE;
    }

    @JsonIgnore
    public int getLevel() {
        // TODO count class levels
        return 0;
    }

    @JsonIgnore
    public int getProficiencyBonus() {
        // TODO getLevel()
        return 0;
    }

    public boolean isProficient(Skill skill) {
        return this.getSkillProficiencies().getOrDefault(skill, false);
    }

    public boolean isProficientSavingThrow(Ability ability) {
        return this.getSavingThrowProficiencies().getOrDefault(ability, false);
    }

    public int getAbilityScore(Ability ability) {
        return this.getAbilityScores().get(ability);
    }

    public int getAbilityModifier(Ability ability) {
        return Ability.getModifier(getAbilityScore(ability));
    }

    public int getSkillModifier(Skill skill) {
        if (this.isProficient(skill)) {
            return this.getProficiencyBonus() + getAbilityModifier(skill.ABILITY);
        } else {
            return this.getAbilityModifier(skill.ABILITY);
        }
    }

    public int getSavingThrowModifier(Ability ability) {
        if (this.isProficientSavingThrow(ability)) {
            return this.getProficiencyBonus() + getAbilityModifier(ability);
        } else {
            return this.getAbilityModifier(ability);
        }
    }

    @JsonIgnore
    public int getPassivePerception() {
        return 10 + this.getSkillModifier(Skill.PERCEPTION);
    }

    @JsonIgnore
    public int getInitiativeModifier() {
        return getAbilityModifier(Ability.DEX); // Initiative is a Dexterity Check -> d20 + DEX modifier
    }

    @JsonIgnore
    public int getCarryingCapacity() { // in pounds
        return this.getAbilityScore(Ability.STR) * 15;
    }

    @JsonIgnore
    public int getPushDragLiftCapacity() {
        // While pushing or dragging weight in excess of your carrying capacity, your speed drops to 5 feet.
        return this.getCarryingCapacity() * 2;
    }

    @JsonIgnore
    public int getArmourClass() {
        // TODO return 10 + getAbilityModifier(Ability.DEX) + getEquipedItem(EquipSlot.TORSO).getItem() + shield item stat // which equipslots count towards AC?
        return 10 + getAbilityModifier(Ability.DEX);
    }

    @JsonIgnore
    public int getJumpLength() {
        return getAbilityScore(Ability.STR);
    }

    @JsonIgnore
    public int getJumpHeight() {
        return 3 + getAbilityModifier(Ability.STR);
    }

    public int getSavingThrowDC(Ability spellcastingAbility) { // TODO change to getDC(SavedSpell savedSpell) - get ability from map spell class origin
        return 8 + this.getAbilityModifier(spellcastingAbility) + this.getProficiencyBonus();
    }

    public void setConcentratingOn(Castable castable) { // sets both the creature's attribute and the concentrating condition  
        this.concentratingOn = castable;
        if (castable == null) {
        // TODO call CreatureService.remove previous from other creatures OR just move this whole function in CreatureService
            this.removeConditionInstance(Condition.CONCENTRATING);
        } else {
            this.addConditionInstance(new ConditionInstance(Condition.CONCENTRATING, castable.getDuration(),
                    new EffectSource(EffectSourceType.CASTABLE, this)));

        }
    }

    // ### LIST/MAP

    public void addItems(List<Item> items) {
        for (Item item : items) {
            this.addItem(item);
        }
    }

    public void addItem(Item item) {
        System.out.println("add item");
        this.inventory.add(item);
        // update item.lastModified
    }

    public Item getItemByIndex(int index) {
        return this.getInventory().get(index);
    }

    public Item getItem(int slot) { // or UUID ?
        // TODO
        return null;
    }

    public UUID getEquipedInSlot(EquipSlot equipSlot) {
        return getEquiped()[equipSlot.ordinal()];
    }

    public Item getEquipedItem(EquipSlot equipSlot) {
        // TODO
        return null;
    }

    public void equipItem(UUID itemId, EquipSlot equipSlot) {
        // remove buffs from previous in that slot (add function to recalculate all status effects)
        // getEquipedInSlot(EquipSlot equipSlot) = this.getItem(itemId);
        // if creature is holding Produce Flame gain Lighted Condition (or just add a lighted boolean to all items and add status effect if holding item)
    }

    public TurnResource getTurnResource(TurnResourceType turnResourceType) {
        for (TurnResource turnResource : getTurnResources()) {
            if (turnResource.getType() == turnResourceType) {
                return turnResource;
            }
        }
        return null;
    }

    public ArrayList<TurnResource> getTurnResources(RefillRate refillRate) {
        ArrayList<TurnResource> refillRateTurnResources = new ArrayList<TurnResource>();
        for (TurnResource turnResource : getTurnResources()) {
            if (turnResource.getRefillRate() == refillRate) {
                refillRateTurnResources.add(turnResource);
            }
        }
        return refillRateTurnResources;
    }

    public boolean setTurnResourceAmount(TurnResourceType turnResourceType, int amount) {
        TurnResource turnResource = getTurnResource(turnResourceType);
        if (turnResource != null) {
            turnResource.setAmount(amount);
        } else {
            System.err.println("turnResource " + turnResourceType.toString() + " doesn't exist");
            return false;
        }
        return true;
    }

    public boolean setTurnResourceMaxAmount(TurnResourceType turnResourceType, int maxAmount) {
        TurnResource turnResource = getTurnResource(turnResourceType);
        if (turnResource != null) {
            turnResource.setMaxAmount(maxAmount);
        } else {
            System.err.println("turnResource " + turnResourceType.toString() + " doesn't exist");
            return false;
        }
        return true;
    }

    public void addTurnResource(TurnResource turnResource) {
        this.turnResources.add(turnResource);
    }

    public void addConditionInstance(ConditionInstance conditionInstance) {
        conditionInstances.add(conditionInstance);
        // print/log if saving throw is needed, what DC, and if affected creature has proficiency in that saving throw
        // then have a popup for what he rolled
    }

    public void removeConditionInstance(Condition condition) {
        for (ConditionInstance conditionInstance : getConditionInstances()) {
            if (conditionInstance.getCondition().equals(condition)) {
                getConditionInstances().remove(conditionInstance);
            }
        }
    }

    public List<Condition> getIncludedConditions(){
        List<Condition> conditions = new ArrayList<>();
        for (ConditionInstance conditionInstance : getConditionInstances()){
            for (Condition condition : conditionInstance.getCondition().getAllIncludedEffects()){
                conditions.add(condition);
            }
        }
        return conditions;
    }


    public boolean hasCondition(Condition condition) {
        for (Condition includedCondition : getIncludedConditions()) {
            if (includedCondition == condition) {
                return true;
            }
        }
        return false;
    }

    
    // ### CONSTRUCTOR

    public Creature(String name, Subrace subrace, Background background, Alignment alignment) {
        // TODO how do creatures get added to gamestate? should it be done here automatically?
        this.creatureId = UUID.randomUUID();
        this.name = name;
        this.subrace = subrace;
        this.background = background;
        this.alignment = alignment;

        //prepared spells (class?)

        addTurnResource(new TurnResource(TurnResourceType.ACTION));
        addTurnResource(new TurnResource(TurnResourceType.BONUS_ACTION));
        addTurnResource(new TurnResource(TurnResourceType.REACTION));
        addTurnResource(new TurnResource(TurnResourceType.MOVEMENT, this.getRace().MOVEMENT_SPEED));

        // the values of theseˇˇ might come from their race/class or maybe even base_CON ?
        addTurnResource(new TurnResource(TurnResourceType.HP, 20));
        addTurnResource(new TurnResource(TurnResourceType.TEMPORARY_HP));
        addTurnResource(new TurnResource(TurnResourceType.HIT_DICE)); // need hit dice counter for each class
    }
}