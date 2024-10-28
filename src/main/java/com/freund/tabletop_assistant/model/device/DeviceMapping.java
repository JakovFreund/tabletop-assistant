package com.freund.tabletop_assistant.model.device;

import java.util.UUID;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
public class DeviceMapping {
    private UUID deviceId;
    private UUID creatureId;
    private boolean dungeonMaster;
}
