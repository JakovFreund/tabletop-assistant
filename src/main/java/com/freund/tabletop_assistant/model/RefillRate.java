package com.freund.tabletop_assistant.model;

public enum RefillRate { // action, bonus action, reaction, movespeed, spellslots, class actions (actionWW surge, rage)
    TURN,
    SHORT_REST,
    LONG_REST, // hp is longrest
    NEVER
}