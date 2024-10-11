package com.freund.tabletop_assistant.model.item;

import java.util.List;

public enum ItemType {
    WOODEN_SWORD("Wooden sword", ItemCategory.WEAPON, Rarity.UNCOMMON, "Just a wooden sword", 30, 10,
                    List.of(new ItemEffect(ItemEffectType.DAMAGE, "d6"))),
    RANDOM_CHESTPLATE("Random Chestplate", ItemCategory.WEARABLE, Rarity.RARE, "abc", 50, 15,
                    List.of(new ItemEffect(ItemEffectType.AC, "10"))),
    SILVERFANG("Silverfang", ItemCategory.WEAPON, Rarity.EPIC,
                    "An ancient sword forged from Mithril in the legendary Great Hearth of the First Dwarven Kingdom. Being made of Mithril makes it a good choice against the undead.",
                    25, 500,
                    List.of(new ItemEffect(ItemEffectType.DAMAGE, "4d8"))),


    // https://shieldmaiden.app/compendium/items
    // https://5e.tools/lootgen.html

    // add staff that gives an action to get arcane acuity for 3 turns

    // Produce Flame is an item that always has "Light" (statuseffect part solved in Creature.java)

    GOLD("Gold", ItemCategory.MISC, Rarity.COMMON, "Currency of Alarién", 0, 1);
    // TODO change inlore name of gold

    //
    final String NAME;
    final ItemCategory CATEGORY;
    final Rarity BASE_RARITY;
    final String DESCRIPTION;
    final int WEIGHT;
    final int BASE_VALUE;
    final List<ItemEffect> BASE_EFFECTS;

    ItemType(String name, ItemCategory category, Rarity rarity, String description, int weight, int value,
                    List<ItemEffect> baseEffects) {
            this.NAME = name;
            this.CATEGORY = category;
            this.BASE_RARITY = rarity;
            this.DESCRIPTION = description;
            this.WEIGHT = weight;
            this.BASE_VALUE = value;
            this.BASE_EFFECTS = baseEffects;
            // TODO weapons can have various properties such as Heavy, Finesse, Light, and so on, Armour has Light, Heavy, 
            // Thrown, Simple, Martial ?
    }

    ItemType(String name, ItemCategory category, Rarity rarity, String description, int weight, int value) {
            this.NAME = name;
            this.CATEGORY = category;
            this.BASE_RARITY = rarity;
            this.DESCRIPTION = description;
            this.WEIGHT = weight;
            this.BASE_VALUE = value;
            this.BASE_EFFECTS = null;
    }
}
