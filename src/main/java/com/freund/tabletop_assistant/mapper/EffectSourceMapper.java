package com.freund.tabletop_assistant.mapper;

import com.freund.tabletop_assistant.dto.EffectSourceDTO;
import com.freund.tabletop_assistant.model.source.EffectSource;

public class EffectSourceMapper {
    public static EffectSourceDTO toDTO (EffectSource effectSource){
        if (effectSource == null) {
            return null;
        }
        EffectSourceDTO dto = new EffectSourceDTO();
        dto.setCreatureId(effectSource.getCreature().getCreatureId());
        dto.setEffectSourceType(effectSource.getEffectSourceType());
        return dto;
    }
}
