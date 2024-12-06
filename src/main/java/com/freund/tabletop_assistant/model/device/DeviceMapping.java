package com.freund.tabletop_assistant.model.device;

import java.util.UUID;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceMapping {
    private String deviceNickname;
    private UUID creatureId;
    private boolean dungeonMaster;
}
