package com.freund.tabletop_assistant.model.device;

import java.util.UUID;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
public class Device {
    private UUID deviceId;
    private String deviceNickname;
}
