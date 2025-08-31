package com.freund.tabletop_assistant.model.castable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.freund.tabletop_assistant.model.damage.Damage;
import com.freund.tabletop_assistant.model.damage.DamageType;
import com.freund.tabletop_assistant.model.source.EffectSource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CastableDamageComponent {
    private DamageType damageType;
    private Map<Integer, String> damageAtCreatureLevel;
    private Map<Integer, String> damageAtSlotLevel;

    public Damage getDamage(int creatureLevel, int slotLevel, EffectSource source) {
        if (damageAtCreatureLevel.isEmpty()) {
            if (damageAtSlotLevel.isEmpty()) {
                return null;
            }
            if (damageAtSlotLevel.containsKey(slotLevel)) {
                HashMap<DamageType, String> components = new HashMap<DamageType, String>();
                components.put(damageType, damageAtSlotLevel.get(slotLevel));
                return new Damage(components, source);
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
            HashMap<DamageType, String> components = new HashMap<DamageType, String>();
            components.put(damageType, value);
            return new Damage(components, source);
        } else {
            System.out.println("Castable level not defined.");
            return null;
        }
    }
}
