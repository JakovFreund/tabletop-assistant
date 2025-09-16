package com.freund.tabletop_assistant.model.castable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.freund.tabletop_assistant.model.damage.Damage;
import com.freund.tabletop_assistant.model.damage.DamageType;

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
                return null;
            }
            if (damageAtSlotLevel.containsKey(slotLevel)) {
                damage.addDamageComponent(damageAtSlotLevel.get(slotLevel), damageType);
                return damage;
            } else {
                System.out.println("Castable slot level not defined.");
                return null;
            }
        }
        // find damageAtCreatureLevel's max key < creatureLevel
        Optional<Integer> key = damageAtCreatureLevel.keySet().stream()
                .filter(k -> k < creatureLevel)
                .max(Integer::compareTo);

        if (key.isPresent()) {
            // use highestKey and value
            int highestKey = key.get();
            String value = damageAtCreatureLevel.get(highestKey);
            damage.addDamageComponent(value, damageType);
            return damage;
        } else {
            System.out.println("Castable level not defined.");
            return null;
        }
    }
}
