package com.soramusoka.destinyApiClient.dto_layer.unique_weapons_stats;

import com.soramusoka.destinyApiClient.dto_layer.common.StatValue;

import java.util.LinkedHashMap;

public class UniqueWeaponsStatGroup {
    public UniqueWeaponsStat[] weapons;
    public LinkedHashMap<String, StatValue> values;
}
