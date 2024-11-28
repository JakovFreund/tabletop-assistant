package com.freund.tabletop_assistant.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusEffectInstance {
    private StatusEffect statusEffect;
    private Duration duration;
    private EffectSource source;
    //private boolean removedOnSourceLostConcentration; // i probably don't need this (just check all effects when concentration is lost)
    private List<StatusEffect> dependsUpon; // for chain removing status effects with multiple "parent" statuseffects
    private String customNote; // DM inputed reminder
}
