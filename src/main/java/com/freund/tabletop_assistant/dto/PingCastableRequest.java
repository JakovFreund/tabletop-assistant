package com.freund.tabletop_assistant.dto;

import java.util.UUID;

import com.freund.tabletop_assistant.model.castable.CastableType;

import lombok.Data;

@Data
public class PingCastableRequest {
    private UUID deviceId;
    private UUID casterId;
    private CastableType castableType;
    private int slotLevel;
}
