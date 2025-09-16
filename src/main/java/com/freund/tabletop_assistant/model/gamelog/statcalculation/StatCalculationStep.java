package com.freund.tabletop_assistant.model.gamelog.statcalculation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StatCalculationStep {
    private int value;
    private String description; // "1d20" "Disadvantage" "Dexterity Modifier", dont mention damage types
}
