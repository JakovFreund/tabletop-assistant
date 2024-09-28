import java.util.List;

public final class GameData {

        static final List<ClassAction> CLASS_ACTIONS = List.of(
                        new ClassAction("Rage", List.of("Bonus Action", "Rage Charge"), false, false, List.of(),
                                        "(Available only in combat) Deal 2 extra damage with melee and improvised weapons, and throwing. You have Resistance to physical damage, and Advantage on Strength Checks and Saving Throws. Rage ends early if you don't attack an enemy or take damage each turn. You can't cast or concentrate on spells while raging."),
                        new ClassAction("Action Surge", List.of("Action Surge Charge"), false, false, List.of(),
                                        "Immediately gain an extra action to use this turn.")
        //Create Spell Slot
        //Bardic Inspiration
        //Cutting Words
        );

        static final List<Spell> SPELLS = List.of(
                        // Cantrips
                        new Spell("Acid Splash", 0, SchoolOfMagic.CONJURATION, List.of("Action"), false, false, false,
                                        List.of("{creature_level}/5+1"),
                                        "Throw a bubble of acid that damages each creature it hits. {0}d6 Acid damage (DEX save to negate). AoE: 2m"),
                        new Spell("Blade Ward", 0, SchoolOfMagic.ABJURATION, List.of("Action"), false, false, false,
                                        List.of(),
                                        "Take only half the damage from Physical attacks. Duration: 2 turns"), // TODO StatusEffect
                        new Spell("Bone Chill", 0, SchoolOfMagic.NECROMANCY, List.of("Action"), false, false, false,
                                        List.of("{creature_level}/5+1"),
                                        "Prevent the target from healing until your next turn. An undead target receives Disadvantage on Attack rolls. {0}d8 Necrotic damage"), // TODO StatusEffect
                        new Spell("Dancing Lights", 0, SchoolOfMagic.EVOCATION, List.of("Action"), true, false, false,
                                        List.of(), "Illuminate a  9m radius."),
                        new Spell("Eldritch Blast", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false,
                                        List.of("{creature_level}/5+1"),
                                        "Conjure {0} beam(s) of crackling energy. Each beam can be targeted individually and deals 1d10 Force damage to a target."),
                        new Spell("Fire Bolt", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false,
                                        List.of("{creature_level}/5+1"),
                                        "Hurl a mote of fire. {0}d10 Fire damage."),
                        new Spell("Friends", 0, SchoolOfMagic.ENCHANTMENT, List.of("Action"), true, false, false,
                                        List.of(),
                                        "Gain Advantage on Charisma Checks against a non-hostile creature."), // TODO StatusEffect
                        new Spell("Guidance", 0, SchoolOfMagic.DIVINATION, List.of("Action"), true, false, false,
                                        List.of(),
                                        "The target gains +1d4 bonus to Ability checks. Duration: 10 turns"), // TODO StatusEffect
                        new Spell("Light", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false,
                                        List.of(),
                                        "Infuse an object with an aura of light. Only affects one target at a time."),
                        new Spell("Mage Hand", 0, SchoolOfMagic.CONJURATION, List.of("Action"), false, false, false,
                                        List.of(),
                                        "Create a spectral hand that can manipulate and interact with objects. Duration: 10 turns. Can only be cast once per short rest."),
                        new Spell("Minor Illusion", 0, SchoolOfMagic.ILLUSION, List.of("Action"), false, false, false,
                                        List.of(),
                                        "Create an illusion that compels nearby creatures to investigate. You can remain hidden while casting this spell."),
                        new Spell("Poison Spray", 0, SchoolOfMagic.CONJURATION, List.of("Action"), false, false, false,
                                        List.of("{creature_level}/5+1"),
                                        "Project a puff of noxious gas, dealing {0}d12 Poison damage to a target (CON save to negate)."),
                        new Spell("Produce Flame", 0, SchoolOfMagic.CONJURATION, List.of("Action"), false, false, false,
                                        List.of(),
                                        "A flame in your hand sheds a light in a 9m radius and deals 1d8 Fire damage when thrown."), //TODO create item (that cannot be put in inventory)
                        new Spell("Ray of Frost", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false,
                                        List.of("{creature_level}/5+1"),
                                        "Reduces the target's Movement Speed by 3m. {0}d8 Cold damage. Duration: 1 turn"), // TODO StatusEffect
                        new Spell("Resistance", 0, SchoolOfMagic.ABJURATION, List.of("Action"), true, false, false,
                                        List.of(),
                                        "Make a target more resistant to spell effects and conditions: it receives a +1d4 bonus to Saving throws. Duration: 10 turns"), //TODO
                        new Spell("Sacred Flame", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, true, false,
                                        List.of("{creature_level}/5+1"),
                                        "Engulf a target in a flame-like radiance. {0}d8 Radiant damage (DEX save to negate)."),
                        new Spell("Shillelagh", 0, SchoolOfMagic.TRANSMUTATION, List.of("Bonus Action"), false, false,
                                        false, List.of(),
                                        "Your staff or club becomes magical: it deals 1d8 + Wisdom Modifier Bludgeoning damage, and uses your Spellcasting Ability for Attack rolls. Duration: 10 turns."), // TODO StatusEffect
                        new Spell("Shocking Grasp", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false,
                                        List.of("{creature_level}/5+1"),
                                        "The target cannot use Reactions. This spell has Advantage on creatures with metal Armour. {0}d8 Lightning damage. Duration: 1 turn"), // TODO StatusEffect
                        new Spell("Thaumaturgy", 0, SchoolOfMagic.TRANSMUTATION, List.of("Action"), false, false, false,
                                        List.of(),
                                        "Gain Advantage on Intimidation and Performance Checks. Duration: 10 turns"), // TODO StatusEffect
                        new Spell("Thorn Whip", 0, SchoolOfMagic.TRANSMUTATION, List.of("Action"), false, false, false,
                                        List.of("{creature_level}/5+1"),
                                        "Pulls the creature 3m closer to you. The target cannot be pulled if it is Huge in size. {0}d6 Piercing damage"),
                        new Spell("True Strike", 0, SchoolOfMagic.DIVINATION, List.of("Action"), true, false, false,
                                        List.of(),
                                        "Gain Advantage on your next Attack roll against the target."), // TODO StatusEffect
                        new Spell("Vicious Mockery", 0, SchoolOfMagic.ENCHANTMENT, List.of("Action"), false, false,
                                        false, List.of("{creature_level}/5+1"),
                                        "Insult a creature: it has Disadvantage on its next Attack roll. {0}d4 Psychic damage (WIS save to negate). Duration: 1 turn."), // TODO StatusEffect

                        // Level 1 spells
                        new Spell("Animal Friendship", 1, SchoolOfMagic.ENCHANTMENT,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        "Charm {level} beast(s) not to attack you. The creature must have an Intelligence of 3 or less. Condition ends early if you or an ally hurts the target. (WIS save)"),
                        new Spell("Armour of Agathys", 1, SchoolOfMagic.ABJURATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false,
                                        List.of("{upcast}*5+5"),
                                        "Gain {0} temporary hit points and deal {0} Cold damage to any creature that hits you with a melee attack. Duration: Until Long rest."), // TODO StatusEffect
                        new Spell("Arms of Hadar", 1, SchoolOfMagic.CONJURATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false,
                                        List.of("{upcast}+2"),
                                        "Summon dark tendrils and deal {0}d6 Necrotic damage to enemies in an area centered on the caster, preventing them from taking Reactions(STR save to take half damage and negate effect). AoE: 3m. Duration: 1 turn."),
                        new Spell("Bane", 1, SchoolOfMagic.ENCHANTMENT, List.of("Action", "Level {level} Spellslot"),
                                        true, false, false, List.of("{upcast}+3"),
                                        "Up to {0} creatures receive a -1d4 penalty to Attack rolls and Saving throws (CHA save). Duration: 10 turns."), // TODO StatusEffect
                        new Spell("Bless", 1, SchoolOfMagic.ENCHANTMENT, List.of("Action", "Level {level} Spellslot"),
                                        true, false, false, List.of("{upcast}+3"),
                                        "Bless up to {0} creatures. They gain a +1d4 bonus to Attack rolls and Saving throws. Duration: 10 turns."),
                        new Spell("Burning Hands", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false,
                                        List.of("{upcast}+3"),
                                        "Shoot a flaming cone from your fingertips and deal {0}d6 Fire damage (DEX save to take half damage). Cone radius: 5m"),
                        new Spell("Charm Person", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        "Charm {level} humanoid(s) to prevent it from attacking you (WIS save). You gain Advantage on Charisma Checks in dialogue. Enemies have Advantage on Saving throws against being Charmed. Condition ends early if you or an ally hurts the target."), // TODO StatusEffect
                        new Spell("Chromatic Orb", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false,
                                        List.of("2+{upcast}", "3+{upcast}"),
                                        "Hurl a ball of energy and deal the desired damage type to enemies ({1}d8 Thunder damage, or {0}d8 Acid, Cold, Fire, Lightning or Poison damage)."),
                        new Spell("Colour Spray", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Command", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"),
                                        false, false, false, List.of(),
                                        ""),
                        new Spell("Compelled Duel", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), true, false, false, List.of(),
                                        ""),
                        new Spell("Create or Destroy Water", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Cure Wounds", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Disguise Self", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, true, List.of(),
                                        ""),
                        new Spell("Dissonant Whispers", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Divine Favour", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), true, false, false, List.of(),
                                        ""),
                        new Spell("Enhance Leap", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, true, List.of(),
                                        ""),
                        new Spell("Ensnaring Strike", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), true, false, false, List.of(),
                                        ""),
                        new Spell("Entangle", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"),
                                        true, false, false, List.of(),
                                        ""),
                        new Spell("Expeditious Retreat", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), true, false, false, List.of(),
                                        ""),
                        new Spell("Faerie Fire", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), true, false, false, List.of(),
                                        ""),
                        new Spell("False Life", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Feather Fall", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, true, List.of(),
                                        ""),
                        new Spell("Find Familiar", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, true, List.of(),
                                        ""),
                        new Spell("Fog Cloud", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"),
                                        true, false, false, List.of(),
                                        ""),
                        new Spell("Goodberry", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"),
                                        false, false, false, List.of(),
                                        ""),
                        new Spell("Grease", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"),
                                        false, false, false, List.of(),
                                        ""),
                        new Spell("Guiding Bolt", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Hail of Thorns", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Healing Word", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Hellish Rebuke", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Heroism", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"),
                                        true, false, false, List.of(),
                                        ""),
                        new Spell("Hex", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"), true,
                                        false, false, List.of(),
                                        ""),
                        new Spell("Hunter's Mark", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), true, false, false, List.of(),
                                        ""),
                        new Spell("Ice Knife", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"),
                                        false, false, false, List.of(),
                                        ""),
                        new Spell("Inflict Wounds", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Longstrider", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, true, List.of(),
                                        ""),
                        new Spell("Mage Armour", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Magic Missile", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, true, false,
                                        List.of("3+{upcast}"),
                                        "Shoot {0} magical darts, each dealing 1d4+1 Force damage. They always hit their target, and can each be targeted individually."),
                        new Spell("Protection from Evil and Good", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Ray of Sickness", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Sanctuary", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"),
                                        false, false, false, List.of(),
                                        ""),
                        new Spell("Searing Smite", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), true, false, false, List.of(),
                                        ""),
                        new Spell("Shield", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"),
                                        false, false, false, List.of(),
                                        ""),
                        new Spell("Shield of Faith", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), true, false, false, List.of(),
                                        ""),
                        new Spell("Sleep", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"),
                                        false, false, false, List.of(),
                                        ""),
                        new Spell("Speak with Animals", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, true, List.of(),
                                        ""),
                        new Spell("Tasha's Hideous Laughter", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), true, false, false, List.of(),
                                        ""),
                        new Spell("Thunderous Smite", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Thunderwave", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(),
                                        ""),
                        new Spell("Witch Bolt", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), true, false, false, List.of(),
                                        ""),
                        new Spell("Wrathful Smite", 1, SchoolOfMagic.EVOCATION,
                                        List.of("Action", "Level {level} Spellslot"), true, false, false, List.of(),
                                        "")

        //---

        // https://bg3.wiki/wiki/List_of_all_spells

        );

        private GameData() { // Private constructor to prevent instantiation
                throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
        }
}

enum ItemType {
        WOODEN_SWORD("Wooden sword", ItemCategory.WEAPON, Rarity.UNCOMMON, "Just a wooden sword", 30, 10,
                        List.of(new ItemEffect(EffectType.DAMAGE, "d6"))),
        RANDOM_CHESTPLATE("Random Chestplate", ItemCategory.WEARABLE, Rarity.RARE, "abc", 50, 15,
                        List.of(new ItemEffect(EffectType.AC, "10"))),
        SILVERFANG("Silverfang", ItemCategory.WEAPON, Rarity.EPIC,
                        "An ancient sword forged from Mithril in the legendary Great Hearth of the First Dwarven Kingdom. Being made of Mithril makes it a good choice against the undead.",
                        25, 500,
                        List.of(new ItemEffect(EffectType.DAMAGE, "4d8"))),

        //https://5e.tools/lootgen.html

        GOLD("Gold", ItemCategory.MISC, Rarity.COMMON, "Currency of Alarién", 0, 1);
        // TODO change inlore name of gold

        //
        final String NAME;
        final ItemCategory TYPE;
        final Rarity BASE_RARITY;
        final String DESCRIPTION;
        final int WEIGHT;
        final int BASE_VALUE;
        final List<ItemEffect> BASE_EFFECTS;

        ItemType(String name, ItemCategory type, Rarity rarity, String description, int weight, int value,
                        List<ItemEffect> baseEffects) {
                this.NAME = name;
                this.TYPE = type;
                this.BASE_RARITY = rarity;
                this.DESCRIPTION = description;
                this.WEIGHT = weight;
                this.BASE_VALUE = value;
                this.BASE_EFFECTS = baseEffects;
                // TODO weapons can have various properties such as Heavy, Finesse, Light, and so on, Armour has Light, Heavy, 
                // Thrown, Simple, Martial ?
        }

        ItemType(String name, ItemCategory type, Rarity rarity, String description, int weight, int value) {
                this.NAME = name;
                this.TYPE = type;
                this.BASE_RARITY = rarity;
                this.DESCRIPTION = description;
                this.WEIGHT = weight;
                this.BASE_VALUE = value;
                this.BASE_EFFECTS = null;
        }
}