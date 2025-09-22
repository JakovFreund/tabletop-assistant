package com.freund.tabletop_assistant.model.item.effect;

import com.freund.tabletop_assistant.model.condition.Condition;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ItemInInventoryGrantsCondition extends ItemEffect { // duration indefinite
    private Condition condition;
    
    public ItemInInventoryGrantsCondition(Condition condition){
        super();
        this.condition = condition;
    }
}
