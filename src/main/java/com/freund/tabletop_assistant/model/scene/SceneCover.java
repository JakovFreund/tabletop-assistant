package com.freund.tabletop_assistant.model.scene;

public enum SceneCover {
    INDOORS, // affected by TimeOfDay lighting (through windows)
    OUTDOORS,
    UNDERGROUND // unaffected by TimeOfDay lighting, needs light source
}
