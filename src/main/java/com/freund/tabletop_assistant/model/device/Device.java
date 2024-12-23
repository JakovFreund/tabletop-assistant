package com.freund.tabletop_assistant.model.device;

import java.util.UUID;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private UUID deviceId;
    private String deviceNickname;
}
