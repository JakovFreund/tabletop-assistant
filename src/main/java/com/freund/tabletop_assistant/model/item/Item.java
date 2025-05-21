package com.freund.tabletop_assistant.model.item;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.freund.tabletop_assistant.model.item.armour.Armour;
import com.freund.tabletop_assistant.model.item.effect.ItemEffect;
import com.freund.tabletop_assistant.model.item.weapon.Weapon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type") // this will add a temporary extra field in the json during serialization (ex. "type":"weapon")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Armour.class, name = "armour"),
    @JsonSubTypes.Type(value = Weapon.class, name = "weapon"),
    @JsonSubTypes.Type(value = ItemStack.class, name = "stack"),
    @JsonSubTypes.Type(value = ContainerItem.class, name = "container")
})
public class Item {
    private UUID itemId;
    private String name;
    private String img;
    private ItemCategory category;
    private Rarity rarity;
    private int cost; // in cp
    private float weight;
    private boolean needsIdentify; // (true for mysterious items, determines if players can by default see: name, cost, effects, description)
    private long lastModified;
    private List<ItemEffect> effects;
    private List<String> description;



    public Item generateRandomItem(){
        // take random item from ItemData (distribution based on rarity)
        // use Item.createItem() for Stackable
        // add random effects/rarity if in MUTABLE_EFFECTS
        return null;
    }

    public Item (String name, String img, ItemCategory category, Rarity rarity, int cost, float weight, boolean needsIdentify, List<ItemEffect> effects, List<String> description){
        this.name = name;
        this.img = img;
        this.category = category;
        this.rarity = rarity;
        this.cost = cost;
        this.weight = weight;
        this.needsIdentify = needsIdentify;
        this.effects = effects;
        this.description = description;

        this.itemId = UUID.randomUUID();
        this.lastModified = System.currentTimeMillis(); // recently modified is bigger number
    }

}
