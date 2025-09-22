package com.freund.tabletop_assistant.model.gamelog.types;

import com.freund.tabletop_assistant.model.condition.ConditionInstance;
import com.freund.tabletop_assistant.model.creature.Creature;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReceivedConditionFromCastableLogEntry extends ReceivedConditionLogEntry {
    private CastableUsedLogEntry castableUsedLogEntry;

    public ReceivedConditionFromCastableLogEntry(Creature targetCreature, ConditionInstance conditionInstance, CastableUsedLogEntry castableUsedLogEntry){
        super(true, targetCreature, conditionInstance);
        this.castableUsedLogEntry = castableUsedLogEntry;
        //setEffectSourceType(EffectSourceType.CASTABLE); // should work without this, since ReceivedConditionLogEntry already sets source based on Condition.source
    }
}
