package com.soramusoka.destinyApiClient.dto_layer.account_summary;

import java.util.LinkedHashMap;

public class StatGroupDefinition {
    public double statGroupHash;
    public int maximumValue;
    public int uiPosition;
    public double hash;
    public int index;
    public ScaledStat[] scaledStats;
    public LinkedHashMap<String, OverrideDefinition> overrides;
}
