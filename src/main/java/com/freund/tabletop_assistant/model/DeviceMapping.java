package com.freund.tabletop_assistant.model;

import java.util.UUID;

public class DeviceMapping {
    private UUID deviceId;
    private UUID creatureId;

    public DeviceMapping(UUID deviceId, UUID creatureId) {
        this.deviceId = deviceId;
        this.creatureId = creatureId;
    }

    public UUID getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
        this.deviceId = deviceId;
    }

    public UUID getCreatureId() {
        return creatureId;
    }

    public void setCreatureId(UUID creatureId) {
        this.creatureId = creatureId;
    }
    
    
    
}
