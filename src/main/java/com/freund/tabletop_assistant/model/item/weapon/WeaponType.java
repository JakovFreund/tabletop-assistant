package com.freund.tabletop_assistant.model.item.weapon;

import java.util.List;

public enum WeaponType {
    BATTLEAXE,
    CLUB,
    DAGGER,
    DART,
    FLAIL,
    GLAIVE,
    GREATAXE,
    GREATCLUB,
    GREATSWORD,
    HALBERD,
    HAND_CROSSBOW,
    HANDAXE,
    HEAVY_CROSSBOW,
    JAVELIN,
    LIGHT_CROSSBOW,
    LIGHT_HAMMER,
    LONGBOW,
    LONGSWORD,
    MACE,
    MAUL,
    MORNINGSTAR,
    PIKE,
    QUARTERSTAFF,
    RAPIER,
    ROD,
    SCIMITAR,
    SHORTBOW,
    SHORTSWORD,
    SICKLE,
    SLING,
    SPEAR,
    STAFF,
    TRIDENT,
    WAND,
    WAR_PICK,
    WARHAMMER,
    UNKNOWN;

    public final WeaponCategory WEAPON_CATEGORY;
    public final WeaponRange WEAPON_RANGE;
    public final List<WeaponProperty> WEAPON_PROPERTIES;
    // public final List<WeaponAction> */

    WeaponType(){ // TODO fill in defaults for each above https://bg3.wiki/wiki/Weapons
        this.WEAPON_CATEGORY = null;
        this.WEAPON_RANGE = null;
        this.WEAPON_PROPERTIES = null;
        // WeaponActions
    }
}

/* */