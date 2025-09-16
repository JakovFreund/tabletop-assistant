package com.freund.tabletop_assistant.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/util")
public class UtilController {
    @GetMapping("/uuid")
    public ResponseEntity<String> generateUUID() {
        String id = UUID.randomUUID().toString();
        System.out.println("Generated UUID: " + id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
