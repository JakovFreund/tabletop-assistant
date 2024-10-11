package com.freund.tabletop_assistant.model;

import java.util.List;

public enum GameClass {
    BARBARIAN(Ability.NONE, List.of(Subclass.BERSERKER, Subclass.WILDHEART, Subclass.WILD_MAGIC)),
    BARD(Ability.CHA, List.of(Subclass.COLLEGE_OF_LORE, Subclass.COLLEGE_OF_VALOUR, Subclass.COLLEGE_OF_SWORDS)),
    CLERIC(Ability.WIS,
            List.of(Subclass.LIFE_DOMAIN, Subclass.LIGHT_DOMAIN, Subclass.TRICKERY_DOMAIN, Subclass.KNOWLEDGE_DOMAIN,
                    Subclass.NATURE_DOMAIN, Subclass.TEMPEST_DOMAIN, Subclass.WAR_DOMAIN)),
    DRUID(Ability.WIS, List.of()), // TODO fill in subclasses
    FIGHTER(Ability.INT, List.of()),
    MONK(Ability.NONE, List.of()),
    PALADIN(Ability.CHA, List.of()),
    RANGER(Ability.WIS, List.of()),
    ROGUE(Ability.INT, List.of()),
    SORCERER(Ability.CHA, List.of()),
    WARLOCK(Ability.CHA, List.of()),
    WIZARD(Ability.INT, List.of());

    final Ability SPELLCASTING_ABILITY;
    final List<Subclass> SUBCLASSES;
    //final Boolean SPELLCASTER;
    //final Ability SPELLCASTING_ABILITY;

    GameClass(Ability spellcastingAbility, List<Subclass> subclassList) {
        this.SPELLCASTING_ABILITY = spellcastingAbility;
        this.SUBCLASSES = subclassList;
    }

    // need to take multiclassing into consideration. Don't program levelups, just classes, perks, feats, proficiencies

    //think about how you want to run the command on levelup (ex.  Player.addFeature())

    // HitDice

}
