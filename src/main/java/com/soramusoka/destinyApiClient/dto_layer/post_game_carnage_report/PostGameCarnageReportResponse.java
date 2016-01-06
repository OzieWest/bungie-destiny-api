package com.soramusoka.destinyApiClient.dto_layer.post_game_carnage_report;

import com.soramusoka.destinyApiClient.dto_layer.ResponseData;
import com.soramusoka.destinyApiClient.dto_layer.DestinyServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseAccountDefinitionGroup;

public class PostGameCarnageReportResponse extends DestinyServerResponse {
    public ResponseData<PostGameCarnageReport, BaseAccountDefinitionGroup> Response;
}
