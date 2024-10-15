package com.freund.tabletop_assistant.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.freund.tabletop_assistant.model.GameState;

import java.io.File;
import java.io.IOException;

public final class JsonHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void saveGameStateToFile(GameState gameState, String filename) throws IOException {
        objectMapper.writeValue(new File(filename), gameState);
        System.out.println("GameState saved to file: " + filename);
    }

    public static GameState loadGameStateFromFile(String filename) throws IOException {
        GameState gameState = objectMapper.readValue(new File(filename), GameState.class);
        System.out.println("GameState loaded from file: " + filename);
        return gameState;
    }


}
