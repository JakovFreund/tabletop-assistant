package com.freund.tabletop_assistant.model.device;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceMapping {
    private UUID deviceId;
    private UUID creatureId;
    private boolean isDM;
}
