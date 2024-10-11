package com.freund.tabletop_assistant.model;

public enum Subrace {
    PLACEHOLDER1(Ability.INT, CreatureSize.MEDIUM),
    PLACEHOLDER2(Ability.CON, CreatureSize.MEDIUM),
    HIGH_ELF(Ability.INT, CreatureSize.MEDIUM),
    WOOD_ELF(Ability.INT, CreatureSize.MEDIUM),
    DROW(Ability.CHA, CreatureSize.MEDIUM),
    HALF_ELF(Ability.INT, CreatureSize.MEDIUM),
    HALF_ELF_DROW_DESCENDANT(Ability.CHA, CreatureSize.MEDIUM),
    DUERGAR(Ability.NONE, CreatureSize.SMALL),
    HILL_DWARF(Ability.NONE, CreatureSize.SMALL),
    MOUNTAIN_DWARF(Ability.NONE, CreatureSize.SMALL),
    LIGHTFOOT(Ability.NONE, CreatureSize.SMALL),
    STOUT(Ability.NONE, CreatureSize.SMALL),
    FOREST_GNOME(Ability.INT, CreatureSize.SMALL),
    ROCK_GNOME(Ability.INT, CreatureSize.SMALL),
    VAMPIRE(Ability.CHA, CreatureSize.MEDIUM), //add more undead
    SOLAR(Ability.WIS, CreatureSize.LARGE),
    AASIMON(Ability.WIS, CreatureSize.LARGE),
    ELADRIN(Ability.WIS, CreatureSize.LARGE),
    DEVIL(Ability.CHA, CreatureSize.LARGE),
    DEMON(Ability.STR, CreatureSize.MEDIUM),
    DAEMON(Ability.WIS, CreatureSize.MEDIUM),

    SPELL(Ability.NONE, CreatureSize.SMALL),
    OTHER(Ability.NONE, CreatureSize.MEDIUM);

    final Ability SPELLCASTING_ABILITY; //for racial spells
    final CreatureSize CREATURE_SIZE;
    final Race RACE;

    Subrace(Ability spellcastingAbility, CreatureSize creatureSize) {
        this.SPELLCASTING_ABILITY = spellcastingAbility;
        this.CREATURE_SIZE = creatureSize;
        this.RACE = null; //RACE(this);
    }

    //TODO 
    /*
    private static Race RACE(Subrace customSubrace){
        for (Race race : Race.values()) {
            for (Subrace subrace : race.SUBRACES) {
                if (customSubrace == subrace) {
                    return race; // add temporary Race variable and change the final prop to it at the end
                }
            }
        }
        return null;
    }
    */

}
