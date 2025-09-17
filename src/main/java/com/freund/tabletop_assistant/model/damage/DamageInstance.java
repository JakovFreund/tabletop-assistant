package com.freund.tabletop_assistant.model.damage;

import com.freund.tabletop_assistant.model.source.EffectSource;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DamageInstance {
    private Damage damage;
    private EffectSource effectSource;
}
