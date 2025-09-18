package com.freund.tabletop_assistant.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.model.device.ConnectedDevices;
import com.freund.tabletop_assistant.model.device.Device;
import com.freund.tabletop_assistant.model.device.DeviceRegistry;
import com.freund.tabletop_assistant.util.JsonHandler;

import jakarta.annotation.PostConstruct;

@Service
public class DeviceService {
    private static final String FILE_PATH = "devices.json";
    @Autowired
    private ConnectedDevices connectedDevices;
    @Autowired
    private GameStateService gameStateService;
    @Autowired
    private DeviceRegistry deviceRegistry;

    public List<UUID> getCurrentlyConnectedDeviceIds() {
        return new ArrayList<UUID>(connectedDevices.getCurrentlyConnectedDeviceIds());
    }

    public Device getDevice(UUID deviceId) {
        return deviceRegistry.getDevice(deviceId);
    }

    public DeviceRegistry getDeviceRegistry() {
        return deviceRegistry;
    }

    public boolean saveDevice(UUID deviceId, String deviceNickname) {
        if (deviceRegistry.getDevice(deviceId) == null) {
            deviceRegistry.getDevices().add(new Device(deviceId, deviceNickname));
        } else {
            deviceRegistry.getDevice(deviceId).setDeviceNickname(deviceNickname);
        }
        saveDeviceRegistry();
        return true;
    }

    public boolean connectDevice(UUID id) { //TODO add try-catch
        connectedDevices.addDevice(id);
        String deviceNickname = "(device not mapped to nickname)";
        if (deviceRegistry.getDevice(id) != null) {
            deviceNickname = deviceRegistry.getDevice(id).getDeviceNickname();
        }
        System.out.println("Connected device: " + deviceNickname + " " + id);
        return true;
    }

    public boolean saveDeviceMapping(String deviceNickname, UUID creatureId, boolean dungeonMaster) {
        return gameStateService.saveDeviceMapping(deviceNickname, creatureId, dungeonMaster);
    }

    @PostConstruct
    public boolean loadDeviceRegistry() {
        try {
            List<Device> loadedDevices = JsonHandler.loadDevicesFromFile(FILE_PATH);
            deviceRegistry.setDevices(loadedDevices);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveDeviceRegistry() {
        try {
            JsonHandler.saveDevicesToFile(deviceRegistry.getDevices(), FILE_PATH);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
