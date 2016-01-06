package com.soramusoka.destinyApiClient.dto_layer.character_progression;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.DestinyServerResponse;

public class CharacterProgressionResponse extends DestinyServerResponse {
    public ResponseData<CharacterProgression, CharacterProgressionDefinitionGroup> Response;
}
