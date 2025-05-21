package com.freund.tabletop_assistant.model.item.effect;

import com.freund.tabletop_assistant.model.ability.Ability;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WeaponUsesDifferentAttackRollModifier extends ItemEffect {
    private Ability ability;
    
    public WeaponUsesDifferentAttackRollModifier(Ability ability){
        super();
        this.ability = ability;
    }
}
