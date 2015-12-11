package com.soramusoka.destinyApiClient.dto_layer.account_summary;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;

public class AccountSummaryResponse {
    public ResponseData<AccountSummary> Response;
    public Integer ErrorCode;
    public Integer ThrottleSeconds;
    public String ErrorStatus;
    public String Message;
    public Object MessageData;
}
