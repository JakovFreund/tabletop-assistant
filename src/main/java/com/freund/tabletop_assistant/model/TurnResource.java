package com.freund.tabletop_assistant.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurnResource {
    private TurnResourceType type; // the turnresources get updated per id_string, but enumerators make it easier for me when adding
    private String name;
    private int amount;
    private int maxAmount;
    private RefillRate refillRate;

    public TurnResource(TurnResourceType type) {
        this.type = type;
        this.name = type.name;
        this.amount = type.defaultMaxAmount;
        this.maxAmount = type.defaultMaxAmount;
        this.refillRate = type.defaultRefillRate;
    }

    public TurnResource(TurnResourceType type, int maxAmount) {
        this(type);
        this.amount = maxAmount;
        this.maxAmount = maxAmount;
    }

    public TurnResource(String customName, int maxAmount) {
        this(TurnResourceType.CUSTOM, maxAmount);
        this.name = customName;
    }
}