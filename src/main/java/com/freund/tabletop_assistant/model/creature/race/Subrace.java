package com.freund.tabletop_assistant.model.creature.race;

import com.freund.tabletop_assistant.model.ability.Ability;
import com.freund.tabletop_assistant.model.creature.CreatureSize;

public enum Subrace { // TODO fill in race
    PLACEHOLDER1(Race.HUMAN, Ability.INT, CreatureSize.MEDIUM),
    PLACEHOLDER2(Race.HUMAN, Ability.CON, CreatureSize.MEDIUM),
    HIGH_ELF(Race.ELF, Ability.INT, CreatureSize.MEDIUM),
    WOOD_ELF(Race.ELF, Ability.INT, CreatureSize.MEDIUM),
    DROW(Race.ELF, Ability.CHA, CreatureSize.MEDIUM),
    HALF_ELF(Race.HALF_ELF, Ability.INT, CreatureSize.MEDIUM),
    HALF_ELF_DROW_DESCENDANT(Race.HALF_ELF, Ability.CHA, CreatureSize.MEDIUM),
    DUERGAR(Race.DWARF, Ability.NONE, CreatureSize.SMALL),
    HILL_DWARF(Race.DWARF, Ability.NONE, CreatureSize.SMALL),
    MOUNTAIN_DWARF(Race.DWARF, Ability.NONE, CreatureSize.SMALL),
    LIGHTFOOT(Race.HALFLING, Ability.NONE, CreatureSize.SMALL),
    STOUT(Race.HALFLING, Ability.NONE, CreatureSize.SMALL),
    FOREST_GNOME(Race.GNOME, Ability.INT, CreatureSize.SMALL),
    ROCK_GNOME(Race.GNOME, Ability.INT, CreatureSize.SMALL),
    VAMPIRE(Race.UNDEAD, Ability.CHA, CreatureSize.MEDIUM), //add more undead
    SOLAR(Race.CELESTIAL, Ability.WIS, CreatureSize.LARGE),
    AASIMON(Race.CELESTIAL, Ability.WIS, CreatureSize.LARGE),
    ELADRIN(Race.CELESTIAL, Ability.WIS, CreatureSize.LARGE),
    DEVIL(Race.FIEND, Ability.CHA, CreatureSize.LARGE),
    DEMON(Race.FIEND, Ability.STR, CreatureSize.MEDIUM),
    DAEMON(Race.FIEND, Ability.WIS, CreatureSize.MEDIUM),
    // check HOMM 3 & HOMM 4 for interesting creatures (that probably also exist in dnd)

    SPELL(null, Ability.NONE, CreatureSize.SMALL),
    OTHER(null, Ability.NONE, CreatureSize.MEDIUM);

    // final String ICON;
    public final Race RACE;
    public final Ability SPELLCASTING_ABILITY; //for racial spells
    public final CreatureSize CREATURE_SIZE;
    

    Subrace(Race race, Ability spellcastingAbility, CreatureSize creatureSize) {
        this.RACE = race;
        this.SPELLCASTING_ABILITY = spellcastingAbility;
        this.CREATURE_SIZE = creatureSize;
    }
}
