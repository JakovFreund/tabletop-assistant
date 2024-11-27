package com.freund.tabletop_assistant.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.freund.tabletop_assistant.model.castable.Castable;
import com.freund.tabletop_assistant.model.item.ItemStack;

import lombok.Data;

@Data
public class Creature {
    private UUID creatureId;
    private String name;
    private Subrace subrace;
    private Castable concentratingOn;
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
    private ArrayList<ItemStack> inventory;
    private UUID equiped[]; // stores ids of equiped items from inventory


    // ### SPECIAL

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

    public void consumeItem(int inventoryIndex) {
        // TODO if type.CONSUMABLE
    }

    public void levelUp(GameClass gameClass) { // TODO optional add subclasses
        if (this.classes.containsKey(gameClass)) {
            this.classes.put(gameClass, this.classes.get(gameClass) + 1);
        } else{
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

    public void addSubclass(Subclass subclass){
        this.subclasses.add(subclass);
    }

    public Race getRace(){
        return this.getSubrace().RACE;
    }

    public CreatureSize getCreatureSize(){
        return this.getSubrace().CREATURE_SIZE;
    }

    public int getLevel(){
        // TODO count class levels
        return 0;
    }

    public int getProficiencyBonus(){
        // TODO getLevel()
        return 0;
    }

    public boolean isProficient(Skill skill){
        return this.getSkillProficiencies().get(skill);
    }

    public boolean isProficientSavingThrow(Ability ability){
        return this.getSavingThrowProficiencies().get(ability);
    }
    
    public int getAbilityScore(Ability ability){
        return this.getAbilityScores().get(ability);
    }

    public int getAbilityModifier(Ability ability){
        return Ability.getModifier(getAbilityScore(ability));
    }

    public int getSkillModifier(Skill skill){
        if (this.isProficient(skill)){
            return this.getProficiencyBonus() + getAbilityModifier(skill.ABILITY);
        } else{
            return this.getAbilityModifier(skill.ABILITY);
        }
    }

    public int getSavingThrowModifier(Ability ability){
        if (this.isProficientSavingThrow(ability)){
            return this.getProficiencyBonus() + getAbilityModifier(ability);
        } else{
            return this.getAbilityModifier(ability);
        }
    }

    public int getPassivePerception(){
        return 10 + this.getSkillModifier(Skill.PERCEPTION);
    }

    public int getInitiativeModifier(){
        return getAbilityModifier(Ability.DEX); // Initiative is a Dexterity Check -> d20 + DEX modifier
    }
    
    public int getCarryingCapacity(){ // in pounds
        return this.getAbilityScore(Ability.STR) * 15;
    }

    public int getPushDragLiftCapacity(){
        // While pushing or dragging weight in excess of your carrying capacity, your speed drops to 5 feet.
        return this.getCarryingCapacity() * 2;
    }

    public int getArmourClass(){
        // TODO return 10 + getAbilityModifier(Ability.DEX) + getEquipedItemStack(EquipSlot.TORSO).getItem() + shield item stat // which equipslots count towards AC?
        return 10 + getAbilityModifier(Ability.DEX);
    }

    public int getJumpLength(){
        return getAbilityScore(Ability.STR);
    }

    public int getJumpHeight(){
        return 3 + getAbilityModifier(Ability.STR);
    }

    public int getSavingThrowDC(Ability spellcastingAbility){ // TODO change to getDC(SavedSpell savedSpell) - get ability from map spell class origin
        // GameClass.SP
        return 8 + this.getAbilityModifier(spellcastingAbility) + this.getProficiencyBonus();
    }

    // @Override lombok ?
    public void setConcentratingOn(Castable castable){
        this.concentratingOn = castable;
        this.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.CONCENTRATING, castable.getDuration(), new EffectSource(EffectSourceType.SPELL, creatureId), List.of(), ""));
    }

    // ### LIST/MAP

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

    public ItemStack getItemStackByIndex(int index){
        return this.getInventory().get(index);
    }

    public ItemStack getItemStack(UUID uuid){
        for (ItemStack itemStack : getInventory()){
            if (itemStack.getItemId().equals(uuid)){
                return itemStack;
            }
        }
        return null;
    }

    public UUID getEquipedInSlot(EquipSlot equipSlot){
        return getEquiped()[equipSlot.ordinal()];
    }

    public ItemStack getEquipedItemStack(EquipSlot equipSlot){
        return getItemStack(getEquipedInSlot(equipSlot));
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

    public void addTurnResource(TurnResource turnResource){
        this.turnResources.add(turnResource);
    }

    public void addStatusEffectInstance(StatusEffectInstance statusEffectInstance){
        statusEffectInstances.add(statusEffectInstance);
        // print/log if saving throw is needed, what DC, and if affected creature has proficiency in that saving throw
        // then have a popup for what he rolled
        // TODO don't need if tree, just go through StatusEffect.dependancies list and apply them with the same duration and dependsUpon.
    }

    public boolean hasStatusEffect(StatusEffect statusEffect){
        for (StatusEffectInstance statusEffectInstance : getStatusEffectInstances()) {
            if (statusEffectInstance.getStatusEffect() == statusEffect){
                return true;
            }
        }
        return false;
    }


    // ### CONSTRUCTOR

    // i probably don't need thisˇˇ (it's just gonna get filled from the gamestate anyway, TODO test array creation with @NoArgsConstructor, what about EquipSlot.values().length ?)
    public Creature() {
        this.abilityScores = new HashMap<Ability, Integer>();
        this.skillProficiencies = new HashMap<Skill, Boolean>();
        this.savingThrowProficiencies = new HashMap<Ability, Boolean>();
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




