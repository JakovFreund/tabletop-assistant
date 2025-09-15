package com.freund.tabletop_assistant.dto;

import com.freund.tabletop_assistant.model.duration.Duration;
import com.freund.tabletop_assistant.model.statuseffect.StatusEffect;

import lombok.Data;

@Data
public class StatusEffectInstanceDTO {
    private StatusEffect statusEffect;
    private Duration duration;
    private EffectSourceDTO effectSourceDTO;
}
