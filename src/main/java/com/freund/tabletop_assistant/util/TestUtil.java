package com.freund.tabletop_assistant.util;

import com.freund.tabletop_assistant.model.Creature;
import com.freund.tabletop_assistant.model.Damage;
import com.freund.tabletop_assistant.model.Duration;
import com.freund.tabletop_assistant.model.Spell;
import com.freund.tabletop_assistant.model.StatusEffect;
import com.freund.tabletop_assistant.model.StatusEffectInstance;
import com.freund.tabletop_assistant.model.item.Item;
import com.freund.tabletop_assistant.model.item.ItemStack;
import com.freund.tabletop_assistant.model.item.ItemType;

public class TestUtil {
    public static void previousMain() {
        // System.out.println(Spell.get("Eldritch Blast").getDescription(0, 5));
        testSpell("Colour Spray");
        // testSpells();
        System.out.println(DiceNotation.addDice("4d12+1d2+7", "1d6+2d2+5"));
        System.out.println(Spell.get("Eldritch Blast").getDescription(0, 5));
        Damage damage = new Damage.Builder().add(Damage.DamageType.ACID, "2d6").add(Damage.DamageType.BLUDGEONING, "4d4+5").build();
        System.out.println(damage);

        Creature a = new Creature();
        a.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.PETRIFIED, 3, Duration.TURNS, ""));
        a.getItem(new ItemStack(new Item(ItemType.WOODEN_SWORD), 2));
        System.out.println(a.getItemStackByIndex(0));

        //testSpells();
    }

    static void testSpells() {
        int testlevel;
        for (Spell spell : Spell.SPELLS) {
            System.out.println(spell.NAME + " level " + spell.LEVEL + ":\n" + spell.getDescription(spell.LEVEL, 1));
            if (spell.FORMULAS.size() > 0) {
                testlevel = spell.LEVEL + 1;
                System.out.println(spell.NAME + " level " + testlevel + ":\n" + spell.getDescription(testlevel, 1));
            }
            System.err.println("###\n");
        }
    }

    static void testSpell(String spellName) {
        Spell spell = Spell.get(spellName);
        int testlevel;
        System.out.println(spell.NAME + " level " + spell.LEVEL + ":\n" + spell.getDescription(spell.LEVEL, 1));
        if (spell.FORMULAS.size() > 0) {
            testlevel = spell.LEVEL + 1;
            System.out.println(spell.NAME + " level " + testlevel + ":\n" + spell.getDescription(testlevel, 1));
        }
        System.out.println("###\n");
    }
}
