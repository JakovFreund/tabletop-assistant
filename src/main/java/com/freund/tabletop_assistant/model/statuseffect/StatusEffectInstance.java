package com.freund.tabletop_assistant.model.statuseffect;

import com.freund.tabletop_assistant.model.duration.Duration;
import com.freund.tabletop_assistant.model.source.EffectSource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusEffectInstance {
    private StatusEffect statusEffect;
    private Duration duration;
    private EffectSource effectSource;
    //private boolean removedOnSourceLostConcentration; // do i need this? (or can i just check all effects when concentration is lost)
}
