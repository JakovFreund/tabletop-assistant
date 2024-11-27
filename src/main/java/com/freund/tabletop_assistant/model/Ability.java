package com.freund.tabletop_assistant.model;

public enum Ability {
    NONE,
    STR,
    DEX,
    CON,
    INT,
    WIS,
    CHA;

    public static int getModifier(int AbilityPoint) {
        int result = AbilityPoint / 2;
        return result - 5;
    }
}