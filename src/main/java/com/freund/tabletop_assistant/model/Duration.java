package com.freund.tabletop_assistant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Duration {
    private DurationType durationType;
    private int turnsDuration; // ignore if duration != TURNS

    public Duration (DurationType durationType){
        this.durationType = durationType;
        this.turnsDuration = 0;
    }
}
