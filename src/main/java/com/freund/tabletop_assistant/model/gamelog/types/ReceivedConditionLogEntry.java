package com.freund.tabletop_assistant.model.gamelog.types;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.statuseffect.StatusEffectInstance;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReceivedConditionLogEntry extends ReceivedEffectLogEntry {
    private StatusEffectInstance receivedStatusEffectInstance;

    public ReceivedConditionLogEntry(boolean isNested, Creature targetCreature, StatusEffectInstance receivedStatusEffectInstance) {
        super(isNested, targetCreature, receivedStatusEffectInstance.getEffectSource().getEffectSourceType());
        this.receivedStatusEffectInstance = receivedStatusEffectInstance;
    }
}
