package com.freund.tabletop_assistant.model.source;

import com.freund.tabletop_assistant.model.creature.Creature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EffectSource { // used for damageinstance, statuseffect
    private EffectSourceType effectSourceType;
    private Creature creature;
}
