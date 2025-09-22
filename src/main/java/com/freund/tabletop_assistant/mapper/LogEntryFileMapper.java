package com.freund.tabletop_assistant.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.freund.tabletop_assistant.dto.LogEntryFileDTO;
import com.freund.tabletop_assistant.model.gamelog.types.CastableUsedLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.DamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.LogEntry;
import com.freund.tabletop_assistant.model.gamelog.LogEntryType;
import com.freund.tabletop_assistant.model.gamelog.types.CastableDamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.CastablePingedLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ItemDamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.LostConditionLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ReceivedConditionFromCastableLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ReceivedConditionLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ReceivedEffectLogEntry;

public class LogEntryFileMapper {
    private static final Map<Class<? extends LogEntry>, Function<LogEntry, LogEntryFileDTO>> registry = new HashMap<>();

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

    public static LogEntryFileDTO toDTO(LogEntry logEntry) {
        var mapper = registry.get(logEntry.getClass());
        if (mapper == null)
            throw new IllegalArgumentException("Unsupported type " + logEntry.getClass());
        return mapper.apply(logEntry);
    }

    private static void mapBaseFields(LogEntryFileDTO dto, LogEntry logEntry) {
        dto.setLogEntryId(logEntry.getLogEntryId());
        dto.setTimestamp(logEntry.getTimestamp());
        dto.setVisibility(logEntry.getVisibility());
        dto.setNested(logEntry.isNested());
        dto.setLogEntryType(LogEntryType.fromClass(logEntry.getClass()));
    }

    private static void mapReceivedEffectFields(LogEntryFileDTO dto, ReceivedEffectLogEntry logEntry) {
        mapBaseFields(dto, logEntry);
        dto.setTargetCreatureId(logEntry.getTargetCreature().getCreatureId());
        dto.setEffectSourceType(logEntry.getEffectSourceType());

    }

    private static void mapDamageFields(LogEntryFileDTO dto, DamageLogEntry logEntry) {
        mapReceivedEffectFields(dto, logEntry);
        dto.setDamageEntry(logEntry.getDamageEntry());
        dto.setStatCalculationBreakdowns(logEntry.getStatCalculationBreakdowns());
    }

    private static void mapReceivedConditionFields(LogEntryFileDTO dto, ReceivedConditionLogEntry logEntry) {
        mapReceivedEffectFields(dto, logEntry);
        dto.setReceivedStatusEffectInstance(
                StatusEffectInstanceMapper.toDTO(logEntry.getReceivedStatusEffectInstance()));
    }

    public static LogEntryFileDTO toDTO(DamageLogEntry logEntry) {
        LogEntryFileDTO dto = new LogEntryFileDTO();
        mapDamageFields(dto, logEntry);
        dto.setText(logEntry.getTargetCreature().getName() + " was damaged for "
                + logEntry.getDamageEntry().getDamageAmount() + " " + logEntry.getDamageEntry().getDamageType()
                + " damage");
        return dto;
    }

    public static LogEntryFileDTO toDTO(CastableDamageLogEntry logEntry) {
        LogEntryFileDTO dto = new LogEntryFileDTO();
        mapDamageFields(dto, logEntry);
        dto.setCastableUsedLogEntryId(logEntry.getCastableUsedLogEntry().getLogEntryId());
        dto.setText(
                logEntry.getTargetCreature().getName() + " was hit for " + logEntry.getDamageEntry().getDamageAmount()
                        + " " + logEntry.getDamageEntry().getDamageType() + " damage by "
                        + logEntry.getCastableUsedLogEntry().getCastableInstance().getCastable()
                                .getCastableType().CASTABLE_NAME);
        return dto;
    }

    public static LogEntryFileDTO toDTO(CastablePingedLogEntry logEntry) {
        LogEntryFileDTO dto = new LogEntryFileDTO();
        mapBaseFields(dto, logEntry);
        dto.setDeviceId(logEntry.getDevice().getDeviceId());
        dto.setCastableInstance(CastableInstanceMapper.toFileDTO(logEntry.getCastableInstance()));
        dto.setText(logEntry.getDevice().getDeviceNickname() + " pinged "
                + logEntry.getCastableInstance().getCastable().getCastableType().CASTABLE_NAME);
        return dto;
    }

    public static LogEntryFileDTO toDTO(CastableUsedLogEntry logEntry) {
        LogEntryFileDTO dto = new LogEntryFileDTO();
        mapBaseFields(dto, logEntry);
        dto.setCastableInstance(CastableInstanceMapper.toFileDTO(logEntry.getCastableInstance()));
        dto.setText(logEntry.getCastableInstance().getCaster().getName() + " used "
                + logEntry.getCastableInstance().getCastable().getCastableType().CASTABLE_NAME);
        return dto;
    }

    public static LogEntryFileDTO toDTO(ItemDamageLogEntry logEntry) {
        LogEntryFileDTO dto = new LogEntryFileDTO();
        mapDamageFields(dto, logEntry);
        dto.setItemId(logEntry.getItem().getItemId());
        dto.setText(logEntry.getTargetCreature().getName() + " was hit for "
                + logEntry.getDamageEntry().getDamageAmount() + " " + logEntry.getDamageEntry().getDamageType()
                + " damage by " + logEntry.getItem().getName());
        return dto;
    }

    public static LogEntryFileDTO toDTO(LostConditionLogEntry logEntry) {
        LogEntryFileDTO dto = new LogEntryFileDTO();
        mapBaseFields(dto, logEntry);
        dto.setTargetCreatureId(logEntry.getTargetCreature().getCreatureId());
        dto.setLostStatusEffectInstance(StatusEffectInstanceMapper.toDTO(logEntry.getLostStatusEffectInstance()));
        dto.setText(logEntry.getTargetCreature().getName() + " lost condition "
                + logEntry.getLostStatusEffectInstance().getStatusEffect().toString());
        return dto;
    }

    public static LogEntryFileDTO toDTO(ReceivedConditionFromCastableLogEntry logEntry) {
        LogEntryFileDTO dto = new LogEntryFileDTO();
        mapReceivedConditionFields(dto, logEntry);
        dto.setCastableUsedLogEntryId(logEntry.getCastableUsedLogEntry().getLogEntryId());
        dto.setText(logEntry.getTargetCreature().getName() + " received condition "
                + logEntry.getReceivedStatusEffectInstance().toString() + " from "
                + logEntry.getCastableUsedLogEntry().getCastableInstance().getCastable().getCastableType().CASTABLE_NAME
                + " - "
                + logEntry.getCastableUsedLogEntry().getCastableInstance().getCaster().getName());
        return dto;
    }

    public static LogEntryFileDTO toDTO(ReceivedConditionLogEntry logEntry) {
        LogEntryFileDTO dto = new LogEntryFileDTO();
        mapReceivedConditionFields(dto, logEntry);
        dto.setText(logEntry.getTargetCreature().getName() + " received condition "
                + logEntry.getReceivedStatusEffectInstance().toString() + " from " + logEntry.getEffectSourceType());
        return dto;
    }
}
