package com.freund.tabletop_assistant.model.castable;

import java.util.List;
import java.util.Map;

import com.freund.tabletop_assistant.model.Ability;
import com.freund.tabletop_assistant.model.Duration;
import com.freund.tabletop_assistant.model.StatusEffect;
import com.freund.tabletop_assistant.model.TurnResourceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Spell extends Castable {
    private int level;
    private SchoolOfMagic schoolOfMagic;
    private boolean upcast;
    private List<String> descriptionAtHigherLevel;

    // TODO function to calculate upcast/render spell based on character level, and spell level, probably return a dto spell
    // render cost as either warlock spellslot or regular one, and on spell ping log both versions to console
    // public String getSpellDTO(int requestedSpellLevel, Creature creature) {

    public Spell(String name, int level, SchoolOfMagic schoolOfMagic, boolean ritual, boolean concentration,
            boolean upcast, Ability savingThrow, EffectTarget effectTarget, Duration duration,
            Map<TurnResourceType, Integer> costs, List<CastableDamageComponent> castableDamageComponents,
            Map<Integer, String> healAtSlotLevel, List<StatusEffect> statusEffects, List<String> description,
            List<String> descriptionAtHigherLevel) {
        super(name, ritual, concentration, savingThrow, effectTarget, duration, costs, castableDamageComponents,
                healAtSlotLevel, statusEffects, description);
        this.level = level;
        this.schoolOfMagic = schoolOfMagic;
        this.upcast = upcast;
        this.descriptionAtHigherLevel = descriptionAtHigherLevel;
    }

}
