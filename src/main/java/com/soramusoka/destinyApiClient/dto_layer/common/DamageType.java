package com.soramusoka.destinyApiClient.dto_layer.common;

public enum DamageType {
    Kinetic("Kinetic"), Arc("Arc"), Solar("Solar"), Void("Void");

    private final String _value;

    private DamageType(String value) {
        this._value = value;
    }

    public String getValue() {
        return this._value;
    }
}
