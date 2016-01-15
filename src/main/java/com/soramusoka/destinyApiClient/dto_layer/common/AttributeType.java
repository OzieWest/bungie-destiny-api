package com.soramusoka.destinyApiClient.dto_layer.common;

public enum AttributeType {
    Stats("Stats"),
    Shields("Shields"),
    Health("Health"),
    Revive("Revive"),
    AimUnderFire("AimUnderFire"),
    Radar("Radar"),
    Invisibility("Invisibility"),
    Reputations("Reputations");

    private final String _value;

    private AttributeType(String value) {
        this._value = value;
    }

    public String getValue() {
        return this._value;
    }
}
