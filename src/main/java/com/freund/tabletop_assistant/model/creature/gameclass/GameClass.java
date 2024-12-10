package com.freund.tabletop_assistant.model.creature.gameclass;

import com.freund.tabletop_assistant.model.ability.Ability;

public enum GameClass {
    BARBARIAN(Ability.NONE, "1d12"), //List.of(Subclass.BERSERKER, Subclass.WILDHEART, Subclass.WILD_MAGIC)
    BARD(Ability.CHA, "1d8"), // List.of(Subclass.COLLEGE_OF_LORE, Subclass.COLLEGE_OF_VALOUR, Subclass.COLLEGE_OF_SWORDS)
    CLERIC(Ability.WIS, "1d8"), // List.of(Subclass.LIFE_DOMAIN, Subclass.LIGHT_DOMAIN, Subclass.TRICKERY_DOMAIN, Subclass.KNOWLEDGE_DOMAIN, Subclass.NATURE_DOMAIN, Subclass.TEMPEST_DOMAIN, Subclass.WAR_DOMAIN)
    DRUID(Ability.WIS, "1d8"),
    FIGHTER(Ability.INT, "1d10"),
    MONK(Ability.NONE, "1d8"),
    PALADIN(Ability.CHA, "1d10"),
    RANGER(Ability.WIS, "1d10"),
    ROGUE(Ability.INT, "1d8"),
    SORCERER(Ability.CHA, "1d6"),
    WARLOCK(Ability.CHA, "1d8"),
    WIZARD(Ability.INT, "1d6");

    public final Ability SPELLCASTING_ABILITY;
    public final String HIT_DICE;
    
    // ˇˇ probably don't need to implement these since I'll be doing the leveling manually anyway
    // final List<Ability> SAVING_THROW_PROFICIENCIES // gain only on level 1 - doesn't apply to multiclass
    // final List<ArmourType> ARMOUR_PROFICIENCIES // Light/Medium/Heavy armour...
    // final List<WeaponType> WEAPON_PROFICIENCIES // Simple, martial ...
    // final List<ToolType> TOOL_PROFICIENCIES // 
    // final Boolean SPELLCASTER; // or maybe what type of spellcaster (spell refill and spend type, full caster...) - enum

    GameClass(Ability spellcastingAbility, String hitDice) {
        this.SPELLCASTING_ABILITY = spellcastingAbility;
        this.HIT_DICE = hitDice;
    }

    // need to take multiclassing into consideration. Don't program levelups, just classes, perks, feats, proficiencies

    //think about how you want to run the command on levelup (ex.  Player.addFeature())

    // HitDice

}
