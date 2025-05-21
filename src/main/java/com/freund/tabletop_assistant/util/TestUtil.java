package com.freund.tabletop_assistant.util;

import com.freund.tabletop_assistant.model.castable.spell.Spell;
import com.freund.tabletop_assistant.model.castable.spell.SpellData;
import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.item.Item;
import com.freund.tabletop_assistant.model.item.ItemCategory;
import com.freund.tabletop_assistant.model.item.Rarity;

public class TestUtil {
    public static void previousMain() {
        // System.out.println(Spell.get("Eldritch Blast").getDescription(0, 5));
        System.out.println(DiceNotation.addDice("4d12+1d2+7", "1d6+2d2+5"));
        //printSpells();
    }

    public static void printSpells(){
        for(Spell spell: SpellData.SPELLS){
            System.out.println(spell.getName());
        }
    }

    public static void consoleLog(String string){ // for StatusEffects that don't proc on their own
        System.out.println("MANUAL INPUT: " + string);
        // TODO change output to frontend console
    }

    public static void addItem(){
        Creature creature = new Creature();
        creature.addItem(new Item("name1","img", ItemCategory.RING, Rarity.RARE, 12, 10.2f, false, null,null));
        System.out.println(creature.getInventory());
    }

}
