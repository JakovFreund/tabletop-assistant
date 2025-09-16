package com.freund.tabletop_assistant.model.gamelog.statcalculation;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StatCalculationBreakdown {
    private String type; // "Attack Roll" "Saving Throw"
    private int total;
    private List<StatCalculationStep> statCalculationSteps;
}
