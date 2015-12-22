package com.soramusoka.destinyApiClient.repository_layer;

import com.soramusoka.destinyApiClient.dto_layer.account_summary.AccountSummary;
import com.soramusoka.destinyApiClient.dto_layer.account_summary.AccountSummaryResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_activities.CharacterActivityGroup;
import com.soramusoka.destinyApiClient.dto_layer.character_activities.CharacterActivitiesResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_inventory.CharacterInventoryGroup;
import com.soramusoka.destinyApiClient.dto_layer.character_inventory.CharacterInventoryResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_progression.CharacterProgression;
import com.soramusoka.destinyApiClient.dto_layer.character_progression.CharacterProgressionResponse;
import com.soramusoka.destinyApiClient.dto_layer.membership_id.MembershipId;
import com.soramusoka.destinyApiClient.dto_layer.membership_id.MembershipIdResponse;
import com.soramusoka.destinyApiClient.dto_layer.stats_definition.StatsDefinitionGroup;
import com.soramusoka.destinyApiClient.dto_layer.stats_definition.StatsDefinitionResponse;
import com.soramusoka.destinyApiClient.service_layer.IRequest;
import org.codehaus.jackson.map.ObjectMapper;

public class DestinyApiClient {
    public IRequest Request;
    private String _hostName = "http://www.bungie.net";
    private String _rootPath = "/Platform/Destiny";
    private Integer _platform = 2;
    private ObjectMapper _mapper = null;

    public DestinyApiClient(IRequest request, Integer platform) {
        this._mapper = new ObjectMapper();
        this.Request = request;
        this._platform = platform;
    }

    private String formUrl(String url) {
        return this._hostName + this._rootPath + url;
    }

    /**
     * Returns a list of Destiny memberships given a full Gamertag or PSN ID.
     */
    public MembershipId[] getMembershipId(String userName) throws Exception {
        String url = this.formUrl("/SearchDestinyPlayer/" + this._platform + "/" + userName);
        String data = this.Request.getUrl(url);

        MembershipIdResponse response = this._mapper.readValue(data, MembershipIdResponse.class);
        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);
        return response.Response;
    }

    /**
     * Returns Destiny account information for the supplied membership in a compact summary form.
     */
    public AccountSummary getAccountSummary(String membershipId, boolean withDefinitions) throws Exception {
        String url = this.formUrl("/" + this._platform + "/Account/" + membershipId + "/Summary" + "?definitions=" + withDefinitions);
        String data = this.Request.getUrl(url);

        AccountSummaryResponse response = this._mapper.readValue(data, AccountSummaryResponse.class);
        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);
        return response.Response.data;
    }

    /**
     * Returns Destiny account information for the supplied membership in a compact summary form.
     */
    public AccountSummary getAccountSummary(String membershipId) throws Exception {
        return this.getAccountSummary(membershipId, false);
    }

    /**
     * Gets historical stats definitions.
     */
    public StatsDefinitionGroup getStatsDefinition() throws Exception {
        String url = this.formUrl("/Stats/Definition/");
        String data = this.Request.getUrl(url);

        StatsDefinitionResponse response = this._mapper.readValue(data, StatsDefinitionResponse.class);
        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);
        return response.Response;
    }

    /**
     * Provides the progression details for the supplied character.
     */
    public CharacterProgression getCharacterProgression(String membershipId, String characterId) throws Exception {
        return this.getCharacterProgression(membershipId, characterId, false);
    }

    /**
     * Provides the progression details for the supplied character.
     */
    public CharacterProgression getCharacterProgression(String membershipId, String characterId, boolean withDefinitions) throws Exception {
        String url = this.formUrl("/" + this._platform + "/Account/" + membershipId + "/Character/" + characterId + "/Progression" + "?definitions=" + withDefinitions);
        String data = this.Request.getUrl(url);

        CharacterProgressionResponse response = this._mapper.readValue(data, CharacterProgressionResponse.class);
        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);
        return response.Response.data;
    }

    /**
     * Retrieve the inventory for the supplied character.
     */
    public CharacterActivityGroup getCharacterActivities(String membershipId, String characterId) throws Exception {
        return this.getCharacterActivities(membershipId, characterId, false);
    }

    /**
     * Retrieve the inventory for the supplied character.
     */
    public CharacterActivityGroup getCharacterActivities(String membershipId, String characterId, boolean withDefinitions) throws Exception {
        String url = this.formUrl("/" + this._platform + "/Account/" + membershipId + "/Character/" + characterId + "/Activities" + "?definitions=" + withDefinitions);
        String data = this.Request.getUrl(url);

        CharacterActivitiesResponse response = this._mapper.readValue(data, CharacterActivitiesResponse.class);
        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);
        return response.Response.data;
    }

    /**
     * Returns summary information for the inventory for the supplied character.
     */
    public CharacterInventoryGroup getCharacterInventory(String membershipId, String characterId) throws Exception {
        String url = this.formUrl("/" + this._platform + "/Account/" + membershipId + "/Character/" + characterId + "/Inventory/Summary/");
        String data = this.Request.getUrl(url);

        CharacterInventoryResponse response = this._mapper.readValue(data, CharacterInventoryResponse.class);
        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);
        return response.Response.data;
    }
}
