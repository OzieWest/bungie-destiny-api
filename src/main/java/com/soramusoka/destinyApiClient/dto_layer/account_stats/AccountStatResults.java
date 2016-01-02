package com.soramusoka.destinyApiClient.dto_layer.account_stats;

import com.soramusoka.destinyApiClient.dto_layer.common.StatValue;
import com.soramusoka.destinyApiClient.dto_layer.common.StatGroupOf;

public class AccountStatResults {
    public ForAllTime<StatGroupOf<StatValue>> allPvE;
    public ForAllTime<StatGroupOf<StatValue>> allPvP;
}
