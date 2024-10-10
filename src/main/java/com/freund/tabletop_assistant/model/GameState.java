package com.freund.tabletop_assistant.model;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.freund.tabletop_assistant.util.JsonHandler;

import jakarta.annotation.PostConstruct;

@Component
public class GameState {
    private ArrayList<Player> players;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public GameState(){
        // TODO add import
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    @PostConstruct
    public void loadGameState(){
        try {
            for (Player player : JsonHandler.loadGameStateFromFile("gamestate.json").getPlayers()){
                this.addPlayer(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
