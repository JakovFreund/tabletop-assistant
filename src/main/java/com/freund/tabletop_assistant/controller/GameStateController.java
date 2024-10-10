package com.freund.tabletop_assistant.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freund.tabletop_assistant.util.JsonHandler;
import com.freund.tabletop_assistant.model.GameState;

@RestController
@RequestMapping("/api")
public class GameStateController {
    @Autowired
    private GameState gameState;

    @GetMapping("/gamestate")
    public GameState getGameState(){
        return gameState;
    }

    @GetMapping("/save")
    public ResponseEntity<String> saveGameState() {
        try {
            JsonHandler.saveGameStateToFile(gameState, "gamestate.json");
            String responseMessage = "GameState has been successfully saved!";
            return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("", HttpStatus.NOT_MODIFIED);
        }
    }


}
