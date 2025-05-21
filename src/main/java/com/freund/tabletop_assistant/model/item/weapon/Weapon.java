package com.freund.tabletop_assistant.model.item.weapon;

import java.util.List;
import java.util.Map;

import com.freund.tabletop_assistant.model.damage.DamageType;
import com.freund.tabletop_assistant.model.item.Item;
import com.freund.tabletop_assistant.model.item.ItemCategory;
import com.freund.tabletop_assistant.model.item.Rarity;
import com.freund.tabletop_assistant.model.item.effect.ItemEffect;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Weapon extends Item {
    private WeaponAttributes weaponAttributes;
    private Map<DamageType, String> damageComponents;

    public Weapon (String name, String img, Rarity rarity, int cost, float weight, boolean needsIdentify, List<ItemEffect> effects, List<String> description, WeaponAttributes weaponAttributes, Map<DamageType, String> damageComponents){
        super(name, img, ItemCategory.WEAPON, rarity, cost, weight, needsIdentify, effects, description);
        this.weaponAttributes = weaponAttributes;
        this.damageComponents = damageComponents;
    }


}
