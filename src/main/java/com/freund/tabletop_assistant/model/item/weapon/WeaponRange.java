package com.freund.tabletop_assistant.model.item.weapon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeaponRange {
    private WeaponRangeType weaponRangeType;
    private int amount;
    private int throwRangeAmount;
}
