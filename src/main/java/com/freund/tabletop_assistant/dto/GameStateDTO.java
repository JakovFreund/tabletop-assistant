package com.freund.tabletop_assistant.dto;

import java.util.List;

import com.freund.tabletop_assistant.model.device.DeviceMapping;

import lombok.Data;

@Data
public class GameStateDTO {
    // fantasy datetime
    private List<CreatureDTO> creatures;
    private List<DeviceMapping> deviceMappings;
    // scene
}

    
