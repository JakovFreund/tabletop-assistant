package com.freund.tabletop_assistant.mapper;

import java.util.stream.Collectors;

import com.freund.tabletop_assistant.dto.GameStateDTO;
import com.freund.tabletop_assistant.model.GameState;

public class GameStateMapper {
    public static GameStateDTO toDTO(GameState gameState) {
        GameStateDTO dto = new GameStateDTO();
        dto.setCreatures(gameState.getCreatures().stream().map(CreatureMapper::toDTO)
                .collect(Collectors.toList()));
        dto.setDeviceMappings(gameState.getDeviceMappings());
        return dto;
    }
}
