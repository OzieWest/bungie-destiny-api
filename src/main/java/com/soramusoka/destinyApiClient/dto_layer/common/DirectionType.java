package com.soramusoka.destinyApiClient.dto_layer.common;

public enum DirectionType {
    Ascending("Ascending"),
    Descending("Descending");

    private final String _value;

    private DirectionType(String value) {
        this._value = value;
    }

    public String getValue() {
        return this._value;
    }
}
