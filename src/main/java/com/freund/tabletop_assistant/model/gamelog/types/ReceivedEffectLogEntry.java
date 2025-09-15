package com.freund.tabletop_assistant.model.gamelog.types;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.gamelog.LogEntry;
import com.freund.tabletop_assistant.model.gamelog.LogVisibility;
import com.freund.tabletop_assistant.model.source.EffectSourceType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class ReceivedEffectLogEntry extends LogEntry {
    private Creature targetCreature;
    private EffectSourceType effectSourceType;

    public ReceivedEffectLogEntry(Creature targetCreature, EffectSourceType effectSourceType){
        super(LogVisibility.SCENE);
        this.targetCreature = targetCreature;
        this.effectSourceType = effectSourceType;
    }
}
