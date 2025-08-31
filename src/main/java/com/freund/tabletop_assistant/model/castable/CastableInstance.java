package com.freund.tabletop_assistant.model.castable;

import com.freund.tabletop_assistant.model.source.EffectSource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CastableInstance {
    private Castable castable;
    private EffectSource effectSource;
}
