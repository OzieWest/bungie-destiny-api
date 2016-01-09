package com.soramusoka.destinyApiClient.dto_layer.account_stats;

import com.soramusoka.destinyApiClient.dto_layer.common.StatValue;

import java.util.LinkedHashMap;

public class AccountStatResults {
    public ForAllTime<LinkedHashMap<String, StatValue>> allPvE;
    public ForAllTime<LinkedHashMap<String, StatValue>> allPvP;
}
