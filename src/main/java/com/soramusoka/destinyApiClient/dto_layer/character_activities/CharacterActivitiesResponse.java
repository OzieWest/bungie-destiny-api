package com.soramusoka.destinyApiClient.dto_layer.character_activities;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.ServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseAccountDefinitionGroup;

public class CharacterActivitiesResponse extends ServerResponse {
    public ResponseData<CharacterActivityGroup, BaseAccountDefinitionGroup> Response;
}
