package com.soramusoka.destinyApiClient.dto_layer.account_stats;

import com.soramusoka.destinyApiClient.dto_layer.common.StatValue;
import com.soramusoka.destinyApiClient.dto_layer.common.StatGroupOf;

public class AccountStatSummary {
    public AccountStatResults results;
    public ForAllTime<StatGroupOf<StatValue>> merged;
}
