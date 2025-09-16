package com.freund.tabletop_assistant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freund.tabletop_assistant.dto.LogEntryFrontendDTO;
import com.freund.tabletop_assistant.dto.PingCastableRequest;
import com.freund.tabletop_assistant.mapper.LogEntryFrontendMapper;
import com.freund.tabletop_assistant.service.GameLogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/gamelog")
public class GameLogController {
    @Autowired
    private GameLogService gameLogService;

    @PostMapping("/ping-castable")
    public ResponseEntity<String> pingCastable(@RequestBody PingCastableRequest request) {
        gameLogService.addCastablePingedLogEntry(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Castable pinged.");
    }

    @GetMapping()
    public ResponseEntity<List<LogEntryFrontendDTO>> getGameLog() {
        return ResponseEntity.status(HttpStatus.OK).body(
                gameLogService.getGameLog().getLogEntries().stream()
                        .map(LogEntryFrontendMapper::toDTO)
                        .toList());
    }

    @PutMapping()
    public ResponseEntity<String> saveGameLog() {
        if (gameLogService.saveGameLog()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("GameLog has been successfully saved.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("IOException while saving GameLog!");
        }
    }

    /*
    @PutMapping("/load")
    public ResponseEntity<String> loadGameLog() {
        if (gameLogService.loadGameLog()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("GameLog has been successfully loaded.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("IOException while loading GameLog!");
        }
    }
    */
}
