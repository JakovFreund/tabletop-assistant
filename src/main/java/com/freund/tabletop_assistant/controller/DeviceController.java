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
import com.freund.tabletop_assistant.dto.SaveDeviceMappingRequest;
import com.freund.tabletop_assistant.dto.SaveDeviceRequest;
import com.freund.tabletop_assistant.service.DeviceService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("/connected")
    public ArrayList<UUID> getConnectedDevices() {
        return deviceService.getCurrentlyConnectedDeviceIds();
    }

    @PostMapping("/connect")
    public ResponseEntity<String> connectDevice(@RequestBody ConnectDeviceRequest request) {
        if(deviceService.connectDevice(request.getDeviceId())){
            return new ResponseEntity<>("Device connected.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Device connecting failed.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/UUID")
    public String generateUUID() {
        String id = UUID.randomUUID().toString();
        System.out.println("Generated UUID: " + id);
        return id;
    }

    @PutMapping("/device")
    public ResponseEntity<String> saveDevice(@RequestBody SaveDeviceRequest request){
        if(deviceService.saveDevice(request.getDeviceId(), request.getDeviceNickname())){
            return new ResponseEntity<>("Device saved.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Device saving failed.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/device-mapping") // TODO is camel case appropriate ?
    public ResponseEntity<String> saveDeviceMapping(@RequestBody SaveDeviceMappingRequest request){
        if(deviceService.saveDeviceMapping(request.getDeviceNickname(), request.getCreatureId(), request.isDungeonMaster())){
            return new ResponseEntity<>("DeviceMapping saved.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("DeviceMapping saving failed.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
