package com.freund.tabletop_assistant.model.item;

public enum Rarity {
    COMMON,
    UNCOMMON,
    RARE,
    VERY_RARE,
    LEGENDARY,
    ARTIFACT,
    
    VARIES; // TODO fix later (it has a rarity, but its unknown due to how the old json was structured)

    Rarity increase() {
        switch (this) {
            case COMMON:
                return UNCOMMON;
            case UNCOMMON:
                return RARE;
            case RARE:
                return VERY_RARE;
            case VERY_RARE:
                return LEGENDARY;
            case LEGENDARY:
                return ARTIFACT;
            case ARTIFACT:
                return ARTIFACT;
            case VARIES:
                return VARIES;
            default:
                return null;
        }
    }
}
