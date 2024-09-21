import java.util.ArrayList;

class Creature{
    int STR;
    int DEX;
    int CON;
    int INT;
    int WIS;
    int CHA;
    ArrayList<StatusEffectInstance> statusEffects;
    ArrayList<TurnResource> turnResources;
    ArrayList<ItemStack> inventory;
    ItemStack equiped [];


    public Creature () {
        statusEffects = new ArrayList<StatusEffectInstance>();
        turnResources = new ArrayList<TurnResource>();
        inventory = new ArrayList<ItemStack>();
        equiped = new ItemStack[EquipSlot.values().length];

        //prepared spells (class?)

        // move this to CharacterDefault dataclass or something and loop through it, add and sort race and class counters to different object/class and levels

        turnResources.add(new TurnResource("Action", 1, 1, RefillRate.TURN));
        turnResources.add(new TurnResource("Bonus Action", 1, 1, RefillRate.TURN));
        turnResources.add(new TurnResource("Reaction", 1, 1, RefillRate.TURN));
        turnResources.add(new TurnResource("Movement", 5, 5, RefillRate.TURN));

        turnResources.add(new TurnResource("HP", 5, 5, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Hit Dice", 3, 3, RefillRate.LONG_REST));

        turnResources.add(new TurnResource("Level 1 Spellslot", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Level 2 Spellslot", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Level 3 Spellslot", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Level 4 Spellslot", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Level 5 Spellslot", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Level 6 Spellslot", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Level 7 Spellslot", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Level 8 Spellslot", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Level 9 Spellslot", 0, 0, RefillRate.LONG_REST));

        turnResources.add(new TurnResource("Warlock Spellslot", 0, 0, RefillRate.SHORT_REST)); //wl spell level is independat of slots

        turnResources.add(new TurnResource("Arcane Recovery Charge", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Bardic Inspiration Charge", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Fungal Infestation Charge", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Lay on Hands Charge", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Natural Recovery Charge", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Rage Charge", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("Sorcery Point", 0, 0, RefillRate.LONG_REST));
        turnResources.add(new TurnResource("War Priest Charge", 0, 0, RefillRate.LONG_REST));

        turnResources.add(new TurnResource("Action Surge Charge", 0, 0, RefillRate.SHORT_REST));
        turnResources.add(new TurnResource("Channel Divinity Charge", 0, 0, RefillRate.SHORT_REST));
        turnResources.add(new TurnResource("Channel Oath Charge", 0, 0, RefillRate.SHORT_REST));
        turnResources.add(new TurnResource("Superiority Dice", 0, 0, RefillRate.SHORT_REST));
        turnResources.add(new TurnResource("Ki Points", 0, 0, RefillRate.SHORT_REST));
        turnResources.add(new TurnResource("Tides of Chaos Charge", 0, 0, RefillRate.SHORT_REST));
        turnResources.add(new TurnResource("Wild Shape Charge", 0, 0, RefillRate.SHORT_REST));

        turnResources.add(new TurnResource("Luck Point", 0, 0, RefillRate.LONG_REST)); // lucky feat

        turnResources.add(new TurnResource("Mage Hand", 0, 0, RefillRate.SHORT_REST));

        // TODO race counters if any? (there is Faerie Fire atleast)



    }


    TurnResource getTurnResource(String name){
        for (TurnResource turnResource : turnResources){
            if (turnResource.name == name){
                return turnResource;
            }
        }
        return null;
    }

    ArrayList<TurnResource> getTurnResources(RefillRate refillRate){
        ArrayList<TurnResource> refillRateTurnResources = new ArrayList<TurnResource>();
        for (TurnResource turnResource : turnResources){
            if (turnResource.refillRate == refillRate){
                refillRateTurnResources.add(turnResource);
            }
        }
        return refillRateTurnResources;
    }

    public void setTurnResourceAmount(String name, int amount){
        TurnResource turnResource = getTurnResource(name);
        if (turnResource != null){
            turnResource.amount = amount;
        }
        else {
            System.out.println("turnResource doesn't exist");
        }
    }


    void myTurn(){
        // refresh action, bonus action, reaction
        for (TurnResource turnResource : getTurnResources(RefillRate.TURN)){
            turnResource.amount = turnResource.maxAmount;
        }


        // TODO proc poisons, saving throws or whatever, this needs to be an if tree with calculations



        // remove 1 duration from effects
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : statusEffects){
            if (statusEffectInstance.duration == null){
                statusEffectInstance.roundsDuration -= 1;
                if (statusEffectInstance.roundsDuration == 0){
                    toRemove.add(statusEffectInstance);
                }
            }
        }
        statusEffects.removeAll(toRemove);
    }

    void endCombat(){
        // loop proc all turnDuration effects to the end
        // TODO prompt auto go into turn based mode on death saving throws
    }

    void shortRest(){
        // TODO HP, SPELLSLOTS...
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : statusEffects){
            if (statusEffectInstance.duration == Duration.SHORT_REST){
                toRemove.add(statusEffectInstance);
            }
        }
        statusEffects.removeAll(toRemove);
    }

    void longRest(){
        // TODO HP, SPELLSLOTS...
        ArrayList<StatusEffectInstance> toRemove = new ArrayList<StatusEffectInstance>();
        for (StatusEffectInstance statusEffectInstance : statusEffects){
            if (statusEffectInstance.duration == Duration.LONG_REST){ //probably need to refresh all, not just LONG_REST
                toRemove.add(statusEffectInstance);
            }
        }
        statusEffects.removeAll(toRemove);
    }

    void giveItems(ArrayList<ItemStack> items){
        for(ItemStack item : items){
            this.giveItem(item);
        }
    }

    void giveItem(ItemStack item){
        inventory.add(item);
    }

    void equipItem(int inventoryIndex, EquipSlot equipSlot){
        // remove buffs from previous in that slot
        equiped[equipSlot.ordinal()] = inventory.get(inventoryIndex);

    }

    void consumeItem(int inventoryIndex){
        // TODO
        // if type.CONSUMABLE
    }

    void damage(int amount){
        getTurnResource("HP").amount -= amount;
    }

    void setHP(int amount){
        getTurnResource("HP").amount = amount;
    }

    void setMaxHP(int amount){
        getTurnResource("HP").maxAmount = amount;
    }


    // add Dancing Lights creature (Construct? Spell? Summon? Object?)

    // add Class and Race to Creature

    // need to implement smart dice addition for multiple of the same ItemEffects addition

    // change item.lastModified on move between inventories (add function inventory.moveItem(itemIndex, otherInventory) or something)

    // add auto-calculation of base damage (stats + equipped weapon), AC, and a bunch of other stats

    // Item image

    // fix subrace sizes

    // finish races & subraces enums, classes and sublclasses enums

    // finish all statuseffects enum

    // make a playable races list

    // add like 20 spells and ClassActions to list

    // Creature.spellbook (will need source of learned spell (which class) to calculate save DC), sort spellbook by school, ability to favourite spells


    // Creature.cast() players can ping spells and attacks (Flint casts Icebolt and it does 3d6+5 frost damage) (Flint uses melee attack and it does 3d6+5 bludgeoning damage)

    // sort race and class TurnResource counters to different objects/classes

    // go through actual dnd (not bg3) subraces, subclasses, spells and add/modify the ones you have

    // levelups are done manually !!!

    // --- WEBAPP RESEARCH & CONVERSION TIME --- 

    // finish all spells list

    // Item can be lootable, add ability to save inventories (probably to database) outside player's inventories (if they intentionally drop some bag), print out its location coordinates and inventories recursively 



    // add sorting options for inventory

    // print shit out and save it to a log file simultaneously




    // player inventory actions come as requests to me with checkmark or x to approve or dissmiss (ability to lock each inventory)

    // add trading: buying and selling items (trader has buy and sell modifiers that can be changed by spells )

    // Go through each class, subclass, race and subrace and imagine trying to level them up

    // do i even need a Creature class or a PlayableCharacter class ?

    // COMBAT TAB with quick resource counter control for all

    // SCENE TAB with Items




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

enum Ability{
    NONE,
    STR,
    DEX,
    CON,
    INT,
    WIS,
    CHA;
    static int toModifier(int AbilityPoint) {
        int result = AbilityPoint/2;
        return result-5;
    }
}
