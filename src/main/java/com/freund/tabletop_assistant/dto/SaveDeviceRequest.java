package com.freund.tabletop_assistant.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class SaveDeviceRequest {
    private UUID deviceId;
    private String deviceNickname;
}
