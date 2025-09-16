package com.freund.tabletop_assistant.model.damage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DamageEntry { // use only for DTOs and logging
    DamageType damageType;
    String damageAmount;
}
