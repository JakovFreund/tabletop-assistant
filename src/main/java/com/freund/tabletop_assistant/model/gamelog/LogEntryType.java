package com.freund.tabletop_assistant.model.gamelog;

import com.freund.tabletop_assistant.model.gamelog.types.CastableDamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.CastablePingedLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.CastableUsedLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.DamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ItemDamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.LostConditionLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ReceivedConditionFromCastableLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ReceivedConditionLogEntry;

public enum LogEntryType {
    CASTABLE_DAMAGE(CastableDamageLogEntry.class),
    CASTABLE_PINGED(CastablePingedLogEntry.class),
    CASTABLE_USED(CastableUsedLogEntry.class),
    DAMAGE(DamageLogEntry.class),
    ITEM_DAMAGE(ItemDamageLogEntry.class),
    LOST_CONDITION(LostConditionLogEntry.class),
    RECEIVED_CONDITION_FROM_CASTABLE(ReceivedConditionFromCastableLogEntry.class),
    RECEIVED_CONDITION(ReceivedConditionLogEntry.class);

    private final Class<? extends LogEntry> clazz;

    LogEntryType(Class<? extends LogEntry> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends LogEntry> getClazz() {
        return clazz;
    }

    public static LogEntryType fromClass(Class<? extends LogEntry> clazz) {
        for (LogEntryType type : values()) {
            if (type.clazz.equals(clazz)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No LogEntryType mapped for " + clazz.getName());
    }

    /*
    // When converting a LogEntry → LogEntryFileDTO:
    LogEntry entry = new DamageLogEntry(...);

    LogEntryType type = LogEntryType.fromClass(entry.getClass());
    dto.setLogType(type);

    // When converting a DTO → LogEntry:
    LogEntryType type = dto.getLogType();
    Class<? extends LogEntry> clazz = type.getClazz();

    // if you want to reconstruct, use Jackson or reflection:
    LogEntry reconstructed = objectMapper.convertValue(dto, clazz);

    */
}

