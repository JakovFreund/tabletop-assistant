package com.freund.tabletop_assistant.model.item;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ContainerItem extends Item { // also render a little plus sign in top right corner of item
    private List<Item> internalInventory = new ArrayList<>();
    private boolean locked;
    // private float maxWeight; maybe implement later

    @Override
    public float getWeight() {
        float inventoryWeight = 0;
        for (Item item : this.getInternalInventory()){
            inventoryWeight += item.getWeight();
        }
        return inventoryWeight + super.getWeight();
    }
}
