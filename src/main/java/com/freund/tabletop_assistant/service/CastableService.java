package com.freund.tabletop_assistant.service;

import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.model.castable.Castable;
import com.freund.tabletop_assistant.model.castable.spell.Spell;
import com.freund.tabletop_assistant.model.castable.spell.SpellData;

@Service
public class CastableService {
    public Castable getCastable(String name) {
        Spell spell = getSpell(name);
        if (spell != null) {
            return spell;
        }
        // TODO check through other castable data
        return null;
    }

    public static Spell getSpell(String spellName) {
        for (Spell spell : SpellData.SPELLS){
            if (spell.getName().equals(spellName)){
                return spell;
            }
        }
        return null;
    }
}
