package com.soramusoka.destinyApiClient.dto_layer.unique_weapons_stats;

import com.soramusoka.destinyApiClient.dto_layer.common.StatGroupOf;
import com.soramusoka.destinyApiClient.dto_layer.common.StatValue;

public class UniqueWeaponsStatGroup {
    public UniqueWeaponsStat[] weapons;
    public StatGroupOf<StatValue> values;
}
