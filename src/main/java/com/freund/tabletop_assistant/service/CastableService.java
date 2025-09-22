package com.freund.tabletop_assistant.service;

import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.model.castable.Castable;
import com.freund.tabletop_assistant.model.castable.CastableType;
import com.freund.tabletop_assistant.model.castable.spell.Spell;
import com.freund.tabletop_assistant.model.castable.spell.SpellData;

@Service
public class CastableService {
    public Castable getCastable(CastableType castableType) {
        Spell spell = getSpell(castableType);
        if (spell != null) {
            return spell;
        }
        // TODO check through other castable data
        return null;
    }

    public static Spell getSpell(CastableType castableType) {
        for (Spell spell : SpellData.SPELLS){
            if (spell.getCastableType().equals(castableType)){
                return spell;
            }
        }
        return null;
    }
}
