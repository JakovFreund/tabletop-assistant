class Main {

public static void main(String[] args) {
    Creature a = new Creature();
    a.statusEffects.add(new StatusEffectInstance(StatusEffect.PETRIFIED, 3, 3));
    a.inventory.add(new ItemStack(new Item(ItemType.WOODEN_SWORD), 2));
    System.out.println(a.inventory.get(0));
    System.out.println(StatusEffect.BLINDED.DESCRIPTION);
    System.out.println(Spell.get("Sacred Flame").getDescription(1, 4));
    //testSpells();
}



static void testSpells(){
    int testlevel;
    for (Spell spell : Spell.SPELLS){
        System.out.println(spell.NAME+" level "+spell.LEVEL+":\n"+spell.getDescription(spell.LEVEL, 1));
        if(spell.FORMULAS.size()>0){
            testlevel = spell.LEVEL + 1;
            System.out.println(spell.NAME+" level "+testlevel+":\n"+spell.getDescription(testlevel, 1));
        }
        System.err.println("###\n");
    }
}



    
    
}
