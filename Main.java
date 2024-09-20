class Main {

public static void main(String[] args) {
    Creature a = new Creature();
    a.statusEffects.add(new StatusEffectInstance(StatusEffect.PETRIFIED, 3, 3));
    a.inventory.add(new ItemStack(new Item(ItemType.WOODEN_SWORD), 2));
    System.out.println(a.inventory.get(0));
    System.out.println(StatusEffect.BLINDED.DESCRIPTION);
    System.out.println(Spell.get("Sacred Flame").getDescription(1, 4));
}



// admin can lock each inventory from player interaction
// add console interface to run commands




    
    
}
