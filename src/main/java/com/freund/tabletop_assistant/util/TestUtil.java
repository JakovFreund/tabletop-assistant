package com.freund.tabletop_assistant.util;

import com.freund.tabletop_assistant.model.Creature;
import com.freund.tabletop_assistant.model.Duration;
import com.freund.tabletop_assistant.model.DurationType;
import com.freund.tabletop_assistant.model.StatusEffect;
import com.freund.tabletop_assistant.model.StatusEffectInstance;
import com.freund.tabletop_assistant.model.castable.Spell;
import com.freund.tabletop_assistant.model.castable.SpellData;
import com.freund.tabletop_assistant.model.item.Item;
import com.freund.tabletop_assistant.model.item.ItemStack;
import com.freund.tabletop_assistant.model.item.ItemType;

public class TestUtil {
    public static void previousMain() {
        // System.out.println(Spell.get("Eldritch Blast").getDescription(0, 5));
        // testSpells();
        System.out.println(DiceNotation.addDice("4d12+1d2+7", "1d6+2d2+5"));

        Creature a = new Creature();
        a.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.PETRIFIED, new Duration(DurationType.TURNS, 3), null, null, ""));
        a.addItem(new ItemStack(new Item(ItemType.WOODEN_SWORD), 2));
        System.out.println(a.getItemStackByIndex(0));

        //testSpells();
    }

    public static void printSpells(){
        for(Spell spell: SpellData.SPELLS){
            System.out.println(spell.getName());
        }
    }

}
