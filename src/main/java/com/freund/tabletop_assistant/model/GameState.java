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

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public Creature getCreature (UUID id){
        for (Creature creature : this.getCreatures()){
            if (creature.getCreatureId().equals(id)){
                System.out.println("returned!");
                return creature;
            }
        }
        return null;
    }

    public void setCreatures(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }

    public GameState(){
        // TODO add import
        this.creatures = new ArrayList<Creature>();
    }

    public void addCreature(Creature creature){
        creatures.add(creature);
    }

    @PostConstruct
    public void loadGameState(){
        try {
            for (Creature creature : JsonHandler.loadGameStateFromFile("gamestate.json").getCreatures()){
                this.addCreature(creature);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
