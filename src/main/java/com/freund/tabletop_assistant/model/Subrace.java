package com.freund.tabletop_assistant.model;

public enum Subrace { // TODO fill in race
    PLACEHOLDER1(null, Ability.INT, CreatureSize.MEDIUM),
    PLACEHOLDER2(null, Ability.CON, CreatureSize.MEDIUM),
    HIGH_ELF(null, Ability.INT, CreatureSize.MEDIUM),
    WOOD_ELF(null, Ability.INT, CreatureSize.MEDIUM),
    DROW(null, Ability.CHA, CreatureSize.MEDIUM),
    HALF_ELF(null, Ability.INT, CreatureSize.MEDIUM),
    HALF_ELF_DROW_DESCENDANT(null, Ability.CHA, CreatureSize.MEDIUM),
    DUERGAR(null, Ability.NONE, CreatureSize.SMALL),
    HILL_DWARF(null, Ability.NONE, CreatureSize.SMALL),
    MOUNTAIN_DWARF(null, Ability.NONE, CreatureSize.SMALL),
    LIGHTFOOT(null, Ability.NONE, CreatureSize.SMALL),
    STOUT(null, Ability.NONE, CreatureSize.SMALL),
    FOREST_GNOME(null, Ability.INT, CreatureSize.SMALL),
    ROCK_GNOME(null, Ability.INT, CreatureSize.SMALL),
    VAMPIRE(null, Ability.CHA, CreatureSize.MEDIUM), //add more undead
    SOLAR(null, Ability.WIS, CreatureSize.LARGE),
    AASIMON(null, Ability.WIS, CreatureSize.LARGE),
    ELADRIN(null, Ability.WIS, CreatureSize.LARGE),
    DEVIL(null, Ability.CHA, CreatureSize.LARGE),
    DEMON(null, Ability.STR, CreatureSize.MEDIUM),
    DAEMON(null, Ability.WIS, CreatureSize.MEDIUM),

    SPELL(null, Ability.NONE, CreatureSize.SMALL),
    OTHER(null, Ability.NONE, CreatureSize.MEDIUM);

    final Race RACE;
    final Ability SPELLCASTING_ABILITY; //for racial spells
    final CreatureSize CREATURE_SIZE;
    

    Subrace(Race race, Ability spellcastingAbility, CreatureSize creatureSize) {
        this.RACE = race;
        this.SPELLCASTING_ABILITY = spellcastingAbility;
        this.CREATURE_SIZE = creatureSize;
    }
}
