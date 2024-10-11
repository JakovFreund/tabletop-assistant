package com.freund.tabletop_assistant.model;

import java.util.List;

public enum Race {
    HUMAN(List.of(Subrace.PLACEHOLDER1, Subrace.PLACEHOLDER2)),
    ELF(List.of(Subrace.WOOD_ELF, Subrace.HIGH_ELF, Subrace.DROW)),
    HALF_ELF(List.of(Subrace.HALF_ELF)),
    DWARF(List.of(Subrace.HILL_DWARF, Subrace.MOUNTAIN_DWARF, Subrace.DUERGAR)),
    HALFLING(List.of(Subrace.LIGHTFOOT, Subrace.STOUT)),
    GNOME(List.of(Subrace.FOREST_GNOME, Subrace.ROCK_GNOME)),
    TIEFLING(List.of()), //CHA spellcasting ability
    GITHYANKI(List.of()),
    ORC(List.of()),
    HALF_ORC(List.of()),
    DRAGON(List.of()), //subraces, subraces have different sizes
    GOBLIN(List.of()), //subraces? (goblin, hobgoblin, bugbear)
    KOBOLD(List.of()), //subraces
    MINOTAUR(List.of()),
    SATYR(List.of()),
    GIANT(List.of()), //ogre, cyclops subrace?
    ILITHID(List.of()), // add elder brain
    CENTAUR(List.of()),
    LEONIN(List.of()),
    AARAKOCRA(List.of()),
    BEHOLDER(List.of()), //add subraces
    UNDEAD(List.of()), //skeleton, zombie, wraith...?
    AASIMAR(List.of()),
    CELESTIAL(List.of(Subrace.SOLAR, Subrace.AASIMON, Subrace.ELADRIN)),
    FIEND(List.of(Subrace.DEVIL, Subrace.DEMON, Subrace.DAEMON)),
    ELEMENTAL(List.of()), //phoenix, along with basic elementals try to find an appropriate being for each (ex. Fire Genasi, Phoenix..)
    // PLANT(List.of(Subrace.TREANT, Subrace.MYCONID)),
    OBJECT(List.of(Subrace.SPELL)), // TODO move to new class SceneObject
    OTHER(List.of());

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

    final List<Subrace> SUBRACES;

    static final List<Race> PLAYABLE_RACES = List.of(Race.HUMAN); //TODO

    Race(List<Subrace> subraceList) {
        this.SUBRACES = subraceList;
    }

}

