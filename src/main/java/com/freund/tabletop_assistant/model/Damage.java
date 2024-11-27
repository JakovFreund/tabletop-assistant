package com.freund.tabletop_assistant.model;

import java.util.HashMap;
import java.util.List;

import com.freund.tabletop_assistant.util.StringUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Damage {
    private HashMap<DamageType, String> components;
    EffectSource source;

    // probably remove
    public Damage(List<String> componentValues) {
        this.components = new HashMap<DamageType, String>();
        this.source = null;
        if (componentValues.size() != DamageType.values().length) {
            throw new IllegalArgumentException("Damage values list size must be equal to the amount of DamageTypes");
        }  
        for (int i = 0; i < DamageType.values().length; i++) {
            this.components.put(DamageType.values()[i], componentValues.get(i));
        }
    }

    public String getComponent(DamageType damageType) {
        if (!this.components.containsKey(damageType)) {
            return "0";
        }
        return this.components.get(damageType);
    }

    @Override
    public String toString() {
        String returnString = "Damage{";
        for (DamageType damageType : DamageType.values()) {
            if (this.getComponent(damageType) != "0") {
                returnString += damageType.toString() + ":" + this.getComponent(damageType) + ";";
            }
        }
        if (returnString != "Damage{") {
            returnString = StringUtil.removeLastChar(returnString);
        }
        returnString += "}";
        return returnString;
    }
}
