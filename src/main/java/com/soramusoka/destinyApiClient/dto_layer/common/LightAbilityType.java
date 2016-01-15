package com.soramusoka.destinyApiClient.dto_layer.common;

public enum LightAbilityType {
    Grenades("Grenades"),
    Melee("Melee"),
    MovementModes("MovementModes"),
    Orbs("Orbs"),
    SuperEnergy("SuperEnergy"),
    SuperMods("SuperMods");

    private final String _value;

    private LightAbilityType(String value) {
        this._value = value;
    }

    public String getValue() {
        return this._value;
    }
}
