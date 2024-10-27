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
import com.freund.tabletop_assistant.model.device.ConnectedDevices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class ConnectedDevicesController {
    @Autowired
    private ConnectedDevices connectedDevices;

    @GetMapping("/connected")
    public ArrayList<UUID> getConnectedDevices() {
        return new ArrayList<UUID>(connectedDevices.getCurrentlyConnectedDeviceIds());
    }

    @PostMapping("/connect")
    public ResponseEntity<String> connectDevice(@RequestBody ConnectDeviceRequest request) {
        connectedDevices.addDevice(request.getDeviceId());
        System.out.println("Connected device: " + request.getDeviceId());
        return new ResponseEntity<>("Device connected.", HttpStatus.OK);
        
    }
    
}
