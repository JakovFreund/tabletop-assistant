package com.freund.tabletop_assistant.dto;

import com.freund.tabletop_assistant.model.condition.Condition;
import com.freund.tabletop_assistant.model.duration.Duration;

import lombok.Data;

@Data
public class ConditionInstanceDTO {
    private Condition condition;
    private Duration duration;
    private EffectSourceDTO effectSourceDTO;
}
