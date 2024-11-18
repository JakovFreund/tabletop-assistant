package com.freund.tabletop_assistant.model;

import java.util.Map;

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

    public Damage getDamage(int creatureLevel, int slotLevel){

        // TODO

        return null;
    }
}
