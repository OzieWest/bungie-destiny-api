package com.soramusoka.destinyApiClient.dto_layer.account_grimoire;

import com.soramusoka.destinyApiClient.dto_layer.ServerResponse;
import com.soramusoka.destinyApiClient.dto_layer.grimoire_definitions.GrimoireCard;

import java.util.LinkedHashMap;

public class AccountGrimoireResponse extends ServerResponse {
    public GrimoireResponseData<AccountGrimoire, LinkedHashMap<String, GrimoireCard>> Response;
}
