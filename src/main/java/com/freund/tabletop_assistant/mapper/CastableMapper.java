package com.freund.tabletop_assistant.mapper;

import com.freund.tabletop_assistant.dto.CastableInstanceDTO;
import com.freund.tabletop_assistant.dto.CastableInstanceFrontendDTO;
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

    public static CastableInstanceFrontendDTO toFrontendDTO(CastableInstance castableInstance){
        if (castableInstance == null) {
            return null;
        }
        CastableInstanceFrontendDTO dto = new CastableInstanceFrontendDTO();
        dto.setCastable(castableInstance.getCastable());
        dto.setCasterId(castableInstance.getCaster().getCreatureId());
        dto.setCasterName(castableInstance.getCaster().getName());
        dto.setSlotLevel(castableInstance.getSlotLevel());
        dto.setDamageInstance(castableInstance.getDamageInstance());
        return dto;
    }
}
