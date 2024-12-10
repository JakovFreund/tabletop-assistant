package com.freund.tabletop_assistant.model.source;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EffectSource { // used for damageinstance, statuseffect
    EffectSourceType effectSourceType;
    UUID creatureId;
}
