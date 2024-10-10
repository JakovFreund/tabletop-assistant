package com.freund.tabletop_assistant.model;

import java.util.ArrayList;
import java.util.HashMap;

class Creature {
    private int base_STR;
    private int base_DEX;
    private int base_CON;
    private int base_INT;
    private int base_WIS;
    private int base_CHA;
    private Race race;
    private Subrace subrace;
    private HashMap<GameClass, Integer> classes;
    private ArrayList<Subclass> subclasses;
    private ArrayList<StatusEffectInstance> statusEffectInstances;
    private ArrayList<TurnResource> turnResources;
    private ArrayList<ItemStack> inventory;
    int equiped[]; // stores inventory indexes of equiped items

    // TODO ^^need getters for all because of StatusEffects (getter returns modified current value (for example temporary double DEX) while these contain base values)

    public Creature() {
        this.classes = new HashMap<GameClass, Integer>();
        this.statusEffectInstances = new ArrayList<StatusEffectInstance>();
        this.turnResources = new ArrayList<TurnResource>();
        this.inventory = new ArrayList<ItemStack>();
        this.equiped = new int[EquipSlot.values().length];
        this.subrace = Subrace.HALF_ELF;
        this.race = this.subrace.RACE;

        //prepared spells (class?)

        turnResources.add(new TurnResource(TurnResourceType.ACTION));
        turnResources.add(new TurnResource(TurnResourceType.BONUS_ACTION));
        //turnResources.add(new TurnResource(TurnResourceType.REACTION));
        //turnResources.add(new TurnResource(TurnResourceType.MOVEMENT));

        //turnResources.add(new TurnResource(TurnResourceType.HP));
        //turnResources.add(new TurnResource(TurnResourceType.Temporary HP));
        //turnResources.add(new TurnResource(TurnResourceType.Hit Dice));

    }

    void levelUp(GameClass gameClass) { // TODO optional add subclasses
        if (this.classes.containsKey(gameClass)) {
            this.classes.put(gameClass, this.classes.get(gameClass) + 1);
        } else{
            this.classes.put(gameClass, 1);
        }
    }

    // TODO void resetLevel() also reset classes and subclasses

    TurnResource getTurnResource(String name) {
        for (TurnResource turnResource : turnResources) {
            if (turnResource.name == name) {
                return turnResource;
            }
        }
        return null;
    }

    ArrayList<TurnResource> getTurnResources(RefillRate refillRate) {
        ArrayList<TurnResource> refillRateTurnResources = new ArrayList<TurnResource>();
        for (TurnResource turnResource : turnResources) {
            if (turnResource.refillRate == refillRate) {
                refillRateTurnResources.add(turnResource);
            }
        }
        return refillRateTurnResources;
    }

    public void setTurnResourceAmount(String name, int amount) {
        TurnResource turnResource = getTurnResource(name);
        if (turnResource != null) {
            turnResource.amount = amount;
        } else {
            System.out.println("turnResource doesn't exist");
        }
    }

    // addTurnResource custom for endpoint ?

    void logManualInput(String string){ // for StatusEffects that don't proc on their own
        System.out.println("MANUAL INPUT: " + string);
    }

    void myTurn() {
        // refresh action, bonus action, reaction
        for (TurnResource turnResource : getTurnResources(RefillRate.TURN)) {
            turnResource.amount = turnResource.maxAmount;
        }

        // TODO proc poisons, saving throws or whatever, this needs to be an if tree with calculations
        // remove 1 duration from effects

        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.duration == null) {
                statusEffectInstance.turnsDuration -= 1;
                if (statusEffectInstance.turnsDuration == 0) {
                    toRemove.add(statusEffectInstance);
                }
            }
        }
        statusEffectInstances.removeAll(toRemove);
    }

    void endTurn(){
        // proc the rare end of turn effects
    }

    void addStatusEffectInstance(StatusEffectInstance statusEffectInstance){
        // TODO also if tree, apply initial effect
        // actually probably a switch case tree
        // for example: addStatusEffectInstance(Invisibility) -> if this.hasStatusEffect(Branding Smite) -> can't turn invisible
    }

    boolean hasStatusEffect(StatusEffect statusEffect){
        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.statusEffect == statusEffect){
                return true;
            }
        }
        return false;
    }

    void endCombat() {
        // don't proc all turnDuration effects since some may last days, proc them as they travel (10 turns = 1 minute)
        // TODO prompt auto go into turn based mode on death saving throws
    }

    void shortRest() {
        // TODO HP, SPELLSLOTS...
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.duration == Duration.SHORT_REST) {
                toRemove.add(statusEffectInstance);
            }
        }
        statusEffectInstances.removeAll(toRemove);
    }

    void longRest() {
        // TODO HP, SPELLSLOTS...
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.duration == Duration.LONG_REST) { //probably need to refresh all, not just LONG_REST
                toRemove.add(statusEffectInstance);
            }
        }
        statusEffectInstances.removeAll(toRemove);
    }

    void giveItems(ArrayList<ItemStack> items) {
        for (ItemStack item : items) {
            this.giveItem(item);
        }
    }

    void giveItem(ItemStack item) {
        inventory.add(item);
    }

    void equipItem(int inventoryIndex, EquipSlot equipSlot) {
        // remove buffs from previous in that slot
        equiped[equipSlot.ordinal()] = inventoryIndex;

        // if creature is holding Produce Flame gain Lighted StatusEffect

    }

    void consumeItem(int inventoryIndex) {
        // TODO if type.CONSUMABLE
    }

    ArrayList<ItemStack> getInventory(){
        return this.inventory;
    }

    ItemStack getItemStackByIndex(int index){
        return this.getInventory().get(index);
    }

    void damage(int damageAmount) {
        if (getTurnResource("Temporary HP").amount>0){
            if (getTurnResource("Temporary HP").amount > damageAmount){
                getTurnResource("Temporary HP").amount -= damageAmount;
                if(this.hasStatusEffect(StatusEffect.ARMOUR_OF_AGATHYS)){
                    // TODO armour of agahtys proc
                }
                // TODO other cases

            }
            
        }
        
        getTurnResource("HP").amount -= damageAmount;
    }

    void setHP(int amount) {
        getTurnResource("HP").amount = amount;
    }

    void setMaxHP(int amount) {
        getTurnResource("HP").maxAmount = amount;
    }
    

}

enum EquipSlot {
    HEAD,
    CAPE,
    TORSO,
    GLOVES,
    FEET,
    AMULET,
    RING_1,
    RING_2,
    RIGHT_HAND,
    LEFT_HAND,
    RANGED
}

enum Ability {
    NONE,
    STR,
    DEX,
    CON,
    INT,
    WIS,
    CHA;

    static int toModifier(int AbilityPoint) {
        int result = AbilityPoint / 2;
        return result - 5;
    }
}
