package com.freund.tabletop_assistant.model.item;

public enum Rarity {
    COMMON, //40%
    UNCOMMON, //30%
    RARE, //20%
    EPIC, //8%
    LEGENDARY; //2%

    Rarity increase() {
        switch (this) {
            case COMMON:
                return UNCOMMON;
            case UNCOMMON:
                return RARE;
            case RARE:
                return EPIC;
            case EPIC:
                return LEGENDARY;
            case LEGENDARY:
                return LEGENDARY;
            default:
                return null;
        }
    }

}