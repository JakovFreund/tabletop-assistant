package com.freund.tabletop_assistant.model.gamelog.types;

import com.freund.tabletop_assistant.model.castable.CastableInstance;
import com.freund.tabletop_assistant.model.gamelog.LogEntry;
import com.freund.tabletop_assistant.model.gamelog.LogVisibility;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CastableUsedLogEntry extends LogEntry {
    private CastableInstance castableInstance;

    public CastableUsedLogEntry (CastableInstance castableInstance){
        super(LogVisibility.SCENE);
        this.castableInstance = castableInstance;
    }
}
