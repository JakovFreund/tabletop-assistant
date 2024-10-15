package com.freund.tabletop_assistant.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freund.tabletop_assistant.model.Creature;
import com.freund.tabletop_assistant.model.Duration;
import com.freund.tabletop_assistant.model.GameState;
import com.freund.tabletop_assistant.model.StatusEffect;
import com.freund.tabletop_assistant.model.StatusEffectInstance;
import com.freund.tabletop_assistant.model.Subrace;
import com.freund.tabletop_assistant.model.item.Item;
import com.freund.tabletop_assistant.model.item.ItemStack;
import com.freund.tabletop_assistant.model.item.ItemType;



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
        if (gameState.saveGameState()){
            return new ResponseEntity<>("GameState has been successfully saved.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("IOException while saving GameState!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/creature/{id}")
    public Creature getCreatureById(@PathVariable UUID id) {
        return gameState.getCreature(id);
    }

    @GetMapping("/addItem")
    public ResponseEntity<String> addItem() {
        gameState.getCreatures().get(0).getItem(new ItemStack(new Item(ItemType.WOODEN_SWORD), 2));
        return new ResponseEntity<String>("Item added.", HttpStatus.CREATED);
    }

    @GetMapping("/addcreatures")
    public ResponseEntity<String> temporaryCreature() {

        ArrayList<Creature> empty =  new ArrayList<Creature>();
        gameState.setCreatures(empty);

        Creature a = new Creature("Creature Ninjani", Subrace.DROW);
        a.getItem(new ItemStack(new Item(ItemType.GOLD), 35));
        gameState.addCreature(a);

        Creature b = new Creature("Second", Subrace.DEMON);
        b.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.BLINDED, 0, Duration.FOREVER, "lmao"));
        gameState.addCreature(b);

        Creature c = new Creature("Player", Subrace.HALF_ELF);
        c.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.BLESS, 0, Duration.LONG_REST, "long note"));
        c.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.BARKSKIN, 0, Duration.SHORT_REST, ""));
        c.getItem(new ItemStack(new Item(ItemType.SILVERFANG), 1));
        gameState.addCreature(c);

        Creature d = new Creature("Fourth", Subrace.HILL_DWARF);
        d.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.CHILLED, 3, Duration.TURNS, "he kinda chill with it tho"));
        gameState.addCreature(d);


        return new ResponseEntity<String>("Creatures added.", HttpStatus.CREATED);
    }
    
    


}
