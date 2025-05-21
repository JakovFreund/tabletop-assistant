package com.freund.tabletop_assistant.model.item.effect;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WeaponBonusAttackRoll extends ItemEffect {
    private String attackRoll;

    public WeaponBonusAttackRoll(String attackRoll){
        super();
        this.attackRoll = attackRoll;
    }  
}
