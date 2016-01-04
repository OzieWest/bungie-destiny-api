package com.soramusoka.destinyApiClient.dto_layer.account_triumphs;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.ServerResponse;

public class AccountTriumphsResponse extends ServerResponse {
    public ResponseData<TriumphSummary, TriumphDefinitionSummary> Response;
}
