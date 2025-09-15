package com.freund.tabletop_assistant.model.gamelog;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class LogEntry {
    private UUID logEntryId;
    private Instant timestamp;
    private LogVisibility visibility;

    public LogEntry(LogVisibility visibility){
        this.logEntryId = UUID.randomUUID();
        this.timestamp = Instant.now();
        this.visibility = visibility;
    }
}
