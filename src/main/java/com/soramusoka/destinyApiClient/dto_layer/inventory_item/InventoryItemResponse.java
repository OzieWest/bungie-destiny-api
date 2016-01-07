package com.soramusoka.destinyApiClient.dto_layer.inventory_item;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.ServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseAccountDefinitionGroup;

public class InventoryItemResponse extends ServerResponse {
    public ResponseData<InventoryItemSummary, BaseAccountDefinitionGroup> Response;
}
