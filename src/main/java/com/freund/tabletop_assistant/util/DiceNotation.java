package com.freund.tabletop_assistant.util;

import java.util.HashMap;
import java.util.Map;

public final class DiceNotation {

    // Function to add two dice notation strings
    public static String addDice(String dice1, String dice2) {
        // Parse both dice notations
        Map<String, Integer> diceMap = new HashMap<>();
        int modifier = 0;

        // Add dice1
        modifier += parseDice(dice1, diceMap);
        // Add dice2
        modifier += parseDice(dice2, diceMap);

        // Build the final dice string
        StringBuilder result = new StringBuilder();

        // Sort the dice by type (e.g., d6, d8) and add to the result
        for (String diceType : diceMap.keySet()) {
            int count = diceMap.get(diceType);
            if (count > 0) {
                if (result.length() > 0)
                    result.append("+");
                result.append(count).append(diceType);
            }
        }

        // Add the modifier if it's not zero
        if (modifier != 0) {
            if (modifier > 0) {
                result.append("+").append(modifier);
            } else {
                result.append(modifier); // already includes the minus sign
            }
        }

        return result.toString();
    }

    // Helper function to parse a dice string (e.g., 2d6+10) into its components
    private static int parseDice(String dice, Map<String, Integer> diceMap) {
        String[] parts = dice.split("\\+|(?=-)");
        int modifier = 0;

        for (String part : parts) {
            part = part.trim();

            if (part.contains("d")) {
                // This is a dice part like 2d6 or 1d8
                String[] diceParts = part.split("d");
                int count = Integer.parseInt(diceParts[0].trim());
                String diceType = "d" + diceParts[1].trim();

                diceMap.put(diceType, diceMap.getOrDefault(diceType, 0) + count);
            } else {
                // This is a modifier part like +10 or -5
                modifier += Integer.parseInt(part);
            }
        }

        return modifier;
    }

    // Main for testing the function

}
