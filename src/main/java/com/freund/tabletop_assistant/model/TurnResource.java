package com.freund.tabletop_assistant.model;

public class TurnResource {
    private TurnResourceType type;
    private String name;
    private int amount;
    private int maxAmount;
    private RefillRate refillRate;

    public TurnResource() {
    }

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

    public TurnResourceType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public RefillRate getRefillRate() {
        return refillRate;
    }

    void setName(String name) {
        this.name = name;
    }

    void setAmount(int amount) {
        this.amount = amount;
    }

    void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    void setRefillRate(RefillRate refillRate) {
        this.refillRate = refillRate;
    }

}

// the turnresources get updated per id_string, but enumerators make it easier for me when adding
