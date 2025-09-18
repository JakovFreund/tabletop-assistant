package com.freund.tabletop_assistant.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.freund.tabletop_assistant.model.creature.Creature;
import com.freund.tabletop_assistant.model.device.DeviceMapping;


@Component
@Data
@NoArgsConstructor
public class GameState {
    // fantasy datetime
    private List<Creature> creatures = new ArrayList<>();
    private List<DeviceMapping> deviceMappings = new ArrayList<>();
    // scene
    // item list

    // possibly move theseˇˇ 3 to service

    public Creature getCreature (UUID id){
        for (Creature creature : this.getCreatures()){
            if (creature.getCreatureId().equals(id)){
                return creature;
            }
        }
        return null;
    }

    public DeviceMapping getDeviceMapping(String deviceNickname){
        for (DeviceMapping deviceMapping : deviceMappings){
            if (deviceMapping.getDeviceNickname().equals(deviceNickname)){
                return deviceMapping;
            }
        }
        return null;
    }
}
