package com.freund.tabletop_assistant.model.item.effect;

import com.freund.tabletop_assistant.model.statuseffect.StatusEffect;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EquipedItemGrantsStatusEffect extends ItemEffect { // duration indefinite
    private StatusEffect statusEffect;
    
    public EquipedItemGrantsStatusEffect(StatusEffect statusEffect){
        super();
        this.statusEffect = statusEffect;
    }
}
