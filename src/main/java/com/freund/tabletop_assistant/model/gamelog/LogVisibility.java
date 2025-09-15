package com.freund.tabletop_assistant.model.gamelog;

public enum LogVisibility {
    ALWAYS, // only important global messages
    SCENE, // most stuff
    DM_ONLY,
    PLAYER_PING // seen by source player and DM
}
