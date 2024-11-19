package com.freund.tabletop_assistant.model;

enum Subclass {
    BERSERKER,
    WILDHEART,
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

    final GameClass GAMECLASS;

    Subclass() {
        this.GAMECLASS = null; //GAMECLASS();
    }
    //TODO 
    /*
    private GameClass GAMECLASS() {
        for (GameClass gameClass : GameClass.values()) {
            for (Subclass subClass : gameClass.SUBCLASSES) {
                if (this == subClass) {
                    return gameClass;
                }
            }
        }
        return null;
    }
    */

}