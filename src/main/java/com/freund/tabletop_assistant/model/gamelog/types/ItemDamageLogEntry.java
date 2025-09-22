package com.freund.tabletop_assistant.model.gamelog.types;

import java.util.List;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.damage.DamageEntry;
import com.freund.tabletop_assistant.model.gamelog.statcalculation.StatCalculationBreakdown;
import com.freund.tabletop_assistant.model.item.Item;
import com.freund.tabletop_assistant.model.source.EffectSourceType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ItemDamageLogEntry extends DamageLogEntry { // TODO probably remove (when does an item damage without a castable or a condition?)
    private Item item;

    public ItemDamageLogEntry(boolean isNested, Creature targetCreature, DamageEntry damageComponent, List<StatCalculationBreakdown> statCalculationBreakdowns, Item item){
        super(isNested, targetCreature, EffectSourceType.ITEM, damageComponent, statCalculationBreakdowns);
        this.item = item;
    }
}
