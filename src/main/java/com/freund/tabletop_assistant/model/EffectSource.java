package com.freund.tabletop_assistant.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EffectSource { // used for damageinstance, statuseffect
    EffectSourceType EffectSourceType;
    UUID creatureId;
}
