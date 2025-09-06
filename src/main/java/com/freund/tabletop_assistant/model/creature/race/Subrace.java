package com.freund.tabletop_assistant.model.creature.race;

import com.freund.tabletop_assistant.model.ability.Ability;
import com.freund.tabletop_assistant.model.creature.CreatureSize;

public enum Subrace {
    CELYRIAN(Race.HUMAN, Ability.INT, CreatureSize.MEDIUM),
    VARNYR(Race.HUMAN, Ability.CON, CreatureSize.MEDIUM),
    AL_ZAHIRAN(Race.HUMAN, Ability.WIS, CreatureSize.MEDIUM),
    HIGH_ELF(Race.ELF, Ability.INT, CreatureSize.MEDIUM),
    WOOD_ELF(Race.ELF, Ability.INT, CreatureSize.MEDIUM),
    DROW(Race.ELF, Ability.CHA, CreatureSize.MEDIUM),
    HALF_ELF(Race.HALF_ELF, Ability.INT, CreatureSize.MEDIUM),
    HALF_ELF_DROW_DESCENDANT(Race.HALF_ELF, Ability.CHA, CreatureSize.MEDIUM),
    HILL_DWARF(Race.DWARF, Ability.NONE, CreatureSize.SMALL),
    MOUNTAIN_DWARF(Race.DWARF, Ability.NONE, CreatureSize.SMALL),
    DUERGAR(Race.DWARF, Ability.NONE, CreatureSize.SMALL),
    LIGHTFOOT(Race.HALFLING, Ability.NONE, CreatureSize.SMALL),
    STOUT(Race.HALFLING, Ability.NONE, CreatureSize.SMALL),
    FOREST_GNOME(Race.GNOME, Ability.INT, CreatureSize.SMALL),
    ROCK_GNOME(Race.GNOME, Ability.INT, CreatureSize.SMALL),
    TIEFLING(Race.TIEFLING, Ability.CHA, CreatureSize.MEDIUM),
    GITHYANKI(Race.GITH, Ability.INT, CreatureSize.MEDIUM),
    GITHZERAI(Race.GITH, Ability.INT, CreatureSize.MEDIUM),
    HALF_ORC(Race.HALF_ORC, Ability.NONE, CreatureSize.MEDIUM),
    ORC(Race.ORC, Ability.NONE, CreatureSize.MEDIUM),
    
    // TODO ˇˇ abilities, sizes

    DRAGON(Race.DRAGON, Ability.CON, CreatureSize.LARGE), // TODO subraces, wyverns?, subraces have different sizes?
    GOBLIN(Race.GOBLINOID, Ability.NONE, CreatureSize.SMALL),
    HOBGOBLIN(Race.GOBLINOID, Ability.NONE, CreatureSize.MEDIUM),
    BUGBEAR(Race.GOBLINOID, Ability.NONE, CreatureSize.MEDIUM),
    KOBOLD(Race.REPTILIAN, Ability.NONE, CreatureSize.SMALL), // TODO other reptilians?
    BEHOLDER(Race.ABBERATION, Ability.NONE, CreatureSize.LARGE),
    ABOLETH(Race.ABBERATION, Ability.NONE, CreatureSize.LARGE),
    ILITHID(Race.ABBERATION, Ability.NONE, CreatureSize.MEDIUM),
    ELDER_BRAIN(Race.ABBERATION, Ability.NONE, CreatureSize.LARGE),
    DISPLACER_BEAST(Race.ABBERATION, Ability.NONE, CreatureSize.LARGE), //maybe beast instead of abberation
    SOLAR(Race.CELESTIAL, Ability.WIS, CreatureSize.LARGE),
    AASIMON(Race.CELESTIAL, Ability.WIS, CreatureSize.LARGE),
    AASIMAR(Race.AASIMAR, Ability.WIS, CreatureSize.MEDIUM),
    DEVIL(Race.FIEND, Ability.CHA, CreatureSize.LARGE),
    DEMON(Race.FIEND, Ability.STR, CreatureSize.MEDIUM), // includes Imps, Succubus
    MINOTAUR(Race.BEAST, Ability.NONE, CreatureSize.LARGE),
    SATYR(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    CENTAUR(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    LEONIN(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    TABAXI(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    AARAKOCRA(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    MERMAID(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    WEREWOLF(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    MEDUSA(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    HYDRA(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    KRAKEN(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    PHASE_SPIDER(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    GRIFFIN(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    UNICORN(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    PEGASUS(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    HARPY(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    GORGON(Race.BEAST, Ability.NONE, CreatureSize.LARGE),
    TARRASQUE(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    OWLBEAR(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    GIANT_EAGLE(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    TIGER(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    BEAR(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    CAT(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    DOG(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    RABBIT(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    CHICKEN(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    COW(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    PIG(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    FROG(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    CRAB(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    RAT(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    BOAR(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    SPIDER(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    WOLF(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    HYENA(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    HORSE(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    DEER(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    LION(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    BIRD(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    BEAST(Race.BEAST, Ability.NONE, CreatureSize.MEDIUM),
    OGRE(Race.GIANT, Ability.NONE, CreatureSize.LARGE),
    TROLL(Race.GIANT, Ability.NONE, CreatureSize.LARGE),
    CYCLOPS(Race.GIANT, Ability.NONE, CreatureSize.LARGE),
    TITAN(Race.GIANT, Ability.NONE, CreatureSize.LARGE),
    VAMPIRE(Race.UNDEAD, Ability.CHA, CreatureSize.MEDIUM),
    LICH(Race.UNDEAD, Ability.NONE, CreatureSize.MEDIUM),
    SKELETON(Race.UNDEAD, Ability.NONE, CreatureSize.MEDIUM),
    ZOMBIE(Race.UNDEAD, Ability.NONE, CreatureSize.MEDIUM),
    WRAITH(Race.UNDEAD, Ability.NONE, CreatureSize.MEDIUM),
    SHADOW(Race.UNDEAD, Ability.NONE, CreatureSize.MEDIUM),
    GHOST(Race.UNDEAD, Ability.NONE, CreatureSize.MEDIUM),
    WIGHT(Race.UNDEAD, Ability.NONE, CreatureSize.MEDIUM),
    GHOUL(Race.UNDEAD, Ability.NONE, CreatureSize.MEDIUM),
    PHOENIX(Race.ELEMENTAL, Ability.NONE, CreatureSize.LARGE),
    NEREID(Race.ELEMENTAL, Ability.NONE, CreatureSize.MEDIUM),
    GARGOYLE(Race.ELEMENTAL, Ability.NONE, CreatureSize.MEDIUM),
    VALKYRIE(Race.ELEMENTAL, Ability.NONE, CreatureSize.MEDIUM),
    FIRE_ELEMENTAL(Race.ELEMENTAL, Ability.NONE, CreatureSize.MEDIUM),
    WATER_ELEMENTAL(Race.ELEMENTAL, Ability.NONE, CreatureSize.MEDIUM),
    EARTH_ELEMENTAL(Race.ELEMENTAL, Ability.NONE, CreatureSize.MEDIUM),
    AIR_ELEMENTAL(Race.ELEMENTAL, Ability.NONE, CreatureSize.MEDIUM),
    FIRE_GENASI(Race.ELEMENTAL, Ability.NONE, CreatureSize.MEDIUM),
    WATER_GENASI(Race.ELEMENTAL, Ability.NONE, CreatureSize.MEDIUM),
    EARTH_GENASI(Race.ELEMENTAL, Ability.NONE, CreatureSize.MEDIUM),
    AIR_GENASI(Race.ELEMENTAL, Ability.NONE, CreatureSize.MEDIUM),
    GOLEM(Race.CONSTRUCT, Ability.NONE, CreatureSize.MEDIUM),
    SCRYING_EYE(Race.CONSTRUCT, Ability.NONE, CreatureSize.SMALL),
    ANIMATED_OBJECT(Race.CONSTRUCT, Ability.NONE, CreatureSize.MEDIUM),
    CONJURATION(Race.CONJURATION, Ability.NONE, CreatureSize.MEDIUM), // Spiritual Weapon, Mage Hand, Flaming Sphere
    OOZE(Race.OOZE, Ability.NONE, CreatureSize.MEDIUM),
    MYCONID(Race.PLANT, Ability.NONE, CreatureSize.MEDIUM),
    TREANT(Race.PLANT, Ability.NONE, CreatureSize.HUGE),
    // more plants ?
    PIXIE(Race.FEY, Ability.NONE, CreatureSize.SMALL),
    // Fairy/Sprite
    // Blink Dog ?
    // Hag ?



    // gnolls, worgs ?
    // ghast (not ghost), spectre ?
    // fish-people to beasts (Kuo-toa, Sahuagin or some more generic)


    // https://5e.tools/races.html
    // https://shieldmaiden.app/compendium/monsters
    // http://dndroll.wikidot.com/races
    // https://www.dndbeyond.com/species

    // go through monster manual creatures


    // check HOMM 3 & HOMM 4 for interesting creatures (that probably also exist in dnd)

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
