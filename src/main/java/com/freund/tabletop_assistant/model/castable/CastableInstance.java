package com.freund.tabletop_assistant.model.castable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.damage.Damage;
import com.freund.tabletop_assistant.model.damage.DamageInstance;
import com.freund.tabletop_assistant.model.source.EffectSource;
import com.freund.tabletop_assistant.model.source.EffectSourceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CastableInstance {
    private Castable castable;
    private Creature caster;
    private int currentCasterLevel;
    private int slotLevel; // because of upcast

    @JsonIgnore
    public DamageInstance getDamageInstance(){
        DamageInstance damageInstance = new DamageInstance();
        EffectSource effectSource = new EffectSource(EffectSourceType.CASTABLE, getCaster());
        damageInstance.setEffectSource(effectSource);
        Damage totalDamage = new Damage();
        for (CastableDamageComponent castableDamageComponent : getCastable().getCastableDamageComponents()){
            totalDamage.addDamage(castableDamageComponent.getDamage(currentCasterLevel, slotLevel));
        }
        damageInstance.setDamage(totalDamage);
        return damageInstance;
    }
}

