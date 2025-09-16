package com.freund.tabletop_assistant.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.freund.tabletop_assistant.dto.LogEntryFileDTO;
import com.freund.tabletop_assistant.mapper.LogEntryFileMapper;
import com.freund.tabletop_assistant.model.GameState;
import com.freund.tabletop_assistant.model.gamelog.GameLog;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class JsonHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static void saveGameStateToFile(GameState gameState, String filename) throws IOException {
        objectMapper.writeValue(new File(filename), gameState);
        System.out.println("GameState saved to file: " + filename);
    }

    public static GameState loadGameStateFromFile(String filename) throws IOException {
        GameState gameState = objectMapper.readValue(new File(filename), GameState.class);
        System.out.println("GameState loaded from file: " + filename);
        return gameState;
    }

    public static void saveGameLogToFile(GameLog gameLog, String filename) throws IOException {
        System.out.println("GameLog saved to file: " + filename);
        objectMapper.writeValue(new File(filename), gameLog.getLogEntries().stream()
                .map(LogEntryFileMapper::toDTO)
                .toList());
    }

    public static List<LogEntryFileDTO> loadGameLogDTOsFromFile(String filename) throws IOException {
        System.out.println("GameLog loaded from file: " + filename);
        return objectMapper.readValue(
                new File(filename),
                new TypeReference<List<LogEntryFileDTO>>() {
                });
    }

}
