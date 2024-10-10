package com.freund.tabletop_assistant.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.freund.tabletop_assistant.model.GameState;
import com.freund.tabletop_assistant.model.Player;

import java.io.File;
import java.io.IOException;

public final class JsonHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Method to serialize Player object to JSON and save it to a file
    public static void savePlayerToFile(Player player, String filename) throws IOException {
        objectMapper.writeValue(new File(filename), player);
        System.out.println("Player saved to file: " + filename);
    }

    // Method to deserialize JSON from file and convert it to a Player object
    public static Player loadPlayerFromFile(String filename) throws IOException {
        Player player = objectMapper.readValue(new File(filename), Player.class);
        System.out.println("Player loaded from file: " + filename);
        return player;
    }

    // Method to serialize Player to JSON and return it as a String
    public static String playerToJson(Player player) throws IOException {
        return objectMapper.writeValueAsString(player);
    }

    // Method to deserialize JSON String to Player object
    public static Player jsonToPlayer(String json) throws IOException {
        return objectMapper.readValue(json, Player.class);
    }

    public static void saveGameStateToFile(GameState gameState, String filename) throws IOException {
        objectMapper.writeValue(new File(filename), gameState);
        System.out.println("GameState saved to file: " + filename);
    }

    // Method to deserialize JSON from file and convert it to a GameState object
    public static GameState loadGameStateFromFile(String filename) throws IOException {
        GameState gameState = objectMapper.readValue(new File(filename), GameState.class);
        System.out.println("GameState loaded from file: " + filename);
        return gameState;
    }


}
