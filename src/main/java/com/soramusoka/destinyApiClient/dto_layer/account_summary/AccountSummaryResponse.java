package com.soramusoka.destinyApiClient.dto_layer.account_summary;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.ServerResponse;

public class AccountSummaryResponse extends ServerResponse {
    public ResponseData<AccountSummary, AccountSummaryDefinitionGroup> Response;
}
