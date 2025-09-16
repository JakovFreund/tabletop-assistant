package com.freund.tabletop_assistant.model.gamelog.types;

import com.freund.tabletop_assistant.model.castable.CastableInstance;
import com.freund.tabletop_assistant.model.device.Device;
import com.freund.tabletop_assistant.model.gamelog.LogEntry;
import com.freund.tabletop_assistant.model.gamelog.LogVisibility;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CastablePingedLogEntry extends LogEntry {
    private Device device;
    private CastableInstance castableInstance;

    public CastablePingedLogEntry (Device device, CastableInstance castableInstance){
        super(LogVisibility.PLAYER_PING, false);
        this.device = device;
        this.castableInstance = castableInstance;
    }
}
