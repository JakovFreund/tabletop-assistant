package com.freund.tabletop_assistant.model.creature.race;

import java.util.List;

public enum Race { // TODO fill in movement speeds
    HUMAN(30),
    ELF(30),
    HALF_ELF(30),
    DWARF(30),
    HALFLING(30),
    GNOME(30),
    TIEFLING(30), // half-fiends
    GITH(30),
    ORC(30),
    HALF_ORC(30),
    // ---
    DRAGON(30),
    GOBLINOID(30),
    REPTILIAN(30),
    ABBERATION(30), // maybe split into different races
    CELESTIAL(30),
    AASIMAR(30), // half-celestials, celestial equivalent of tieflings 
    FIEND(30),
    BEAST(30),
    GIANT(30),
    UNDEAD(30),
    ELEMENTAL(30),
    CONSTRUCT(30),
    CONJURATION(30),
    OOZE(30),
    PLANT(30),
    FEY(30);

    
    // final String ICON;
    public final int MOVEMENT_SPEED;
    public static final List<Race> PLAYABLE_RACES = List.of(Race.HUMAN, Race.ELF, Race.HALF_ELF, Race.DWARF, Race.HALFLING, Race.GNOME, Race.TIEFLING, Race.GITH, Race.HALF_ORC);

    Race(int movementSpeed) {
        this.MOVEMENT_SPEED = movementSpeed;
    }

}

