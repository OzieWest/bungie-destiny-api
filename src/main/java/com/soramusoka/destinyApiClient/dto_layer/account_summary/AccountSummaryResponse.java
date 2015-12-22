package com.soramusoka.destinyApiClient.dto_layer.account_summary;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.ServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseAccountDefinitionGroup;

public class AccountSummaryResponse extends ServerResponse {
    public ResponseData<AccountSummary, BaseAccountDefinitionGroup> Response;
}
