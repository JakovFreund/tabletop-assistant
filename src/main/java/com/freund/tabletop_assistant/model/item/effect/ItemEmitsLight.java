package com.freund.tabletop_assistant.model.item.effect;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ItemEmitsLight extends ItemEffect {
    public ItemEmitsLight(){
        super();
    }
}
