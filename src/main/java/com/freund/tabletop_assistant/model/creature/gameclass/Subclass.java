package com.freund.tabletop_assistant.model.creature.gameclass;

public enum Subclass { // TODO fill in GameClasses
    BERSERKER(GameClass.BARBARIAN),
    WILDHEART(GameClass.BARBARIAN),
    COLLEGE_OF_LORE(GameClass.BARBARIAN),
    COLLEGE_OF_VALOUR(GameClass.BARBARIAN),
    COLLEGE_OF_SWORDS(GameClass.BARBARIAN),
    LIFE_DOMAIN(GameClass.BARBARIAN),
    LIGHT_DOMAIN(GameClass.BARBARIAN),
    TRICKERY_DOMAIN(GameClass.BARBARIAN),
    KNOWLEDGE_DOMAIN(GameClass.BARBARIAN),
    NATURE_DOMAIN(GameClass.BARBARIAN),
    TEMPEST_DOMAIN(GameClass.BARBARIAN),
    WAR_DOMAIN(GameClass.BARBARIAN),
    CIRCLE_OF_THE_MOON(GameClass.BARBARIAN),
    CIRCLE_OF_THE_LAND(GameClass.BARBARIAN),
    CIRCLE_OF_THE_SPORES(GameClass.BARBARIAN),
    BATTLE_MASTER(GameClass.BARBARIAN),
    ELDRITCH_KNIGHT(GameClass.BARBARIAN),
    CHAMPION(GameClass.BARBARIAN),
    WAY_OF_THE_OPEN_HAND(GameClass.BARBARIAN),
    WAY_OF_SHADOW(GameClass.BARBARIAN),
    WAY_OF_THE_FOUR_ELEMENTS(GameClass.BARBARIAN),
    OATH_OF_DEVOTION(GameClass.BARBARIAN),
    OATH_OF_THE_ANCIENTS(GameClass.BARBARIAN),
    OATH_OF_VENGEANCE(GameClass.BARBARIAN),
    OATHBREAKER(GameClass.BARBARIAN),
    BEAST_MASTER(GameClass.BARBARIAN),
    HUNTER(GameClass.BARBARIAN),
    GLOOM_STALKER(GameClass.BARBARIAN),
    THIEF(GameClass.BARBARIAN),
    ARCANE_TRICKSTER(GameClass.BARBARIAN),
    ASSASSIN(GameClass.BARBARIAN),
    DRACONIC_BLOODLINE(GameClass.BARBARIAN),
    WILD_MAGIC(GameClass.BARBARIAN),
    STORM_SORCERY(GameClass.BARBARIAN),
    THE_FIEND(GameClass.BARBARIAN),
    THE_GREAT_OLD_ONE(GameClass.BARBARIAN),
    ARCHFEY(GameClass.BARBARIAN),
    ABJURATIOM_SCHOOL(GameClass.BARBARIAN),
    CONJURATION_SCHOOL(GameClass.BARBARIAN),
    DIVINATION_SCHOOL(GameClass.BARBARIAN),
    ENCHANTMENT_SCHOOL(GameClass.BARBARIAN),
    EVOCATION_SCHOOL(GameClass.BARBARIAN),
    ILLUSION_SCHOOL(GameClass.BARBARIAN),
    NECROMANCY_SCHOOL(GameClass.BARBARIAN),
    TRANSMUTATION_SCHOOL(GameClass.BARBARIAN);

    final GameClass GAMECLASS;

    Subclass(GameClass gameClass) {
        this.GAMECLASS = gameClass;
    }

}