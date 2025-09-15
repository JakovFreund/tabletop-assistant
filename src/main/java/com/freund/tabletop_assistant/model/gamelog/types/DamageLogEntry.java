package com.freund.tabletop_assistant.model.gamelog.types;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.damage.DamageType;
import com.freund.tabletop_assistant.model.source.EffectSourceType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DamageLogEntry extends ReceivedEffectLogEntry {
    private DamageType damageType;
    private String damageAmount;

    public DamageLogEntry(Creature targetCreature, EffectSourceType effectSourceType, DamageType damageType, String damageAmount){
        super(targetCreature, effectSourceType);
        this.damageType = damageType;
        this.damageAmount = damageAmount;
    }
}