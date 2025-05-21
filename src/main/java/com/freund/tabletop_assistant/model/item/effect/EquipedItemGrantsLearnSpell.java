package com.freund.tabletop_assistant.model.item.effect;

import com.freund.tabletop_assistant.model.ability.Ability;
import com.freund.tabletop_assistant.model.castable.spell.Spell;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EquipedItemGrantsLearnSpell extends ItemEffect {
    private Spell spell;
    private Ability primaryDCAbility; // probably need this for non-caster creatures ?

    public EquipedItemGrantsLearnSpell(Spell spell, Ability primaryDCAbility){
        super();
        this.spell = spell;
        this.primaryDCAbility = primaryDCAbility;
    }
}
