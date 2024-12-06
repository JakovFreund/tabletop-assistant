package com.freund.tabletop_assistant.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class SaveDeviceMappingRequest {
    private String deviceNickname;
    private UUID creatureId;
    private boolean dungeonMaster;
}
