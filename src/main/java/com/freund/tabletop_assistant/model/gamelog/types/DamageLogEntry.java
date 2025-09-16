package com.freund.tabletop_assistant.model.gamelog.types;

import java.util.List;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.damage.DamageEntry;
import com.freund.tabletop_assistant.model.gamelog.statcalculation.StatCalculationBreakdown;
import com.freund.tabletop_assistant.model.source.EffectSourceType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DamageLogEntry extends ReceivedEffectLogEntry {
    private DamageEntry damageEntry;
    private List<StatCalculationBreakdown> statCalculationBreakdowns;

    public DamageLogEntry(boolean isNested, Creature targetCreature, EffectSourceType effectSourceType, DamageEntry damageEntry, List<StatCalculationBreakdown> statCalculationBreakdowns){
        super(isNested, targetCreature, effectSourceType);
        this.damageEntry = damageEntry;
        this.statCalculationBreakdowns = statCalculationBreakdowns;
    }
}