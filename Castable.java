import java.util.ArrayList;
import java.util.List;


abstract class Castable {
    final String NAME;
    final List<String> COST; // TurnResource name
    final Boolean CONCENTRATION;
    final Boolean RITUAL;
    final Ability SAVING_THROW;
    final List<String> FORMULAS; //(ex. "3+{upcast}") //RESULTS ALWAYS INTEGERS
    final String DESCRIPTION;

    // target?, condition?


    Castable (String name, List<String> cost, Boolean concentration, Boolean ritual, Ability savingThrow, List<String> formulas, String description){
        this.NAME = name;
        this.COST = cost;
        this.CONCENTRATION = concentration;
        this.RITUAL = ritual;
        this.SAVING_THROW = savingThrow;
        this.FORMULAS = formulas;
        this.DESCRIPTION = description;
    }
}


class ClassAction extends Castable {
    //final Class CLASS;
    ClassAction(String name, List<String> cost, Boolean concentration, Boolean ritual, Ability savingThrow, List<String> formulas, String description) {
        super(name, cost, concentration, ritual, savingThrow, formulas, description);
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
        new ClassAction("Rage", List.of("Bonus Action", "Rage Charge"), false, false, Ability.NONE, List.of(),"(Available only in combat) Deal 2 extra damage with melee and improvised weapons, and throwing. You have Resistance to physical damage, and Advantage on Strength Checks and Saving Throws. Rage ends early if you don't attack an enemy or take damage each turn. You can't cast or concentrate on spells while raging."),
        new ClassAction("Action Surge", List.of("Action Surge Charge"), false, false, Ability.NONE, List.of(), "Immediately gain an extra action to use this turn.")
        //Create Spell Slot
        //Bardic Inspiration
        //Cutting Words
    );

}


class Spell extends Castable{
    final int LEVEL;
    final SchoolOfMagic SCHOOL;
    final Boolean UPCAST;

    Spell (String name, int level, SchoolOfMagic school, List<String> cost, Boolean concentration, Boolean upcast, Boolean ritual, Ability savingThrow, List<String> formulas, String description){
        super(name, cost, concentration, ritual, savingThrow, formulas, description);
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

    String getDescription(int level, int creatureLevel){
        if (this.LEVEL > level || this.UPCAST == false && this.LEVEL != level){
            return "Spell cannot be cast at this level.";
        }
        
        ArrayList<Integer> calculatedFormulas = new ArrayList<Integer>();
        for (String FORMULA : this.FORMULAS) {
            int result = 0;
            String formula = new String(FORMULA);
            
            formula = replaceVariables(formula, this.LEVEL, level, creatureLevel, calculatedFormulas);
            
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
            cost = replaceVariables(cost, this.LEVEL, level, creatureLevel, calculatedFormulas);
            calculatedCosts.add(cost);
        }

        String description = new String(this.DESCRIPTION);
        description = replaceVariables(description, this.LEVEL, level, creatureLevel, calculatedFormulas);

        String finalDescription = new String();
        finalDescription += this.NAME + "\n";
        finalDescription += "Costs:\n";
        if(calculatedCosts.isEmpty()){
            finalDescription += "None\n";
        }
        for (String cost : calculatedCosts){
            finalDescription += "-" + cost + "\n";
        }
        finalDescription += "---\n"+description;
        
        return finalDescription; // when rendering color the upcast numbers differently, and color damage type keywords "Force", "Radiant"...
    }

    static final List<Spell> SPELLS = List.of(
        new Spell("Acid Splash", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Blade Ward", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Bone Chill", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Dancing Lights", 0, SchoolOfMagic.EVOCATION, List.of("Action"), true, false, false, Ability.DEX, List.of(), ""),
        new Spell("Eldritch Blast", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Fire Bolt", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Friends", 0, SchoolOfMagic.EVOCATION, List.of("Action"), true, false, false, Ability.DEX, List.of(), ""),
        new Spell("Guidance", 0, SchoolOfMagic.EVOCATION, List.of("Action"), true, false, false, Ability.DEX, List.of(), ""),
        new Spell("Light", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Mage Hand", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Minor Illusion", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Poison Spray", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Produce Flame", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Ray of Frost", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Resistance", 0, SchoolOfMagic.EVOCATION, List.of("Action"), true, false, false, Ability.DEX, List.of(), ""),
        new Spell("Sacred Flame", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, true, false, Ability.DEX, List.of("{creature_level}/5+1"), "Engulf a target in a flame-like radiance. Deal {0}d8 Radiant damage. (DEX Saving throw to negate)"),
        new Spell("Shillelagh", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Shocking Grasp", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Thaumaturgy", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("Thorn Whip", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),
        new Spell("True Strike", 0, SchoolOfMagic.EVOCATION, List.of("Action"), true, false, false, Ability.DEX, List.of(), ""),
        new Spell("Vicious Mockery", 0, SchoolOfMagic.EVOCATION, List.of("Action"), false, false, false, Ability.DEX, List.of(), ""),


        //---

        new Spell("Magic Missile", 1, SchoolOfMagic.EVOCATION, List.of("Action", "Level {level} Spellslot"), false, true, false, Ability.NONE, List.of("3+{upcast}"), "{0}d4+{0} Force damage. Shoot {0} magical darts, each dealing 1d4+1 Force damage. They always hit their target. Range: 18m")
        


        

        // https://bg3.wiki/wiki/List_of_all_spells


    );
 
}

enum SchoolOfMagic{
    ABJURATIOM,
    CONJURATION,
    DIVINATION,
    ENCHANTMENT,
    EVOCATION,
    ILLUSION,
    NECROMANCY,
    TRANSMUTATION;
}

