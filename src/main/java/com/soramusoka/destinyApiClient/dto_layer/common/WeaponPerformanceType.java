package com.soramusoka.destinyApiClient.dto_layer.common;

public enum WeaponPerformanceType {
    RateOfFire("RateOfFire"),
    Damage("Damage"),
    Accuracy("Accuracy"),
    Range("Range"),
    Zoom("Zoom"),
    Recoil("Recoil"),
    Ready("Ready"),
    Reload("Reload"),
    HairTrigger("HairTrigger"),
    AmmoAndMagazine("AmmoAndMagazine"),
    TrackingAndDetonation("TrackingAndDetonation"),
    ShotgunSpread("ShotgunSpread"),
    ChargeTime("ChargeTime");

    private final String _value;

    private WeaponPerformanceType(String value) {
        this._value = value;
    }

    public String getValue() {
        return this._value;
    }
}
