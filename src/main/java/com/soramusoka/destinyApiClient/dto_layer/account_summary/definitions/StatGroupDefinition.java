package com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions;

import com.soramusoka.destinyApiClient.dto_layer.account_summary.ScaledStat;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseDefinition;

import java.util.LinkedHashMap;

public class StatGroupDefinition extends BaseDefinition {
    public long statGroupHash;
    public int maximumValue;
    public int uiPosition;
    public ScaledStat[] scaledStats;
    public LinkedHashMap<String, OverrideDefinition> overrides;
}
