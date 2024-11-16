package com.freund.tabletop_assistant.model;

import java.util.List;

class OldClassAction extends OldCastable {
    //final Class CLASS;
    OldClassAction(String name, List<String> cost, Boolean concentration, Boolean ritual, List<String> formulas,
                    String description) {
            super(name, cost, concentration, ritual, formulas, description);
    }

    static OldClassAction get(String name) {
            for (OldClassAction CLASS_ACTION : CLASS_ACTIONS) {
                    if (CLASS_ACTION.getNAME() == name) {
                            return CLASS_ACTION;
                    }
            }
            return null;
    }

    static final List<OldClassAction> CLASS_ACTIONS = GameData.CLASS_ACTIONS;

}
