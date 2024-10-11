package com.freund.tabletop_assistant.model.item;

import java.util.ArrayList;

public class ItemStack {
    private Item item;
    private int amount;
    private long lastModified; // TODO add currentDate function
    private ArrayList<ItemStack> inventory;

    public ItemStack() {
    }

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

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public long getLastModified() {
        return lastModified;
    }

    public ArrayList<ItemStack> getInventory() {
        return inventory;
    }

}
