package com.freund.tabletop_assistant.model.item.effect;

import java.util.Map;

import com.freund.tabletop_assistant.model.damage.DamageType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WeaponBonusDamage extends ItemEffect{
    private Map<DamageType, String> damageComponents;

    public WeaponBonusDamage(Map<DamageType, String> damageComponents){
        super();
        this.damageComponents = damageComponents;
    }
}