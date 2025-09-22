package com.freund.tabletop_assistant.dto;

import java.util.UUID;

import com.freund.tabletop_assistant.model.castable.CastableType;

import lombok.Data;

@Data
public class CastableInstanceFileDTO {
    private CastableType castableType;
    private UUID casterId;
    private int currentCasterLevel;
    private int slotLevel;
}
