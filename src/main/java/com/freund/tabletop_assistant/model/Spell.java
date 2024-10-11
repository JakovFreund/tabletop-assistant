package com.freund.tabletop_assistant.model;

import java.util.List;
import java.util.ArrayList;

import com.freund.tabletop_assistant.util.MathParser;

public class Spell extends Castable {
    // TODO change all to private and add getters and setters
    public final int LEVEL;
    public final SchoolOfMagic SCHOOL;
    public final Boolean UPCAST;
    public static final List<Spell> SPELLS = GameData.SPELLS;

    Spell(String name, int level, SchoolOfMagic school, List<String> cost, Boolean concentration, Boolean upcast,
                    Boolean ritual, List<String> formulas, String description) {
            super(name, cost, concentration, ritual, formulas, description);
            this.LEVEL = level;
            this.SCHOOL = school;
            this.UPCAST = upcast;
    }

    public static Spell get(String name) {
            for (Spell SPELL : SPELLS) {
                    if (SPELL.NAME == name) {
                            return SPELL;
                    }
            }
            return null;
    }

    public static String replaceVariables(String string, int baseSpellLevel, int spellLevel, int creatureLevel,
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

    public String getDescription(int requestedSpellLevel, int creatureLevel) {
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

}
