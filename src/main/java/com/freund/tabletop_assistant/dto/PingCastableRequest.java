package com.freund.tabletop_assistant.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class PingCastableRequest {
    private UUID deviceId;
    private UUID casterId;
    private String castableName;
    private int slotLevel;
}
