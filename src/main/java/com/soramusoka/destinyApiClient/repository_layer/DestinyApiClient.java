package com.soramusoka.destinyApiClient.repository_layer;

import com.soramusoka.destinyApiClient.dto_layer.account_summary.AccountSummary;
import com.soramusoka.destinyApiClient.dto_layer.account_summary.AccountSummaryResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_activities.CharacterActivities;
import com.soramusoka.destinyApiClient.dto_layer.character_activities.CharacterActivitiesResponse;
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

    public MembershipId[] getMembershipId(String userName) throws Exception {
        String url = this.formUrl("/SearchDestinyPlayer/" + this._platform + "/" + userName);
        String data = this.Request.getUrl(url);

        MembershipIdResponse response = this._mapper.readValue(data, MembershipIdResponse.class);
        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);
        return response.Response;
    }

    public AccountSummary getAccountSummary(String membershipId) throws Exception {
        String url = this.formUrl("/" + this._platform + "/Account/" + membershipId);
        String data = this.Request.getUrl(url);

        AccountSummaryResponse response = this._mapper.readValue(data, AccountSummaryResponse.class);
        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);
        return response.Response.data;
    }

    public StatsDefinitionGroup getStatsDefinition() throws Exception {
        String url = this.formUrl("/Stats/Definition/");
        String data = this.Request.getUrl(url);

        StatsDefinitionResponse response = this._mapper.readValue(data, StatsDefinitionResponse.class);
        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);
        return response.Response;
    }

    public CharacterProgression getCharacterProgression(String membershipId, String characterId) throws Exception {
        String url = this.formUrl("/" + this._platform + "/Account/" + membershipId + "/Character/" + characterId + "/Progression/");
        String data = this.Request.getUrl(url);

        CharacterProgressionResponse response = this._mapper.readValue(data, CharacterProgressionResponse.class);
        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);
        return response.Response.data;
    }

    public CharacterActivities getCharacterActivities(String membershipId, String characterId) throws Exception {
        String url = this.formUrl("/" + this._platform + "/Account/" + membershipId + "/Character/" + characterId + "/Activities/");
        String data = this.Request.getUrl(url);

        CharacterActivitiesResponse response = this._mapper.readValue(data, CharacterActivitiesResponse.class);
        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);
        return response.Response.data;
    }
}
