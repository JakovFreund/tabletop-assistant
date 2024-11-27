package com.freund.tabletop_assistant.model.item;

import java.util.ArrayList;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemStack {
    private UUID itemId;
    private Item item; // TODO change to ArrayList<Item> because of UUID
    private int amount; // get this from items.length ^^
    private long lastModified; // TODO add currentDate function
    private ArrayList<ItemStack> inventory;

    public ItemStack(Item item, int amount) {
        System.out.println("ItemStack constructor");
        this.item = item;
        this.amount = amount;
        this.lastModified = System.currentTimeMillis(); // recently modified is bigger number

        if (item.getItemType().CATEGORY == ItemCategory.CONTAINER) {
            System.out.println("type container");
            inventory = new ArrayList<ItemStack>(); // also render a little plus sign in top right corner of item
        }
    }

    @Override
    public String toString() {
        return this.amount + "x " + this.item;
    }
}
