package com.freund.tabletop_assistant.model;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusEffectInstance {
    private StatusEffect statusEffect;
    private Duration duration;
    private UUID source;
    private List<StatusEffect> dependsUpon; // for chain removing status effects
    private String customNote; // DM inputed reminder
}
