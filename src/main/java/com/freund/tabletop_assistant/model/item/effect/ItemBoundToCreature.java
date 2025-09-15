package com.freund.tabletop_assistant.model.item.effect;

import com.freund.tabletop_assistant.model.creature.Creature;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ItemBoundToCreature extends ItemEffect {
    private Creature boundCreature;

    public ItemBoundToCreature(Creature boundCreature){
        super();
        this.boundCreature = boundCreature;
    }
}
