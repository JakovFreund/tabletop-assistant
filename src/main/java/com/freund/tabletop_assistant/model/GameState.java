package com.freund.tabletop_assistant.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import com.freund.tabletop_assistant.util.JsonHandler;


@Component
public class GameState {
    private ArrayList<Creature> creatures;

    @PostConstruct
    public void loadGameState(){
        try {
            GameState loadedGameState = JsonHandler.loadGameStateFromFile("gamestate.json");
            this.creatures = loadedGameState.getCreatures();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean saveGameState(){
        try {
            JsonHandler.saveGameStateToFile(this, "gamestate.json");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public GameState(){
        this.creatures = new ArrayList<Creature>();
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public Creature getCreature (UUID id){
        for (Creature creature : this.getCreatures()){
            if (creature.getCreatureId().equals(id)){
                return creature;
            }
        }
        return null;
    }

    public void setCreatures(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }

    public void addCreature(Creature creature){
        creatures.add(creature);
    }
}
