package com.freund.tabletop_assistant.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.freund.tabletop_assistant.model.item.ItemStack;

import lombok.Data;

@Data
public class Creature {
    private UUID creatureId;
    private String name;
    private int base_STR;
    private int base_DEX;
    private int base_CON;
    private int base_INT;
    private int base_WIS;
    private int base_CHA;
    private Subrace subrace;
    private HashMap<GameClass, Integer> classes;
    private ArrayList<Subclass> subclasses;
    private ArrayList<StatusEffectInstance> statusEffectInstances;
    private ArrayList<TurnResource> turnResources;
    private ArrayList<ItemStack> inventory;
    private UUID equiped[]; // stores ids of equiped items from inventory

    // i probably don't need thisˇˇ (it's just gonna get filled from the gamestate anyway, TODO test array creation with @NoArgsConstructor, what about EquipSlot.values().length ?)
    public Creature() {
        this.classes = new HashMap<GameClass, Integer>();
        this.subclasses = new ArrayList<Subclass>();
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

    
    

    // TODO modified ability getters (getSTR() => base_STR * StatusEffect.ENCOUMBERED ...) (getter returns modified current value (for example temporary double DEX) while these contain base values)

    // addClass(), addSubclass, addTurnResource

    public Race getRace(){
        return this.subrace.RACE;
    }


    public void addItems(ArrayList<ItemStack> items) {
        for (ItemStack item : items) {
            this.addItem(item);
        }
    }

    public void addItem(ItemStack item) {
        System.out.println("add item");
        this.inventory.add(item);
        // update item.lastModified
    }

    public void equipItem(UUID itemId, EquipSlot equipSlot) {
        // remove buffs from previous in that slot (add function to recalculate all status effects)
        // equiped[equipSlot.ordinal()] = this.getItem(itemId);
        // if creature is holding Produce Flame gain Lighted StatusEffect
    }

    public void consumeItem(int inventoryIndex) {
        // TODO if type.CONSUMABLE
    }

    public ItemStack getItemStackByIndex(int index){
        return this.getInventory().get(index);
    }


    public TurnResource getTurnResource(TurnResourceType turnResourceType) {
        for (TurnResource turnResource : turnResources) {
            if (turnResource.getType() == turnResourceType) {
                return turnResource;
            }
        }
        return null;
    }

    public ArrayList<TurnResource> getTurnResources(RefillRate refillRate) {
        ArrayList<TurnResource> refillRateTurnResources = new ArrayList<TurnResource>();
        for (TurnResource turnResource : turnResources) {
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
            System.err.println("turnResource "+turnResourceType.toString()+" doesn't exist");
            return false;
        }
        return true;
    }

    public boolean setTurnResourceMaxAmount(TurnResourceType turnResourceType, int maxAmount) {
        TurnResource turnResource = getTurnResource(turnResourceType);
        if (turnResource != null) {
            turnResource.setMaxAmount(maxAmount);
        } else {
            System.err.println("turnResource "+turnResourceType.toString()+" doesn't exist");
            return false;
        }
        return true;
    }

    public void addStatusEffectInstance(StatusEffectInstance statusEffectInstance){
        statusEffectInstances.add(statusEffectInstance);
        // TODO don't need if tree, just go through StatusEffect.dependancies list and apply them with the same duration and dependsUpon.
    }

    public boolean hasStatusEffect(StatusEffect statusEffect){
        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.getStatusEffect() == statusEffect){
                return true;
            }
        }
        return false;
    }

    
    // addTurnResource custom for endpoint ?
    

    // ---


    public void levelUp(GameClass gameClass) { // TODO optional add subclasses
        if (this.classes.containsKey(gameClass)) {
            this.classes.put(gameClass, this.classes.get(gameClass) + 1);
        } else{
            this.classes.put(gameClass, 1);
        }
    }

    // TODO void resetLevel() also reset classes and subclasses



    public void logManualInput(String string){ // for StatusEffects that don't proc on their own
        System.out.println("MANUAL INPUT: " + string);
    }

    public void myTurn() {
        // refresh action, bonus action, reaction
        for (TurnResource turnResource : getTurnResources(RefillRate.TURN)) {
            turnResource.setAmount(turnResource.getMaxAmount());
        }

        // TODO proc poisons, saving throws or whatever, this needs to be an if tree with calculations
        // remove 1 duration from effects

        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();

        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.getDuration().getDurationType() == DurationType.TURNS) {
                statusEffectInstance.getDuration().setTurnsDuration(statusEffectInstance.getDuration().getTurnsDuration() - 1);
                if (statusEffectInstance.getDuration().getTurnsDuration() == 0) {
                    toRemove.add(statusEffectInstance);
                }
            }
        }

        statusEffectInstances.removeAll(toRemove);
    }

    public void endTurn(){
        // proc the rare end of turn effects
    }

    public void endCombat() {
        // don't proc all turnDuration effects since some may last days, proc them as they travel (10 turns = 1 minute)
        // TODO prompt auto go into turn based mode on death saving throws
    }

    public void shortRest() {
        // TODO HP, SPELLSLOTS...
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.getDuration().getDurationType() == DurationType.SHORT_REST) {
                toRemove.add(statusEffectInstance);
            }
        }
        statusEffectInstances.removeAll(toRemove);
    }

    public void longRest() {
        // TODO HP, SPELLSLOTS...
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
            if (statusEffectInstance.getDuration().getDurationType() == DurationType.LONG_REST) { //probably need to refresh all, not just LONG_REST
                toRemove.add(statusEffectInstance);
            }
        }
        statusEffectInstances.removeAll(toRemove);
    }


    public void damage(int damageAmount) {
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

    // TODO check rules on creature death/knocked out: do statuseffects get removed? (by source UUID?)

}




