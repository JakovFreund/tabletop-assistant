package com.freund.tabletop_assistant.model.gamelog.types;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.statuseffect.StatusEffectInstance;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReceivedConditionFromCastableLogEntry extends ReceivedConditionLogEntry {
    private CastableUsedLogEntry castableUsedLogEntry;

    public ReceivedConditionFromCastableLogEntry(Creature targetCreature, StatusEffectInstance statusEffectInstance, CastableUsedLogEntry castableUsedLogEntry){
        super(true, targetCreature, statusEffectInstance);
        this.castableUsedLogEntry = castableUsedLogEntry;
        //setEffectSourceType(EffectSourceType.CASTABLE); // should work without this, since ReceivedConditionLogEntry already sets source based on StatusEffect.source
    }
}
