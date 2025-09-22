package com.freund.tabletop_assistant.model.castable;

import java.util.HashMap;
import java.util.Map;

import com.freund.tabletop_assistant.model.damage.Damage;
import com.freund.tabletop_assistant.model.damage.DamageType;
import com.freund.tabletop_assistant.util.TabletopAssistantUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CastableDamageComponent {
    private DamageType damageType;
    private Map<Integer, String> damageAtCreatureLevel = new HashMap<>();
    private Map<Integer, String> damageAtSlotLevel = new HashMap<>();

    public Damage getDamage(int creatureLevel, int slotLevel) {
        Damage damage = new Damage();
        if (damageAtCreatureLevel.isEmpty()) {
            if (damageAtSlotLevel.isEmpty()) {
                System.out.println("CastableDamageComponent: damage not defined.");
                return null;
            }
            if (damageAtSlotLevel.containsKey(slotLevel)) {
                damage.addDamageComponent(damageAtSlotLevel.get(slotLevel), damageType);
                return damage;
            } else {
                System.out.println("CastableDamageComponent: Castable slot level not defined.");
                return null;
            }
        }
        // find damageAtCreatureLevel's max key < creatureLevel
        Integer key = TabletopAssistantUtil.findMaxNumberSmallerOrEqualThan(damageAtCreatureLevel.keySet(), creatureLevel);
        if (key!=null) {
            String value = damageAtCreatureLevel.get(key);
            damage.addDamageComponent(value, damageType);
            return damage;
        } else {
            System.out.println("CastableDamageComponent: Castable creature level not defined.");
            return null;
        }
    }
}
