package com.freund.tabletop_assistant.model.gamelog.types;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.gamelog.LogEntry;
import com.freund.tabletop_assistant.model.gamelog.LogVisibility;
import com.freund.tabletop_assistant.model.statuseffect.StatusEffectInstance;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LostConditionLogEntry extends LogEntry {
    private Creature targetCreature;
    private StatusEffectInstance LostStatusEffectInstance;

    public LostConditionLogEntry (boolean isNested, Creature targetCreature, StatusEffectInstance LostStatusEffectInstance){
        super(LogVisibility.SCENE, isNested);
        this.targetCreature = targetCreature;
        this.LostStatusEffectInstance = LostStatusEffectInstance;
    }
}
