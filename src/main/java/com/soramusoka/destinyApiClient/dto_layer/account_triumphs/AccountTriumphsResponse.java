package com.soramusoka.destinyApiClient.dto_layer.account_triumphs;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.DestinyServerResponse;

public class AccountTriumphsResponse extends DestinyServerResponse {
    public ResponseData<TriumphSummary, TriumphDefinitionSummary> Response;
}
