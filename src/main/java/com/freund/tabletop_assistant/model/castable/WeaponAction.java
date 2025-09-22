package com.freund.tabletop_assistant.model.castable;

import java.util.List;
import java.util.Map;

import com.freund.tabletop_assistant.model.ability.Ability;
import com.freund.tabletop_assistant.model.condition.Condition;
import com.freund.tabletop_assistant.model.duration.Duration;
import com.freund.tabletop_assistant.model.turnresource.TurnResourceType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WeaponAction extends Castable {
    private int flatDC;

    public WeaponAction(CastableType castableType, boolean ritual, boolean concentration, Ability savingThrow, int flatDC,
            EffectTarget effectTarget, Duration duration, Map<TurnResourceType, Integer> costs,
            List<CastableDamageComponent> castableDamageComponents, Map<Integer, String> healAtSlotLevel,
            List<Condition> appliesConditions, List<String> description) {
        super(castableType, ritual, concentration, savingThrow, effectTarget, duration, costs, castableDamageComponents,
                healAtSlotLevel, appliesConditions, description);
        this.flatDC = flatDC;
    }
}
