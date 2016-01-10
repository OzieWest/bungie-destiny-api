package com.soramusoka.destinyApiClient.dto_layer.account_stats;

import com.soramusoka.destinyApiClient.dto_layer.common.StatValue;

import java.util.LinkedHashMap;

public class AccountStatSummary {
    public AccountStatResults results;
    public ForTime<LinkedHashMap<String, StatValue>> merged;
}
