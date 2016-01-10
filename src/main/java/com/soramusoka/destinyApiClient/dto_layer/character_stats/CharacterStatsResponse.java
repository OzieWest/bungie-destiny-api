package com.soramusoka.destinyApiClient.dto_layer.character_stats;

import com.soramusoka.destinyApiClient.dto_layer.ServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.account_stats.ForTime;
import com.soramusoka.destinyApiClient.dto_layer.common.StatValue;

import java.util.LinkedHashMap;

public class CharacterStatsResponse extends ServerResponse {
    public LinkedHashMap<String, ForTime<LinkedHashMap<String, StatValue>>> Response;
}
