package com.soramusoka.destinyApiClient.dto_layer.character_activities;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.DestinyServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseAccountDefinitionGroup;

public class CharacterActivitiesResponse extends DestinyServerResponse {
    public ResponseData<CharacterActivityGroup, BaseAccountDefinitionGroup> Response;
}
