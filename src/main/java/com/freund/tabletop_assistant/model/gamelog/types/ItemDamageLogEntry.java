package com.freund.tabletop_assistant.model.gamelog.types;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.damage.DamageType;
import com.freund.tabletop_assistant.model.item.Item;
import com.freund.tabletop_assistant.model.source.EffectSourceType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ItemDamageLogEntry extends DamageLogEntry {
    private Item item;

    public ItemDamageLogEntry(Creature targetCreature, DamageType damageType, String damageAmount, Item item){
        super(targetCreature, EffectSourceType.ITEM, damageType, damageAmount);
        this.item = item;
    }
}
