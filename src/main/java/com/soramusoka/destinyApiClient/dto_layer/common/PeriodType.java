package com.soramusoka.destinyApiClient.dto_layer.common;

public enum PeriodType {
    Daily("Daily"),
    Monthly("Monthly"),
    AllTime("AllTime"),
    Activity("Activity");

    private final String _value;

    private PeriodType(String value) {
        this._value = value;
    }

    public String getValue() {
        return this._value;
    }
}
