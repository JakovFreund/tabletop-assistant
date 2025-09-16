package com.freund.tabletop_assistant.mapper;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.freund.tabletop_assistant.dto.LogEntryFrontendDTO;
import com.freund.tabletop_assistant.model.gamelog.LogEntry;
import com.freund.tabletop_assistant.model.gamelog.LogEntryType;
import com.freund.tabletop_assistant.model.gamelog.types.CastableDamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.CastablePingedLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.CastableUsedLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.DamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ItemDamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.LostConditionLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ReceivedConditionFromCastableLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ReceivedConditionLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ReceivedEffectLogEntry;

public class LogEntryFrontendMapper {
    private static final Map<Class<? extends LogEntry>, Function<LogEntry, LogEntryFrontendDTO>> registry = new HashMap<>();

    static {
        registry.put(CastableDamageLogEntry.class, l -> toDTO((CastableDamageLogEntry) l));
        registry.put(CastablePingedLogEntry.class, l -> toDTO((CastablePingedLogEntry) l));
        registry.put(CastableUsedLogEntry.class, l -> toDTO((CastableUsedLogEntry) l));
        registry.put(DamageLogEntry.class, l -> toDTO((DamageLogEntry) l));
        registry.put(ItemDamageLogEntry.class, l -> toDTO((ItemDamageLogEntry) l));
        registry.put(LostConditionLogEntry.class, l -> toDTO((LostConditionLogEntry) l));
        registry.put(ReceivedConditionFromCastableLogEntry.class,
                l -> toDTO((ReceivedConditionFromCastableLogEntry) l));
        registry.put(ReceivedConditionLogEntry.class, l -> toDTO((ReceivedConditionLogEntry) l));
    }

    public static LogEntryFrontendDTO toDTO(LogEntry logEntry) {
        var mapper = registry.get(logEntry.getClass());
        if (mapper == null)
            throw new IllegalArgumentException("Unsupported type " + logEntry.getClass());
        return mapper.apply(logEntry);
    }

    private static void mapBaseFields(LogEntryFrontendDTO dto, LogEntry logEntry) {
        dto.setLogEntryId(logEntry.getLogEntryId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.systemDefault());
        dto.setTimestamp(formatter.format(logEntry.getTimestamp()));
        dto.setVisibility(logEntry.getVisibility());
        dto.setNested(logEntry.isNested());
        dto.setLogEntryType(LogEntryType.fromClass(logEntry.getClass()));
    }

    private static void mapReceivedEffectFields(LogEntryFrontendDTO dto, ReceivedEffectLogEntry logEntry) {
        mapBaseFields(dto, logEntry);
        dto.setTargetCreatureId(logEntry.getTargetCreature().getCreatureId());
        dto.setTargetCreatureName(logEntry.getTargetCreature().getName());
        dto.setEffectSourceType(logEntry.getEffectSourceType());
    }

    private static void mapDamageFields(LogEntryFrontendDTO dto, DamageLogEntry logEntry) {
        mapReceivedEffectFields(dto, logEntry);
        dto.setDamageEntry(logEntry.getDamageEntry());
        dto.setStatCalculationBreakdowns(logEntry.getStatCalculationBreakdowns());
    }

    private static void mapReceivedConditionFields(LogEntryFrontendDTO dto, ReceivedConditionLogEntry logEntry) {
        mapReceivedEffectFields(dto, logEntry);
        dto.setReceivedStatusEffectInstance(
                StatusEffectInstanceMapper.toDTO(logEntry.getReceivedStatusEffectInstance()));
    }

    public static LogEntryFrontendDTO toDTO(DamageLogEntry logEntry) {
        LogEntryFrontendDTO dto = new LogEntryFrontendDTO();
        mapDamageFields(dto, logEntry);
        return dto;
    }

    public static LogEntryFrontendDTO toDTO(CastableDamageLogEntry logEntry) {
        LogEntryFrontendDTO dto = new LogEntryFrontendDTO();
        mapDamageFields(dto, logEntry);
        return dto;
    }

    public static LogEntryFrontendDTO toDTO(CastablePingedLogEntry logEntry) {
        LogEntryFrontendDTO dto = new LogEntryFrontendDTO();
        mapBaseFields(dto, logEntry);
        dto.setDeviceNickname(logEntry.getDevice().getDeviceNickname());
        dto.setCastableInstance(CastableMapper.toFrontendDTO(logEntry.getCastableInstance()));
        return dto;
    }

    public static LogEntryFrontendDTO toDTO(CastableUsedLogEntry logEntry) {
        LogEntryFrontendDTO dto = new LogEntryFrontendDTO();
        mapBaseFields(dto, logEntry);
        dto.setCastableInstance(CastableMapper.toFrontendDTO(logEntry.getCastableInstance()));
        return dto;
    }

    public static LogEntryFrontendDTO toDTO(ItemDamageLogEntry logEntry) {
        LogEntryFrontendDTO dto = new LogEntryFrontendDTO();
        mapDamageFields(dto, logEntry);
        dto.setItemId(logEntry.getItem().getItemId());
        dto.setItemName(logEntry.getItem().getName());
        return dto;
    }

    public static LogEntryFrontendDTO toDTO(LostConditionLogEntry logEntry) {
        LogEntryFrontendDTO dto = new LogEntryFrontendDTO();
        mapBaseFields(dto, logEntry);
        dto.setTargetCreatureId(logEntry.getTargetCreature().getCreatureId());
        dto.setTargetCreatureName(logEntry.getTargetCreature().getName());
        dto.setLostStatusEffectInstance(StatusEffectInstanceMapper.toDTO(logEntry.getLostStatusEffectInstance()));
        return dto;
    }

    public static LogEntryFrontendDTO toDTO(ReceivedConditionFromCastableLogEntry logEntry) {
        LogEntryFrontendDTO dto = new LogEntryFrontendDTO();
        mapReceivedConditionFields(dto, logEntry);
        return dto;
    }

    public static LogEntryFrontendDTO toDTO(ReceivedConditionLogEntry logEntry) {
        LogEntryFrontendDTO dto = new LogEntryFrontendDTO();
        mapReceivedConditionFields(dto, logEntry);
        return dto;
    }
}
