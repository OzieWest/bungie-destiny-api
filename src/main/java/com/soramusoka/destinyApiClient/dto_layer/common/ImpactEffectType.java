package com.soramusoka.destinyApiClient.dto_layer.common;

public enum ImpactEffectType {
    ArmorPiercing("ArmorPiercing"),
    Ricochet("Ricochet"),
    Flinch("Flinch"),
    CollateralDamage("CollateralDamage"),
    Disorient("Disorient"),
    HighlightTarget("HighlightTarget");

    private final String _value;

    private ImpactEffectType(String value) {
        this._value = value;
    }

    public String getValue() {
        return this._value;
    }
}
