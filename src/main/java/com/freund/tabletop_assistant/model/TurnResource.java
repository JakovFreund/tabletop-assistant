package com.freund.tabletop_assistant.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurnResource {
    private TurnResourceType type; // the turnresources get updated per id_string, but enumerators make it easier for me when adding
    private String name; // also need name for different instances of same TurnResourceType (ex. multiclass HitDice) 
    private int amount;
    private int maxAmount;
    private RefillRate refillRate;

    public TurnResource(TurnResourceType type) {
        this.setType(type);
        this.setName(type.defaultName);
        this.setAmount(type.defaultMaxAmount);
        this.setMaxAmount(type.defaultMaxAmount);
        this.setRefillRate(type.defaultRefillRate);
    }

    public TurnResource(TurnResourceType type, int maxAmount) {
        this(type);
        this.setAmount(maxAmount);
        this.setMaxAmount(maxAmount);
    }

    public TurnResource(TurnResourceType type, String name, int maxAmount) {
        this(type, maxAmount);
        this.setName(name);
    }

    public TurnResource(String customName, int maxAmount) {
        this(TurnResourceType.CUSTOM, maxAmount);
        this.setName(customName);
    }
}