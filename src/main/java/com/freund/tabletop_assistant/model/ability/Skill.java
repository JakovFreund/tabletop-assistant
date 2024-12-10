package com.freund.tabletop_assistant.model.ability;

public enum Skill {
    ATHLETICS(Ability.STR),
    ACROBATICS(Ability.DEX),
    SLEIGHT_OF_HAND(Ability.DEX),
    STEALTH(Ability.DEX),
    ARCANA(Ability.INT),
    HISTORY(Ability.INT),
    INVESTIGATION(Ability.INT),
    NATURE(Ability.INT),
    RELIGION(Ability.INT),
    ANIMAL_HANDLING(Ability.WIS),
    INSIGHT(Ability.WIS),
    MEDICINE(Ability.WIS),
    PERCEPTION(Ability.WIS),
    SURVIVAL(Ability.WIS),
    DECEPTION(Ability.CHA),
    INTIMIDATION(Ability.CHA),
    PERFORMANCE(Ability.CHA),
    PERSUASION(Ability.CHA);

    public final Ability ABILITY;

    Skill(Ability aBILITY) {
        this.ABILITY = aBILITY;
    }

}
