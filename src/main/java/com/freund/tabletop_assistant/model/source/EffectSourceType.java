package com.freund.tabletop_assistant.model.source;

public enum EffectSourceType { // used for damageinstance, statuseffect
    CASTABLE,
    ITEM,
    FALL_DAMAGE,
    ENVIRONMENT, // fire, explosion, trap, lightning strike
    REST, // received hp, bonuses
    CONDITION // status efects
}
