package com.freund.tabletop_assistant.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import com.freund.tabletop_assistant.dto.LogEntryFileDTO;
import com.freund.tabletop_assistant.dto.PingCastableRequest;
import com.freund.tabletop_assistant.model.castable.CastableInstance;
import com.freund.tabletop_assistant.model.gamelog.GameLog;
import com.freund.tabletop_assistant.model.gamelog.LogEntry;
import com.freund.tabletop_assistant.model.gamelog.types.CastablePingedLogEntry;
import com.freund.tabletop_assistant.util.JsonHandler;

import jakarta.annotation.PostConstruct;

@Service
@DependsOn("gameStateService")
public class GameLogService {
    private static final String FILE_PATH = "gamelog.json";
    @Autowired
    private GameLog gameLog;
    @Autowired
    private LogEntryReconstructorService logEntryReconstructorService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private CreatureService creatureService;
    @Autowired
    private CastableService castableService;

    @PostConstruct
    public void init() {
        loadGameLog();
    }

    public void addCastablePingedLogEntry(PingCastableRequest request){
        CastableInstance castableInstance = new CastableInstance(
            castableService.getCastable(request.getCastableName()),
            creatureService.getCreature(request.getCasterId()),
            creatureService.getCreature(request.getCasterId()).getLevel(),
            request.getSlotLevel()
        );
        CastablePingedLogEntry castablePingedLogEntry = new CastablePingedLogEntry(
            deviceService.getDevice(request.getDeviceId()),
            castableInstance
        );
        gameLog.add(castablePingedLogEntry);
    }

    public boolean saveGameLog() {
        try {
            JsonHandler.saveGameLogToFile(gameLog, FILE_PATH);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loadGameLog() {
        try {
            List<LogEntryFileDTO> dtoList = JsonHandler.loadGameLogDTOsFromFile(FILE_PATH);
            List<LogEntry> reconstructed = logEntryReconstructorService.fromDTOs(dtoList);
            gameLog.setLogEntries(reconstructed);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public GameLog getGameLog() {
        return gameLog;
    }
}
