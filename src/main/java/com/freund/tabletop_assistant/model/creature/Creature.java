package com.freund.tabletop_assistant.model.creature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.freund.tabletop_assistant.model.creature.gameclass.GameClass;
import com.freund.tabletop_assistant.model.creature.gameclass.Subclass;
import com.freund.tabletop_assistant.model.ability.Ability;
import com.freund.tabletop_assistant.model.ability.Skill;
import com.freund.tabletop_assistant.model.castable.Castable;
import com.freund.tabletop_assistant.model.creature.race.Race;
import com.freund.tabletop_assistant.model.creature.race.Subrace;
import com.freund.tabletop_assistant.model.duration.DurationType;
import com.freund.tabletop_assistant.model.item.Item;
import com.freund.tabletop_assistant.model.source.EffectSource;
import com.freund.tabletop_assistant.model.source.EffectSourceType;
import com.freund.tabletop_assistant.model.statuseffect.StatusEffect;
import com.freund.tabletop_assistant.model.statuseffect.StatusEffectInstance;
import com.freund.tabletop_assistant.model.turnresource.RefillRate;
import com.freund.tabletop_assistant.model.turnresource.TurnResource;
import com.freund.tabletop_assistant.model.turnresource.TurnResourceType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Creature {
    private UUID creatureId;
    private String name;
    private Subrace subrace;
    private Castable concentratingOn;
    private Background background;
    private Alignment alignment;
    // Armour/Weapon Proficiencies ?
    private HashMap<Ability, Integer> abilityScores;
    private HashMap<Skill, Boolean> skillProficiencies; //ˇˇ these two could be Lists with only true elements inside but whatever
    private HashMap<Ability, Boolean> savingThrowProficiencies;
    private HashMap<GameClass, Integer> classes;
    private ArrayList<Subclass> subclasses;
    private ArrayList<StatusEffectInstance> statusEffectInstances;
    private ArrayList<TurnResource> turnResources;
    private ArrayList<Item> inventory;
    private UUID equiped[]; // stores ids of equiped items from inventory

    // ### SPECIAL

    public void damage(int damageAmount) {
        if (getTurnResource(TurnResourceType.TEMPORARY_HP).getAmount() > 0) {
            if (getTurnResource(TurnResourceType.TEMPORARY_HP).getAmount() > damageAmount) {
                getTurnResource(TurnResourceType.TEMPORARY_HP)
                        .setAmount(getTurnResource(TurnResourceType.TEMPORARY_HP).getAmount() - damageAmount);
                if (this.hasStatusEffect(StatusEffect.ARMOUR_OF_AGATHYS)) {
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

        // TODO proc StatusEffects, saving throws or whatever, if tree

        // ˇˇremoves 1 duration from effects, check if works
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : getStatusEffectInstances()) {
            if (statusEffectInstance.getDuration().getDurationType() == DurationType.TURNS) {
                statusEffectInstance.getDuration()
                        .setTurnsDuration(statusEffectInstance.getDuration().getTurnsDuration() - 1);
                if (statusEffectInstance.getDuration().getTurnsDuration() == 0) {
                    toRemove.add(statusEffectInstance);
                }
            }
        }
        statusEffectInstances.removeAll(toRemove);
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
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : getStatusEffectInstances()) {
            if (statusEffectInstance.getDuration().getDurationType() == DurationType.SHORT_REST) {
                toRemove.add(statusEffectInstance);
            }
        }
        statusEffectInstances.removeAll(toRemove);
    }

    public void longRest() {
        // TODO HP, SPELLSLOTS...
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : getStatusEffectInstances()) {
            if (statusEffectInstance.getDuration().getDurationType() == DurationType.LONG_REST) { //probably need to refresh all, not just LONG_REST
                toRemove.add(statusEffectInstance);
            }
        }
        statusEffectInstances.removeAll(toRemove);
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

    @JsonIgnore
    public int getSavingThrowDC(Ability spellcastingAbility) { // TODO change to getDC(SavedSpell savedSpell) - get ability from map spell class origin
        return 8 + this.getAbilityModifier(spellcastingAbility) + this.getProficiencyBonus();
    }

    public void setConcentratingOn(Castable castable) { // sets both the creature's attribute and the concentrating statuseffect  
        this.concentratingOn = castable;
        if (castable == null) {
        // TODO call CreatureService.remove previous from other creatures
            this.removeStatusEffectInstance(StatusEffect.CONCENTRATING);
        } else {
            this.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.CONCENTRATING, castable.getDuration(),
                    new EffectSource(EffectSourceType.SPELL, creatureId), ""));

        }
    }

    // ### LIST/MAP

    public void addItems(ArrayList<Item> items) {
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
        // if creature is holding Produce Flame gain Lighted StatusEffect (or just add a lighted boolean to all items and add status effect if holding item)
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

    public void addStatusEffectInstance(StatusEffectInstance statusEffectInstance) {
        statusEffectInstances.add(statusEffectInstance);
        // print/log if saving throw is needed, what DC, and if affected creature has proficiency in that saving throw
        // then have a popup for what he rolled
    }

    public void removeStatusEffectInstance(StatusEffect statusEffect) {
        for (StatusEffectInstance statusEffectInstance : getStatusEffectInstances()) {
            if (statusEffectInstance.getStatusEffect().equals(statusEffect)) {
                getStatusEffectInstances().remove(statusEffectInstance);
            }
        }
    }

    public List<StatusEffect> getIncludedStatusEffects(){
        List<StatusEffect> statusEffects = new ArrayList<>();
        for (StatusEffectInstance statusEffectInstance : getStatusEffectInstances()){
            for (StatusEffect statusEffect : statusEffectInstance.getStatusEffect().getAllIncludedEffects()){
                statusEffects.add(statusEffect);
            }
        }
        return statusEffects;
    }


    public boolean hasStatusEffect(StatusEffect statusEffect) {
        for (StatusEffect includedStatusEffect : getIncludedStatusEffects()) {
            if (includedStatusEffect == statusEffect) {
                return true;
            }
        }
        return false;
    }

    
    // ### CONSTRUCTOR

    // i probably don't need thisˇˇ (it's just gonna get filled from the gamestate anyway, TODO test array creation with @NoArgsConstructor, what about EquipSlot.values().length ?)
    public Creature() {
        this.setCreatureId(UUID.randomUUID());
        this.abilityScores = new HashMap<Ability, Integer>();
        this.skillProficiencies = new HashMap<Skill, Boolean>();
        this.savingThrowProficiencies = new HashMap<Ability, Boolean>();
        this.classes = new HashMap<GameClass, Integer>();
        this.subclasses = new ArrayList<Subclass>();
        this.statusEffectInstances = new ArrayList<StatusEffectInstance>();
        this.turnResources = new ArrayList<TurnResource>();
        this.inventory = new ArrayList<Item>();
        this.equiped = new UUID[EquipSlot.values().length];


        for (Ability ability : Ability.getAll()) {
            abilityScores.put(ability, 0);
        }

        for (Skill skill : Skill.values()) {
            skillProficiencies.put(skill, false);
        }

        for (Ability ability : Ability.getAll()) {
            savingThrowProficiencies.put(ability, false);
        }
    }

    public Creature(String name, Subrace subrace) {
        this();
        this.setName(name);
        this.setSubrace(subrace);

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
