import java.util.ArrayList;
import java.util.List;


abstract class Castable {
    final String NAME;
    final List<String> COST; // TurnResource name
    final Boolean CONCENTRATION;
    final Boolean RITUAL;
    //final Ability SAVING_THROW; // maybe remove since its included in the DESCRIPTION
    final List<String> FORMULAS; //(ex. "3+{upcast}") //RESULTS ALWAYS INTEGERS
    final String DESCRIPTION;

    // target?, condition?


    Castable (String name, List<String> cost, Boolean concentration, Boolean ritual, List<String> formulas, String description){
        this.NAME = name;
        this.COST = cost;
        this.CONCENTRATION = concentration;
        this.RITUAL = ritual;
        this.FORMULAS = formulas;
        this.DESCRIPTION = description;
    }
}

// TODO move ClassAction and Spell to seperate files

class ClassAction extends Castable {
    //final Class CLASS;
    ClassAction(String name, List<String> cost, Boolean concentration, Boolean ritual, List<String> formulas, String description) {
        super(name, cost, concentration, ritual, formulas, description);
    }

    static ClassAction get(String name){
        for (ClassAction CLASS_ACTION : CLASS_ACTIONS){
            if (CLASS_ACTION.NAME == name){
                return CLASS_ACTION;
            }
        }
        return null;
    }


    
    static final List<ClassAction> CLASS_ACTIONS = List.of(
        new ClassAction("Rage", List.of("Bonus Action", "Rage Charge"), false, false, List.of(),"(Available only in combat) Deal 2 extra damage with melee and improvised weapons, and throwing. You have Resistance to physical damage, and Advantage on Strength Checks and Saving Throws. Rage ends early if you don't attack an enemy or take damage each turn. You can't cast or concentrate on spells while raging."),
        new ClassAction("Action Surge", List.of("Action Surge Charge"), false, false, List.of(), "Immediately gain an extra action to use this turn.")
        //Create Spell Slot
        //Bardic Inspiration
        //Cutting Words
    );

}

enum SchoolOfMagic{
    ABJURATION,
    CONJURATION,
    DIVINATION,
    ENCHANTMENT,
    EVOCATION,
    ILLUSION,
    NECROMANCY,
    TRANSMUTATION;
}

class Spell extends Castable{
    final int LEVEL;
    final SchoolOfMagic SCHOOL;
    final Boolean UPCAST;

    Spell (String name, int level, SchoolOfMagic school, List<String> cost, Boolean concentration, Boolean upcast, Boolean ritual, List<String> formulas, String description){
        super(name, cost, concentration, ritual, formulas, description);
        this.LEVEL = level;
        this.SCHOOL = school;
        this.UPCAST = upcast;
    }

    // Spell save DC is class determined so i don't need to calculate it here

    static Spell get(String name){
        for (Spell SPELL : SPELLS){
            if (SPELL.NAME == name){
                return SPELL;
            }
        }
        return null;
    }



    static String replaceVariables(String string, int baseSpellLevel, int spellLevel, int creatureLevel, ArrayList<Integer> calculatedFormulas){
        // maybe need {class_level}
        // 4 variables {base_level}, {upcast}, {level}, {creature_level} and index numbers from list ({1},{2}...)
        string = string.replace("{base_level}", Integer.toString(baseSpellLevel));
        string = string.replace("{upcast}", Integer.toString(spellLevel-baseSpellLevel));
        string = string.replace("{level}", Integer.toString(spellLevel));
        string = string.replace("{creature_level}", Integer.toString(creatureLevel));

        for (int i = 0; i < calculatedFormulas.size(); i++){
            string = string.replace("{"+Integer.toString(i)+"}", Integer.toString(calculatedFormulas.get(i)));
        }

        return string;
    }

    String getDescription(int requestedSpellLevel, int creatureLevel){
        if (this.LEVEL > requestedSpellLevel || this.UPCAST == false && this.LEVEL != requestedSpellLevel){
            return "Spell cannot be cast at this level.";
        }
        
        ArrayList<Integer> calculatedFormulas = new ArrayList<Integer>();
        for (String FORMULA : this.FORMULAS) {
            int result = 0;
            String formula = new String(FORMULA);
            
            formula = replaceVariables(formula, this.LEVEL, requestedSpellLevel, creatureLevel, calculatedFormulas);
            
            // Evaluate the expression
            try {
                result = MathParser.evaluateExpression(formula);
            } catch (Exception e) {
                e.printStackTrace();
            }

            calculatedFormulas.add(result);
        }

        ArrayList<String> calculatedCosts = new ArrayList<String>();
        for (String COST : this.COST){
            String cost = new String(COST);
            cost = replaceVariables(cost, this.LEVEL, requestedSpellLevel, creatureLevel, calculatedFormulas);
            calculatedCosts.add(cost);
        }

        String description = new String(this.DESCRIPTION);
        description = replaceVariables(description, this.LEVEL, requestedSpellLevel, creatureLevel, calculatedFormulas);

        String finalDescription = new String();
        finalDescription += this.NAME + "\n";
        finalDescription += "Costs:\n";
        if(calculatedCosts.isEmpty()){
            finalDescription += "None\n";
        }
        for (String cost : calculatedCosts){
            finalDescription += "-" + cost + "\n";
        }
        finalDescription += "---\n"+description+"\n";
        
        return finalDescription; // when rendering color the upcast numbers differently, and color damage type keywords "Force", "Radiant"...
    }

    static final List<Spell> SPELLS = List.of(
        // Cantrips
        new Spell("Acid Splash", 0, SchoolOfMagic.CONJURATION, List.of("Action"), false, false, false, List.of("{creature_level}/5+1"), 
        "Throw a bubble of acid that damages each creature it hits. {0}d6 Acid damage (DEX save to negate). AoE: 2m"),
        new Spell("Blade Ward", 0, SchoolOfMagic.ABJURATION, List.of("Action"), false, false, false, List.of(), 
        "Take only half the damage from Physical attacks. Duration: 2 turns"), // TODO StatusEffect
        new Spell("Bone Chill", 0, SchoolOfMagic.NECROMANCY, List.of("Action"), false, false, false, List.of("{creature_level}/5+1"), 
        "Prevent the target from healing until your next turn. An undead target receives Disadvantage on Attack rolls. {0}d8 Necrotic damage"), // TODO StatusEffect
        new Spell("Dancing Lights", 0, SchoolOfMagic.EVOCATION, List.of("Action"), true, false, false, List.of(), "Illuminate a  9m radius."),
        new Spell("Eldritch Blast", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, List.of("{creature_level}/5+1"), 
        "Conjure {0} beam/s of crackling energy. Each beam can be targeted individually and deals 1d10 Force damage to a target."),
        new Spell("Fire Bolt", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, List.of("{creature_level}/5+1"), 
        "Hurl a mote of fire. {0}d10 Fire damage."),
        new Spell("Friends", 0, SchoolOfMagic.ENCHANTMENT, List.of("Action"), true, false, false, List.of(), 
        "Gain Advantage on Charisma Checks against a non-hostile creature."), // TODO StatusEffect
        new Spell("Guidance", 0, SchoolOfMagic.DIVINATION, List.of("Action"), true, false, false, List.of(), 
        "The target gains +1d4 bonus to Ability checks. Duration: 10 turns"), // TODO StatusEffect
        new Spell("Light", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, List.of(), 
        "Infuse an object with an aura of light. Only affects one target at a time."),
        new Spell("Mage Hand", 0, SchoolOfMagic.CONJURATION, List.of("Action"), false, false, false, List.of(), 
        "Create a spectral hand that can manipulate and interact with objects. Duration: 10 turns. Can only be cast once per short rest."),
        new Spell("Minor Illusion", 0, SchoolOfMagic.ILLUSION, List.of("Action"), false, false, false, List.of(), 
        "Create an illusion that compels nearby creatures to investigate. You can remain hidden while casting this spell."),
        new Spell("Poison Spray", 0, SchoolOfMagic.CONJURATION, List.of("Action"), false, false, false, List.of("{creature_level}/5+1"), 
        "Project a puff of noxious gas, dealing {0}d12 Poison damage to a target (CON save to negate)."),
        new Spell("Produce Flame", 0, SchoolOfMagic.CONJURATION, List.of("Action"), false, false, false, List.of(), 
        "A flame in your hand sheds a light in a 9m radius and deals 1d8 Fire damage when thrown."), //TODO create item (that cannot be put in inventory)
        new Spell("Ray of Frost", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, List.of("{creature_level}/5+1"), 
        "Reduces the target's Movement Speed by 3m. {0}d8 Cold damage. Duration: 1 turn"), // TODO StatusEffect
        new Spell("Resistance", 0, SchoolOfMagic.ABJURATION, List.of("Action"), true, false, false, List.of(), 
        "Make a target more resistant to spell effects and conditions: it receives a +1d4 bonus to Saving throws. Duration: 10 turns"), //TODO
        new Spell("Sacred Flame", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, true, false, List.of("{creature_level}/5+1"), 
        "Engulf a target in a flame-like radiance. {0}d8 Radiant damage (DEX save to negate)."),
        new Spell("Shillelagh", 0, SchoolOfMagic.TRANSMUTATION, List.of("Bonus Action"), false, false, false, List.of(), 
        "Your staff or club becomes magical: it deals 1d8 + Wisdom Modifier Bludgeoning damage, and uses your Spellcasting Ability for Attack rolls. Duration: 10 turns."), // TODO StatusEffect
        new Spell("Shocking Grasp", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, List.of("{creature_level}/5+1"), 
        "The target cannot use Reactions. This spell has Advantage on creatures with metal Armour. {0}d8 Lightning damage. Duration: 1 turn"), // TODO StatusEffect
        new Spell("Thaumaturgy", 0, SchoolOfMagic.TRANSMUTATION, List.of("Action"), false, false, false, List.of(), 
        "Gain Advantage on Intimidation and Performance Checks. Duration: 10 turns"), // TODO StatusEffect
        new Spell("Thorn Whip", 0, SchoolOfMagic.TRANSMUTATION, List.of("Action"), false, false, false, List.of("{creature_level}/5+1"), 
        "Pulls the creature 3m closer to you. The target cannot be pulled if it is Huge in size. {0}d6 Piercing damage"),
        new Spell("True Strike", 0, SchoolOfMagic.DIVINATION, List.of("Action"), true, false, false, List.of(), 
        "Gain Advantage on your next Attack roll against the target."), // TODO StatusEffect
        new Spell("Vicious Mockery", 0, SchoolOfMagic.ENCHANTMENT, List.of("Action"), false, false, false, List.of("{creature_level}/5+1"), 
        "Insult a creature: it has Disadvantage on its next Attack roll. {0}d4 Psychic damage (WIS save to negate). Duration: 1 turn."), // TODO StatusEffect

        // Level 1 spells
        new Spell("Spellname", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(), 
        ""),
        new Spell("Spellname", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(), 
        ""),
        new Spell("Spellname", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"), false, false, false, List.of(), 
        ""),


        //---

        new Spell("Magic Missile", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"), false, true, false, List.of("3+{upcast}"), "Shoot {0} magical darts, each dealing 1d4+1 Force damage. They always hit their target, and can each be targeted individually.")
        


        

        // https://bg3.wiki/wiki/List_of_all_spells


    );
 
}
