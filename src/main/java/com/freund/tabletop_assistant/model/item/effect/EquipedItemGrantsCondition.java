package com.freund.tabletop_assistant.model.item.effect;

import com.freund.tabletop_assistant.model.condition.Condition;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EquipedItemGrantsCondition extends ItemEffect { // duration indefinite
    private Condition condition;
    
    public EquipedItemGrantsCondition(Condition condition){
        super();
        this.condition = condition;
    }
}
