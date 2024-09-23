import java.util.List;

public enum GameClass {
    BARBARIAN(Ability.NONE, List.of(Subclass.BERSERKER, Subclass.WILDHEART, Subclass.WILD_MAGIC)),
    BARD(Ability.CHA, List.of(Subclass.COLLEGE_OF_LORE, Subclass.COLLEGE_OF_VALOUR, Subclass.COLLEGE_OF_SWORDS)),
    CLERIC(Ability.WIS,
            List.of(Subclass.LIFE_DOMAIN, Subclass.LIGHT_DOMAIN, Subclass.TRICKERY_DOMAIN, Subclass.KNOWLEDGE_DOMAIN,
                    Subclass.NATURE_DOMAIN, Subclass.TEMPEST_DOMAIN, Subclass.WAR_DOMAIN)),
    DRUID(Ability.WIS, List.of()), // TODO fill in subclasses
    FIGHTER(Ability.INT, List.of()),
    MONK(Ability.NONE, List.of()),
    PALADIN(Ability.CHA, List.of()),
    RANGER(Ability.WIS, List.of()),
    ROGUE(Ability.INT, List.of()),
    SORCERER(Ability.CHA, List.of()),
    WARLOCK(Ability.CHA, List.of()),
    WIZARD(Ability.INT, List.of());

    final Ability SPELLCASTING_ABILITY;
    final List<Subclass> SUBCLASSES;
    //final Boolean SPELLCASTER;
    //final Ability SPELLCASTING_ABILITY;

    GameClass(Ability spellcastingAbility, List<Subclass> subclassList) {
        this.SPELLCASTING_ABILITY = spellcastingAbility;
        this.SUBCLASSES = subclassList;
    }

    // need to take multiclassing into consideration. Don't program levelups, just classes, perks, feats, proficiencies

    //think about how you want to run the command on levelup (ex.  Player.addFeature())

    // HitDice

}

enum Subclass { // TODO add TurnResource list to subclass constructor? 
    BERSERKER,
    WILDHEART,
    WILD_MAGIC_BARBARIAN,
    COLLEGE_OF_LORE,
    COLLEGE_OF_VALOUR,
    COLLEGE_OF_SWORDS,
    LIFE_DOMAIN,
    LIGHT_DOMAIN,
    TRICKERY_DOMAIN,
    KNOWLEDGE_DOMAIN,
    NATURE_DOMAIN,
    TEMPEST_DOMAIN,
    WAR_DOMAIN,
    CIRCLE_OF_THE_MOON,
    CIRCLE_OF_THE_LAND,
    CIRCLE_OF_THE_SPORES,
    BATTLE_MASTER,
    ELDRITCH_KNIGHT,
    CHAMPION,
    WAY_OF_THE_OPEN_HAND,
    WAY_OF_SHADOW,
    WAY_OF_THE_FOUR_ELEMENTS,
    OATH_OF_DEVOTION,
    OATH_OF_THE_ANCIENTS,
    OATH_OF_VENGEANCE,
    OATHBREAKER,
    BEAST_MASTER,
    HUNTER,
    GLOOM_STALKER,
    THIEF,
    ARCANE_TRICKSTER,
    ASSASSIN,
    DRACONIC_BLOODLINE,
    WILD_MAGIC,
    STORM_SORCERY,
    THE_FIEND,
    THE_GREAT_OLD_ONE,
    ARCHFEY,
    ABJURATIOM_SCHOOL,
    CONJURATION_SCHOOL,
    DIVINATION_SCHOOL,
    ENCHANTMENT_SCHOOL,
    EVOCATION_SCHOOL,
    ILLUSION_SCHOOL,
    NECROMANCY_SCHOOL,
    TRANSMUTATION_SCHOOL;
}
