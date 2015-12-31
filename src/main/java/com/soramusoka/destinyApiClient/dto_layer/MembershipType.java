package com.soramusoka.destinyApiClient.dto_layer;

public enum MembershipType {
    XBOX(1), PLAYSTATION(2);

    private final int _value;

    private MembershipType(int value) {
        this._value = value;
    }

    public int getValue() {
        return this._value;
    }
}
