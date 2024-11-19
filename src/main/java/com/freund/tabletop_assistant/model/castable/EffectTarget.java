package com.freund.tabletop_assistant.model.castable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EffectTarget {
    RangeType rangeType;
    int rangeSize; // ignore if rangeType != RANGE
    AreaType areaType;
    int areaSize;

    public EffectTarget(RangeType rangeType, int rangeSize){
        this.rangeType = rangeType;
        this.rangeSize = rangeSize;
        this.areaType = null;
        this.areaSize = 0;
    }
}
