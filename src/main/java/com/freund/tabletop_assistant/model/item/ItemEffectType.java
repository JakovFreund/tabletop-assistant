package com.freund.tabletop_assistant.model.item;

public enum ItemEffectType { // only for perma stats/effects no temporary like "Light" or "Magic Weapon"
    DAMAGE,
    HEAL, // for consumables, probably change to GRANT_STATUS_EFFECT(StatusEffect.HASTE.name() and then convert it back with StatusEffect.valueOf("HASTE")) to wielder
    AC,
    LEARN_SPELL, // (EffectType.LEARN_SPELL,"Haste") maybe needs a primary DC Ability ("Haste;DEX")
    ON_HIT_EFFECT, // applies StatusEffect on target/victim
    PACT_WEAPON,
    

    // TODO add more
    // go through statuseffects and maybe move some here to weapon effect
}