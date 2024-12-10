package com.freund.tabletop_assistant.model.ability;

public enum Ability {
    NONE, // TODO remove (just use null)
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

    public static Ability[] getAll() {
        Ability[] array = new Ability[Ability.values().length - 1];
        int index = 0;
        for (Ability ability : Ability.values()) {
            if (!ability.equals(Ability.NONE)) {
                array[index++] = ability;
            }
        }
        return array;
    }

}