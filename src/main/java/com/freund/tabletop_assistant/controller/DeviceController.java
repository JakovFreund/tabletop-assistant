package com.freund.tabletop_assistant.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freund.tabletop_assistant.dto.ConnectDeviceRequest;
import com.freund.tabletop_assistant.dto.SaveDeviceMappingRequest;
import com.freund.tabletop_assistant.dto.SaveDeviceRequest;
import com.freund.tabletop_assistant.service.DeviceService;


@RestController
@RequestMapping("/api")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("/uuid")
    public String generateUUID() {
        String id = UUID.randomUUID().toString();
        System.out.println("Generated UUID: " + id);
        return id;
    }

    @GetMapping("/connected-devices")
    public ArrayList<UUID> getConnectedDevices() { // ok
        return deviceService.getCurrentlyConnectedDeviceIds();
    }

    @PostMapping("/connected-devices")
    public ResponseEntity<String> connectDevice(@RequestBody ConnectDeviceRequest request) {
        if(deviceService.connectDevice(request.getDeviceId())){
            return ResponseEntity.status(HttpStatus.CREATED).body("Device connected.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Device connecting failed.");
        }
    }

    @PutMapping("/devices")
    public ResponseEntity<String> saveDevice(@RequestBody SaveDeviceRequest request){
        if(deviceService.saveDevice(request.getDeviceId(), request.getDeviceNickname())){
            return ResponseEntity.status(HttpStatus.CREATED).body("Device saved.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Device saving failed.");
        }
    }

    @PutMapping("/device-mappings")
    public ResponseEntity<String> saveDeviceMapping(@RequestBody SaveDeviceMappingRequest request){
        if(deviceService.saveDeviceMapping(request.getDeviceNickname(), request.getCreatureId(), request.isDungeonMaster())){
            return ResponseEntity.status(HttpStatus.CREATED).body("DeviceMapping saved.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DeviceMapping saving failed.");
        }
    }
}
