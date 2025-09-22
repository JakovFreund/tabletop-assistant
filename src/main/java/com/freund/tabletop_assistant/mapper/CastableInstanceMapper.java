package com.freund.tabletop_assistant.mapper;

import com.freund.tabletop_assistant.dto.CastableInstanceFileDTO;
import com.freund.tabletop_assistant.dto.CastableInstanceFrontendDTO;
import com.freund.tabletop_assistant.model.castable.CastableInstance;

public class CastableInstanceMapper {
    public static CastableInstanceFileDTO toFileDTO(CastableInstance castableInstance) {
        if (castableInstance == null) {
            return null;
        }
        CastableInstanceFileDTO dto = new CastableInstanceFileDTO();
        dto.setCastableType(castableInstance.getCastable().getCastableType());
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
        dto.setCastable(CastableMapper.toDTO(castableInstance.getCastable()));
        dto.setCasterId(castableInstance.getCaster().getCreatureId());
        dto.setCasterName(castableInstance.getCaster().getName());
        dto.setSlotLevel(castableInstance.getSlotLevel());
        dto.setDamageInstance(DamageInstanceMapper.toDTO(castableInstance.getDamageInstance()));
        return dto;
    }
}
