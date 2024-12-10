package com.freund.tabletop_assistant.model.creature;

public enum CreatureSize {
    TINY(0.5f),
    SMALL(1),
    MEDIUM(1),
    LARGE(2),
    HUGE(4),
    GARGANTUAN(8);

    final float carryingCapacityModifier;

    CreatureSize(float carryingCapacityModifier){
        this.carryingCapacityModifier = carryingCapacityModifier;
    }
}
