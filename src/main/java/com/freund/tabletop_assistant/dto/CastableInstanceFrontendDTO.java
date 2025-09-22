package com.freund.tabletop_assistant.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class CastableInstanceFrontendDTO {
    private CastableDTO castable;
    private UUID casterId;
    private String casterName;
    private int slotLevel;
    private DamageInstanceDTO damageInstance;
}
