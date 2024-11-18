package com.freund.tabletop_assistant.model;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ClassAction extends Castable {
    public ClassAction(String name, boolean ritual, boolean concentration, Ability savingThrow,
            EffectTarget effectTarget, Duration duration, Map<TurnResourceType, Integer> costs,
            List<CastableDamageComponent> castableDamageComponents, Map<Integer, String> healAtSlotLevel,
            List<StatusEffect> statusEffects, List<String> description) {
        super(name, ritual, concentration, savingThrow, effectTarget, duration, costs, castableDamageComponents,
                healAtSlotLevel, statusEffects, description);
    }
}

/*
    public static final List<OldClassAction> CLASS_ACTIONS = List.of(
                        new OldClassAction("Rage", List.of("Bonus Action", "Rage Charge"), false, false, List.of(),
                                        "(Available only in combat) Deal 2 extra damage with melee and improvised weapons, and throwing. You have Resistance to physical damage, and Advantage on Strength Checks and Saving Throws. Rage ends early if you don't attack an enemy or take damage each turn. You can't cast or concentrate on spells while raging."),
                        new OldClassAction("Action Surge", List.of("Action Surge Charge"), false, false, List.of(),
                                        "Immediately gain an extra action to use this turn.")
        //Create Spell Slot
        //Bardic Inspiration
        //Cutting Words

        // unique actions of summons and druid wild shape also go here (don't need monsters since players aren't gonna be controlling them) - technically racial actions
        // Water elemental: Slam, Winter's Breath, Multiattack
        );
 */