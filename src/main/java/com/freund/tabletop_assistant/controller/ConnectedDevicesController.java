package com.freund.tabletop_assistant.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freund.tabletop_assistant.dto.ConnectDeviceRequest;
import com.freund.tabletop_assistant.service.ConnectedDevicesService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class ConnectedDevicesController {
    @Autowired
    private ConnectedDevicesService connectedDevicesService;

    @GetMapping("/connected")
    public ArrayList<UUID> getConnectedDevices() {
        return connectedDevicesService.getCurrentlyConnectedDeviceIds();
    }

    @PostMapping("/connect")
    public ResponseEntity<String> connectDevice(@RequestBody ConnectDeviceRequest request) {
        if(connectedDevicesService.connectDevice(request.getDeviceId())){
            return new ResponseEntity<>("Device connected.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Connect device failed.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @GetMapping("/UUID")
    public String generateUUID() {
        String id = UUID.randomUUID().toString();
        System.out.println("Generated UUID: " + id);
        return id;
    }
    
}
