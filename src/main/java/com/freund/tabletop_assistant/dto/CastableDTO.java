package com.freund.tabletop_assistant.dto;

import java.util.List;
import java.util.Map;

import com.freund.tabletop_assistant.model.ability.Ability;
import com.freund.tabletop_assistant.model.castable.CastableDamageComponent;
import com.freund.tabletop_assistant.model.castable.CastableType;
import com.freund.tabletop_assistant.model.castable.EffectTarget;
import com.freund.tabletop_assistant.model.condition.Condition;
import com.freund.tabletop_assistant.model.duration.Duration;
import com.freund.tabletop_assistant.model.turnresource.TurnResourceType;

import lombok.Data;

@Data
public class CastableDTO {
    // TODO Spell stuff?, schools...
    // TODO WeaponAction.flatDC
    // maybe add String castableCategory for frontend rendering
    private CastableType castableType;
    private String castableName;
    private boolean ritual;
    private boolean concentration;
    private Ability savingThrow;
    private EffectTarget effectTarget;
    private Duration duration;
    private Map<TurnResourceType, Integer> costs;
    private List<CastableDamageComponent> castableDamageComponents;
    private Map<Integer, String> healAtSlotLevel;
    private List<Condition> appliesConditions;
    private List<String> description;
}
