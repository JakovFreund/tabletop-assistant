package com.freund.tabletop_assistant.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Castable {
    private String name;
    private boolean ritual;
    private boolean concentration;
    private Ability savingThrow;
    private EffectTarget effectTarget;
    private Duration duration;
    private Map<TurnResourceType, Integer> costs; // convert to minutes/hours at render time if necessary, spellslot not included by default (because of upcast)
    private List<CastableDamageComponent> castableDamageComponents;
    private Map<Integer, String> healAtSlotLevel;
    private List<StatusEffect> statusEffects;
    private List<String> description;
}
