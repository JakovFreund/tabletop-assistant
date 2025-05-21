package com.freund.tabletop_assistant.model.item.effect;

import com.freund.tabletop_assistant.model.duration.Duration;
import com.freund.tabletop_assistant.model.statuseffect.StatusEffect;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WeaponAppliesStatusEffect extends ItemEffect{
    private StatusEffect statusEffect;
    private Duration duration;

    public WeaponAppliesStatusEffect(StatusEffect statusEffect, Duration duration){
        super();
        this.statusEffect = statusEffect;
        this.duration = duration;
    }
}
