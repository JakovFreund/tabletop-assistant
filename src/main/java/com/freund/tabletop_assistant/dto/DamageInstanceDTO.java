package com.freund.tabletop_assistant.dto;

import com.freund.tabletop_assistant.model.damage.Damage;

import lombok.Data;

@Data
public class DamageInstanceDTO {
    private Damage damage;
    private EffectSourceDTO effectSource;
}
