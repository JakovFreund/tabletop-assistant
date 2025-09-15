package com.freund.tabletop_assistant.mapper;

import com.freund.tabletop_assistant.dto.StatusEffectInstanceDTO;
import com.freund.tabletop_assistant.model.statuseffect.StatusEffectInstance;

public class StatusEffectInstanceMapper {
    public static StatusEffectInstanceDTO toDTO (StatusEffectInstance statusEffectInstance){
        if (statusEffectInstance == null) {
            return null;
        }
        StatusEffectInstanceDTO dto = new StatusEffectInstanceDTO();
        dto.setStatusEffect(statusEffectInstance.getStatusEffect());
        dto.setDuration(statusEffectInstance.getDuration());
        dto.setEffectSourceDTO(EffectSourceMapper.toDTO(statusEffectInstance.getEffectSource()));
        return dto;
    }
}
