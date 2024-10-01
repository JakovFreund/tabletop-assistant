import java.util.ArrayList;

import util.DiceNotation;


// novi komentar

public class ItemStack {
    Item item;
    int amount;
    long lastModified; // TODO add currentDate function
    ArrayList<ItemStack> inventory;

    public ItemStack(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.lastModified = System.currentTimeMillis(); // recently modified is bigger number

        if (item.INFO.TYPE == ItemCategory.CONTAINER) {
            inventory = new ArrayList<ItemStack>(); // also render a little plus sign in top right corner of item
        }
    }

    @Override
    public String toString() {
        return this.amount + "x " + this.item;
    }

}

class Item {
    final ItemType INFO;
    Rarity rarity;
    ArrayList<ItemEffect> effects;
    ArrayList<ItemEffect> newEffects;
    int value;

    public Item(ItemType itemInfo) {
        this.INFO = itemInfo;
        this.effects = new ArrayList<>(this.INFO.BASE_EFFECTS);
        this.rarity = this.INFO.BASE_RARITY;
        this.value = this.INFO.BASE_VALUE;
    }

    public Item(ItemType itemInfo, ArrayList<ItemEffect> newEffects) {
        this(itemInfo);
        this.newEffects = newEffects;
        this.recalculate();
    }

    void addEffect(ItemEffect itemEffect) {
        this.newEffects.add(itemEffect);
        recalculate();
    }

    String getEffectModifier(EffectType effectType){
        ArrayList<String> modifiers = new ArrayList<String>();
        for (ItemEffect effect : this.effects){
            if (effect.effectType == effectType){
                modifiers.add(effect.statModifier);
            }
        }
        if (modifiers.isEmpty()){
            return null;
        }
        String value = "0";
        for (String modifier : modifiers){
            value = DiceNotation.addDice(modifier, value);
        }
        return value;
    }

    void recalculate() {
        this.effects = new ArrayList<>(this.INFO.BASE_EFFECTS);
        this.rarity = this.INFO.BASE_RARITY;
        this.value = this.INFO.BASE_VALUE;
        this.effects.addAll(newEffects);
        if (newEffects.size() > 2) {
            this.rarity = this.rarity.increase().increase();
        } else {
            if (newEffects.size() > 0) {
                this.rarity = this.rarity.increase();
            }
        }
        // TODO value calculation based on new effect modifiers unless MISC
    }

    @Override
    public String toString() {
        String str = this.INFO.NAME + "@[" + this.INFO.TYPE + ", " + this.rarity + ", value: " + this.value
                + ", weight: " + this.INFO.WEIGHT + ", " + this.INFO.DESCRIPTION + "]{";
        for (ItemEffect itemEffect : effects) {
            str += itemEffect.effectType + ": " + itemEffect.statModifier;
        }
        str += "}";
        return str;
    }

    // TODO need equals() comparison for item stacking

}

enum ItemCategory {
    WEAPON,
    WEARABLE,
    CONTAINER,
    CONSUMABLE,
    MISC
}

class ItemEffect {
    EffectType effectType;
    String statModifier; //maybe change String to Object

    // TODO maybe do if EffectType == ... -> assign different properties (have ItemEffect obj have Damage, StatusEffect)
    // can we do it all from String? (for example Damage obj from String("4d6,0,0,0,0,1d4,0")), String(StatusEffect), String(spellName)

    ItemEffect(EffectType effectType, String statModifier) {
        this.effectType = effectType;
        this.statModifier = statModifier;
    }

    Damage getDamage(){
        // TODO
        return null;
    }

    // StatusEffectInstance(StatusEffect, int turnsDuration, Duration, String customNote) // SPLIT BY ";"
    
}

enum EffectType {
    DAMAGE,
    HEAL, // for consumables, probably change to GRANT_STATUS_EFFECT(String(StatusEffect)) to wielder
    AC,
    LEARN_SPELL, // (EffectType.LEARN_SPELL,"Haste 2") add function to Spell class to convert string to enum
    APPLY_EFFECT_ON_HIT, // TODO change name - applies StatusEffect on target/victim
    LIGHTED // item is illuminated

    // TODO add more
}

enum Rarity {
    COMMON, //40%
    UNCOMMON, //30%
    RARE, //20%
    EPIC, //8%
    LEGENDARY; //2%

    Rarity increase() {
        switch (this) {
            case COMMON:
                return UNCOMMON;
            case UNCOMMON:
                return RARE;
            case RARE:
                return EPIC;
            case EPIC:
                return LEGENDARY;
            case LEGENDARY:
                return LEGENDARY;
            default:
                return null;
        }
    }

}