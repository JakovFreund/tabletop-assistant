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
public class CastableDamageLogEntry extends DamageLogEntry {
    private CastableUsedLogEntry castableUsedLogEntry;

    public CastableDamageLogEntry(Creature targetCreature, EffectSourceType effectSourceType, DamageEntry damageComponent, List<StatCalculationBreakdown> statCalculationBreakdowns, CastableUsedLogEntry castableUsedLogEntry) {
        super(true, targetCreature, EffectSourceType.CASTABLE, damageComponent, statCalculationBreakdowns);
        this.castableUsedLogEntry = castableUsedLogEntry;
    }
}