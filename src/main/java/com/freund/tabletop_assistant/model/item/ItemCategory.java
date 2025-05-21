package com.freund.tabletop_assistant.model.item;

import java.util.List;

public enum ItemCategory {
    WEAPON(""), // includes staff, rod, wand
    ARMOUR(""),
    AMMUNITION(""),
    GEAR_AND_TOOLS(""), // includes tools and adventuring-gear minus ammunition
    RING(""),
    POTION(""),
    SCROLL(""),
    WONDROUS_ARTIFACT(""); // wondrous-item

    public final String defaultIcon;

    public static final List<ItemCategory> STACKABLE = List.of(AMMUNITION, POTION, SCROLL);
    public static final List<ItemCategory> MUTABLE_EFFECTS = List.of(WEAPON, ARMOUR, RING);

    private ItemCategory(String defaultIcon) {
        this.defaultIcon = defaultIcon;
    }
}