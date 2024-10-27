package com.freund.tabletop_assistant.model.item;

import java.util.ArrayList;
import java.util.List;

import com.freund.tabletop_assistant.util.DiceNotation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {
    private ItemType itemType;
    private Rarity rarity;
    private ArrayList<ItemEffect> effects;
    private ArrayList<ItemEffect> newEffects;
    private int value;

    public Item(ItemType itemType) {
        System.out.println("Item constructor");
        this.itemType = itemType;
        this.effects = new ArrayList<ItemEffect>(this.itemType.BASE_EFFECTS != null ? this.itemType.BASE_EFFECTS : List.of());
        this.rarity = this.itemType.BASE_RARITY;
        this.value = this.itemType.BASE_VALUE;
    }

    public Item(ItemType itemType, ArrayList<ItemEffect> newEffects) {
        this(itemType);
        this.newEffects = newEffects;
        this.recalculate();
    }

    void addEffect(ItemEffect itemEffect) {
        this.newEffects.add(itemEffect);
        recalculate();
    }

    String getEffectModifier(ItemEffectType effectType){
        ArrayList<String> modifiers = new ArrayList<String>();
        for (ItemEffect effect : this.effects){
            if (effect.getEffectType() == effectType){
                modifiers.add(effect.getStatModifier());
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
        this.effects = new ArrayList<>(this.itemType.BASE_EFFECTS);
        this.rarity = this.itemType.BASE_RARITY;
        this.value = this.itemType.BASE_VALUE;
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
        String str = this.itemType.NAME + "@[" + this.itemType.CATEGORY + ", " + this.rarity + ", value: " + this.value
                + ", weight: " + this.itemType.WEIGHT + ", " + this.itemType.DESCRIPTION + "]{";
        for (ItemEffect itemEffect : effects) {
            str += itemEffect.getEffectType() + ": " + itemEffect.getStatModifier();
        }
        str += "}";
        return str;
    }

    // TODO probably override @Data equals() (or maybe implement) to not compare UUID - for item stacking
}
