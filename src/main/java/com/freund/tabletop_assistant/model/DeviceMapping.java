package com.freund.tabletop_assistant.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceMapping {
    private UUID deviceId;
    private UUID creatureId;
}
