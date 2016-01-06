package com.soramusoka.destinyApiClient.dto_layer.account_summary;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.DestinyServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseAccountDefinitionGroup;

public class AccountSummaryResponse extends DestinyServerResponse {
    public ResponseData<AccountSummary, BaseAccountDefinitionGroup> Response;
}
