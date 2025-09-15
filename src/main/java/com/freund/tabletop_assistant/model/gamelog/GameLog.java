package com.freund.tabletop_assistant.model.gamelog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class GameLog {
    private List<LogEntry> logEntries = new ArrayList<>();

    public void add(LogEntry logEntry){
        logEntries.add(logEntry);
    }
}
