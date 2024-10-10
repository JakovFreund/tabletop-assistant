package com.freund.tabletop_assistant.model;

import java.util.ArrayList;
import java.util.List;

import com.freund.tabletop_assistant.util.MathParser;

abstract class Castable {
        final String NAME;
        final List<String> COST; // TurnResource name
        final Boolean CONCENTRATION;
        final Boolean RITUAL;
        //final Ability SAVING_THROW; // maybe remove since its included in the DESCRIPTION
        final List<String> FORMULAS; //(ex. "3+{upcast}") //RESULTS ALWAYS INTEGERS
        final String DESCRIPTION;

        // target?, condition?

        Castable(String name, List<String> cost, Boolean concentration, Boolean ritual, List<String> formulas,
                        String description) {
                this.NAME = name;
                this.COST = cost;
                this.CONCENTRATION = concentration;
                this.RITUAL = ritual;
                this.FORMULAS = formulas;
                this.DESCRIPTION = description;
        }
}

class ClassAction extends Castable {
        //final Class CLASS;
        ClassAction(String name, List<String> cost, Boolean concentration, Boolean ritual, List<String> formulas,
                        String description) {
                super(name, cost, concentration, ritual, formulas, description);
        }

        static ClassAction get(String name) {
                for (ClassAction CLASS_ACTION : CLASS_ACTIONS) {
                        if (CLASS_ACTION.NAME == name) {
                                return CLASS_ACTION;
                        }
                }
                return null;
        }

        static final List<ClassAction> CLASS_ACTIONS = GameData.CLASS_ACTIONS;

}

enum SchoolOfMagic {
        ABJURATION,
        CONJURATION,
        DIVINATION,
        ENCHANTMENT,
        EVOCATION,
        ILLUSION,
        NECROMANCY,
        TRANSMUTATION;
}

class Spell extends Castable {
        final int LEVEL;
        final SchoolOfMagic SCHOOL;
        final Boolean UPCAST;

        Spell(String name, int level, SchoolOfMagic school, List<String> cost, Boolean concentration, Boolean upcast,
                        Boolean ritual, List<String> formulas, String description) {
                super(name, cost, concentration, ritual, formulas, description);
                this.LEVEL = level;
                this.SCHOOL = school;
                this.UPCAST = upcast;
        }

        static Spell get(String name) {
                for (Spell SPELL : SPELLS) {
                        if (SPELL.NAME == name) {
                                return SPELL;
                        }
                }
                return null;
        }

        static String replaceVariables(String string, int baseSpellLevel, int spellLevel, int creatureLevel,
                        ArrayList<Integer> calculatedFormulas) {
                // maybe need {class_level}
                // 4 variables {base_level}, {upcast}, {level}, {creature_level} and index numbers from list ({1},{2}...)
                string = string.replace("{base_level}", Integer.toString(baseSpellLevel));
                string = string.replace("{upcast}", Integer.toString(spellLevel - baseSpellLevel));
                string = string.replace("{level}", Integer.toString(spellLevel));
                string = string.replace("{creature_level}", Integer.toString(creatureLevel));

                for (int i = 0; i < calculatedFormulas.size(); i++) {
                        string = string.replace("{" + Integer.toString(i) + "}",
                                        Integer.toString(calculatedFormulas.get(i)));
                }

                return string;
        }

        String getDescription(int requestedSpellLevel, int creatureLevel) {
                if (this.LEVEL > requestedSpellLevel || this.UPCAST == false && this.LEVEL != requestedSpellLevel) {
                        return "Spell cannot be cast at this level.";
                }

                ArrayList<Integer> calculatedFormulas = new ArrayList<Integer>();
                for (String FORMULA : this.FORMULAS) {
                        int result = 0;
                        String formula = new String(FORMULA);

                        formula = replaceVariables(formula, this.LEVEL, requestedSpellLevel, creatureLevel,
                                        calculatedFormulas);

                        // Evaluate the expression
                        try {
                                result = MathParser.evaluateExpression(formula);
                        } catch (Exception e) {
                                e.printStackTrace();
                        }

                        calculatedFormulas.add(result);
                }

                ArrayList<String> calculatedCosts = new ArrayList<String>();
                for (String COST : this.COST) {
                        String cost = new String(COST);
                        cost = replaceVariables(cost, this.LEVEL, requestedSpellLevel, creatureLevel,
                                        calculatedFormulas);
                        calculatedCosts.add(cost);
                }

                String description = new String(this.DESCRIPTION);
                description = replaceVariables(description, this.LEVEL, requestedSpellLevel, creatureLevel,
                                calculatedFormulas);

                String finalDescription = new String();
                finalDescription += this.NAME + "\n";
                finalDescription += "Costs:\n";
                if (calculatedCosts.isEmpty()) {
                        finalDescription += "None\n";
                }
                for (String cost : calculatedCosts) {
                        finalDescription += "-" + cost + "\n";
                }
                finalDescription += "---\n" + description + "\n";

                return finalDescription; // when rendering color the upcast numbers differently, and color damage type keywords "Force", "Radiant"...
        }

        static final List<Spell> SPELLS = GameData.SPELLS;

}
