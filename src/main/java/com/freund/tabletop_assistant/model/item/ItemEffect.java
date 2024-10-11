package com.freund.tabletop_assistant.model.item;

import com.freund.tabletop_assistant.model.Damage;

public class ItemEffect {
    private ItemEffectType effectType;
    private String statModifier; //maybe change String to Object

    // TODO maybe do if EffectType == ... -> assign different properties (have ItemEffect obj have Damage, StatusEffect)
    // can we do it all from String? (for example Damage obj from String("4d6,0,0,0,0,1d4,0")), String(StatusEffect), String(spellName)

    public ItemEffect() {
    }

    public ItemEffect(ItemEffectType effectType, String statModifier) {
        this.effectType = effectType;
        this.statModifier = statModifier;
    }

    Damage getDamage() {
        // TODO
        return null;
    }

    // StatusEffectInstance(StatusEffect, int turnsDuration, Duration, String customNote) // SPLIT BY ";"

    public ItemEffectType getEffectType() {
        return effectType;
    }

    public String getStatModifier() {
        return statModifier;
    }

}
