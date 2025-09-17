package com.freund.tabletop_assistant.mapper;

import com.freund.tabletop_assistant.dto.DamageInstanceDTO;
import com.freund.tabletop_assistant.model.damage.DamageInstance;

public class DamageInstanceMapper {
    public static DamageInstanceDTO toDTO(DamageInstance damageInstance) {
        if (damageInstance == null) {
            return null;
        }
        DamageInstanceDTO dto = new DamageInstanceDTO();
        dto.setDamage(damageInstance.getDamage());
        dto.setEffectSource(EffectSourceMapper.toDTO(damageInstance.getEffectSource()));
        return dto;
    }

}
