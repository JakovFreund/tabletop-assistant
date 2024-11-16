package com.freund.tabletop_assistant.model;

import java.util.List;
import lombok.Data;

@Data
abstract class OldCastable {
        // TODO change all to private and add getters
        private final String NAME;
        public final List<String> COST; // TurnResource name
        public final Boolean CONCENTRATION;
        public final Boolean RITUAL;
        //final Ability SAVING_THROW; // maybe remove since its included in the DESCRIPTION
        public final List<String> FORMULAS; //(ex. "3+{upcast}") //RESULTS ALWAYS INTEGERS
        public final String DESCRIPTION;

        // target?, condition?

        OldCastable(String name, List<String> cost, Boolean concentration, Boolean ritual, List<String> formulas,
                        String description) {
                this.NAME = name;
                this.COST = cost;
                this.CONCENTRATION = concentration;
                this.RITUAL = ritual;
                this.FORMULAS = formulas;
                this.DESCRIPTION = description;
        }
}