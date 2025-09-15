package com.freund.tabletop_assistant.model.damage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DamageComponent {
    DamageType damageType;
    String damageAmount;
}
