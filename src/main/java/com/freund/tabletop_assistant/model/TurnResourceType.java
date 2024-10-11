package com.freund.tabletop_assistant.model;

public enum TurnResourceType {
    ACTION("Action", 1, RefillRate.TURN),
    BONUS_ACTION("Bonus Action", 1, RefillRate.TURN),
    REACTION("Reaction", 1, RefillRate.TURN),
    MOVEMENT("Movement", 5, RefillRate.TURN),

    HP("HP", 5, RefillRate.LONG_REST),
    TEMPORARY_HP("Temporary HP", 0, RefillRate.NEVER),
    HIT_DICE("Hit Dice", 3, RefillRate.LONG_REST),
    
    // TODO fill in all of these ˇˇ

    /* 
        "Action", 1, 1, RefillRate.TURN
        "Bonus Action", 1, 1, RefillRate.TURN
        "Reaction", 1, 1, RefillRate.TURN
        "Movement", 5, 5, RefillRate.TURN
    
        "HP", 5, 5, RefillRate.LONG_REST
        "Temporary HP", 0, 0, RefillRate.NEVER
        "Hit Dice", 3, 3, RefillRate.LONG_REST
    
        "Level 1 Spellslot", 0, 0, RefillRate.LONG_REST
        "Level 2 Spellslot", 0, 0, RefillRate.LONG_REST
        "Level 3 Spellslot", 0, 0, RefillRate.LONG_REST
        "Level 4 Spellslot", 0, 0, RefillRate.LONG_REST
        "Level 5 Spellslot", 0, 0, RefillRate.LONG_REST
        "Level 6 Spellslot", 0, 0, RefillRate.LONG_REST
        "Level 7 Spellslot", 0, 0, RefillRate.LONG_REST
        "Level 8 Spellslot", 0, 0, RefillRate.LONG_REST
        "Level 9 Spellslot", 0, 0, RefillRate.LONG_REST
    
        "Warlock Spellslot", 0, 0, RefillRate.SHORT_REST //wl spell level is independat of slots
    
        "Arcane Recovery Charge", 0, 0, RefillRate.LONG_REST
        "Bardic Inspiration Charge", 0, 0, RefillRate.LONG_REST
        "Fungal Infestation Charge", 0, 0, RefillRate.LONG_REST
        "Lay on Hands Charge", 0, 0, RefillRate.LONG_REST
        "Natural Recovery Charge", 0, 0, RefillRate.LONG_REST
        "Rage Charge", 0, 0, RefillRate.LONG_REST
        "Sorcery Point", 0, 0, RefillRate.LONG_REST
        "War Priest Charge", 0, 0, RefillRate.LONG_REST
    
        "Action Surge Charge", 0, 0, RefillRate.SHORT_REST
        "Channel Divinity Charge", 0, 0, RefillRate.SHORT_REST
        "Channel Oath Charge", 0, 0, RefillRate.SHORT_REST
        "Superiority Dice", 0, 0, RefillRate.SHORT_REST
        "Ki Points", 0, 0, RefillRate.SHORT_REST
        "Tides of Chaos Charge", 0, 0, RefillRate.SHORT_REST
        "Wild Shape Charge", 0, 0, RefillRate.SHORT_REST
    
        "Luck Point", 0, 0, RefillRate.LONG_REST // lucky feat
    
        "Faerie Fire", 0, 0, RefillRate.SHORT_REST // drow race trait
        "Mage Hand", 0, 0, RefillRate.SHORT_REST
        "Benign Transposition: Teleport", 0, 0, RefillRate.LONG_REST
    */

    CUSTOM("", 1, RefillRate.NEVER);


    final String name;
    final int defaultMaxAmount;
    final RefillRate defaultRefillRate;

    TurnResourceType(String name, int defaultMaxAmount, RefillRate defaultRefillRate) {
        this.name = name;
        this.defaultMaxAmount = defaultMaxAmount;
        this.defaultRefillRate = defaultRefillRate;
    }
}
