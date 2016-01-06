package com.soramusoka.destinyApiClient.dto_layer.aggregate_activity_stats;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.DestinyServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseAccountDefinitionGroup;

public class AggregateActivityStatsResponse extends DestinyServerResponse {
    public ResponseData<AggregateActivityStatsGroup, BaseAccountDefinitionGroup> Response;
}
