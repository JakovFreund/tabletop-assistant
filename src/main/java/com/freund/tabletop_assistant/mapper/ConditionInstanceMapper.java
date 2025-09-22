package com.freund.tabletop_assistant.mapper;

import com.freund.tabletop_assistant.dto.ConditionInstanceDTO;
import com.freund.tabletop_assistant.model.condition.ConditionInstance;

public class ConditionInstanceMapper {
    public static ConditionInstanceDTO toDTO (ConditionInstance conditionInstance){
        if (conditionInstance == null) {
            return null;
        }
        ConditionInstanceDTO dto = new ConditionInstanceDTO();
        dto.setCondition(conditionInstance.getCondition());
        dto.setDuration(conditionInstance.getDuration());
        dto.setEffectSourceDTO(EffectSourceMapper.toDTO(conditionInstance.getEffectSource()));
        return dto;
    }
}
