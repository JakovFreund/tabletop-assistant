package com.freund.tabletop_assistant.model.condition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public enum Condition {
    // @formatter:off

    // Immunities, Resistances, Vulnerabilities
    ACID_IMMUNITY("Immune to Acid damage.", List.of()),
    ACID_RESISTANCE("Resistant to Acid damage.", List.of()),
    ACID_VULNERABILITY("Vulnerable to Acid damage.", List.of()),
    BLUDGEONING_IMMUNITY("Immune to Bludgeoning damage.", List.of()),
    BLUDGEONING_RESISTANCE("Resistant to Bludgeoning damage.", List.of()),
    BLUDGEONING_VULNERABILITY("Vulnerable to Bludgeoning damage.", List.of()),
    COLD_IMMUNITY("Immune to Cold damage.", List.of()),
    COLD_RESISTANCE("Resistant to Cold damage.", List.of()),
    COLD_VULNERABILITY("Vulnerable to Cold damage.", List.of()),
    FIRE_IMMUNITY("Immune to Fire damage.", List.of()),
    FIRE_RESISTANCE("Resistant to Fire damage.", List.of()),
    FIRE_VULNERABILITY("Vulnerable to Fire damage.", List.of()),
    FORCE_IMMUNITY("Immune to Force damage.", List.of()),
    FORCE_RESISTANCE("Resistant to Force damage.", List.of()),
    FORCE_VULNERABILITY("Vulnerable to Force damage.", List.of()),
    LIGHTNING_IMMUNITY("Immune to Lightning damage. Can't be Shocked or Electrocuted.", List.of()),
    LIGHTNING_RESISTANCE("Resistant to Lightning damage. Can't be Shocked or Electrocuted.", List.of()),
    LIGHTNING_VULNERABILITY("Vulnerable to Lightning damage.", List.of()),
    NECROTIC_IMMUNITY("Immune to Necrotic damage.", List.of()),
    NECROTIC_RESISTANCE("Resistant to Necrotic damage.", List.of()),
    NECROTIC_VULNERABILITY("Vulnerable to Necrotic damage.", List.of()),
    PIERCING_IMMUNITY("Immune to Piercing damage.", List.of()),
    PIERCING_RESISTANCE("Resistant to Piercing damage.", List.of()),
    PIERCING_VULNERABILITY("Vulnerable to Piercing damage.", List.of()),
    POISON_IMMUNITY("Immune to Poison damage.", List.of()),
    POISON_RESISTANCE("Resistant to Poison damage.", List.of()),
    POISON_VULNERABILITY("Vulnerable to Poison damage.", List.of()),
    PSYCHIC_IMMUNITY("Immune to Psychic damage.", List.of()),
    PSYCHIC_RESISTANCE("Resistant to Psychic damage.", List.of()),
    PSYCHIC_VULNERABILITY("Vulnerable to Psychic damage.", List.of()),
    RADIANT_IMMUNITY("Immune to Radiant damage.", List.of()),
    RADIANT_RESISTANCE("Resistant to Radiant damage.", List.of()),
    RADIANT_VULNERABILITY("Vulnerable to Radiant damage.", List.of()),
    SLASHING_IMMUNITY("Immune to Slashing damage.", List.of()),
    SLASHING_RESISTANCE("Resistant to Slashing damage.", List.of()),
    SLASHING_VULNERABILITY("Vulnerable to Slashing damage.", List.of()),  
    THUNDER_IMMUNITY("Immune to Thunder damage.", List.of()),
    THUNDER_RESISTANCE("Resistant to Thunder damage.", List.of()),
    THUNDER_VULNERABILITY("Vulnerable to Thunder damage.", List.of()),
    PHYSICAL_IMMUNITY("Immune to Bludgeoning, Piercing and Slashing damage.", List.of(BLUDGEONING_IMMUNITY, PIERCING_IMMUNITY, SLASHING_IMMUNITY)),
    PHYSICAL_RESISTANCE("Resistant to Bludgeoning, Piercing and Slashing damage.", List.of(BLUDGEONING_RESISTANCE, PIERCING_RESISTANCE, SLASHING_RESISTANCE)),
    PHYSICAL_VULNERABILITY("Vulnerable to Bludgeoning, Piercing and Slashing damage.", List.of(BLUDGEONING_VULNERABILITY, PIERCING_VULNERABILITY, SLASHING_VULNERABILITY)),

    // Other Dependent Effects
    FOCUSED("Advantage on Attack Rolls.", List.of()),
    UNFOCUSED("Disadvantage on Attack Rolls.", List.of()),
    VULNERABLE("Attack Rolls against the affected entity have Advantage.", List.of()),
    ELUSIVE("Attack Rolls against the affected entity have Disadvantage.", List.of()),
    INCAPACITATED("Can't take Actions, Bonus Actions or Reactions. If Concentrating, lose Concentration.", List.of()), // PC can ping castables, but have a warning before it
    IMMOBILE("Can't move.", List.of()),
    CONCENTRATING("Concentrating on a spell. Upon taking damage, must make a Constitution Saving Throw to maintain concentration (DC equals 10 or half the damage you take, whichever number is higher).", List.of()),
    DULL("Can't take Reactions.", List.of()),
    PRONE("Disadvantage on Attack Rolls. Melee attacks against the creature have Advantage. Ranged attacks against the creature have Disadvantage. Crawling costs double movement. Can spend half its maximum Movement Speed to stand up.", List.of(UNFOCUSED)),
    PARALYZED("Incapacitated and can't move or speak. Automatically fails Strength and Dexterity Saving Throws. Attack Rolls against the affected entity have Advantage. Melee attacks against the creature are always Critical Hits", List.of(INCAPACITATED, IMMOBILE, VULNERABLE)), // TODO silenced?
    RAGE("Deals additional damage with melee and improvised weapons. Damage amount depends on level. Resistant to physical damage, Advantage on Strength Checks and Saving Throws. Can't cast or concentrate on spells. Rage ends early if the barbarian hasn't attacked an enemy or taken damage since their last turn.", List.of(PHYSICAL_RESISTANCE)),
    BLINDED("Disadvantage on Attack Rolls. Ranged attacks and spells have a range of 10 ft. Unaffected by Illusion spells. Attack Rolls against the affected entity have Advantage.", List.of(UNFOCUSED, VULNERABLE)),
    UNCONSCIOUS("Paralyzed and Prone. Unaware of surroundings. Drops whatever it's holding.", List.of(PARALYZED, PRONE)),
    CHARM_IMMUNITY("Can't be Charmed.", List.of()),
    FRIGHTEN_IMMUNITY("Can't be Frightened.", List.of()),
    DISEASE_IMMUNITY("Can't be afflicted by a disease.", List.of()),

    // ---

    ACID("Armour Class reduced by 2.", List.of()),
    ACID_ARROW("Affected entity takes 2d4 Acid damage at the end of their turn.", List.of()),
    AID("HP maximum increased by 5 points.", List.of()),
    ANIMALISTIC_VITALITY("Affected entity regains 1d8 HP every round when below 60 HP. Gains an additional 12 ft of Movement Speed.", List.of()),
    ARCANE_ACUITY("Affected entity gains a +1 bonus to its spell Attack Rolls and spell save DC for each remaining turn. Reduce the duration by 2 each time the entity takes damage.", List.of()),
    ARCANE_WARD("Blocks damage equal to Arcane Ward charges and then loses 1 charge. Casting Abjuration spells will add charges equal to the level of the spell.", List.of()),
    ARMOUR_OF_AGATHYS("Gains 5 temporary HP and deals 5 Cold damage to any creature that hits the affected entity with a melee attack while the added HP are present.", List.of()),
    ARMS_OF_HADAR("Can't take Reactions", List.of(DULL)),
    ASPECT_OF_THE_ELK("Affected entity and nearby allies in a 60 ft radius have a +5 ft bonus to Movement Speed.", List.of()),
    ASPECT_OF_THE_STALLION("Gains temporary HP equal to twice its Barbarian level.", List.of()),
    ASPECT_OF_THE_WOLF("Affected entity and nearby allies in a 60 ft radius have a bonus to Stealth Checks equal to the Dexterity Modifier of the barbarian.", List.of()),
    ASTRAL_KNOWLEDGE_CHA("Gains Proficiency in Deception, Intimidation, Performance, and Persuasion until Long Rest.", List.of()),
    ASTRAL_KNOWLEDGE_DEX("Gains Proficiency in Acrobatics, Sleight of Hand, and Stealth until Long Rest.", List.of()),
    ASTRAL_KNOWLEDGE_INT("Gains Proficiency in Arcana, History, Investigation, Nature, and Religion until Long Rest.", List.of()),
    ASTRAL_KNOWLEDGE_STR("Gains Proficiency in Athletics until Long Rest.", List.of()),
    ASTRAL_KNOWLEDGE_WIS("Gains Proficiency in Animal Handling, Insight, Medicine, Perception, and Survival until Long Rest.", List.of()),
    AURA_OF_COURAGE("The paladin and any nearby allies in a 10 ft radius can't be Frightened.", List.of(FRIGHTEN_IMMUNITY)),
    AURA_OF_DEVOTION("The paladin and any nearby allies in a 10 ft radius can't be Charmed.", List.of(CHARM_IMMUNITY)),
    AURA_OF_HATE("The paladin and all nearby fiends and undead in a 10 ft radius deal additional melee damage equal to the Charisma Modifier of the paladin.", List.of()),
    AURA_OF_PROTECTION("The paladin and any nearby allies in a 10 ft radius have a bonus on Saving Throws equal to the Charisma Modifier of the paladin.", List.of()),
    AURA_OF_WARDING("The paladin and any nearby allies in a 10 ft radius have Resistance to damage from spells.", List.of()),
    BANE("Has a -1d4 penalty to Attack Rolls and Saving Throws.", List.of()),
    BANISHED("Banished from this plane of existance. Incapacitated, can't move or be targeted", List.of(INCAPACITATED, IMMOBILE)),
    BARDIC_INSPIRATION("Gains bonus to next Attack Roll, Ability Check, or Saving Throw (bonus amount depends on Bard's level).", List.of()),
    BARKSKIN("Armour Class increased to 16.", List.of()),
    BEACON_OF_HOPE("Advantage on Wisdom and Death Saving Throws. Use the highest possible dice roll when healed.", List.of()),
    BEARS_ENDURANCE("Advantage on Constitution Checks. Gains 7 Temporary HP.", List.of()),
    BEND_LUCK_BONUS("Wild magic has twisted the affected entity's fate. Gains a +1d4 bonus to Ability Checks.", List.of()),
    BEND_LUCK_PENALTY("Wild magic has twisted the affected entity's fate. Gains a -1d4 bonus to Ability Checks.", List.of()),
    BLACK_TENTACLES("Restrained by dark tendrils. Disadvantage on Attack Rolls. Affected entity can't move and takes 3d6 Bludgeoning damage per turn. Attack Rolls against the affected entity have Advantage. Strength Saving Throw to end the condition.", List.of(IMMOBILE, UNFOCUSED, VULNERABLE)),
    BLADE_WARD("Resistant to Bludgeoning, Piercing, and Slashing damage.", List.of(PHYSICAL_RESISTANCE)),
    BLEEDING("Affected entity takes 2 Slashing damage at the start of each turn. Disadvantage on Constitution Saving Throws.", List.of()),
    BLESS("Gains a +1d4 bonus to Attack Rolls and Saving Throws.", List.of()),
    BLESSING_OF_SELUNE("Weapon attacks deal an additional 1d6 Radiant damage.", List.of()),
    BLESSING_OF_THE_TRICKSTER("Advantage on Stealth Checks.", List.of()),
    BLINK("At the end of their turn, there is a chance the affected entity gets Blinked to the Ethereal Plane. They return to the Material Plane at the start of their next turn.", List.of()),
    BLINKED_TO_THE_ETHEREAL_PLANE("Affected entity is in the Ethereal Plane, where it can't be harmed, seen, or affected. Can't move or interact with anything in the world, but can choose to teleport up to 20ft.", List.of(IMMOBILE)),
    BLUDGEON_THE_WEAK("Affected entity is Vulnerable to Bludgeoning damage for 3 turns, or until it takes damage.", List.of()),
    BLURRED("Attack Rolls against the affected entity have Disadvantage, unless they do not rely on sight or can see through illusions.", List.of(ELUSIVE)),
    BOLSTERING_MAGIC_BOON("Bolstered by wild magic. Gains a +1d4 bonus to Attack Rolls and Ability Checks", List.of()),
    BONE_CHILLED("Can not regain HP. If Undead, has Disadvantage on Attack Rolls.", List.of()),
    BRACED("Advantage on Damage Rolls.", List.of()),
    BRANDING_SMITE("Can't turn Invisible", List.of()),
    BRITTLE("Taking 2d6 Cold damage damage per turn. Affected entity has been rapidly cooled while aflame, making it Vulnerable to Thunder and Bludgeoning damage.", List.of()),
    BUFOTOXIN("Disadvantage on Dexterity Saving Throws.", List.of()),
    BULLS_STRENGTH("Advantage on Strength Checks. Weight Limit doubled.", List.of()),
    BURNING("Takes 1d4 Fire damage per turn. Immune from if Wet.", List.of()),
    CALL_LIGHTNING("Can cast Call Lightning without expending a spell slot.", List.of()),
    CALMED("Can't be Charmed or Frightened, and can't Rage", List.of(CHARM_IMMUNITY, FRIGHTEN_IMMUNITY)),
    CATS_GRACE("Advantage on Dexterity Checks. Takes half falling damage.", List.of()),
    CHANNEL_DIVINITY_CLOAK_OF_SHADOWS("Advantage on Attack Rolls. Attack Rolls against the affected entity have Disadvantage. Condition ends if affected entity attacks, casts a spell, takes an Action, or takes damage.", List.of(FOCUSED, ELUSIVE)),
    CHARMED("Can't attack spellcaster. Spellcaster has Advantage on Charisma Checks in dialogue with the affected entity.", List.of()),
    CHEST_TRAUMA("Disadvantage on Constitution Saving Throws. Has one fewer Action per turn. Removed by healing.", List.of()),
    CHILLED("Affected entity is vulnerable to Cold damage and resistant to Fire damage. Applying Wet to a chilled entity will make it Frozen for 1 turn.", List.of()),
    CLOAK_OF_SHADOWS("Advantage on Attack Rolls. Attack Rolls against the affected entity have Disadvantage. Attacking, casting spells, or entering a brightly lit area ends this condition.", List.of(FOCUSED, ELUSIVE)),
    COCOONED("Trapped in a spider's web. Incapacitated and can't move. Condition ends upon taking damage or making a successful Strength Saving Throw.", List.of(INCAPACITATED, IMMOBILE)),
    COMBAT_INSPIRATION("Gains bonus to next Attack Roll, Ability Check, Saving Throw, Damage Roll or Armour Class for one attack (bonus amount depends on Bard's level).", List.of()),
    COMMAND_APPROACH("Incapacitated. Must move toward the spellcaster by the shortest route possible.", List.of(INCAPACITATED)),
    COMMAND_DROP("Incapacitated. Must drop whatever it is holding.", List.of(INCAPACITATED)),
    COMMAND_FLEE("Incapacitated. Must move away from the spellcaster by the fastest means possible.", List.of(INCAPACITATED)),
    COMMAND_GROVEL("Incapacitated and can't move. Must drop Prone.", List.of(INCAPACITATED, IMMOBILE, PRONE)),
    COMMAND_HALT("Incapacitated and can't move.", List.of(INCAPACITATED, IMMOBILE)),
    COMMANDERS_STRIKE("Affected entity can immediately use a Reaction to make a weapon attack.", List.of()),
    COMPELLED_DUEL("Can't attack creatures other than the spellcaster.", List.of()),
    CONFUSED("Affected entity must roll a d10 at the start of each of its turns to determine its behaviour for that turn. (1: Flees in a random direction. 2-6: Incapacitated and can't move. 7-8: Attacks a randomly selected creature within reach. 9-10: Acts and moves normally.)", List.of()),
    CONTAGION_BLINDING_SICKNESS("Blinded. Disadvantage on Wisdom Checks and Wisdom Saving Throws.", List.of(BLINDED)),
    CONTAGION_FILTH_FEVER("Disadvantage on Strength Checks, Strength Saving Throws and Strength Attack Rolls.", List.of()),
    CONTAGION_FLESH_ROT("Vulnerable to all damage. Disadvantage on Charisma Checks.", List.of(BLUDGEONING_VULNERABILITY, PIERCING_VULNERABILITY, SLASHING_VULNERABILITY, COLD_VULNERABILITY, FIRE_VULNERABILITY, LIGHTNING_VULNERABILITY, THUNDER_VULNERABILITY, ACID_VULNERABILITY, POISON_VULNERABILITY, RADIANT_VULNERABILITY, NECROTIC_VULNERABILITY, FORCE_VULNERABILITY, PSYCHIC_VULNERABILITY)),
    CONTAGION_MINDFIRE("Confused. Disadvantage on Intelligence Checks and Intelligence Saving Throws", List.of()),
    CONTAGION_SEIZURE("Disadvantage on Dexterity Checks, Dexterity Saving Throws and Dexterity Attack Rolls.", List.of()),
    CONTAGION_SLIMY_DOOM("Whenever the creature takes damage, it is stunned until the end of its next turn. Disadvantage on Constitution Checks and Constitution Saving Throws.", List.of()),
    CONTROLLED("This undead is under the control of a Paladin.", List.of()),
    CORROSIVE_SPIT("Takes Acid damage per turn (damage amount depends on Druid's level). Armour Class decreases by 1 per turn, to a maximum of -5. Water removes the spit and its effects.", List.of()),
    COUNTERCHARM("Advantage on Saving Throws against being Charmed or Frightened.", List.of()),
    CRAWLING_GNAW("Infected with zombie mucus. If the affected entity dies before the infection wears off, it will temporarily rise as a Newborn Zombie (They have 10 HP and the Newborn Zombie condition).", List.of()),
    CROWN_OF_MADNESS("Instilled with magical madness. Must attack the nearest creature, other than the spellcaster.", List.of()),
    CRUSADERS_MANTLE("Near a paladin's holy aura. Weapon attacks deal an additional 1d4 Radiant damage", List.of()),
    CRUSADERS_MANTLE_AURA("Emmiting a holy aura. Weapon attacks of nearby allies deal an additional 1d4 Radiant damage", List.of()),
    CURSE_OF_THE_DIRE_RAVEN("Marked by the feather of a dire raven. Attack Rolls against the affected entity have Advantage.", List.of(VULNERABLE)),
    CURSED_ADDITIONAL_DAMAGE("Receives an additional 1d8 Necrotic damage from the spellcaster's attacks or spells.", List.of()),
    CURSED_ATTACK_DISADVANTAGE("Disadvantage on Attack Rolls against the source of the curse.", List.of()),
    CURSED_CHARISMA("Disadvantage on Ability Checks and Saving Throws using Charisma.", List.of()),
    CURSED_CONSTITUTION("Disadvantage on Ability Checks and Saving Throws using Constitution.", List.of()),
    CURSED_DEXTERITY("Disadvantage on Ability Checks and Saving Throws using Dexterity.", List.of()),
    CURSED_DREAD("Each turn, the affected entity must succeed on a Wisdom Saving Throw or skip its turn.", List.of()),
    CURSED_INTELLIGENCE("Disadvantage on Ability Checks and Saving Throws using Intelligence.", List.of()),
    CURSED_STRENGTH("Disadvantage on Ability Checks and Saving Throws using Strength.", List.of()),
    CURSED_WISDOM("Disadvantage on Ability Checks and Saving Throws using Wisdom.", List.of()),
    DARK_ONES_BLESSING("Whenever it reduces a hostile creature to 0 HP, affected entity gains temporary HP equal to its Charisma modifier and Warlock level combined.", List.of()),
    DARKNESS("In the dark.", List.of()),
    DARKVISION("Can see in the dark up to the range of 40 ft.", List.of()),
    DAZED("Disadvantage on Wisdom Saving Throws, can't take Reactions, and loses the Dexterity bonus to their Armour Class.", List.of(DULL)),
    DEAD("This creature is dead.", List.of()),
    DEAFENED("Affected entity can't hear. Attack Rolls against the affected entity have Advantage. Unaffected by Bardic Inspiration.", List.of(VULNERABLE)),
    DEATH_WARD("The next time damage would reduce the affected entity to 0 HP. it remains conscious with 1 HP left.", List.of()),
    DEFENSIVE_FLOURISH("Armour Class increased by 4", List.of()),
    DETECT_THOUGHTS("Can read the thoughts of any creature with Intelligence higher than 3.", List.of()),
    DIFFICULT_TERRAIN("Movement Speed halved.", List.of()),
    DISGUISE_SELF("Appearance is entirely changed.", List.of()),
    DISPEL_EVIL_AND_GOOD("Aberrations, Celestials, Elementals, Fey, Fiends, and Undead have Disadvantage against the affected entity. If the affected entity touches an ally that is Charmed or Frightened, it breaks the enchantment. Affected entity can attempt to drive a creature back to its home plane by making a melee spell attack against a Celestial, an Elemental, a Fey, a Fiend, or an Undead - enemy must succeed on a Charisma Saving Throw or be sent back to its home plane.", List.of()),
    DISTRACTED("The distractor's allies have Advantage on their next Attack Roll against the creature.", List.of()),
    DIVINE_FAVOUR("Affected entity's weapons deal an additional 1d4 Radiant damage.", List.of()),
    DIVINE_SENSE("Advantage against Celestials, Fiends, and Undead.", List.of()),
    DOMINATED("Affected entity is under the control of the caster. Each time it takes damage, it can break the spell by making a successful Wisdom Saving Throw. ", List.of()),
    DOWNED("Unconscious. Death Saving Throws must be rolled each turn. Any damage received counts as one failure. Can be removed by healing or when Helped.", List.of(UNCONSCIOUS)),
    DREAD_AMBUSHER("Movement Speed increased by 10 ft. Affected entity can make an extra weapon attack that deals an additional 1d8 damage.", List.of()),
    DRUNK("Strength increased by 1. Disadvantage on Dexterity and Charisma Checks.", List.of()),
    EAGLES_SPLENDOR("Advantage on Charisma Checks.", List.of()),
    ELDRITCH_STRIKE("Disadvantage on next Saving Throw against caster.", List.of()),
    ELECTROCUTED("Takes 1d4 Lightning damage per turn.", List.of()),
    ELEMENTAL_AFFINITY_ACID_RESISTANCE("Resistant to Acid damage.", List.of(ACID_RESISTANCE)),
    ELEMENTAL_AFFINITY_COLD_RESISTANCE("Resistant to Cold damage.", List.of(COLD_RESISTANCE)),
    ELEMENTAL_AFFINITY_FIRE_RESISTANCE("Resistant to Fire damage.", List.of(FIRE_RESISTANCE)),
    ELEMENTAL_AFFINITY_LIGHTNING_RESISTANCE("Resistant to Lightning damage.", List.of(LIGHTNING_RESISTANCE)),
    ELEMENTAL_AFFINITY_POISON_RESISTANCE("Resistant to Poison damage.", List.of(POISON_RESISTANCE)),
    ELVEN_ELEGANCE("Noble elven arcana grants the affected entity an additional 20 ft Movement Speed and Superior Darkvision until Long Rest.", List.of()),
    ENCUMBERED("Carrying too much weight. Jump distance halved. Movement Speed reduced by 10 ft.", List.of()),
    ENHANCED_LEAP("Jump distance is tripled.", List.of()),
    ENLARGED("Size is increased. Weapon attacks deal 1d4 more damage. Advantage on Strength Checks and Saving Throws.", List.of()),
    ENTHRALLED("Peripheral vision reduced. Must keep looking at the spellcaster.", List.of()),
    ENTROPIC_WARD("Missed an attack on a warlock. The warlock has Advantage on their next Attack Roll against the affected entity.", List.of()),
    EVASIVE_FOOTWORK("Enemies have Disadvantage on melee Attack Rolls against the affected entity", List.of()),
    EXHAUSTED_1("Disadvantage on Ability Checks.", List.of()),
    EXHAUSTED_2("Movement Speed halved.", List.of(EXHAUSTED_1)),
    EXHAUSTED_3("Disadvantage on Attack Rolls and Saving Throws.", List.of(EXHAUSTED_2, UNFOCUSED)),
    EXHAUSTED_4("HP maximum halved.", List.of(EXHAUSTED_3)),
    EXHAUSTED_5("Can't move.", List.of(EXHAUSTED_4, IMMOBILE)),
    EXPEDITIOUS_RETREAT("Dash available as a Bonus Action.", List.of()),
    EYEBITE_SICKENED("Disadvantage on Attack Rolls and Ability Checks.", List.of(UNFOCUSED)),
    FANGS_OF_THE_FIRE_SNAKE("Affected entity's melee attacks deal an additional 1d4 Fire damage.", List.of()),
    FEARFUL("Incapacitated. Affected entity must run from the source of its fear. Disadvantage on Ability Checks and Attack Rolls. Makes a Saving Throw to end the condition if its turn is ended out of sight from the source of fear.", List.of()),
    FEATHER_FALL("Rate of falling is slowed, granting Immunity to falling damage", List.of()),
    FEEBLE("Deals half damage with weapon attacks that use Strenth. At the end of each turn, affected entity makes a Constitution Saving Throw to end the condition.", List.of()),
    FEIGNING_DEATH("Sunk into a deep magical coma. Incapacitated and can't move. Resistant to all damage except Psychic damage.", List.of(INCAPACITATED, IMMOBILE, BLUDGEONING_RESISTANCE, PIERCING_RESISTANCE, SLASHING_RESISTANCE, COLD_RESISTANCE, FIRE_RESISTANCE, LIGHTNING_RESISTANCE, THUNDER_RESISTANCE, ACID_RESISTANCE, POISON_RESISTANCE, RADIANT_RESISTANCE, NECROTIC_RESISTANCE, FORCE_RESISTANCE)),
    FIRE_SHIELD_CHILL("Sheds light in a 10 ft radius. Resistant to Fire damage. Deals 2d8 Cold damage to anyone who hits with a melee attack.", List.of()),
    FIRE_SHIELD_WARM("Sheds light in a 10 ft radius. Resistant to Cold damage. Deals 2d8 Fire damage to anyone who hits with a melee attack.", List.of()),
    FLAMING_SPHERE("Enemies and objects within 5 ft of the sphere at end of their turn take 2d6 Fire damage. Dexterity Saving Throw.", List.of()),
    FLESH_TO_STONE("Affected entity can't move as its body begins to petrify over the course of 3 turns. Attack Rolls against it have Advantage, while the entity's Attack Rolls and Dexterity Saving Throws have Disadvantage.", List.of(IMMOBILE, VULNERABLE, UNFOCUSED)),
    FLIGHT("Can Fly to target position, up to 60 ft each turn. Spends Movement Speed.", List.of()),
    FORCED_MANOEUVRE("Movement Speed increased by half and doesn't provoke Opportunity Attacks.", List.of()),
    FOXS_CUNNING("Advantage on Intelligence Checks.", List.of()),
    FREEDOM_OF_MOVEMENT("Movement Speed can't be reduced by Difficult Terrain, spells or magical effects. Can't be Paralyzed or Restrained.", List.of()),
    FRENZIED("In Rage. Can use Frenzied Strike and Enraged Throw. When Frenzy ends, suffers one level of exhaustion.", List.of(RAGE)),
    FRENZIED_STRIKE("The barbarian takes a -1 penalty on Attack Rolls for every stack. All stacks are removed when Frenzy ends.", List.of()),
    FRIENDS("Caster has Advantage on Charisma Checks directed at the affected entity.", List.of()),
    FRIGHTENED("Can't move. Disadvantage on Ability Checks and Attack Rolls.", List.of(IMMOBILE, UNFOCUSED)),
    FROZEN("Incapacitated. Vulnerable to Bludgeoning, Thunder, and Force damage. Resistant to Fire damage. Immune to Burning. If it is dealt Bludgeoning, Thunder, or Force damage, the ice shatters, ending the condition.", List.of(INCAPACITATED, BLUDGEONING_VULNERABILITY, THUNDER_VULNERABILITY, FORCE_VULNERABILITY, FIRE_RESISTANCE)),
    GAPING_WOUNDS("Attacks against this creature deal an additional 2 Piercing damage. Removed by healing.", List.of()),
    GASEOUS_FORM("Transformed into a cloud of mist. Resistant to all damage. Advantage on Constitution, Dexterity, and Strength Saving Throws. Becomes Tiny in size. Can't attack, cast spells, or speak. The affected entity's Strength and Dexterity scores are set to 10 while in this form.", List.of(BLUDGEONING_RESISTANCE, PIERCING_RESISTANCE, SLASHING_RESISTANCE, COLD_RESISTANCE, FIRE_RESISTANCE, LIGHTNING_RESISTANCE, THUNDER_RESISTANCE, ACID_RESISTANCE, POISON_RESISTANCE, RADIANT_RESISTANCE, NECROTIC_RESISTANCE, FORCE_RESISTANCE, PSYCHIC_RESISTANCE)),
    GIANTS_RAGE("In Rage. Increased size.",List.of(RAGE, ENLARGED)),
    GOADED("Must attack the goading creature, if possible. Disadvantage against targets other than the spellcaster.", List.of()),
    GRAPPLED("Can't move. Condition ends if the grappler is Incapacitated or an effect removes the grappled creature from the reach of the grappler, such as when a creature is hurled away by the thunderwave spell.", List.of(IMMOBILE)),
    GREAT_WEAPON_MASTER("If affected entity kills a target or lands a Critical Hit with a melee weapon, it can use a Bonus Action to make another melee weapon attack.", List.of()),
    GREAT_WEAPON_MASTER_ALL_IN("When attacking with a Two-Handed or Versatile melee weapon (in both hands) that affected entity is Proficient with, Attack Rolls take a -5 penalty, but their damage increases by 10.", List.of()),
    GREATER_INVISIBLITY("Advantage on Attack Rolls. Attack Rolls against the affected entity have Disadvantage.", List.of(FOCUSED, ELUSIVE)),
    GUIDANCE("Gains a +1d4 bonus to Ability Checks.", List.of()),
    GUIDED_STRIKE("Gains a +10 bonus to its next Attack Roll.", List.of()),
    GUIDING_BOLT("Glowing with mystical dim light. The next Attack Roll made against the affected entity has Advantage", List.of()),
    HAMSTRUNG("Movement Speed halved. Removed by healing.", List.of()),
    HARM("Affected entity's maximum HP has been reduced by the damage inflicted by the Harm spell. This condition is a Disease", List.of()),
    HASTENED("Gains +2 to Armour Class and Advantage on Dexterity Saving Throws. Movement Speed is increased by 30ft. Gains an additional Action. When the condition ends, affected entity becomes Lethargic (Incapacitated and can't move) for 1 turn.", List.of()),
    HEALING_RADIANCE("Allies within 10 ft will regain {Proficiency Bonus + Paladin Level + Charisma Modifier} HP at the start of the Paladin's next turn.", List.of()),
    HEAVILY_ENCUMBERED("Carrying far too much weight. Movement Speed reduced to 1 square. Can't cimb or jump. Disadvantage on Ability Checks and Attack Rolls, as well as Strength, Dexterity, and Constitution Saving Throws.", List.of()),
    HEROES_FEAST("HP maximum increased by 12 points. Gains 12 HP. Immune to poison. Can't be Frightened. Advantage on Wisdom Saving Throws.", List.of(FRIGHTEN_IMMUNITY, POISON_IMMUNITY)),
    HEROISM("Can't be Frightened. Receive 5 temporary HP at the start of each turn.", List.of(FRIGHTEN_IMMUNITY)),
    HEXED_CHA("Takes an additional 1d6 Necrotic damage from the spellcaster. Disadvantage on Charisma Checks.", List.of()),
    HEXED_CON("Takes an additional 1d6 Necrotic damage from the spellcaster. Disadvantage on Constitution Checks.", List.of()),
    HEXED_DEX("Takes an additional 1d6 Necrotic damage from the spellcaster. Disadvantage on Dexterity Checks.", List.of()),
    HEXED_INT("Takes an additional 1d6 Necrotic damage from the spellcaster. Disadvantage on Intelligence Checks.", List.of()),
    HEXED_STR("Takes an additional 1d6 Necrotic damage from the spellcaster. Disadvantage on Strength Checks.", List.of()),
    HEXED_WIS("Takes an additional 1d6 Necrotic damage from the spellcaster. Disadvantage on Wisdom Checks.", List.of()),
    HIDE_IN_PLAIN_SIGHT("Affected entity is Invisible. Gains a +10 bonus to Stealth Checks. Invisibility ends early if the invisible entity moves, attacks, casts another spell, takes an Action, or takes damage.", List.of()),
    HIDEOUS_LAUGHTER("Incapacitated and can't move. Prone. Disadvantage on Strength and Dexterity Saving Throws. At the end of its turn or when it takes damage, affected entity makes a Wisdom Saving Throw to end the condition.", List.of(INCAPACITATED, IMMOBILE, PRONE)),
    HOLD_MONSTER("Incapacitated and can't move. Automatically fails all Strength and Dexterity Saving Throws. Attack Rolls against the affected entity have Advantage. Melee attacks against the affected entity are always Critical Hits.", List.of(INCAPACITATED, IMMOBILE, VULNERABLE)),
    HOLD_PERSON("Incapacitated and can't move. Automatically fails all Strength and Dexterity Saving Throws. Attack Rolls against the affected entity have Advantage. Melee attacks against the affected entity are always Critical Hits.", List.of(INCAPACITATED, IMMOBILE, VULNERABLE)),
    HOLY_REBUKE("Attackers take 1d4 Radiant damage when they hit the affected entity with a melee attack.", List.of()),
    HORDE_BREAKER("Creature is open to a follow-up attack.", List.of()),
    HUNTERS_MARK("Takes an additional 1d6 damage if the spellcaster hits it with a weapon attack.", List.of()),
    HYPNOTIC_GAZE("Incapacitated and can't move. Spellcaster has Advantage on Ability Checks in dialogue. Removed upon taking damage. Duration can be extended with Maintain Hypnotic Gaze", List.of(INCAPACITATED, IMMOBILE)),
    HYPNOTIZED("Incapacitated and can't move. Removed by taking damage, being Shoved, or Helped", List.of(INCAPACITATED, IMMOBILE)),
    INCITING_HOWL("Movement Speed increased by 10 ft.", List.of()),
    INFECTED("Disadvantage on Constitution Saving Throws, and Constitution is reduced by 1.", List.of()),
    INSTINCTIVE_CHARM_UNAFFECTED("Can't be affected by Instinctive Charm until Long Rest.", List.of()),
    INVISIBLE("Advantage on Attack Rolls. Attack Rolls against affected entity have Disadvantage. Invisibility ends early if the invisible entity attacks, casts a spell, interacts with an object, takes an Action or Bonus Action, or is damaged.", List.of(FOCUSED, ELUSIVE)),
    INVULNERABLE("Immune to all damage. Can still be afflicted with status effects.", List.of(BLUDGEONING_IMMUNITY, PIERCING_IMMUNITY, SLASHING_IMMUNITY, COLD_IMMUNITY, FIRE_IMMUNITY, LIGHTNING_IMMUNITY, THUNDER_IMMUNITY, ACID_IMMUNITY, POISON_IMMUNITY, RADIANT_IMMUNITY, NECROTIC_IMMUNITY, FORCE_IMMUNITY, PSYCHIC_IMMUNITY)),
    IRRESISTIBLE_DANCE("Can't move or take Actions. Disadvantage on Attack Rolls and Dexterity Saving Throws. Attack Rolls against the affected entity have Advantage.", List.of(IMMOBILE, VULNERABLE, UNFOCUSED, VULNERABLE)),
    KNOWLEDGE_OF_THE_AGES_CHA("Gains Proficiency in Deception, Intimidation, Performance, and Persuasion until Long Rest.", List.of()),
    KNOWLEDGE_OF_THE_AGES_DEX("Gains Proficiency in Acrobatics, Sleight of Hand, and Stealth until Long Rest.", List.of()),
    KNOWLEDGE_OF_THE_AGES_INT("Gains Proficiency in Arcana, History, Investigation, Nature, and Religion until Long Rest.", List.of()),
    KNOWLEDGE_OF_THE_AGES_STR("Gains Proficiency in Athletics until Long Rest.", List.of()),
    KNOWLEDGE_OF_THE_AGES_WIS("Gains Proficiency in Animal Handling, Insight, Medicine, Perception, and Survival until Long Rest.", List.of()),
    KNOWN_ENEMY("An observant enemy has Advantage against the affected entity after examining it.", List.of()),
    LETHARGIC("Consumed by exhaustion in the aftermath of Haste. Incapacitated and can't move.", List.of(INCAPACITATED, IMMOBILE)),
    LONGSTRIDER("Movement Speed increased by 10 ft.", List.of()),
    LURED("Attracted to a harpy's luring melody. Must move toward the harpy by the shortest route possible. Makes a 13 DC Wisdom Saving Throw each turn. Being attacked or Shoved will remove the condition.", List.of()),
    MAGE_ARMOUR("If unarmoured, Armour Class becomes 13 + Dexterity Modifier.", List.of()),
    MAGIC_AWARENESS("The barbarian and all creatures within 10 ft add their Proficiency Bonus to Saving Throws against spells.", List.of()),
    MAGICAL_AMBUSH("Affected entity is hidden. Creatures have Disadvantage on Saving Throws against its spells.", List.of()),
    MAIMED("Can't move. Disadvantage on Dexterity Saving Throws. Removed by healing.", List.of(IMMOBILE)),
    MARTIAL_ARTS_BONUS_UNARMED_STRIKE("After making an attack with a Monk Weapon or while unarmed, the affected entity can make another unarmed attack as a Bonus Action.", List.of()),
    MOBILE("Movement Speed increased by 10ft and doesn't provoke melee Opportunity Attacks. Isn't slowed down by Difficult Terrain while Dashing.", List.of()),
    MULTIATTACK_DEFENCE("Affected entity has a -4 penalty to Attack Rolls against the ranger it just attacked.", List.of()),
    NATURES_WRATH("Can't move. Disadvantage on Attack Rolls and Dexterity Saving Throws. Attack Rolls against the affected entity have Advantage.", List.of(IMMOBILE, UNFOCUSED, VULNERABLE)), // TODO remove and change spell description to "Restrain"
    NAUSEOUS("Can't take Actions.", List.of()),
    NEWBORN_ZOMBIE("Takes 1 Necrotic damage per turn.", List.of()),
    OFF_BALANCE("Disadvantage on Strength and Dexterity Ability Checks. Attack Rolls against the affected entity have Advantage. Removed by taking damage or when Helped.", List.of(VULNERABLE)),
    OIL_OF_COMBUSTION("If the affected entity takes Fire damage, it deals 3d6 Fire damage in a 10 ft radius AoE.", List.of()),
    ONE_MIRROR_IMAGE("Increases Armour Class by 3. On a successful attack evasion, one of the images disappears.", List.of()),
    ONE_WITH_THE_SHADOWS("Affected entity is Invisible. Invisibility ends early if the invisible entity moves, attacks, casts another spell, takes an Action, or takes damage.", List.of()),
    OWLS_WISDOM("Advantage on Wisdom Checks.", List.of()),
    // PACIFIED ?
    PASS_WITHOUT_TRACE("This entity and nearby allies have a +10 bonus to Stealth Checks.", List.of()),
    PATIENT_DEFENCE(" Advantage on Dexterity Saving Throws. Attack Rolls against the affected entity have Disadvantage.", List.of(ELUSIVE)),
    PETRIFIED("Incapacitated, can't move or speak, and is unaware of its surroundings. Automatically fails Strength and Dexterity Saving Throws. Resistant to all damage. Immune to poison and disease.", List.of(INCAPACITATED, IMMOBILE, POISON_IMMUNITY, DISEASE_IMMUNITY, BLUDGEONING_RESISTANCE, PIERCING_RESISTANCE, SLASHING_RESISTANCE, COLD_RESISTANCE, FIRE_RESISTANCE, LIGHTNING_RESISTANCE, THUNDER_RESISTANCE, ACID_RESISTANCE, RADIANT_RESISTANCE, NECROTIC_RESISTANCE, FORCE_RESISTANCE, PSYCHIC_RESISTANCE)), //TODO silenced?
    PHANTASMAL_FORCE("Takes 1d6 Psychic damage per turn. When the affected entity takes damage from another source, Phantasmal Force changes to that damage type. At the end of each turn, the affected entity makes an Intelligence Saving Throw to end the condition.", List.of()),
    PHANTASMAL_KILLER("Can't move and takes 4d10 + 1d10 per upcast level Psychic damage per turn. Disadvantage on Ability Checks and Attack Rolls.", List.of(IMMOBILE, UNFOCUSED)),
    PLANAR_BINDING("Affected entity follows and fights for the one who has bound it. Every time it takes damage, it may break the caster's control over it with a successful Wisdom Saving Throw.", List.of()),
    POISONED("Disadvantage on Attack Rolls and Ability Checks. Takes 1d4 Poison damage per turn.", List.of(UNFOCUSED)),
    POLYMORPHED("Creature is turned into a harmless animal with 3 HP. If it's HP is reduced to 0, the creature reverts to its original form with its original HP.", List.of()),
    PRECISION_ATTACK("Gains a bonus to its next weapon Attack Roll equal to its Superiority Die.", List.of()),
    PREPARED("Melee attacks deal additional Slashing damage equal to caster's Strength Modifier.", List.of()),
    PROPHECY_A_BLUNT_TOOL("Dealing at least 1 Bludgeoning damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_A_LITTLE_HELP("Casting an Conjuration spell will result in a new Portent Die.", List.of()),
    PROPHECY_A_LITTLE_PRICK("Dealing at least 1 Piercing damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_BURN_AFTER_READING("Dealing at least 1 Fire damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_CHANGES("Casting an Transmutation spell will result in a new Portent Die.", List.of()),
    PROPHECY_CUTTING_EDGE("Dealing at least 1 Slashing damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_DEAD_RIGHT("Casting an Necromancy spell will result in a new Portent Die.", List.of()),
    PROPHECY_DELIVERING_ALMS("Helping an ally will result in a new Portent Die.", List.of()),
    PROPHECY_EVOCATIVE("Casting an Evocation spell will result in a new Portent Die.", List.of()),
    PROPHECY_FEIGN_SURPRISE("Casting an Illusion spell will result in a new Portent Die.", List.of()),
    PROPHECY_FORCEFUL_INSISTENCE("Dealing at least 1 Force damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_FROSTY_RECEPTION("Dealing at least 1 Cold damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_GRAVE_FATE("Dealing at least 1 Necrotic damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_GUARDED("Casting an Abjuration spell will result in a new Portent Die.", List.of()),
    PROPHECY_HEADACHE("Dealing at least 1 Psychic damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_HOLY_EPIPHANY("Dealing at least 1 Radiant damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_MELTING_POT("Dealing at least 1 Acid damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_PREDICTABLE("Casting a Divination spell will result in a new Portent Die.", List.of()),
    PROPHECY_REAP_REWARDS("Dealing the killing blow to an enemy will result in a new a Portent Die after taking a short rest.", List.of()),
    PROPHECY_SCHOCKING_REVELATION("Dealing at least 1 Lightning damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_SPELLBINDING("Casting an Enchantment spell will result in a new Portent Die.", List.of()),
    PROPHECY_THUNDEROUS_APPLAUSE("Dealing at least 1 Thunder damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_VENOMOUS_WORDS("Dealing at least 1 Poison damage to an enemy will result in a new Portent Die.", List.of()),
    PROPHECY_WELL_READ("Learning from or using a Spell Scroll will result in a new Portent Die.", List.of()),
    PROTECTION_FROM_EVIL_AND_GOOD("Can't be Charmed or Frightened. Aberrations, Celestials, Elementals, Fey, Fiends, and Undead have Disadvantage against the affected entity.", List.of(CHARM_IMMUNITY, FRIGHTEN_IMMUNITY)),
    PROTECTION_FROM_POISON("All previous Poison effects are removed. Gains Resistance to Poison damage and Advantage on Saving Throws against being Poisoned", List.of()),
    PROWLING("Stalking its prey. While Invisible, the affected entity's next attack deals an additional 1d8 damage.", List.of()),
    RAGE_BOAR("In Rage. Becomes Enlarged. Deals an additional 2 Slashing damage. Resistant to physical damage, Advantage on Strength Checks and Saving Throws. Rage ends early if the boar hasn't attacked an enemy or taken damage since their last turn.", List.of(RAGE)),
    RAGE_BEAR_HEART("In Rage. Can use Unrelenting Ferocity. Resistant to all damage types except Psychic.", List.of(RAGE, BLUDGEONING_RESISTANCE, PIERCING_RESISTANCE, SLASHING_RESISTANCE, COLD_RESISTANCE, FIRE_RESISTANCE, LIGHTNING_RESISTANCE, THUNDER_RESISTANCE, ACID_RESISTANCE, POISON_RESISTANCE, RADIANT_RESISTANCE, NECROTIC_RESISTANCE, FORCE_RESISTANCE)),
    RAGE_EAGLE_HEART("In Rage. Can use Diving Strike. Can use Dash as a Bonus Action. Opportunity Attacks against the affected entity have Disadvantage.", List.of(RAGE)),
    RAGE_ELK_HEART("In Rage. Can use Primal Stampede. Movement Speed increased by 15 ft.", List.of(RAGE)),
    RAGE_TIGER_HEART("In Rage. Can use Tiger's Bloodlust. Jump distance increased by 15 ft.", List.of(RAGE)),
    RAGE_WOLF_HEART("In Rage. Can use Inciting Howl. Allies have melee Advantage against enemies within 7ft of affected entity.", List.of(RAGE)),
    RAY_OF_FROST("Movement Speed reduced by 10ft.", List.of()),
    REAPPLY_HEX("Can recast Hex without expending a new spell slot.", List.of()),
    RECAST_SPEAK_WITH_DEAD("Can recast Speak with Dead without expending a spell slot.", List.of()),
    RECKLESS_ATTACK("Advantage on Attack Rolls. Attack Rolls against the affected entity also have Advantage.", List.of(FOCUSED, VULNERABLE)),
    REDUCED("Size is reduced. Weapon attacks deal 1d4 less damage. Disadvantage on Strength Checks and Saving Throws. Carrying Capacity reduced by 25%.", List.of()),
    RELENTLESS_AVENGER("Gain 15ft bonus Movement Speed", List.of()),
    RESILIENT_SPHERE("Enclosed in an arcane sphere. Affected entity can't be damaged by attacks or effects from outside the sphere, nor can it damage anything outside the sphere. Movement Speed halved.", List.of()),
    RESISTANCE("Gains a +1d4 bonus to Saving Throws.", List.of()),
    RESISTED_THE_SONG("Succeeded a Saving Throw against the harpy's Luring Song and is immune to the effects for 2 turns.", List.of()),
    RESONATING_KI("The ki within the affected entity is resonating with a monk's.", List.of()),
    RESTRAINED("Can't move. Disadvantage on Attack Rolls and Dexterity Saving Throws. Attack Rolls against the affected entity have Advantage.", List.of(IMMOBILE, UNFOCUSED, VULNERABLE)),
    SANCTUARY("Can't be targeted by enemy attacks or spells, but it can still take damage from AoE effects. Condition ends if the affected entity attacks or harms another creature, and will receive Sanctuary Blocked for 1 turn.", List.of()),
    SANCTUARY_BLOCKED("Can't receive Sanctuary", List.of()),
    SEARING_SMITE("Takes 1d6 Fire damage per turn. Condition ends upon making a successful Constitution Saving Throw.", List.of()),
    SEE_INVISIBILITY("Can see Invisible creatures within 30ft. Creatures must succeed a Dexterity Saving Throw or become revealed to others and lose their Invisibility.", List.of()),
    SEPTIC("Constitution reduced by 1. Disadvantage on Constitution Saving Throws", List.of()),
    SHADOW_STEP("Gains Advantage on next melee Attack Roll", List.of()),
    SHIELD("Gains +5 bonus to Armour Class. Immune to Magic Missile.", List.of()),
    SHIELD_OF_FAITH("Gains +2 bonus to Armour Class.", List.of()),
    SHILLELAGH("Staff or Club becomes magical and deals 1d8 + Wisdom Modifier Bludgeoning damage. Attack Rolls use the wielder's Spellcasting Ability Modifier.", List.of()),
    SHOCKED("Can't take Reactions. Disadvantage on Ability Checks and Saving Throws using Dexterity.", List.of(DULL)),
    SHOCKING_GRASP("Can't take Reactions.", List.of(DULL)),
    SHRED_ARMOUR("Armour Class has been reduced by 2. Removed by healing.", List.of()),
    SILENCED("Can't speak or cast spells. Immune to Thunder damage.", List.of()),
    SINGING("The harpy Lures nearby creatures with a magical melody.", List.of()),
    SLEEPING("Unconscious. Removed by taking damage, getting wet, being Helped or Shoved", List.of(UNCONSCIOUS)),
    SLOWED("Movement Speed is halved. Has a -2 penalty to Armour Class and Dexterity Saving Throws. Can only take an Action or a Bonus Action, not both. Can't take Reactions. Can't make more than 1 attack per turn. When casting a spell, roll a d20: On an 11 or higher, the spell is delayed for one turn. At the end of each turn, affected entity makes a Wisdom Saving Throw to end the condition.", List.of(DULL)),
    SPEAK_WITH_ANIMALS("Can comprehend and communicate with beasts.", List.of()),
    SPIRIT_GUARDIANS_RADIANT("Enemies in the 15ft radius aura of the caster are on difficult terrain and take 3d8 Radiant damage when they first enter the area on a turn or start their turn in it. Damage is halved upon making a successful Wisdom Saving Throw.", List.of()),
    SPIRIT_GUARDIANS_NECROTIC("Enemies in the 15ft radius aura of the caster are on difficult terrain and take 3d8 Necrotic damage when they first enter the area on a turn or start their turn in it. Damage is halved upon making a successful Wisdom Saving Throw.", List.of()),
    SPITEFUL_SUFFERING("Takes 1d4 + Caster's Charisma Modifier Necrotic damage each turn and Attack Rolls against it have Advantage.", List.of()),
    SPREADING_SPORES("Takes 2d8 Necrotic damage per turn.", List.of()),
    STAGGERED("Can't take Reactions.", List.of(DULL)),
    // STEP_OF_THE_WIND ??
    STONESKIN("Resistant to Bludgeoning, Piercing, and Slashing damage.", List.of(PHYSICAL_RESISTANCE)),
    STUNNED("Incapacitated and can't move. Automatically fails Strength and Dexterity Saving Throws.", List.of(INCAPACITATED, IMMOBILE)), // Attack Rolls against affected entity have Advantage ??
    SUNLIGHT_HYPERSENSITIVITY("Takes 20 Radiant damage if it starts its turn in sunlight. While sunlit, has Disadvantage on Attack Rolls and Ability Checks.", List.of()),
    SURPRISED("Can't move, take Actions or Reactions.", List.of(IMMOBILE)),
    SYMBIOTIC_ENTITY("Gains 4 Temporary HP per Druid level. Melee attacks deal an additional +1d6 Necrotic damage, and it deals double damage with Halo of Spores. Ends early if the entity uses Wild Shape.", List.of()),
    TELEKINESIS("Once per turn, you can use Telekinesis again without expending a Spell Slot.", List.of()),
    TEMPESTOUS_MAGIC_FLY("Can Fly as Bonus Action", List.of()),
    THAUMATURGY("Advantage on Intimidation and Performance Checks", List.of()),
    THIRD_EYE_DARKVISION("Can see in the dark up to the range of 80ft.", List.of()),
    THREATENED("An enemy is close. Disadvantage on ranged Attack Rolls. Moving will provoke opportunity attack.",List.of()),
    TIDES_OF_CHAOS("Increased chance of Wild Magic surge (DC 11). Condition ends after rolling a Wild Magic check.", List.of()),
    TRANSMUTATION_STONE_CONSTITUTION("Proficiency in Constitution Saving Throws", List.of()),
    TRANSMUTATION_STONE_DEPLETED_MAGIC("Recently created a Transmuter's Stone. Needs to cast a Transmutation spell of Level 1 or higher or take a Long Rest before it can create another one.", List.of()),
    TRANSMUTATION_STONE_MOVEMENT_SPEED("Movement Speed increased by 10ft.", List.of()),
    TRUE_STRIKE("Spellcaster has Advantage on Attack Rolls against the affected entity.", List.of()),
    TURNED("Incapacitated. Must run as far away from caster as it can. Condition ends upon taking damage.", List.of(INCAPACITATED)),
    UMBRAL_SHROULD("Invisible if obscured in shadows.", List.of()),
    UNDEAD_FORTITUDE("When reduced to 0 hit points, regain 1 hit point instead, unless hit with a Critical Hit or Radiant damage.", List.of()),
    VAMPIRIC_TOUCH("Can recast Vampiric Touch without expending a Spell Slot.", List.of()),
    VAPRAKS_GREED("Carrying capacity increased by 25%", List.of()),
    VISCIOUS_MOCKERY("Disadvantage on next Attack Roll.", List.of(UNFOCUSED)),
    VOW_OF_ENMITY("Spellcaster has Advantage on Attack Rolls against the affected entity.", List.of()),
    WARDEN_OF_VITALITY("Can use Restore Vitality to heal itself or nearby allies.", List.of()),
    WARDING_BOND_ALLY("Gains a +1 bonus to Armour Class and Saving throws. Resistant to all damage. Each time the affected entity takes damage, the caster takes the same amount of damage.", List.of(BLUDGEONING_RESISTANCE, PIERCING_RESISTANCE, SLASHING_RESISTANCE, COLD_RESISTANCE, FIRE_RESISTANCE, LIGHTNING_RESISTANCE, THUNDER_RESISTANCE, ACID_RESISTANCE, POISON_RESISTANCE, RADIANT_RESISTANCE, NECROTIC_RESISTANCE, FORCE_RESISTANCE, PSYCHIC_RESISTANCE)),
    WARDING_BOND_CASTER("Bound to an ally. Each time the ally takes damage, the caster takes the same amount of damage.", List.of()),
    WAR_GODS_BLESSING("Gains a +10 bonus to its next Attack Roll.", List.of()),
    WEAK_GRIP("Disadvantage on Attack rolls and Strength Saving throws.", List.of(UNFOCUSED)),
    WET("Immune to Burning. Resistant to Fire damage. Vulnerable to Lightning and Cold damage.", List.of(FIRE_RESISTANCE, LIGHTNING_VULNERABILITY, COLD_VULNERABILITY)),
    WHOLENESS_OF_BODY("Has an extra Bonus Action and regains 1 Ki Point per turn.", List.of()),
    WILD_SHAPE_AIR_MYRMIDON("Wild shaped into an Air Myrmidon.", List.of()),
    WILD_SHAPE_BADGER("Wild shaped into a Badger.", List.of()),
    WILD_SHAPE_CAT("Wild shaped into a Cat.", List.of()),
    WILD_SHAPE_CAVE_BEAR("Wild shaped into a Cave Bear.", List.of()),
    WILD_SHAPE_DEEP_ROTHE("Wild shaped into Deep Rothé.", List.of()),
    WILD_SHAPE_DILOPHOSAURUS("Wild shaped into Dilophosaurus.", List.of()),
    WILD_SHAPE_DIRE_RAVEN("Wild shaped into Dire Raven.", List.of()),
    WILD_SHAPE_DIRE_WOLF("Wild shaped into Dire Wolf.", List.of()),
    WILD_SHAPE_EARTH_MYRMIDON("Wild shaped into Earth Myrmidon.", List.of()),
    WILD_SHAPE_FIRE_MYRMIDON("Wild shaped into Fire Myrmidon.", List.of()),
    WILD_SHAPE_GIANT_SPIDER("Wild shaped into Giant Spider.", List.of()),
    WILD_SHAPE_OWLBEAR("Wild shaped into Owlbear.", List.of()),
    WILD_SHAPE_PANTHER("Wild shaped into a Panther.", List.of()),
    WILD_SHAPE_POLAR_BEAR("Wild shaped into a Polar Bear.", List.of()),
    WILD_SHAPE_RAT("Wild shaped into a rat.", List.of()),
    WILD_SHAPE_SABRE_TOOTHED_TIGER("Wild shaped into a Sabre-Toothed Tiger.", List.of()),
    WILD_SHAPE_WATER_MYRMIDON("Wild shaped into a Water Myrmidon.", List.of()),
    WITCH_BOLT("Linked to caster. Caster can use an Action to recast the spell and deal 1d12 Lightning damage.", List.of()), // TODO does this only work on the same target??







    // add bleeding, open wound, rotting, flesh rot (do i need to add to disease status group ?)
    

    // Inquisitor's Might spell doesn't exist

    // Undead (vulnerable to radiant) and other similiar traits - check both PH/DMG and bg3 wiki for info about racial passives
    // Blindsight, Truesight ?
    // Concentration here or just on creature ?
    // Ethereal? - can't be Shoved, Thrown, or used as an Improvised Melee Weapon

    // STARVATION
    // DEHYDRATION
    // TEMPERATURE

    ;
    // Features (proficiencies, racial traits, class traits, passives)
    // Feats // Character.addFeat(FEAT.blabla); Character.addBuff(Buff.STR_IMPROVEMENT, Duration.UNLIMITED) - increases STR by 1
    // Athlete feat has free stand up from prone
    // @formatter:on

    // https://bg3.wiki/w/index.php?title=Special:CargoQuery&limit=1500&offset=0&tables=conditions&fields=_pageName+%3D+page%2C+name%2C+icon%2C+effects&order_by=name&format=template&default=%3Ctr%3E%3Ctd+colspan%3D%222%22+style%3D%22text-align%3A+center%3B%22%3E%27%27None%27%27%3C%2Ftd%3E%3C%2Ftr%3E&template=ConditionsTableRow&named+args=yes

    // https://bg3.wiki/wiki/Feats
    // https://baldursgate3.wiki.fextralife.com/Traits+and+Features

    // check if each class action is possible (do necessary turnresources and conditions exist):

    // for the effects you can't proc because of unknown variables or impossible implementation: print out what must happen to log (with a #needsDMaction tag or something)

    // https://bg3.wiki/wiki/Template:BarbarianNavbox
    // https://bg3.wiki/wiki/Template:BardNavbox
    // https://bg3.wiki/wiki/Template:ClericNavbox
    // https://bg3.wiki/wiki/Template:DruidNavbox
    // https://bg3.wiki/wiki/Template:FighterNavbox
    // https://bg3.wiki/wiki/Template:MonkNavbox
    // https://bg3.wiki/wiki/Template:PaladinNavbox
    // https://bg3.wiki/wiki/Template:RangerNavbox
    // https://bg3.wiki/wiki/Template:RogueNavbox
    // https://bg3.wiki/wiki/Template:SorcererNavbox
    // https://bg3.wiki/wiki/Template:WarlockNavbox
    // https://bg3.wiki/wiki/Template:WizardNavbox


    private final static List<Condition> CHARMED_STATUS_GROUP = List.of(CHARMED, DOMINATED, FRIENDS, HYPNOTIC_GAZE, HYPNOTIZED, IRRESISTIBLE_DANCE, LURED, PLANAR_BINDING);
    private final static List<Condition> FRIGHTENED_STATUS_GROUP = List.of(FRIGHTENED, FEARFUL);
    private final static List<Condition> DISEASED_STATUS_GROUP = List.of(CRAWLING_GNAW, HARM, INFECTED, SEPTIC, CONTAGION_BLINDING_SICKNESS, CONTAGION_FILTH_FEVER, CONTAGION_FLESH_ROT, CONTAGION_MINDFIRE, CONTAGION_SEIZURE, CONTAGION_SLIMY_DOOM);
    private final static List<Condition> HELPABLE_STATUS_GROUP = List.of(BURNING, DAZED, DOWNED, FEIGNING_DEATH, HYPNOTIZED, OFF_BALANCE, SLEEPING, WEAK_GRIP);
    private final static List<Condition> PARALYZED_STATUS_GROUP = List.of(); // TODO https://bg3.wiki/wiki/SG_Paralyzed


    final String DESCRIPTION;
    final List<Condition> INCLUDED_EFFECTS;

    Condition(String description, List<Condition> includedEffects) {
        this.DESCRIPTION = description;
        this.INCLUDED_EFFECTS = includedEffects;
    }

    @JsonIgnore
    public boolean isCharm(){
        return CHARMED_STATUS_GROUP.contains(this);
    }

    @JsonIgnore
    public boolean isFrighten(){
        return FRIGHTENED_STATUS_GROUP.contains(this);
    }
    
    @JsonIgnore
    public boolean isDisease(){ // can be healed by heal, lesser restoration, lay of hands...
        return DISEASED_STATUS_GROUP.contains(this);
    }

    @JsonIgnore
    public boolean isHelpable(){ // Can be removed by the Help action
        return HELPABLE_STATUS_GROUP.contains(this);
    }

    @JsonIgnore
    public boolean isParalyze(){ // Not implemented, Can be removed by the Help action
        return PARALYZED_STATUS_GROUP.contains(this);
    }

    @JsonIgnore
    public List<Condition> getAllIncludedEffects(){
        Set<Condition> allIncludedEffects = new HashSet<Condition>();
        allIncludedEffects.add(this);
        boolean eachIncludedEffectIsEmpty;
        do {
            for(Condition condition : allIncludedEffects){
                for(Condition includedEffect : condition.INCLUDED_EFFECTS){
                    allIncludedEffects.add(includedEffect);
                }
            }
            eachIncludedEffectIsEmpty = true;
            for(Condition condition : allIncludedEffects){
                if(!condition.INCLUDED_EFFECTS.isEmpty()){
                    eachIncludedEffectIsEmpty = false;
                }
            }
        }
        while(!eachIncludedEffectIsEmpty);
        List<Condition> returnList = new ArrayList<Condition>();
        returnList.addAll(allIncludedEffects);
        return returnList;
    }

    public boolean includesEffect(Condition includedEffect){
        if (this.equals(includedEffect)){
            return true;
        }
        for (Condition effect : this.INCLUDED_EFFECTS){
            if (effect.includesEffect(includedEffect)){
                return true;
            }
        }
        return false;
    }


}