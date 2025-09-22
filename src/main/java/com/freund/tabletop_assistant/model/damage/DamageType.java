package com.freund.tabletop_assistant.model.damage;

import java.util.List;

import com.freund.tabletop_assistant.model.condition.Condition;

public enum DamageType {
    BLUDGEONING(Condition.BLUDGEONING_VULNERABILITY, Condition.BLUDGEONING_RESISTANCE, Condition.BLUDGEONING_IMMUNITY),
    PIERCING(Condition.PIERCING_VULNERABILITY, Condition.PIERCING_RESISTANCE, Condition.PIERCING_IMMUNITY),
    SLASHING(Condition.SLASHING_VULNERABILITY, Condition.SLASHING_RESISTANCE, Condition.SLASHING_IMMUNITY),
    COLD(Condition.COLD_VULNERABILITY, Condition.COLD_RESISTANCE, Condition.COLD_IMMUNITY),
    FIRE(Condition.FIRE_VULNERABILITY, Condition.FIRE_RESISTANCE, Condition.FIRE_IMMUNITY),
    LIGHTNING(Condition.LIGHTNING_VULNERABILITY, Condition.LIGHTNING_RESISTANCE, Condition.LIGHTNING_IMMUNITY),
    THUNDER(Condition.THUNDER_VULNERABILITY, Condition.THUNDER_RESISTANCE, Condition.THUNDER_IMMUNITY),
    ACID(Condition.ACID_VULNERABILITY, Condition.ACID_RESISTANCE, Condition.ACID_IMMUNITY),
    POISON(Condition.POISON_VULNERABILITY, Condition.POISON_RESISTANCE, Condition.POISON_IMMUNITY),
    RADIANT(Condition.RADIANT_VULNERABILITY, Condition.RADIANT_RESISTANCE, Condition.RADIANT_IMMUNITY),
    NECROTIC(Condition.NECROTIC_VULNERABILITY, Condition.NECROTIC_RESISTANCE, Condition.NECROTIC_IMMUNITY),
    FORCE(Condition.FORCE_VULNERABILITY, Condition.FORCE_RESISTANCE, Condition.FORCE_IMMUNITY),
    PSYCHIC(Condition.PSYCHIC_VULNERABILITY, Condition.PSYCHIC_RESISTANCE, Condition.PSYCHIC_IMMUNITY),;

    final Condition VULNERABILITY;
    final Condition RESISTANCE;
    final Condition IMMUNITY;

    private final static List<DamageType> PHYSICAL_GROUP = List.of(BLUDGEONING, PIERCING, SLASHING);

    public boolean isPhysical(){
        return PHYSICAL_GROUP.contains(this);
    }

    DamageType(Condition vulnerability, Condition resistance, Condition immunity) {
        this.VULNERABILITY = vulnerability;
        this.RESISTANCE = resistance;
        this.IMMUNITY = immunity;
    }
}