class StatusEffectInstance {
    StatusEffect statusEffect;
    Duration duration;
    int turnsDuration; // maybe change to turnsDuration
    String customNote; // DM inputed reminder

    public StatusEffectInstance(StatusEffect statusEffect, Duration duration, String customNote) { // probably change to 1 constructor with default Duration.TURN 
        this.statusEffect = statusEffect;
        this.duration = duration;
        this.customNote = customNote;
    }

    public StatusEffectInstance(StatusEffect statusEffect, int turnsDuration, String customNote) {
        this.statusEffect = statusEffect;
        this.turnsDuration = turnsDuration;
        this.customNote = customNote;
    }
}

enum Duration {
    SHORT_REST,
    LONG_REST,
    UNLIMITED
}

enum StatusEffect {
    // Base Conditions
    
    CHARMED("charmed description"),
    DEAFENED("description"),
    FRIGHTENED("description"),
    GRAPPLED("description"),
    INCAPACITATED("description"),
    INVISIBLE("description"),
    PARALYZED("description"),
    PETRIFIED("description"),
    POISONED("description"),
    PRONE("description"),
    RESTRAINED("description"),
    STUNNED("description"),
    UNCONSCIOUS("description"),
    EXHAUSTED("description"),

    // Conditions
    ABJURE_FRIGHTENED("Cannot move. Frightened entities also have Disadvantage on Ability Checks and Attack rolls."),
    ABJURE_SLOW("Movement speed is halved. Taking damage ends this condition."),
    ACID("Reduces Armour Class by 2."),
    ACID_RESISTANCE("Resistant to Acid damage."),
    AID("HP maximum increased by 5 points."),
    ALCOHOL("Has Disadvantage on Dexterity and Charisma checks."),
    AMBUSHED("Attack Rolls against the affected entity have Advantage and it has Disadvantage on Strength and Dexterity Checks. Taking damage or being Helped ends this condition."),
    ANIMALISTIC_VITALITY("Affected entity regains 1d8 HP of health every round when below 60 HP. It also receives an additional 12ft of movement speed."),
    ARCANE_WARD("Blocks damage equal to Arcane Ward charges and then loses 1 charge. Casting Abjuration spells will add charges equal to the level of the spell."),
    ARMOUR_OF_AGATHYS("Gain 5 temporary HP and deal 5 Cold damage to any creature that hits you with a melee attack while the added HP are present."),
    ARMS_OF_HADAR("Can't take Reactions"),
    ASPECT_OF_THE_ELK("Affected entity and nearby allies in a 60ft radius have a +5ft bonus to Movement Speed."),
    ASPECT_OF_THE_STALLION("Dashing granted you temporary hit points equal to twice your Barbarian level."),
    ASPECT_OF_THE_WOLF("Affected entity and nearby allies in a 60ft radius have a bonus to Stealth Checks equal to the Dexterity modifier of the barbarian."),
    ASTRAL_KNOWLEDGE_CHA("Gain Proficiency in Deception, Intimidation, Performance, and Persuasion until Long Rest."),
    ASTRAL_KNOWLEDGE_DEX("Gain Proficiency in Acrobatics, Sleight of Hand, and Stealth until Long Rest."),
    ASTRAL_KNOWLEDGE_INT("Gain Proficiency in Arcana, History, Investigation, Nature, and Religion until Long Rest."),
    ASTRAL_KNOWLEDGE_STR("Gain Proficiency in Athletics until Long Rest."),
    ASTRAL_KNOWLEDGE_WIS("Gain Proficiency in Animal Handling, Insight, Medicine, Perception, and Survival until Long Rest."),
    AURA_OF_COURAGE("The paladin and any nearby allies in a 10ft radius can't be Frightened."),
    AURA_OF_DEVOTION("The paladin and any nearby allies in a 10ft radius can't be Charmed."),
    AURA_OF_HATE("The paladin and all nearby fiends and undead in a 10ft radius deal additional melee damage equal to the Charisma modifier of the paladin."),
    AURA_OF_PROTECTION("The paladin and any nearby allies in a 10ft radius have a bonus on Saving Throws equal to the Charisma modifier of the paladin."),
    AURA_OF_WARDING("The paladin and any nearby allies in a 10ft radius have Resistance to damage from spells."),
    BANE("Has a -1d4 penalty to Attack rolls and Saving throws."),
    BANISHED("Banished from this plane of existance. Can't move, take actions, bonus actions, reactions or be targeted"),
    BARDIC_INSPIRATION("Gain bonus to next Attack roll, Ability check, or Saving throw (bonus amount depends on Bard's level)."),
    BARKSKIN("Armour Class increased to 16."),
    BEACON_OF_HOPE("Has Advantage on Wisdom and Death Saving throws. Use the highest possible dice roll when healed."),
    BEARS_ENDURANCE("Has Advantage on Constitution Checks. Gain 7 Temporary Hit Points."),
    BEND_LUCK_BONUS("Wild magic has twisted the affected entity's fate. It gained a +1d4 bonus to Ability Checks."),
    BEND_LUCK_PENALTY("Wild magic has twisted the affected entity's fate. It gained a -1d4 bonus to Ability Checks."),
    BLACK_TENTACLES("Restrained by dark tendrils. Affected entity can't move and takes 3d6 Bludgeoning damage per turn. Attack Rolls against the affected entity have Advantage, while the entity's Attack Rolls and Dexterity Saving Throws have Disadvantage"),
    BLADE_WARD("Has Resistance against Bludgeoning, Piercing, and Slashing damage."),
    BLEEDING("Creature takes 2 Slashing damage at the start of each turn and has Disadvantage on Constitution Saving throws."),
    BLESS("Gains a +1d4 bonus to Attack rolls and Saving throws."),
    // Blessing of Selûne (make up some effect, maybe bonus radiant damage?)
    BLESSING_OF_THE_TRICKSTER("Has Advantage on Stealth Checks."),
    BLINDED("Ranged attacks and spells have a range of 10ft and Attack Rolls suffer Disadvantage. Attack Rolls against you have Advantage."),
    BLINK("At the end of their turn, there is a chance the affected entity gets Blinked to the Ethereal Plane. They return to the Material Plane at the start of their next turn."),
    BLINKED_TO_THE_ETHEREAL_PLANE("Affected entity is in the Ethereal Plane, where it can't be harmed, seen, or affected. Can't move or interact with anything in the world, but can choose to teleport up to 20ft."),
    BLUDGEON_THE_WEAK("Affected entity is Vulnerable to Bludgeoning damage for 3 turns, or until it takes damage."),
    BLURRED("Attackers have Disadvantage on Attack rolls against this creature, unless they do not rely on sight or can see through illusions."),
    





    ENHANCED_LEAP("Jump distance is tripled.");








    ;
    // Features (proficiencies, traits)
    // Feats // Character.addFeat(FEAT.blabla); Character.addBuff(Buff.STR_IMPROVEMENT, Duration.UNLIMITED) - increases STR by 1
    // Wet

    // https://bg3.wiki/w/index.php?title=Special:CargoQuery&limit=1500&offset=0&tables=conditions&fields=_pageName+%3D+page%2C+name%2C+icon%2C+effects&order_by=name&format=template&default=%3Ctr%3E%3Ctd+colspan%3D%222%22+style%3D%22text-align%3A+center%3B%22%3E%27%27None%27%27%3C%2Ftd%3E%3C%2Ftr%3E&template=ConditionsTableRow&named+args=yes

    final String DESCRIPTION;

    StatusEffect(String description) {
        this.DESCRIPTION = description;
    }
}