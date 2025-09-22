package com.freund.tabletop_assistant.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.dto.CastableInstanceFileDTO;
import com.freund.tabletop_assistant.dto.EffectSourceDTO;
import com.freund.tabletop_assistant.dto.LogEntryFileDTO;
import com.freund.tabletop_assistant.dto.ConditionInstanceDTO;
import com.freund.tabletop_assistant.model.castable.CastableInstance;
import com.freund.tabletop_assistant.model.condition.ConditionInstance;
import com.freund.tabletop_assistant.model.gamelog.LogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.CastableDamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.CastablePingedLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.CastableUsedLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.DamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ItemDamageLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.LostConditionLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ReceivedConditionFromCastableLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ReceivedConditionLogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.ReceivedEffectLogEntry;
import com.freund.tabletop_assistant.model.source.EffectSource;

@Service
public class LogEntryReconstructorService {
    @Autowired
    private CreatureService creatureService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private GameStateService gameStateService;
    @Autowired
    private CastableService castableService;

    public List<LogEntry> fromDTOs(List<LogEntryFileDTO> dtoList) {
        Map<UUID, LogEntry> reconstructed = new HashMap<>();

        // Pass 1
        for (LogEntryFileDTO dto : dtoList) {
            LogEntry entry = firstPass(dto);
            reconstructed.put(entry.getLogEntryId(), entry);
        }

        // Pass 2: resolve references
        for (LogEntryFileDTO dto : dtoList) {
            LogEntry entry = reconstructed.get(dto.getLogEntryId());
            secondPass(entry, dto, reconstructed);
        }
        return new ArrayList<>(reconstructed.values());
    }

    private LogEntry firstPass(LogEntryFileDTO dto) {
        switch (dto.getLogEntryType()) {
            case DAMAGE:
                return toDamageLogEntry(dto);
            case CASTABLE_DAMAGE:
                return toCastableDamageLogEntry(dto);
            case CASTABLE_PINGED:
                return toCastablePingedLogEntry(dto);
            case CASTABLE_USED:
                return toCastableUsedLogEntry(dto);
            case ITEM_DAMAGE:
                return toItemDamageLogEntry(dto);
            case LOST_CONDITION:
                return toLostConditionLogEntry(dto);
            case RECEIVED_CONDITION_FROM_CASTABLE:
                return toReceivedConditionFromCastableLogEntry(dto);
            case RECEIVED_CONDITION:
                return toReceivedConditionLogEntry(dto);
            default:
                throw new IllegalArgumentException("Unsupported log entry type: " + dto.getLogEntryType());
        }
    }

    private void secondPass(LogEntry entry, LogEntryFileDTO dto, Map<UUID, LogEntry> reconstructed) {
        if (entry instanceof CastableDamageLogEntry cd) {
            cd.setCastableUsedLogEntry(
                    (CastableUsedLogEntry) reconstructed.get(dto.getCastableUsedLogEntryId()));
        }

        if (entry instanceof ReceivedConditionFromCastableLogEntry rcfc) {
            rcfc.setCastableUsedLogEntry(
                    (CastableUsedLogEntry) reconstructed.get(dto.getCastableUsedLogEntryId()));
        }
    }

    private static void mapBaseFields(LogEntry entry, LogEntryFileDTO dto) {
        entry.setLogEntryId(dto.getLogEntryId());
        entry.setTimestamp(dto.getTimestamp());
        entry.setVisibility(dto.getVisibility());
    }

    private void mapReceivedEffectFields(ReceivedEffectLogEntry entry, LogEntryFileDTO dto) {
        mapBaseFields(entry, dto);
        entry.setTargetCreature(creatureService.getCreature(dto.getTargetCreatureId()));
        entry.setEffectSourceType(dto.getEffectSourceType());
    }

    private void mapDamageFields(DamageLogEntry entry, LogEntryFileDTO dto) {
        mapReceivedEffectFields(entry, dto);
        entry.setDamageEntry(dto.getDamageEntry());
        entry.setStatCalculationBreakdowns(dto.getStatCalculationBreakdowns());
    }

    private void mapReceivedConditionFields(ReceivedConditionLogEntry entry, LogEntryFileDTO dto) {
        mapReceivedEffectFields(entry, dto);
        entry.setReceivedConditionInstance(mapConditionInstance(dto.getReceivedConditionInstance()));
    }

    private CastableInstance mapCastableInstance(CastableInstanceFileDTO dto) {
        CastableInstance castableIntance = new CastableInstance();
        castableIntance.setCaster(creatureService.getCreature(dto.getCasterId()));
        castableIntance.setCastable(castableService.getCastable(dto.getCastableType()));
        castableIntance.setCurrentCasterLevel(dto.getCurrentCasterLevel());
        castableIntance.setSlotLevel(dto.getSlotLevel());
        return castableIntance;
    }

    private ConditionInstance mapConditionInstance(ConditionInstanceDTO dto) {
        ConditionInstance conditionInstance = new ConditionInstance();
        conditionInstance.setCondition(dto.getCondition());
        conditionInstance.setDuration(dto.getDuration());
        conditionInstance.setEffectSource(mapEffectSource(dto.getEffectSourceDTO()));
        return conditionInstance;
    }

    private EffectSource mapEffectSource(EffectSourceDTO dto) {
        EffectSource effectSource = new EffectSource();
        effectSource.setCreature(creatureService.getCreature(dto.getCreatureId()));
        effectSource.setEffectSourceType(dto.getEffectSourceType());
        return effectSource;
    }

    private DamageLogEntry toDamageLogEntry(LogEntryFileDTO dto) {
        DamageLogEntry entry = new DamageLogEntry();
        mapDamageFields(entry, dto);
        return entry;
    }

    private CastableDamageLogEntry toCastableDamageLogEntry(LogEntryFileDTO dto) {
        CastableDamageLogEntry entry = new CastableDamageLogEntry();
        mapDamageFields(entry, dto);
        entry.setCastableUsedLogEntry(null);
        return entry;
    }

    private CastablePingedLogEntry toCastablePingedLogEntry(LogEntryFileDTO dto) {
        CastablePingedLogEntry entry = new CastablePingedLogEntry();
        mapBaseFields(entry, dto);
        entry.setDevice(deviceService.getDevice(dto.getDeviceId()));
        entry.setCastableInstance(mapCastableInstance(dto.getCastableInstance()));
        return entry;
    }

    private CastableUsedLogEntry toCastableUsedLogEntry(LogEntryFileDTO dto) {
        CastableUsedLogEntry entry = new CastableUsedLogEntry();
        mapBaseFields(entry, dto);
        entry.setCastableInstance(mapCastableInstance(dto.getCastableInstance()));
        return entry;
    }

    private ItemDamageLogEntry toItemDamageLogEntry(LogEntryFileDTO dto) {
        ItemDamageLogEntry entry = new ItemDamageLogEntry();
        mapDamageFields(entry, dto);
        entry.setItem(gameStateService.getItem(dto.getItemId()));
        return entry;
    }

    private LostConditionLogEntry toLostConditionLogEntry(LogEntryFileDTO dto) {
        LostConditionLogEntry entry = new LostConditionLogEntry();
        mapBaseFields(entry, dto);
        entry.setTargetCreature(creatureService.getCreature(dto.getTargetCreatureId()));
        entry.setLostConditionInstance(mapConditionInstance(dto.getLostConditionInstance()));
        return entry;
    }

    private ReceivedConditionFromCastableLogEntry toReceivedConditionFromCastableLogEntry(LogEntryFileDTO dto) {
        ReceivedConditionFromCastableLogEntry entry = new ReceivedConditionFromCastableLogEntry();
        mapReceivedConditionFields(entry, dto);
        entry.setCastableUsedLogEntry(null);
        return entry;
    }

    private ReceivedConditionLogEntry toReceivedConditionLogEntry(LogEntryFileDTO dto) {
        ReceivedConditionLogEntry entry = new ReceivedConditionLogEntry();
        mapReceivedConditionFields(entry, dto);
        return entry;
    }
}
