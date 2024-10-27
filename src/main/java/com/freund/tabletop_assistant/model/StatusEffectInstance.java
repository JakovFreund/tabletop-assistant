package com.freund.tabletop_assistant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusEffectInstance {
    private StatusEffect statusEffect;
    private int turnsDuration; // ignore if duration != TURNS
    private Duration duration;
    private String customNote; // DM inputed reminder
}
