enum StatusEffect{
    //Conditions
    BLINDED("blind description"),
    CHARMED("charmed description"),
    DEAFENED("description"),
    FRIGHTENED("description"),
    GRAPPLED("description"),
    INCAPACITATED("description"),
    INVISIBLE("description"),
    PARALYZED("description"),
    PETRIFIED("description"),
    POISONED("description"),
    PRONE("description"),
    RESTRAINED("description"),
    STUNNED("description"),
    UNCONSCIOUS("description"),
    EXHAUSTED("description");
    // Buffs
    // Debuffs
    // Features (proficiencies, traits)
    // Feats // Character.addFeat(FEAT.blabla); Character.addBuff(Buff.STR_IMPROVEMENT, Duration.UNLIMITED) - increases STR by 1


    final String DESCRIPTION;

    /* //deprecated
    final static HashMap<StatusEffect, String> DESCRIPTION = new HashMap<StatusEffect,String>(Map.ofEntries(
        Map.entry(StatusEffect.BLINDED,"blind description"),
        Map.entry(StatusEffect.CHARMED,"description"),
        Map.entry(StatusEffect.DEAFENED,"description"),
        Map.entry(StatusEffect.FRIGHTENED,"description"),
        Map.entry(StatusEffect.GRAPPLED,"description"),
        Map.entry(StatusEffect.INCAPACITATED,"description"),
        Map.entry(StatusEffect.INVISIBLE,"description"),
        Map.entry(StatusEffect.PARALYZED,"description"),
        Map.entry(StatusEffect.PETRIFIED,"description"),
        Map.entry(StatusEffect.POISONED,"description"),
        Map.entry(StatusEffect.PRONE,"description"),
        Map.entry(StatusEffect.RESTRAINED,"description"),
        Map.entry(StatusEffect.STUNNED,"description"),
        Map.entry(StatusEffect.UNCONSCIOUS,"description"),
        Map.entry(StatusEffect.EXHAUSTED,"description")
        ));
    */

    StatusEffect(String description){
        this.DESCRIPTION = description;
    }

}



enum Duration {
    SHORT_REST,
    LONG_REST,
    UNLIMITED
}

class StatusEffectInstance {
    StatusEffect statusEffect;
    Duration duration;
    int roundsDuration; // maybe change to turnsDuration
    int Amount; //TODO to String for dice values

    
    

    public StatusEffectInstance (StatusEffect statusEffect, Duration duration, int Amount){ // probably change to 1 constructor with default Duration.TURN 
        this.statusEffect = statusEffect;
        this.duration = duration;
        this.Amount = Amount;
    }

    public StatusEffectInstance (StatusEffect statusEffect, int roundsDuration, int Amount){
        this.statusEffect = statusEffect;
        this.roundsDuration = roundsDuration;
        this.Amount = Amount;
    }
}
