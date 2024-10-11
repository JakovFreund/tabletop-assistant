package com.freund.tabletop_assistant.model;


import java.util.List;

abstract class Castable {
        // TODO change all to private and add getters
        public final String NAME;
        public final List<String> COST; // TurnResource name
        public final Boolean CONCENTRATION;
        public final Boolean RITUAL;
        //final Ability SAVING_THROW; // maybe remove since its included in the DESCRIPTION
        public final List<String> FORMULAS; //(ex. "3+{upcast}") //RESULTS ALWAYS INTEGERS
        public final String DESCRIPTION;

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
