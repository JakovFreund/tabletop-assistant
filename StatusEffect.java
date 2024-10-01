class StatusEffectInstance {
    StatusEffect statusEffect;
    Duration duration;
    int turnsDuration; // maybe change to turnsDuration
    String customNote; // DM inputed reminder

    public StatusEffectInstance(StatusEffect statusEffect, int turnsDuration, Duration duration, String customNote) {
        this.statusEffect = statusEffect;
        this.duration = duration;
        this.turnsDuration = turnsDuration;
        this.customNote = customNote;
    }
}

enum Duration {
    TURNS,
    SHORT_REST,
    LONG_REST,
    UNLIMITED
}

enum StatusEffect {
    // Base Conditions
    // @formatter:off
    GRAPPLED("description"),
    INCAPACITATED("description"),
    INVISIBLE("description"),
    PARALYZED("description"),
    PETRIFIED("description"),
    POISONED("description"),
    PRONE("description"),
    STUNNED("description"),
    UNCONSCIOUS("description"),
    EXHAUSTED("description"),

    // Conditions
    ABJURE_FRIGHTENED("Cannot move. Frightened entities also have Disadvantage on Ability Checks and Attack rolls."),
    ABJURE_SLOW("Movement speed is halved. Taking damage ends this condition."),
    ACID("Reduces Armour Class by 2."),
    ACID_RESISTANCE("Resistant to Acid damage."),
    AID("HP maximum increased by 5 points."),
    ANIMALISTIC_VITALITY("Affected entity regains 1d8 HP of health every round when below 60 HP. It also receives an additional 12ft of movement speed."),
    ARCANE_ACUITY("Affected entity has a +1 bonus to its spell Attack rolls and spell save DC for each remaining turn. Reduce the duration by 2 each time the entity takes damage."),
    ARCANE_WARD("Blocks damage equal to Arcane Ward charges and then loses 1 charge. Casting Abjuration spells will add charges equal to the level of the spell."),
    ARMOUR_OF_AGATHYS("Gains 5 temporary HP and deal 5 Cold damage to any creature that hits the affected entity with a melee attack while the added HP are present."),
    ARMS_OF_HADAR("Can't take Reactions"),
    ASPECT_OF_THE_ELK("Affected entity and nearby allies in a 60ft radius have a +5ft bonus to Movement speed."),
    ASPECT_OF_THE_STALLION("Gains temporary HP equal to twice its Barbarian level."),
    ASPECT_OF_THE_WOLF("Affected entity and nearby allies in a 60ft radius have a bonus to Stealth Checks equal to the Dexterity modifier of the barbarian."),
    ASTRAL_KNOWLEDGE_CHA("Gains Proficiency in Deception, Intimidation, Performance, and Persuasion until Long Rest."),
    ASTRAL_KNOWLEDGE_DEX("Gains Proficiency in Acrobatics, Sleight of Hand, and Stealth until Long Rest."),
    ASTRAL_KNOWLEDGE_INT("Gains Proficiency in Arcana, History, Investigation, Nature, and Religion until Long Rest."),
    ASTRAL_KNOWLEDGE_STR("Gains Proficiency in Athletics until Long Rest."),
    ASTRAL_KNOWLEDGE_WIS("Gains Proficiency in Animal Handling, Insight, Medicine, Perception, and Survival until Long Rest."),
    AURA_OF_COURAGE("The paladin and any nearby allies in a 10ft radius can't be Frightened."),
    AURA_OF_DEVOTION("The paladin and any nearby allies in a 10ft radius can't be Charmed."),
    AURA_OF_HATE("The paladin and all nearby fiends and undead in a 10ft radius deal additional melee damage equal to the Charisma modifier of the paladin."),
    AURA_OF_PROTECTION("The paladin and any nearby allies in a 10ft radius have a bonus on Saving Throws equal to the Charisma modifier of the paladin."),
    AURA_OF_WARDING("The paladin and any nearby allies in a 10ft radius have Resistance to damage from spells."),
    BANE("Has a -1d4 penalty to Attack rolls and Saving throws."),
    BANISHED("Banished from this plane of existance. Can't move, take actions, bonus actions, reactions or be targeted"),
    BARDIC_INSPIRATION("Gains bonus to next Attack roll, Ability check, or Saving throw (bonus amount depends on Bard's level)."),
    BARKSKIN("Armour Class increased to 16."),
    BEACON_OF_HOPE("Has Advantage on Wisdom and Death Saving throws. Use the highest possible dice roll when healed."),
    BEARS_ENDURANCE("Has Advantage on Constitution Checks. Gains 7 Temporary Hit Points."),
    BEND_LUCK_BONUS("Wild magic has twisted the affected entity's fate. Gains a +1d4 bonus to Ability Checks."),
    BEND_LUCK_PENALTY("Wild magic has twisted the affected entity's fate. Gains a -1d4 bonus to Ability Checks."),
    BLACK_TENTACLES("Restrained by dark tendrils. Affected entity can't move and takes 3d6 Bludgeoning damage per turn. Attack Rolls against the affected entity have Advantage, while the entity's Attack Rolls have Disadvantage. Strength Saving throw to get out."),
    BLADE_WARD("Has Resistance against Bludgeoning, Piercing, and Slashing damage."),
    BLEEDING("Creature takes 2 Slashing damage at the start of each turn and has Disadvantage on Constitution Saving throws."),
    BLESS("Gains a +1d4 bonus to Attack rolls and Saving throws."),
    BLESSING_OF_SELUNE("Weapon attacks deal an additional 1d6 Radiant damage."),
    BLESSING_OF_THE_TRICKSTER("Has Advantage on Stealth Checks."),
    BLINDED("Ranged attacks and spells have a range of 10ft and Attack Rolls suffer Disadvantage. Attack Rolls against the affected entity have Advantage."),
    BLINK("At the end of their turn, there is a chance the affected entity gets Blinked to the Ethereal Plane. They return to the Material Plane at the start of their next turn."),
    BLINKED_TO_THE_ETHEREAL_PLANE("Affected entity is in the Ethereal Plane, where it can't be harmed, seen, or affected. Can't move or interact with anything in the world, but can choose to teleport up to 20ft."),
    BLUDGEON_THE_WEAK("Affected entity is Vulnerable to Bludgeoning damage for 3 turns, or until it takes damage."),
    BLURRED("Attackers have Disadvantage on Attack rolls against this creature, unless they do not rely on sight or can see through illusions."),
    BOLSTERING_MAGIC_BOON("Bolstered by wild magic. Has a +1d4 bonus to Attack Rolls and Ability Checks"),
    BONE_CHILLED("Can not regain HP. If Undead, has Disadvantage on Attack rolls."),
    BOUND_WEAPON("The weapon is ritually bound to its wielder. It can't be knocked out of the wielder's hand, and automatically returns to its wielder when Thrown."),
    BRACED("On Damage Rolls, roll twice and use the higher result."),
    BRANDING_SMITE("Cannot turn Invisible"),
    BRITTLE("Taking 2d6 Cold damage damage per turn. Affected entity has been rapidly cooled while aflame, making it Vulnerable to Thunder and Bludgeoning damage."),
    BUFOTOXIN("Has Disadvantage on Dexterity Saving throws."),
    BULLS_STRENGTH("Has Advantage on Strength Checks. Weight Limit doubled."),
    BURNING("Takes 1d4 Fire damage per turn. Can be removed with the Help action. Immune from if Wet."),
    CALL_LIGHTNING("Can Call Lightning without expending a spell slot."),
    CALMED("Can't be Charmed or Frightened, and can't Rage"),
    CATS_GRACE("Has Advantage on Dexterity Checks. Takes half falling damage."),
    CHANNEL_DIVINITY_CLOAK_OF_SHADOWS("Has Advantage on Attack rolls and imposes Disadvantage on enemy Attack Rolls. Condition ends if affected entity attacks, casts a spell, takes an action, or takes damage."),
    CHARMED("Can't attack spellcaster. Spellcaster has Advantage on Charisma Checks in dialogue."),
    CHEST_TRAUMA("Has Disadvantage on Constitution Saving Throws and has one fewer action. Removed by healing."),
    CHILLED("Affected entity is vulnerable to Cold damage and resistant to Fire damage. Applying Wet to a chilled entity will make it Frozen for 1 turn."),
    CLOAK_OF_SHADOWS("Has Advantage on Attack rolls and imposes Disadvantage on enemy Attack Rolls. Attacking, casting spells, or entering a brightly lit area ends this condition."),
    COCOONED("Trapped in a spider's web. Incapacitated and can't move. Condition ends upon taking damage or making a successful Strength Saving throw."),
    COLD_RESISTANCE("Resistant to Cold damage."),
    COMBAT_INSPIRATION("Gains bonus to next Attack roll, Ability check, Saving throw, Damage roll or Armour Class for one attack (bonus amount depends on Bard's level)."),
    COMMAND_APPROACH("Incapacitated. Must move toward the spellcaster by the shortest route possible."),
    COMMAND_DROP("Incapacitated. Must drop whatever it is holding."),
    COMMAND_FLEE("Incapacitated. Must move away from the spellcaster by the fastest means possible."),
    COMMAND_GROVEL("Incapacitated and can't move. Must drop prone."),
    COMMAND_HALT("Incapacitated and can't move."),
    COMPELLED_DUEL("Cannot attack creatures other than the spellcaster."),
    CONFUSED("Affected entity must roll a d10 at the start of each of its turns to determine its behaviour for that turn. (1: Flees in a random direction. 2-6: Incapacitated and can't move. 7-8: Attacks a randomly selected creature within reach. 9-10: Acts and moves normally.)"),
    CONTROLLED("This undead is under the control of a Paladin."),
    CORROSIVE_SPIT("Takes Acid damage per turn (damage amount depends on Druid's level). The target's Armour Class decreases by 1 per turn, to a maximum of -5. Water removes the spit and its effects."),
    COUNTERCHARM("Gains Advantage on Saving Throws against being Charmed or Frightened."),
    CRAWLING_GNAW("Target is inflicted with zombie mucus. If the affected entity dies before the infection wears off, it will temporarily rise as a Newborn Zombie (They have 10 HP and the Newborn Zombie condition)."),
    CROWN_OF_MADNESS("Instilled with magical madness. Must attack the nearest creature, other than the spellcaster."),
    CRUSADERS_MANTLE("Near a paladin's holy aura. Weapon attacks deal an additional 1d4 Radiant damage"),
    CRUSADERS_MANTLE_AURA("Emmiting a holy aura. Weapon attacks of nearby allies deal an additional 1d4 Radiant damage"),
    CURSE_OF_THE_DIRE_RAVEN("Marked by the feather of a dire raven. Attack rolls against the affected entity have Advantage."),
    CURSED_ADDITIONAL_DAMAGE("Receives an additional 1d8 Necrotic damage from the spellcaster's attacks or spells."),
    CURSED_ATTACK_DISADVANTAGE("Has Disadvantage on Attack rolls against the source of the curse."),
    CURSED_CHARISMA("Has Disadvantage on Ability checks and Saving throws using Charisma."),
    CURSED_CONSTITUTION("Has Disadvantage on Ability checks and Saving throws using Constitution."),
    CURSED_DEXTERITY("Has Disadvantage on Ability checks and Saving throws using Dexterity."),
    CURSED_DREAD("Each turn, the affected entity has to succeed on a Wisdom Saving throw or skip its turn."),
    CURSED_INTELLIGENCE("Has Disadvantage on Ability checks and Saving throws using Intelligence."),
    CURSED_STRENGTH("Has Disadvantage on Ability checks and Saving throws using Strength."),
    CURSED_WISDOM("Has Disadvantage on Ability checks and Saving throws using Wisdom."),
    DARK_ONES_BLESSING("Whenever it reduces a hostile creature to 0 HP, affected entity gains temporary HP equal to its Charisma modifier and Warlock level combined."),
    DARKVISION("Can see in the dark up to the range of 40ft."),
    DAZED("Has Disadvantage on Wisdom Saving throws, can't take Reactions, and loses the Dexterity bonus to their Armour Class. Can be removed with the Help action."),
    DEAD("This creature is dead."),
    DEAFENED("Affected entity can't hear. Attack Rolls against the affected entity have Advantage. Unaffected by Bardic Inspiration."),
    DEATH_WARD("The next time damage would reduce the affected entity to 0 HP. it remains conscious with 1 HP left."),
    DEFENSIVE_FLOURISH("Armour Class increased by 4"),
    DETECT_THOUGHTS("Can read the thoughts of any creature with Intelligence higher than 3."),
    DIFFICULT_TERRAIN("Movement speed halved."),
    DISGUISE_SELF("Appearance is entirely changed."),
    DISPEL_EVIL_AND_GOOD("Aberrations, Celestials, Elementals, Fey, Fiends, and Undead have Disadvantage on Attack rolls against the affected entity. If the affected entity touches an ally that is Charmed or Frightened, it breaks the enchantment. Affected entity can attempt to drive a creature back to its home plane by making a melee spell attack against a Celestial, an Elemental, a Fey, a Fiend, or an Undead - enemy must succeed on a Charisma Saving throw or be sent back to its home plane."),
    DISTRACTED("The distractor's allies have Advantage on their next Attack Roll against the creature."),
    DIVINE_FAVOUR("Affected entity's weapons deal an additional 1d4 Radiant damage."),
    DIVINE_SENSE("Has Advantage on Attack Rolls against celestials, fiends, and undead."),
    DOMINATED("Affected entity is under the control of the caster. Each time it takes damage, it can break the spell by making a successful Wisdom Saving throw. "),
    DOWNED("Death Saving Throws must be rolled each turn. Any damage received while unconscious counts as one failure. Can be removed by healing or with the Help action"),
    DREAD_AMBUSHER("Movement speed increased by 10ft. Affected entity can also make an extra weapon attack that deals an additional 1d8 damage."),
    DRUNK("Has Disadvantage on Dexterity and Charisma checks."),
    EAGLES_SPLENDOR("Has Advantage on Charisma Checks."),
    ELECTROCUTED("Takes 1d4 Lightning damage per turn."),
    ELEMENTAL_AFFINITY_ACID_RESISTANCE("Resistant to Acid damage."),
    ELEMENTAL_AFFINITY_COLD_RESISTANCE("Resistant to Cold damage."),
    ELEMENTAL_AFFINITY_FIRE_RESISTANCE("Resistant to Fire damage."),
    ELEMENTAL_AFFINITY_LIGHTNING_RESISTANCE("Resistant to Lightning damage."),
    ELEMENTAL_AFFINITY_POISON_RESISTANCE("Resistant to Poison damage."),
    ELEMENTAL_WEAPON_ACID("Has a +1 bonus to Attack rolls and deals an additional 1d4 Acid damage."),
    ELEMENTAL_WEAPON_COLD("Has a +1 bonus to Attack rolls and deals an additional 1d4 Cold damage."),
    ELEMENTAL_WEAPON_FIRE("Has a +1 bonus to Attack rolls and deals an additional 1d4 Fire damage."),
    ELEMENTAL_WEAPON_LIGHTNING("Has a +1 bonus to Attack rolls and deals an additional 1d4 Lightning damage."),
    ELEMENTAL_WEAPON_THUNDER("Has a +1 bonus to Attack rolls and deals an additional 1d4 Thunder damage."),
    ELVEN_ELEGANCE("Noble elven arcana grants the affected entity an additional 20ft movement speed and Superior Darkvision until Long Rest."),
    ENCUMBERED("Carrying too much weight. Cannot jump, and Movement speed is reduced by 10ft"),
    ENHANCED_LEAP("Jump distance is tripled."),
    ENLARGED("Size is increased. Weapon attacks deal 1d4 more damage. Has Advantage on Strength Checks and Saving throws."),
    ENTHRALLED("Peripheral vision reduced. Will keep looking at the spellcaster."),
    ENTROPIC_WARD("Missed an attack on a warlock. The warlock has Advantage on their next Attack roll against the affected entity."),
    EVASIVE_FOOTWORK("Enemies have Disadvantage on melee attacks against the affected entity"),
    EXHAUSTED_1("Has Disadvantage on Ability Checks."),
    EXHAUSTED_2("Movement speed halved."),
    EXHAUSTED_3("Has Disadvantage on Attack Rolls and Saving Throws."),
    EXHAUSTED_4("HP maximum halved."),
    EXHAUSTED_5("Cannot move."),
    EXPEDITIOUS_RETREAT("Dash available as a Bonus action."),
    EYEBITE_SICKENED("Affected entity has Disadvantage on Attack Rolls and Checks."),
    FANGS_OF_THE_FIRE_SNAKE("Affected entity's melee attacks deal an additional 1d4 Fire damage."),
    FEARFUL("Has Disadvantage on Ability Checks and Attack rolls. Affected entity must run from the source of its fear and cannot take any additional actions. It makes a Saving throw to shake off this effect if its turn is ended out of sight from the source of fear."),
    FEATHER_FALL("Rate of falling is slowed, granting Immunity to falling damage"),
    FEEBLE("Deal only half damage with weapon attacks."), // TODO fix spell description
    



    FRIGHTENED("Cannot move. Frightened entities also have Disadvantage on  Ability checks and Attack rolls."),

    






    FROZEN("Incapacitated. Gains Vulnerability to Bludgeoning, Thunder, and Force damage. Gains Resistance to Fire damage. If it is dealt Bludgeoning, Thunder, or Force damage, the ice shatters, ending the condition."),

    RESTRAINED("Cannot move. Attack rolls against the creature have Advantage, while the creature's Attack Rolls and Dexterity Saving throws have Disadvantage."),

    
    THIRD_EYE_DARKVISION("Can see in the dark up to the range of 80ft.");




    

    // add potion heal here

    // add Undead (vulnerable to radiant) and other similiar traits

    ;
    // Features (proficiencies, traits)
    // Feats // Character.addFeat(FEAT.blabla); Character.addBuff(Buff.STR_IMPROVEMENT, Duration.UNLIMITED) - increases STR by 1
    // Wet
    // Hexed
    // @formatter:on

    // https://bg3.wiki/w/index.php?title=Special:CargoQuery&limit=1500&offset=0&tables=conditions&fields=_pageName+%3D+page%2C+name%2C+icon%2C+effects&order_by=name&format=template&default=%3Ctr%3E%3Ctd+colspan%3D%222%22+style%3D%22text-align%3A+center%3B%22%3E%27%27None%27%27%3C%2Ftd%3E%3C%2Ftr%3E&template=ConditionsTableRow&named+args=yes

    final String DESCRIPTION;

    StatusEffect(String description) {
        this.DESCRIPTION = description;
    }
}