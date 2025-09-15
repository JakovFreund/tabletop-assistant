package com.freund.tabletop_assistant.mapper;

import com.freund.tabletop_assistant.dto.CastableInstanceDTO;
import com.freund.tabletop_assistant.model.castable.CastableInstance;

public class CastableMapper {
    public static CastableInstanceDTO toDTO(CastableInstance castableInstance) {
        if (castableInstance == null) {
            return null;
        }
        CastableInstanceDTO dto = new CastableInstanceDTO();
        dto.setCastableName(castableInstance.getCastable().getName());
        dto.setCasterId(castableInstance.getCaster().getCreatureId());
        dto.setCurrentCasterLevel(castableInstance.getCurrentCasterLevel());
        dto.setSlotLevel(castableInstance.getSlotLevel());
        return dto;
    }
}
