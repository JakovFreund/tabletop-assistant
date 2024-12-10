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
@RequestMapping("/api/gamestate")
public class GameStateController {
    @Autowired
    private GameStateService gameStateService;

    @GetMapping()
    public GameStateDTO getGameState() { // ok
        return GameStateMapper.toDTO(gameStateService.getGameState());
    }

    @PutMapping()
    public ResponseEntity<String> saveGameState() {
        if (gameStateService.saveGameState()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("GameState has been successfully saved.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("IOException while saving GameState!");
        }
    }

    /* 
    @GetMapping("/addcreatures")
    public ResponseEntity<String> temporaryCreature() {
        ArrayList<Creature> empty = new ArrayList<>();
        gameStateService.getGameState().setCreatures(empty);

        Creature a = new Creature("Creature Ninjani", Subrace.DROW);
        gameStateService.addCreature(a);

        Creature b = new Creature("Second", Subrace.DEMON);
        b.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.BLINDED, new Duration(DurationType.INDEFINITE), null, null, "lmao"));
        gameStateService.addCreature(b);

        Creature c = new Creature("Player", Subrace.HALF_ELF);
        c.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.BLESS, new Duration(DurationType.LONG_REST), null, null, "long note"));
        c.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.BARKSKIN, new Duration(DurationType.LONG_REST), null, null, ""));
        gameStateService.addCreature(c);

        Creature d = new Creature("Fourth", Subrace.HILL_DWARF);
        d.addStatusEffectInstance(new StatusEffectInstance(StatusEffect.CHILLED, new Duration(DurationType.TURNS, 3), null, null, "he kinda chill with it tho"));
        gameStateService.addCreature(d);

        return ResponseEntity.status(HttpStatus.CREATED).body("Creatures added.");
    }
    */
}
