public class TurnResource { // or just Resource because HP isn't a turn resource
    String name;
    int amount;
    int maxAmount;
    RefillRate refillRate;
    String cost; //name of TurnResource, on combat simulation loop through player's actions and remove 1 cost


    public TurnResource (String name, int amount, int maxAmount, RefillRate refillRate){
        this.name = name;
        this.amount = amount;
        this.maxAmount = maxAmount;
        this.refillRate = refillRate;
    }
    public TurnResource (String name, int amount, int maxAmount, RefillRate refillRate, String cost){
        this(name, amount, maxAmount, refillRate);
        this.cost = cost;
    }
    
}

enum RefillRate { //action, bonus action, reaction, movespeed, spellslots, class actions (action surge, rage)
    TURN,
    SHORT_REST,
    LONG_REST, //hp is longrest
    NEVER
}

