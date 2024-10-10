package com.freund.tabletop_assistant.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freund.tabletop_assistant.util.JsonHandler;
import com.freund.tabletop_assistant.model.GameClass;
import com.freund.tabletop_assistant.model.Player;

@RestController
@RequestMapping("/api")
public class PlayerController {
    @GetMapping("/players")
    public List<Player> getPlayers() {
        return Arrays.asList(
            new Player(1L, "Player One", 100, GameClass.BARBARIAN),
            new Player(2L, "Player Two", 80, GameClass.DRUID),
            new Player(3L, "Player Three", 60, GameClass.BARBARIAN)
        );
    }

    @GetMapping("/player")
    public Player getPlayer() {
        try {
            Player player = JsonHandler.loadPlayerFromFile("player.json");
            return player;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
