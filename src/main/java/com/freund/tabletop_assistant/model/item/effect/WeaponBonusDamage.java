package com.freund.tabletop_assistant.model.item.effect;

import com.freund.tabletop_assistant.model.damage.Damage;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WeaponBonusDamage extends ItemEffect{
    private Damage damage;

    public WeaponBonusDamage(Damage damage){
        super();
        this.damage = damage;
    }
}