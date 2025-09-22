package com.freund.tabletop_assistant.mapper;

import com.freund.tabletop_assistant.dto.CastableDTO;
import com.freund.tabletop_assistant.model.castable.Castable;

public class CastableMapper {
    // TODO Spell stuff?, schools...
    // TODO WeaponAction.flatDC
    // maybe add String castableCategory for frontend rendering
    public static CastableDTO toDTO(Castable castable){
        CastableDTO dto = new CastableDTO();
        dto.setCastableType(castable.getCastableType());
        dto.setCastableName(castable.getCastableType().CASTABLE_NAME);
        dto.setRitual(castable.isRitual());
        dto.setConcentration(castable.isConcentration());
        dto.setSavingThrow(castable.getSavingThrow());
        dto.setEffectTarget(castable.getEffectTarget());
        dto.setDuration(castable.getDuration());
        dto.setCosts(castable.getCosts());
        dto.setCastableDamageComponents(castable.getCastableDamageComponents());
        dto.setHealAtSlotLevel(castable.getHealAtSlotLevel());
        dto.setAppliesConditions(castable.getAppliesConditions());
        dto.setDescription(castable.getDescription());
        return dto;
    }
}
