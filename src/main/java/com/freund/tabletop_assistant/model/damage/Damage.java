package com.freund.tabletop_assistant.model.damage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.freund.tabletop_assistant.util.DiceNotation;
import com.freund.tabletop_assistant.util.TabletopAssistantUtil;

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

    public List<DamageEntry> toDamageEntries() {
        List<DamageEntry> damageEntries = new ArrayList<>();
        for (DamageType damageType : components.keySet()) {
            damageEntries.add(new DamageEntry(damageType, components.get(damageType)));
        }
        return damageEntries;
    }

    public void addDamageComponent(String damageAmount, DamageType damageType) {
        if (components.containsKey(damageType)) {
            components.put(damageType, DiceNotation.addDice(damageAmount, this.getComponentAmount(damageType)));
        } else {
            components.put(damageType, damageAmount);
        }
    }

    public void addDamage(Damage otherDamage) {
        for (DamageType damageType : otherDamage.getComponents().keySet()) {
            this.addDamageComponent(otherDamage.getComponentAmount(damageType), damageType);
        }
    }

    public Map<DamageType, String> getComponents() {
        return Collections.unmodifiableMap(components);
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
            returnString = TabletopAssistantUtil.removeLastChar(returnString);
        }
        returnString += "}";
        return returnString;
    }
}
