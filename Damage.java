import java.util.HashMap;
import java.util.List;

import util.StringUtil;

public class Damage {
    private HashMap<DamageType, String> components;
    String source;

    public Damage(List<String> componentValues) {
        this.components = new HashMap<DamageType, String>();
        this.source = "";
        if (componentValues.size() != DamageType.values().length) {
            throw new IllegalArgumentException("Damage values list size must be equal to the amount of DamageTypes");
        }  
        for (int i = 0; i < DamageType.values().length; i++) {
            this.components.put(DamageType.values()[i], componentValues.get(i));
        }
    }

    public Damage(Builder builder) {
        this.components = new HashMap<DamageType, String>();
        this.source = "";
        for (DamageType damageType : builder.components.keySet()) {
            this.components.put(damageType, builder.components.get(damageType));
        }
        this.source = builder.source;
    }

    public static class Builder {
        private HashMap<DamageType, String> components;
        private String source;

        public Builder() {
            this.components = new HashMap<DamageType, String>();
        }

        public Builder add(DamageType damageType, String amount) {
            this.components.put(damageType, amount);
            return this;
        }

        public Builder source(String source){
            this.source = source;
            return this;
        }

        public Damage build() {
            return new Damage(this);
        }
    }

    public String getComponent(DamageType damageType) {
        if (!this.components.containsKey(damageType)) {
            return "0";
        }
        return this.components.get(damageType);
    }

    @Override
    public String toString() {
        String returnString = "Damage{";
        for (DamageType damageType : DamageType.values()) {
            if (this.getComponent(damageType) != "0") {
                returnString += damageType.toString() + ":" + this.getComponent(damageType) + ";";
            }
        }
        if (returnString != "Damage{") {
            returnString = StringUtil.removeLastChar(returnString);
        }
        returnString += "}";
        return returnString;
    }

    public enum DamageType {
        BLUDGEONING,
        PIERCING,
        SLASHING,
        COLD,
        FIRE,
        LIGHTNING,
        THUNDER,
        ACID,
        POISON,
        RADIANT,
        NECROTIC,
        FORCE,
        PSYCHIC,
    }
}
