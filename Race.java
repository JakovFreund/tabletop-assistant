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
    DRAGON(List.of()), //subraces
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
    
    // animals? (owlbear, griffin...)

    // maybe group Minotaurs, Aarakocra, Satyr, Leonin, Tabaxi to Chimera/Beast
    // Pegasus also to Chimera or Air Elemental
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
    PLACEHOLDER1(Ability.INT),
    PLACEHOLDER2(Ability.CON),
    HIGH_ELF(Ability.INT),
    WOOD_ELF(Ability.INT),
    DROW(Ability.CHA),
    HALF_ELF(Ability.INT),
    HALF_ELF_DROW_DESCENDANT(Ability.CHA),
    DUERGAR(Ability.NONE),
    HILL_DWARF(Ability.NONE),
    MOUNTAIN_DWARF(Ability.NONE),
    VAMPIRE(Ability.CHA), //add more undead
    SOLAR(Ability.WIS),
    AASIMON(Ability.WIS),
    ELADRIN(Ability.WIS),
    DEVIL(Ability.CHA),
    DEMON(Ability.STR);


    final Ability SPELLCASTING_ABILITY; //for racial spells

    Subrace(Ability spellcastingAbility){
        this.SPELLCASTING_ABILITY = spellcastingAbility;
    }
}
