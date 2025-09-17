package com.freund.tabletop_assistant.model.damage;

import java.util.List;

import com.freund.tabletop_assistant.model.statuseffect.StatusEffect;

public enum DamageType {
    BLUDGEONING(StatusEffect.BLUDGEONING_VULNERABILITY, StatusEffect.BLUDGEONING_RESISTANCE, StatusEffect.BLUDGEONING_IMMUNITY),
    PIERCING(StatusEffect.PIERCING_VULNERABILITY, StatusEffect.PIERCING_RESISTANCE, StatusEffect.PIERCING_IMMUNITY),
    SLASHING(StatusEffect.SLASHING_VULNERABILITY, StatusEffect.SLASHING_RESISTANCE, StatusEffect.SLASHING_IMMUNITY),
    COLD(StatusEffect.COLD_VULNERABILITY, StatusEffect.COLD_RESISTANCE, StatusEffect.COLD_IMMUNITY),
    FIRE(StatusEffect.FIRE_VULNERABILITY, StatusEffect.FIRE_RESISTANCE, StatusEffect.FIRE_IMMUNITY),
    LIGHTNING(StatusEffect.LIGHTNING_VULNERABILITY, StatusEffect.LIGHTNING_RESISTANCE, StatusEffect.LIGHTNING_IMMUNITY),
    THUNDER(StatusEffect.THUNDER_VULNERABILITY, StatusEffect.THUNDER_RESISTANCE, StatusEffect.THUNDER_IMMUNITY),
    ACID(StatusEffect.ACID_VULNERABILITY, StatusEffect.ACID_RESISTANCE, StatusEffect.ACID_IMMUNITY),
    POISON(StatusEffect.POISON_VULNERABILITY, StatusEffect.POISON_RESISTANCE, StatusEffect.POISON_IMMUNITY),
    RADIANT(StatusEffect.RADIANT_VULNERABILITY, StatusEffect.RADIANT_RESISTANCE, StatusEffect.RADIANT_IMMUNITY),
    NECROTIC(StatusEffect.NECROTIC_VULNERABILITY, StatusEffect.NECROTIC_RESISTANCE, StatusEffect.NECROTIC_IMMUNITY),
    FORCE(StatusEffect.FORCE_VULNERABILITY, StatusEffect.FORCE_RESISTANCE, StatusEffect.FORCE_IMMUNITY),
    PSYCHIC(StatusEffect.PSYCHIC_VULNERABILITY, StatusEffect.PSYCHIC_RESISTANCE, StatusEffect.PSYCHIC_IMMUNITY),;

    final StatusEffect VULNERABILITY;
    final StatusEffect RESISTANCE;
    final StatusEffect IMMUNITY;

    private final static List<DamageType> PHYSICAL_GROUP = List.of(BLUDGEONING, PIERCING, SLASHING);

    public boolean isPhysical(){
        return PHYSICAL_GROUP.contains(this);
    }

    DamageType(StatusEffect vulnerability, StatusEffect resistance, StatusEffect immunity) {
        this.VULNERABILITY = vulnerability;
        this.RESISTANCE = resistance;
        this.IMMUNITY = immunity;
    }
}