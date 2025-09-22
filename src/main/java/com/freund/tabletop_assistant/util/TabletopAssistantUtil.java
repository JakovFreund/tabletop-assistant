package com.freund.tabletop_assistant.util;

import java.util.Optional;
import java.util.Set;

public final class TabletopAssistantUtil {
    public static String removeLastChar(String str){
        if (str.length() > 0){
            return str.substring(0, str.length() - 1);
        }
        return "";
    }

    public static Integer findMaxNumberSmallerOrEqualThan(Set<Integer> keys, int treshold){
        // find damageAtCreatureLevel's max key <= creatureLevel
        Optional<Integer> key = keys.stream()
                .filter(k -> k <= treshold)
                .max(Integer::compareTo);

        if (key.isPresent()) {
            // use highestKey and value
            return key.get();
        } else {
            System.out.println("CastableDamageComponent: Castable creature level not defined.");
            return null;
        }
    }
    
}
