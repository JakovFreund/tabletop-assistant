package com.freund.tabletop_assistant.dto;

import java.util.UUID;

import com.freund.tabletop_assistant.model.source.EffectSourceType;

import lombok.Data;

@Data
public class EffectSourceDTO {
    private EffectSourceType effectSourceType;
    private UUID creatureId;
}
