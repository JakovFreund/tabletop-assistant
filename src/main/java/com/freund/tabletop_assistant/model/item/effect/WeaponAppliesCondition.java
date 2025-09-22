package com.freund.tabletop_assistant.model.item.effect;

import com.freund.tabletop_assistant.model.condition.Condition;
import com.freund.tabletop_assistant.model.duration.Duration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WeaponAppliesCondition extends ItemEffect{
    private Condition condition;
    private Duration duration;

    public WeaponAppliesCondition(Condition condition, Duration duration){
        super();
        this.condition = condition;
        this.duration = duration;
    }
}
