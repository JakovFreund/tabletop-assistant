package com.freund.tabletop_assistant.model;

public class StatusEffectInstance {
    private StatusEffect statusEffect;
    private Duration duration;
    private int turnsDuration; // maybe change to turnsDuration
    private String customNote; // DM inputed reminder

    public StatusEffectInstance() {
    }

    public StatusEffectInstance(StatusEffect statusEffect, int turnsDuration, Duration duration, String customNote) {
        this.statusEffect = statusEffect;
        this.duration = duration;
        this.turnsDuration = turnsDuration; // ignore if duration != TURNS
        this.customNote = customNote;
    }

    public StatusEffect getStatusEffect() {
        return statusEffect;
    }

    public Duration getDuration() {
        return duration;
    }

    public int getTurnsDuration() {
        return turnsDuration;
    }

    public String getCustomNote() {
        return customNote;
    }

    public void setStatusEffect(StatusEffect statusEffect) {
        this.statusEffect = statusEffect;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setTurnsDuration(int turnsDuration) {
        this.turnsDuration = turnsDuration;
    }

    public void setCustomNote(String customNote) {
        this.customNote = customNote;
    }

    

    
}
