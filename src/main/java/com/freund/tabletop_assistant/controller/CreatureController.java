package com.freund.tabletop_assistant.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freund.tabletop_assistant.dto.CreatureDTO;
import com.freund.tabletop_assistant.dto.HPUpdateRequest;
import com.freund.tabletop_assistant.mapper.CreatureMapper;
import com.freund.tabletop_assistant.service.CreatureService;

@RestController
@RequestMapping("/api/creatures")
public class CreatureController {
    @Autowired
    private CreatureService creatureService;

    @GetMapping("/{id}") 
    public CreatureDTO getCreatureById(@PathVariable UUID id) { // test ResponseEntity<CreatureDTO> ResponseEntity.ok
        // TODO add 404
        return CreatureMapper.toDTO(creatureService.getCreature(id));
    }

    @PutMapping("/{id}/hp")
    public ResponseEntity<String> updateCreatureHP(@PathVariable UUID id, @RequestBody HPUpdateRequest request) {
        if(creatureService.updateCreatureHP(id, request.getHp())){
            return ResponseEntity.ok("HP updated successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Creature not found");
    }
    
}
