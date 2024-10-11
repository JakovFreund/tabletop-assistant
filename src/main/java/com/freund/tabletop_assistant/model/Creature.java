package com.freund.tabletop_assistant.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.core.annotation.AliasFor;

import com.freund.tabletop_assistant.model.item.ItemStack;

public class Creature {
    private UUID creatureId;
    private String name;
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
    UUID equiped[]; // stores inventory indexes of equiped items

    public Creature() {
        this.classes = new HashMap<GameClass, Integer>();
        this.statusEffectInstances = new ArrayList<StatusEffectInstance>();
        this.turnResources = new ArrayList<TurnResource>();
        this.inventory = new ArrayList<ItemStack>();
        this.equiped = new UUID[EquipSlot.values().length];

    }

    public Creature (String name, Subrace subrace){
        this();
        this.creatureId = UUID.randomUUID();
        this.name = name;
        this.subrace = subrace;
        this.race = this.subrace.RACE;

        //prepared spells (class?)

        turnResources.add(new TurnResource(TurnResourceType.ACTION));
        turnResources.add(new TurnResource(TurnResourceType.BONUS_ACTION));
        turnResources.add(new TurnResource(TurnResourceType.REACTION));
        turnResources.add(new TurnResource(TurnResourceType.MOVEMENT));

        
        // the values of theseˇˇ might come from their race/class or maybe even base_CON ?
        turnResources.add(new TurnResource(TurnResourceType.HP, 20));
        turnResources.add(new TurnResource(TurnResourceType.TEMPORARY_HP));
        turnResources.add(new TurnResource(TurnResourceType.HIT_DICE)); 
    }

    // default getters

    public UUID getCreatureId(){
        return this.creatureId;
    }

    public String getName(){
        return this.name;
    }

    public int getBase_STR(){
        return this.base_STR;
    }

    public int getBase_DEX(){
        return this.base_DEX;
    }

    public int getBase_CON(){
        return this.base_CON;
    }

    public int getBase_INT(){
        return this.base_INT;
    }

    public int getBase_WIS(){
        return this.base_WIS;
    }

    public int getBase_CHA(){
        return this.base_CHA;
    }

    public Race getRace(){
        return this.race;
    }

    public Subrace getSubrace(){
        return this.subrace;
    }

    public HashMap<GameClass, Integer> getClasses(){
        return this.classes;
    }

    public ArrayList<Subclass> getSubclasses(){
        return this.subclasses;
    }

    public ArrayList<StatusEffectInstance> getStatusEffectInstances(){
        return this.statusEffectInstances;
    }

    public ArrayList<TurnResource> getTurnResources(){
        return this.turnResources;
    }

    public ArrayList<ItemStack> getInventory(){
        return this.inventory;
    }

    public UUID[] getEquiped(){
        return this.equiped;
    }

    // ---

    // TODO modified ability getters
    // need getters for all because of StatusEffects (getter returns modified current value (for example temporary double DEX) while these contain base values)


    void getItems(ArrayList<ItemStack> items) {
        for (ItemStack item : items) {
            this.getItem(item);
        }
    }

    public void getItem(ItemStack item) {
        System.out.println("give item");
        this.inventory.add(item);
        // update item.lastModified
    }

    public void giveItemToCreature(Creature creature, int index){
        // TODO
    }

    void equipItem(UUID itemId, EquipSlot equipSlot) {
        // remove buffs from previous in that slot
        // equiped[equipSlot.ordinal()] = this.getItem(itemId);
        // if creature is holding Produce Flame gain Lighted StatusEffect
    }

    void consumeItem(int inventoryIndex) {
        // TODO if type.CONSUMABLE
    }

    public ItemStack getItemStackByIndex(int index){
        return this.getInventory().get(index);
    }


    TurnResource getTurnResource(TurnResourceType turnResourceType) {
        for (TurnResource turnResource : turnResources) {
            if (turnResource.getType() == turnResourceType) {
                return turnResource;
            }
        }
        return null;
    }

    ArrayList<TurnResource> getTurnResources(RefillRate refillRate) {
        ArrayList<TurnResource> refillRateTurnResources = new ArrayList<TurnResource>();
        for (TurnResource turnResource : turnResources) {
            if (turnResource.getRefillRate() == refillRate) {
                refillRateTurnResources.add(turnResource);
            }
        }
        return refillRateTurnResources;
    }

    public void setTurnResourceAmount(TurnResourceType turnResourceType, int amount) {
        TurnResource turnResource = getTurnResource(turnResourceType);
        if (turnResource != null) {
            turnResource.setAmount(amount);
        } else {
            System.out.println("turnResource doesn't exist");
        }
    }

    public void setTurnResourceMaxAmount(TurnResourceType turnResourceType, int maxAmount) {
        TurnResource turnResource = getTurnResource(turnResourceType);
        if (turnResource != null) {
            turnResource.setMaxAmount(maxAmount);
        } else {
            System.out.println("turnResource doesn't exist");
        }
    }

    public void addStatusEffectInstance(StatusEffectInstance statusEffectInstance){
        statusEffectInstances.add(statusEffectInstance);
        // TODO also if tree, apply initial effect
        // actually probably a switch case tree
        // for example: addStatusEffectInstance(Invisibility) -> if this.hasStatusEffect(Branding Smite) -> can't turn invisible
    }

    boolean hasStatusEffect(StatusEffect statusEffect){
        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.getStatusEffect() == statusEffect){
                return true;
            }
        }
        return false;
    }

    
    // addTurnResource custom for endpoint ?
    

    // ---


    void levelUp(GameClass gameClass) { // TODO optional add subclasses
        if (this.classes.containsKey(gameClass)) {
            this.classes.put(gameClass, this.classes.get(gameClass) + 1);
        } else{
            this.classes.put(gameClass, 1);
        }
    }

    // TODO void resetLevel() also reset classes and subclasses






    void logManualInput(String string){ // for StatusEffects that don't proc on their own
        System.out.println("MANUAL INPUT: " + string);
    }

    void myTurn() {
        // refresh action, bonus action, reaction
        for (TurnResource turnResource : getTurnResources(RefillRate.TURN)) {
            turnResource.setAmount(turnResource.getMaxAmount());
        }

        // TODO proc poisons, saving throws or whatever, this needs to be an if tree with calculations
        // remove 1 duration from effects

        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.getDuration() == null) {
                statusEffectInstance.setTurnsDuration(statusEffectInstance.getTurnsDuration() - 1);
                if (statusEffectInstance.getTurnsDuration() == 0) {
                    toRemove.add(statusEffectInstance);
                }
            }
        }
        statusEffectInstances.removeAll(toRemove);
    }

    void endTurn(){
        // proc the rare end of turn effects
    }

    void endCombat() {
        // don't proc all turnDuration effects since some may last days, proc them as they travel (10 turns = 1 minute)
        // TODO prompt auto go into turn based mode on death saving throws
    }

    void shortRest() {
        // TODO HP, SPELLSLOTS...
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.getDuration() == Duration.SHORT_REST) {
                toRemove.add(statusEffectInstance);
            }
        }
        statusEffectInstances.removeAll(toRemove);
    }

    void longRest() {
        // TODO HP, SPELLSLOTS...
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.getDuration() == Duration.LONG_REST) { //probably need to refresh all, not just LONG_REST
                toRemove.add(statusEffectInstance);
            }
        }
        statusEffectInstances.removeAll(toRemove);
    }


    void damage(int damageAmount) {
        if (getTurnResource(TurnResourceType.TEMPORARY_HP).getAmount()>0){
            if (getTurnResource(TurnResourceType.TEMPORARY_HP).getAmount() > damageAmount){
                getTurnResource(TurnResourceType.TEMPORARY_HP).setAmount(getTurnResource(TurnResourceType.TEMPORARY_HP).getAmount() - damageAmount);
                if(this.hasStatusEffect(StatusEffect.ARMOUR_OF_AGATHYS)){
                    // TODO armour of agahtys proc
                }
                // TODO other cases

            }
            
        }
        
        getTurnResource(TurnResourceType.HP).setAmount(getTurnResource(TurnResourceType.HP).getAmount() - damageAmount);
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
