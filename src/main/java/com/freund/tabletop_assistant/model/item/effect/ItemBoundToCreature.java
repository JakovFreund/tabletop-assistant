package com.freund.tabletop_assistant.model.item.effect;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ItemBoundToCreature extends ItemEffect {
    private UUID boundCreature;

    public ItemBoundToCreature(UUID boundCreature){
        super();
        this.boundCreature = boundCreature;
    }
}
