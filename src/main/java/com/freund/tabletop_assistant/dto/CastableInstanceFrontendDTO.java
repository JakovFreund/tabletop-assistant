package com.freund.tabletop_assistant.dto;

import java.util.UUID;

import com.freund.tabletop_assistant.model.castable.Castable;
import com.freund.tabletop_assistant.model.damage.DamageInstance;

import lombok.Data;

@Data
public class CastableInstanceFrontendDTO {
    private Castable castable;
    private UUID casterId;
    private String casterName;
    private int slotLevel;
    private DamageInstance damageInstance;
}
