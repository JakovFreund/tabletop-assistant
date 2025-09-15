package com.freund.tabletop_assistant.model.creature;

import java.util.List;

import com.freund.tabletop_assistant.model.ability.Skill;

public enum Background {  
    ACOLYTE(List.of(Skill.INSIGHT, Skill.RELIGION)),
    CHARLATAN(List.of(Skill.DECEPTION, Skill.SLEIGHT_OF_HAND)),
    CRIMINAL(List.of(Skill.DECEPTION, Skill.STEALTH)),
    ENTERTAINER(List.of(Skill.ACROBATICS, Skill.PERFORMANCE)),
    FOLK_HERO(List.of(Skill.ANIMAL_HANDLING, Skill.SURVIVAL)),
    GUILD_ARTISAN(List.of(Skill.INSIGHT, Skill.PERSUASION)),
    HERMIT(List.of(Skill.MEDICINE, Skill.RELIGION)),
    NOBLE(List.of(Skill.HISTORY, Skill.PERSUASION)),
    OUTLANDER(List.of(Skill.ATHLETICS, Skill.SURVIVAL)),
    SAGE(List.of(Skill.ARCANA, Skill.HISTORY)),
    SAILOR(List.of(Skill.ATHLETICS, Skill.PERCEPTION)),
    SOLDIER(List.of(Skill.ATHLETICS, Skill.INTIMIDATION)),
    URCHIN(List.of(Skill.SLEIGHT_OF_HAND, Skill.STEALTH));

    final List<Skill> SKILL_PROFICIENCIES;

    Background(List<Skill> skillProficiencies){
        this.SKILL_PROFICIENCIES = skillProficiencies;
    }
}
