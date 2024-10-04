import util.DiceNotation;

class Main {

    public static void main(String[] args) {
        // System.out.println(Spell.get("Eldritch Blast").getDescription(0, 5));
        testSpell("Colour Spray");
        // testSpells();
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
