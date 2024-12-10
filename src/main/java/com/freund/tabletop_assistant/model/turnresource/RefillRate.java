package com.freund.tabletop_assistant.model.turnresource;

public enum RefillRate { // action, bonus action, reaction, movespeed, spellslots, class actions (action surge, rage)
    TURN,
    SHORT_REST,
    LONG_REST, // hp is longrest
    NEVER
}