package com.freund.tabletop_assistant.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class CastableInstanceDTO {
    private String castableName;
    private UUID casterId;
    private int currentCasterLevel;
    private int slotLevel;
}
