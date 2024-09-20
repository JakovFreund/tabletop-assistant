import java.util.ArrayList;
import java.util.List;


public class ItemStack {
    Item item;
    int amount;
    long lastModified; // TODO add currentDate function
    ArrayList<ItemStack> inventory;
    

    public ItemStack (Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.lastModified = System.currentTimeMillis(); // recently modified is bigger number

        if (item.INFO.TYPE == ItemCategory.CONTAINER){
            inventory = new ArrayList<ItemStack>(); // also render a little plus sign in top right corner of item
        }
    }

    @Override
    public String toString() {
        return this.amount + "x " + this.item;
    }


}


class Item {
    final ItemType INFO;
    Rarity rarity;
    ArrayList<ItemEffect> effects;
    ArrayList<ItemEffect> newEffects;
    int value;

    public Item(ItemType itemInfo){
        this.INFO = itemInfo;
        this.effects = new ArrayList<>(this.INFO.BASE_EFFECTS);
        this.rarity = this.INFO.BASE_RARITY;
        this.value = this.INFO.BASE_VALUE;
    }


    public Item(ItemType itemInfo, ArrayList<ItemEffect> newEffects){
        this(itemInfo);
        this.newEffects = newEffects;
        this.recalculate();
    }

    void addEffect(ItemEffect itemEffect){
        this.newEffects.add(itemEffect);
        recalculate();
    }

    void recalculate(){
        this.effects = new ArrayList<>(this.INFO.BASE_EFFECTS);
        this.rarity = this.INFO.BASE_RARITY;
        this.value = this.INFO.BASE_VALUE;
        this.effects.addAll(newEffects);
        if (newEffects.size() > 2){
            this.rarity = this.rarity.increase().increase();
        } 
        else{
            if (newEffects.size() > 0){
                this.rarity = this.rarity.increase();
            } 
        }
        // TODO value calculation based on new effect modifiers unless MISC
    }


    @Override
    public String toString() {
        String str = this.INFO.NAME + "@[" + this.INFO.TYPE + ", " + this.rarity + ", value: " + this.value + ", weight: " + this.INFO.WEIGHT + ", " + this.INFO.DESCRIPTION + "]{";
        for (ItemEffect itemEffect : effects){
            str += itemEffect.effectType + ": " + itemEffect.statModifier;
        }
        str += "}";
        return str;
    }

    // TODO need equals() comparison for item stacking
    

}



enum ItemType {
    WOODEN_SWORD ("Wooden sword", ItemCategory.WEAPON, Rarity.UNCOMMON, "Just a wooden sword", 30, 10, List.of(new ItemEffect(EffectType.DAMAGE,"d6"))),
    RANDOM_CHESTPLATE("Random Chestplate", ItemCategory.WEARABLE, Rarity.RARE, "abc", 50, 15, List.of(new ItemEffect(EffectType.AC,"10"))),


    //https://5e.tools/lootgen.html

    GOLD("Gold", ItemCategory.MISC, Rarity.COMMON, "Currency of Alarién", 0, 1);
    // TODO change inlore name of gold


    //
    final String NAME;
    final ItemCategory TYPE;
    final Rarity BASE_RARITY;
    final String DESCRIPTION;
    final int WEIGHT;
    final int BASE_VALUE;
    final List<ItemEffect> BASE_EFFECTS;

    ItemType (String name, ItemCategory type, Rarity rarity, String description, int weight, int value, List<ItemEffect> baseEffects) {
        this.NAME = name;
        this.TYPE = type;
        this.BASE_RARITY = rarity;
        this.DESCRIPTION = description;
        this.WEIGHT = weight;
        this.BASE_VALUE = value;
        this.BASE_EFFECTS = baseEffects;
        // TODO weapons can have various properties such as Heavy, Finesse, Light, and so on, Armour has Light, Heavy, 
    }
    ItemType (String name, ItemCategory type, Rarity rarity, String description, int weight, int value) {
        this.NAME = name;
        this.TYPE = type;
        this.BASE_RARITY = rarity;
        this.DESCRIPTION = description;
        this.WEIGHT = weight;
        this.BASE_VALUE = value;
        this.BASE_EFFECTS = null;
    }
}

enum ItemCategory {
    WEAPON,
    WEARABLE,
    CONTAINER,
    CONSUMABLE,
    MISC 
}

class ItemEffect {
    EffectType effectType;
    String statModifier; //maybe change String to Object

    ItemEffect(EffectType effectType, String statModifier){
        this.effectType = effectType;
        this.statModifier = statModifier;
    }
}

enum EffectType {
    DAMAGE,
    HEAL,
    AC,
    LEARN_SPELL, // (EffectType.LEARN_SPELL,"Haste 2") add function to Spell class to convert string to enum
    LIGHT
    // TODO add more
}

enum Rarity {
    COMMON, //40%
    UNCOMMON, //30%
    RARE, //20%
    EPIC, //8%
    LEGENDARY; //2%

    Rarity increase(){
        switch(this){
            case COMMON:
                return UNCOMMON;
            case UNCOMMON:
                return RARE;
            case RARE:
                return EPIC;
            case EPIC:
                return LEGENDARY;
            case LEGENDARY:
                return LEGENDARY;
            default:
                return null;
        }
    }

}