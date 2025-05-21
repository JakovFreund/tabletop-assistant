package com.freund.tabletop_assistant.model.item.armour;

import java.util.List;

import com.freund.tabletop_assistant.model.item.Item;
import com.freund.tabletop_assistant.model.item.ItemCategory;
import com.freund.tabletop_assistant.model.item.Rarity;
import com.freund.tabletop_assistant.model.item.effect.ItemEffect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Armour extends Item {
    private ArmourCategory armourCategory;
    private ItemArmourClass armourClass;
    private boolean stealthDisadvantage;
    private int minimumStrength;

    public Armour (String name, String img, Rarity rarity, int cost, float weight, boolean needsIdentify, List<ItemEffect> effects, List<String> description, ArmourCategory armourCategory, ItemArmourClass armourClass, boolean stealthDisadvantage, int minimumStrength){
        super(name, img, ItemCategory.ARMOUR, rarity, cost, weight, needsIdentify, effects, description);
        this.armourCategory = armourCategory;
        this.armourClass = armourClass;
        this.stealthDisadvantage = stealthDisadvantage;
        this.minimumStrength = minimumStrength;
    }
}
