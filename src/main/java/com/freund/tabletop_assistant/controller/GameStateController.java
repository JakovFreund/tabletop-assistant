package com.freund.tabletop_assistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freund.tabletop_assistant.dto.GameStateDTO;
import com.freund.tabletop_assistant.mapper.GameStateMapper;
import com.freund.tabletop_assistant.service.GameStateService;

@RestController
@RequestMapping("/gamestate")
public class GameStateController {
    @Autowired
    private GameStateService gameStateService;

    @GetMapping()
    public ResponseEntity<GameStateDTO> getGameState() {
        return ResponseEntity.status(HttpStatus.OK).body(GameStateMapper.toDTO(gameStateService.getGameState()));
    }

    @PutMapping()
    public ResponseEntity<String> saveGameState() {
        if (gameStateService.saveGameState()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("GameState has been successfully saved.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("IOException while saving GameState!");
        }
    }
}
