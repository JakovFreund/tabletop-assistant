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
    SUMMON(List.of(Subrace.SPELL))
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
    PLACEHOLDER1(Ability.INT, CreatureSize.MEDIUM),
    PLACEHOLDER2(Ability.CON, CreatureSize.MEDIUM),
    HIGH_ELF(Ability.INT, CreatureSize.MEDIUM),
    WOOD_ELF(Ability.INT, CreatureSize.MEDIUM),
    DROW(Ability.CHA, CreatureSize.MEDIUM),
    HALF_ELF(Ability.INT, CreatureSize.MEDIUM),
    HALF_ELF_DROW_DESCENDANT(Ability.CHA, CreatureSize.MEDIUM),
    DUERGAR(Ability.NONE, CreatureSize.MEDIUM),
    HILL_DWARF(Ability.NONE, CreatureSize.MEDIUM),
    MOUNTAIN_DWARF(Ability.NONE, CreatureSize.MEDIUM),
    VAMPIRE(Ability.CHA, CreatureSize.MEDIUM), //add more undead
    SOLAR(Ability.WIS, CreatureSize.MEDIUM),
    AASIMON(Ability.WIS, CreatureSize.MEDIUM),
    ELADRIN(Ability.WIS, CreatureSize.MEDIUM),
    DEVIL(Ability.CHA, CreatureSize.MEDIUM),
    DEMON(Ability.STR, CreatureSize.MEDIUM),

    SPELL(Ability.NONE, CreatureSize.SMALL);


    final Ability SPELLCASTING_ABILITY; //for racial spells
    final CreatureSize CREATURE_SIZE;

    Subrace(Ability spellcastingAbility, CreatureSize creatureSize){
        this.SPELLCASTING_ABILITY = spellcastingAbility;
        this.CREATURE_SIZE = creatureSize;
    }
}

enum CreatureSize{
    TINY,
    SMALL,
    MEDIUM,
    LARGE,
    HUGE,
    GARGANTUAN
}
