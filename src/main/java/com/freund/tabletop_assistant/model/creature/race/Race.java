package com.freund.tabletop_assistant.model.creature.race;

import java.util.List;

public enum Race { // TODO fill in movement speeds
    HUMAN(30), //List.of(Subrace.PLACEHOLDER1, Subrace.PLACEHOLDER2)
    ELF(30), // List.of(Subrace.WOOD_ELF, Subrace.HIGH_ELF, Subrace.DROW)
    HALF_ELF(30), // List.of(Subrace.HALF_ELF)
    DWARF(30), //List.of(Subrace.HILL_DWARF, Subrace.MOUNTAIN_DWARF, Subrace.DUERGAR)
    HALFLING(30), //List.of(Subrace.LIGHTFOOT, Subrace.STOUT)
    GNOME(30),//List.of(Subrace.FOREST_GNOME, Subrace.ROCK_GNOME)
    TIEFLING(30), //CHA spellcasting ability
    GITH(30), // githyanki, githzerai
    ORC(30),
    HALF_ORC(30),
    DRAGON(30), //subraces, subraces have different sizes
    GOBLIN(30), //subraces? (goblin, hobgoblin, bugbear)
    KOBOLD(30), //subraces
    MINOTAUR(30),
    SATYR(30),
    GIANT(30), //ogre, cyclops subrace?
    ILITHID(30), // add elder brain
    CENTAUR(30),
    LEONIN(30),
    AARAKOCRA(30),
    BEHOLDER(30), //add subraces
    UNDEAD(30), //skeleton, zombie, wraith...?
    AASIMAR(30),
    CELESTIAL(30), // List.of(Subrace.SOLAR, Subrace.AASIMON, Subrace.ELADRIN)
    FIEND(30), // List.of(Subrace.DEVIL, Subrace.DEMON, Subrace.DAEMON)
    ELEMENTAL(30), //all elemental genasi, along with basic elementals try to find an appropriate being for each (ex. Phoenix for fire..)
    // PLANT(List.of(Subrace.TREANT, Subrace.MYCONID)),
    OBJECT(30), // List.of(Subrace.SPELL) TODO maybe move to new class SceneObject
    OTHER(30);

    // construct ?
    //fairy
    //siren
    //myconid
    //ooze?

    // TODO add more animals (and group them to Beast)
    // Bear, Cat, Dog, Frog, Rat, Boar, Spider, Wolf, Bird, Bat, Other

    // group to Beast: Harpy, Minotaur, Aarakocra, Satyr, Leonin, Tabaxi, Pegasus, Owlbear, Griffin, Displacer Beast
    //  also to Chimera or Air Elemental

    //https://bg3.wiki/wiki/Template:Creatures
    //https://bg3.wiki/wiki/List_of_creature_types
    //https://5e.tools/races.html
    //https://shieldmaiden.app/compendium/monsters
    //http://dndroll.wikidot.com/races
    //https://www.dndbeyond.com/races

    public final int MOVEMENT_SPEED;

    public static final List<Race> PLAYABLE_RACES = List.of(Race.HUMAN); //TODO

    Race(int movementSpeed) {
        this.MOVEMENT_SPEED = movementSpeed;
    }

}

