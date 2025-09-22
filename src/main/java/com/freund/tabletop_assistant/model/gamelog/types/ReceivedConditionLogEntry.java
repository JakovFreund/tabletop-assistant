package com.freund.tabletop_assistant.model.gamelog.types;

import com.freund.tabletop_assistant.model.condition.ConditionInstance;
import com.freund.tabletop_assistant.model.creature.Creature;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReceivedConditionLogEntry extends ReceivedEffectLogEntry {
    private ConditionInstance receivedConditionInstance;

    public ReceivedConditionLogEntry(boolean isNested, Creature targetCreature, ConditionInstance receivedConditionInstance) {
        super(isNested, targetCreature, receivedConditionInstance.getEffectSource().getEffectSourceType());
        this.receivedConditionInstance = receivedConditionInstance;
    }
}
