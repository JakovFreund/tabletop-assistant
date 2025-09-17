package com.freund.tabletop_assistant.model.scene;

public enum TimeOfDay {
    MORNING(SceneLightLevel.DIM, 6, 8),
    DAY(SceneLightLevel.BRIGHT, 9, 18),
    EVENING(SceneLightLevel.DIM, 19, 21),
    NIGHT(SceneLightLevel.DARKNESS, 22, 5);

    final SceneLightLevel LIGHT_LEVEL;
    final int START_HOUR;
    final int END_HOUR;
    // clock time range

    TimeOfDay(SceneLightLevel lightLevel, int startHour, int endHour){
        this.LIGHT_LEVEL = lightLevel;
        this.START_HOUR = startHour;
        this.END_HOUR = endHour;
    }
}
