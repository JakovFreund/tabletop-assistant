package com.freund.tabletop_assistant.dto;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.freund.tabletop_assistant.model.damage.DamageEntry;
import com.freund.tabletop_assistant.model.gamelog.LogEntryType;
import com.freund.tabletop_assistant.model.gamelog.LogVisibility;
import com.freund.tabletop_assistant.model.gamelog.statcalculation.StatCalculationBreakdown;
import com.freund.tabletop_assistant.model.scene.SceneCover;
import com.freund.tabletop_assistant.model.scene.SceneLightSource;
import com.freund.tabletop_assistant.model.scene.SceneLightLevel;
import com.freund.tabletop_assistant.model.scene.TimeOfDay;
import com.freund.tabletop_assistant.model.scene.Weather;
import com.freund.tabletop_assistant.model.source.EffectSourceType;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogEntryFrontendDTO {
    private UUID logEntryId;
    private String timestamp;
    private LogVisibility visibility;
    private boolean isNested;
    private LogEntryType logEntryType;

    private UUID targetCreatureId;
    private String targetCreatureName;
    private UUID sourceCreatureId;
    private String sourceCreatureName;
    private UUID itemId;
    private String itemName;
    // probably don't need this since i have isNested for rendering
    // private UUID castableUsedLogEntryId;
    private String deviceNickname;
    private DamageEntry damageEntry;
    private EffectSourceType effectSourceType;
    private CastableInstanceFrontendDTO castableInstance;
    private ConditionInstanceDTO lostConditionInstance;
    private ConditionInstanceDTO receivedConditionInstance;

    private List<StatCalculationBreakdown> statCalculationBreakdowns;

    private int roundNumber;
    private Weather weather;
    private TimeOfDay timeOfDay;
    private SceneCover sceneCover;
    private SceneLightSource sceneLightSource;
    private SceneLightLevel sceneLighting;
}
