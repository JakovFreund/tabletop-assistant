package com.freund.tabletop_assistant.model.castable.spell;

import java.util.List;
import java.util.Map;

import com.freund.tabletop_assistant.model.ability.Ability;
import com.freund.tabletop_assistant.model.castable.Castable;
import com.freund.tabletop_assistant.model.castable.CastableDamageComponent;
import com.freund.tabletop_assistant.model.castable.CastableType;
import com.freund.tabletop_assistant.model.castable.EffectTarget;
import com.freund.tabletop_assistant.model.duration.Duration;
import com.freund.tabletop_assistant.model.statuseffect.StatusEffect;
import com.freund.tabletop_assistant.model.turnresource.TurnResourceType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Spell extends Castable {
    private int level;
    private SchoolOfMagic schoolOfMagic;
    private boolean upcastable;
    private List<String> descriptionAtHigherLevel;

    // render cost as either warlock spellslot or regular one, and on spell ping log both versions to console

    public Spell(CastableType castableType, int level, SchoolOfMagic schoolOfMagic, boolean ritual, boolean concentration,
            boolean upcastable, Ability savingThrow, EffectTarget effectTarget, Duration duration,
            Map<TurnResourceType, Integer> costs, List<CastableDamageComponent> castableDamageComponents,
            Map<Integer, String> healAtSlotLevel, List<StatusEffect> appliesStatusEffects, List<String> description,
            List<String> descriptionAtHigherLevel) {
        super(castableType, ritual, concentration, savingThrow, effectTarget, duration, costs, castableDamageComponents,
                healAtSlotLevel, appliesStatusEffects, description);
        this.level = level;
        this.schoolOfMagic = schoolOfMagic;
        this.upcastable = upcastable;
        this.descriptionAtHigherLevel = descriptionAtHigherLevel;
    }

}
