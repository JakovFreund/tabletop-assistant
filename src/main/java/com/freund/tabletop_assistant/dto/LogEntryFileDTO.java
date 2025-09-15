package com.freund.tabletop_assistant.dto;

import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.freund.tabletop_assistant.model.damage.DamageType;
import com.freund.tabletop_assistant.model.gamelog.LogEntryType;
import com.freund.tabletop_assistant.model.gamelog.LogVisibility;
import com.freund.tabletop_assistant.model.scene.SceneCover;
import com.freund.tabletop_assistant.model.scene.SceneLightSource;
import com.freund.tabletop_assistant.model.scene.SceneLighting;
import com.freund.tabletop_assistant.model.scene.TimeOfDay;
import com.freund.tabletop_assistant.model.scene.Weather;
import com.freund.tabletop_assistant.model.source.EffectSourceType;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogEntryFileDTO {
    private UUID logEntryId;
    private Instant timestamp;
    private LogVisibility visibility;
    private LogEntryType logEntryType;

    private String text;

    private UUID targetCreatureId;
    private UUID sourceCreatureId;
    private UUID itemId;
    private UUID castableUsedLogEntryId;
    private UUID deviceId;
    private DamageType damageType;
    private String damageAmount;
    private EffectSourceType effectSourceType;
    private CastableInstanceDTO castableInstance;
    private StatusEffectInstanceDTO lostStatusEffectInstance;
    private StatusEffectInstanceDTO receivedStatusEffectInstance;
    
    private int roundNumber;
    private Weather weather;
    private TimeOfDay timeOfDay;
    private SceneCover sceneCover;
    private SceneLightSource sceneLightSource;
    private SceneLighting sceneLighting;

    // private Map<String, StatCalculationDTO> statCalculations; // how can i calculate this if not in LogEntry
    // do i need saving throw / opposed check info (Ability, Skill) ?
    // actually should be able to get this^^ info from castable

}
