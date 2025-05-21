package com.freund.tabletop_assistant.model.item;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ItemStack extends Item { // items autostack if their ItemCategory is in STACKABLE, otherwise they don't
    private Item item;
    private int amount;

    public ItemStack(Item item){
        this.item = item;
        this.amount = 1;
    }
}
