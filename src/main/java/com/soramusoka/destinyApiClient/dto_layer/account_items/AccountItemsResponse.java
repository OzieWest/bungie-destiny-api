package com.soramusoka.destinyApiClient.dto_layer.account_items;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.DestinyServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseAccountDefinitionGroup;

public class AccountItemsResponse extends DestinyServerResponse {
    public ResponseData<AccountItemGroup, BaseAccountDefinitionGroup> Response;
}
