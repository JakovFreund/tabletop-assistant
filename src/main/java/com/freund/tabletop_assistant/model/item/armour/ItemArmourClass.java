package com.freund.tabletop_assistant.model.item.armour;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemArmourClass {
    private int base;
    private boolean dexterityBonus; // apply dex modifier up to maxBonus (if different than -1)
    private int maxBonus;
}
