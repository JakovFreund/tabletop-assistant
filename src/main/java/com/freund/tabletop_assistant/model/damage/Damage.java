package com.freund.tabletop_assistant.model.damage;

import java.util.HashMap;
import java.util.Map;

import com.freund.tabletop_assistant.util.StringUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Damage {
    private Map<DamageType, String> components = new HashMap<>();

    public String getComponentAmount(DamageType damageType) {
        if (!this.components.containsKey(damageType)) {
            return "0";
        }
        return this.components.get(damageType);
    }

    @Override
    public String toString() {
        String returnString = "Damage{";
        for (DamageType damageType : DamageType.values()) {
            if (this.getComponentAmount(damageType) != "0") {
                returnString += damageType.toString() + ":" + this.getComponentAmount(damageType) + ";";
            }
        }
        if (returnString != "Damage{") {
            returnString = StringUtil.removeLastChar(returnString);
        }
        returnString += "}";
        return returnString;
    }
}
