package com.freund.tabletop_assistant.model.item.weapon;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeaponAttributes {
    private WeaponType weaponType;
    private WeaponCategory weaponCategory;
    private WeaponRange weaponRange;
    private List<WeaponProperty> weaponProperties;
    // List<WeaponAction>

    public WeaponAttributes(WeaponType weaponType){
        this.weaponType = weaponType;
        this.weaponCategory = weaponType.WEAPON_CATEGORY;
        this.weaponRange = weaponType.WEAPON_RANGE;
        this.weaponProperties = weaponType.WEAPON_PROPERTIES;
        // List<WeaponAction>
    }

    public WeaponAttributes(WeaponCategory weaponCategory, WeaponRange weaponRange, List<WeaponProperty> weaponProperties){
        this.weaponType = WeaponType.UNKNOWN;
        this.weaponCategory = weaponCategory;
        this.weaponRange = weaponRange;
        this.weaponProperties = weaponProperties;
        // List<WeaponAction>
    }
}
