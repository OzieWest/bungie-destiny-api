package com.soramusoka.destinyApiClient.dto_layer.character_inventory;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.DestinyServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseAccountDefinitionGroup;

public class CharacterInventoryResponse extends DestinyServerResponse {
    public ResponseData<CharacterInventoryGroup, BaseAccountDefinitionGroup> Response;
}
