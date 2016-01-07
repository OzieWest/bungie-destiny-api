package com.soramusoka.destinyApiClient.dto_layer.unique_weapons_stats;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.ServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseAccountDefinitionGroup;

public class UniqueWeaponsStatsResponse extends ServerResponse {
    public ResponseData<UniqueWeaponsStatGroup, BaseAccountDefinitionGroup> Response;
}
