import java.util.List;

public enum Race {
    HUMAN(List.of(Subrace.PLACEHOLDER1, Subrace.PLACEHOLDER2)),
    ELF(List.of(Subrace.WOOD_ELF, Subrace.HIGH_ELF, Subrace.DROW)),
    HALF_ELF(List.of(Subrace.HALF_ELF)),
    DWARF(List.of(Subrace.HILL_DWARF, Subrace.MOUNTAIN_DWARF, Subrace.DUERGAR)),
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
    ILITHID(List.of()),
    CENTAUR(List.of()),
    LEONIN(List.of()),
    AARAKOCRA(List.of()),
    BEHOLDER(List.of()),//add subraces
    UNDEAD(List.of()), //skeleton, zombie, wraith...?
    AASIMAR(List.of()),
    CELESTIAL(List.of(Subrace.SOLAR, Subrace.AASIMON, Subrace.ELADRIN)),
    FIEND(List.of(Subrace.DEVIL, Subrace.DEMON)),
    ELEMENTAL(List.of()), //phoenix, instead of elementals try to find an appropriate being, Fire Genasi,
    //fairy
    //siren
    //myconid
    //ooze?
    
    // TODO add more animals (and group them to Beast)
    // Bear, Cat, Dog, Frog, Rat, Boar, Spider, Wolf, Bird, Bat, Other

    // group to Beast: Minotaurs, Aarakocra, Satyr, Leonin, Tabaxi, Pegasus, Owlbear, Griffin, Displacer Beast
    //  also to Chimera or Air Elemental
    ;

    //https://5e.tools/races.html
    //http://dndroll.wikidot.com/races
    //https://www.dndbeyond.com/races

    final List<Subrace> SUBRACES;


    Race(List<Subrace> subraceList){
        this.SUBRACES = subraceList;
    }

}


enum Subrace {
    PLACEHOLDER1(Ability.INT, Size.MEDIUM),
    PLACEHOLDER2(Ability.CON, Size.MEDIUM),
    HIGH_ELF(Ability.INT, Size.MEDIUM),
    WOOD_ELF(Ability.INT, Size.MEDIUM),
    DROW(Ability.CHA, Size.MEDIUM),
    HALF_ELF(Ability.INT, Size.MEDIUM),
    HALF_ELF_DROW_DESCENDANT(Ability.CHA, Size.MEDIUM),
    DUERGAR(Ability.NONE, Size.MEDIUM),
    HILL_DWARF(Ability.NONE, Size.MEDIUM),
    MOUNTAIN_DWARF(Ability.NONE, Size.MEDIUM),
    VAMPIRE(Ability.CHA, Size.MEDIUM), //add more undead
    SOLAR(Ability.WIS, Size.MEDIUM),
    AASIMON(Ability.WIS, Size.MEDIUM),
    ELADRIN(Ability.WIS, Size.MEDIUM),
    DEVIL(Ability.CHA, Size.MEDIUM),
    DEMON(Ability.STR, Size.MEDIUM);


    final Ability SPELLCASTING_ABILITY; //for racial spells

    Subrace(Ability spellcastingAbility, Size size){
        this.SPELLCASTING_ABILITY = spellcastingAbility;
    }
}

enum Size{
    TINY,
    SMALL,
    MEDIUM,
    LARGE,
    HUGE,
    GARGANTUAN
}
