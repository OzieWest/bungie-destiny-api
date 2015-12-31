package com.soramusoka.destinyApiClient.repository_layer;

import com.soramusoka.destinyApiClient.dto_layer.MembershipType;
import com.soramusoka.destinyApiClient.dto_layer.account_items.AccountItemsResponse;
import com.soramusoka.destinyApiClient.dto_layer.account_summary.AccountSummaryResponse;
import com.soramusoka.destinyApiClient.dto_layer.activity_history_stats.ActivityHistoryStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.aggregate_activity_stats.AggregateActivityStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_activities.CharacterActivitiesResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_inventory.CharacterInventoryResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_progression.CharacterProgressionResponse;
import com.soramusoka.destinyApiClient.dto_layer.custom_errors.DestinyApiClientException;
import com.soramusoka.destinyApiClient.dto_layer.membership_id.MembershipIdResponse;
import com.soramusoka.destinyApiClient.dto_layer.stats_definition.StatsDefinitionResponse;
import com.soramusoka.destinyApiClient.service_layer.IRequest;
import org.codehaus.jackson.map.ObjectMapper;

public class DestinyApiClient {
    public IRequest Request;
    private String _hostName = "http://www.bungie.net";
    private String _rootPath = "/Platform/Destiny";
    private MembershipType _membershipType = MembershipType.XBOX;
    private ObjectMapper _mapper = null;

    public DestinyApiClient(IRequest request, MembershipType membershipType) {
        this._mapper = new ObjectMapper();
        this.Request = request;
        this._membershipType = membershipType;
    }

    private String formUrl(String url) {
        return this._hostName + this._rootPath + url;
    }

    /**
     * Returns a list of Destiny memberships given a full Gamertag or PSN ID.
     * @param userName
     * @return MembershipIdResponse
     * @throws DestinyApiClientException
     */
    public MembershipIdResponse getMembershipId(String userName) throws DestinyApiClientException {
        try {
            String url = this.formUrl("/SearchDestinyPlayer/" + this._membershipType.getValue() + "/" + userName);
            String data = this.Request.getUrl(url);

            MembershipIdResponse response = this._mapper.readValue(data, MembershipIdResponse.class);
            if (response.ErrorCode != 1) throw new DestinyApiClientException(response.ErrorStatus + ". " + response.Message);
            return response;
        } catch (Exception e) {
            throw new DestinyApiClientException(e);
        }
    }

    /**
     * Returns Destiny account information for the supplied membership in a compact summary form.
     * @param membershipId
     * @param withDefinitions
     * @return AccountSummaryResponse
     * @throws DestinyApiClientException
     */
    public AccountSummaryResponse getAccountSummary(String membershipId, boolean withDefinitions) throws DestinyApiClientException {
        try {
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Summary" + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            AccountSummaryResponse response = this._mapper.readValue(data, AccountSummaryResponse.class);
            if (response.ErrorCode != 1) throw new DestinyApiClientException(response.ErrorStatus + ". " + response.Message);
            return response;
        } catch (Exception e) {
            throw new DestinyApiClientException(e);
        }
    }

    /**
     * Returns Destiny account information for the supplied membership in a compact summary form.
     * @param membershipId
     * @return AccountSummaryResponse
     * @throws DestinyApiClientException
     */
    public AccountSummaryResponse getAccountSummary(String membershipId) throws DestinyApiClientException {
        return this.getAccountSummary(membershipId, false);
    }

    /**
     * Gets historical stats definitions.
     * @return StatsDefinitionResponse
     * @throws DestinyApiClientException
     */
    public StatsDefinitionResponse getStatsDefinition() throws DestinyApiClientException {
        try {
            String url = this.formUrl("/Stats/Definition/");
            String data = this.Request.getUrl(url);

            StatsDefinitionResponse response = this._mapper.readValue(data, StatsDefinitionResponse.class);
            if (response.ErrorCode != 1) throw new DestinyApiClientException(response.ErrorStatus + ". " + response.Message);
            return response;
        } catch (Exception e) {
            throw new DestinyApiClientException(e);
        }
    }

    /**
     * Provides the progression details for the supplied character.
     * @param membershipId
     * @param characterId
     * @param withDefinitions
     * @return CharacterProgressionResponse
     * @throws DestinyApiClientException
     */
    public CharacterProgressionResponse getCharacterProgression(String membershipId, String characterId, boolean withDefinitions) throws DestinyApiClientException {
        try {
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Character/" + characterId + "/Progression" + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            CharacterProgressionResponse response = this._mapper.readValue(data, CharacterProgressionResponse.class);
            if (response.ErrorCode != 1) throw new DestinyApiClientException(response.ErrorStatus + ". " + response.Message);
            return response;
        } catch (Exception e) {
            throw new DestinyApiClientException(e);
        }
    }

    /**
     * Provides the progression details for the supplied character.
     * @param membershipId
     * @param characterId
     * @return CharacterProgressionResponse
     * @throws DestinyApiClientException
     */
    public CharacterProgressionResponse getCharacterProgression(String membershipId, String characterId) throws DestinyApiClientException {
        return this.getCharacterProgression(membershipId, characterId, false);
    }

    /**
     * Retrieve the inventory for the supplied character.
     * @param membershipId
     * @param characterId
     * @param withDefinitions
     * @return CharacterActivitiesResponse
     * @throws DestinyApiClientException
     */
    public CharacterActivitiesResponse getCharacterActivities(String membershipId, String characterId, boolean withDefinitions) throws DestinyApiClientException {
        try {
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Character/" + characterId + "/Activities" + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            CharacterActivitiesResponse response = this._mapper.readValue(data, CharacterActivitiesResponse.class);
            if (response.ErrorCode != 1) throw new DestinyApiClientException(response.ErrorStatus + ". " + response.Message);
            return response;
        } catch (Exception e) {
            throw new DestinyApiClientException(e);
        }
    }

    /**
     * Retrieve the inventory for the supplied character.
     * @param membershipId
     * @param characterId
     * @return CharacterActivitiesResponse
     * @throws DestinyApiClientException
     */
    public CharacterActivitiesResponse getCharacterActivities(String membershipId, String characterId) throws DestinyApiClientException {
        return this.getCharacterActivities(membershipId, characterId, false);
    }

    /**
     * Returns summary information for the inventory for the supplied character.
     * @param membershipId
     * @param characterId
     * @param withDefinitions
     * @return CharacterInventoryResponse
     * @throws DestinyApiClientException
     */
    public CharacterInventoryResponse getCharacterInventorySummary(String membershipId, String characterId, boolean withDefinitions) throws DestinyApiClientException {
        try {
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Character/" + characterId + "/Inventory/Summary" + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            CharacterInventoryResponse response = this._mapper.readValue(data, CharacterInventoryResponse.class);
            if (response.ErrorCode != 1) throw new DestinyApiClientException(response.ErrorStatus + ". " + response.Message);
            return response;
        } catch (Exception e) {
            throw new DestinyApiClientException(e);
        }
    }

    /**
     * Returns summary information for the inventory for the supplied character.
     * @param membershipId
     * @param characterId
     * @return CharacterInventoryResponse
     * @throws DestinyApiClientException
     */
    public CharacterInventoryResponse getCharacterInventorySummary(String membershipId, String characterId) throws DestinyApiClientException {
        return this.getCharacterInventorySummary(membershipId, characterId, false);
    }

    /**
     * Gets activity history stats for indicated character.
     * @param membershipId
     * @param characterId
     * @param count
     * @param page
     * @param mode
     * @param withDefinitions
     * @return ActivityHistoryStatsResponse
     * @throws DestinyApiClientException
     */
    public ActivityHistoryStatsResponse getActivityHistoryStats(String membershipId, String characterId, int count, int page, String mode, boolean withDefinitions) throws DestinyApiClientException {
        try {
            String query = "definitions=" + withDefinitions +
                    "&page=" + page +
                    "&count=" + count +
                    "&mode=" + (mode == null ? "None" : mode);

            String url = this.formUrl("/Stats/ActivityHistory/" + this._membershipType.getValue() + "/" + membershipId + "/" + characterId + "/?" + query);
            String data = this.Request.getUrl(url);

            ActivityHistoryStatsResponse response = this._mapper.readValue(data, ActivityHistoryStatsResponse.class);
            if (response.ErrorCode != 1) throw new DestinyApiClientException(response.ErrorStatus + ". " + response.Message);
            return response;
        } catch (Exception e) {
            throw new DestinyApiClientException(e);
        }
    }

    /**
     * Gets activity history stats for indicated character.
     * @param membershipId
     * @param characterId
     * @param count
     * @param page
     * @param mode
     * @return ActivityHistoryStatsResponse
     * @throws DestinyApiClientException
     */
    public ActivityHistoryStatsResponse getActivityHistoryStats(String membershipId, String characterId, int count, int page, String mode) throws DestinyApiClientException {
        return this.getActivityHistoryStats(membershipId, characterId, count, page, mode, false);
    }

    /**
     * Gets activity history stats for indicated character.
     * @param membershipId
     * @param characterId
     * @param count
     * @param page
     * @return ActivityHistoryStatsResponse
     * @throws DestinyApiClientException
     */
    public ActivityHistoryStatsResponse getActivityHistoryStats(String membershipId, String characterId, int count, int page) throws DestinyApiClientException {
        return this.getActivityHistoryStats(membershipId, characterId, count, page, "None", false);
    }

    /**
     * Gets all activities the character has participated in together with aggregate statistics for those activities.
     * @param membershipId
     * @param characterId
     * @param withDefinitions
     * @return AggregateActivityStatsResponse
     * @throws DestinyApiClientException
     */
    public AggregateActivityStatsResponse getAggregateActivityStats(String membershipId, String characterId, boolean withDefinitions) throws DestinyApiClientException {
        try {
            String url = this.formUrl("/Stats/AggregateActivityStats/" + this._membershipType.getValue() + "/" + membershipId + "/" + characterId + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            AggregateActivityStatsResponse response = this._mapper.readValue(data, AggregateActivityStatsResponse.class);
            if (response.ErrorCode != 1) throw new DestinyApiClientException(response.ErrorStatus + ". " + response.Message);
            return response;
        } catch (Exception e) {
            throw new DestinyApiClientException(e);
        }
    }

    /**
     * Gets all activities the character has participated in together with aggregate statistics for those activities.
     * @param membershipId
     * @param characterId
     * @return AggregateActivityStatsResponse
     * @throws DestinyApiClientException
     */
    public AggregateActivityStatsResponse getAggregateActivityStats(String membershipId, String characterId) throws DestinyApiClientException {
        return this.getAggregateActivityStats(membershipId, characterId, false);
    }

    /**
     * Returns information about all items on the for the supplied Destiny Membership ID, and a minimal set of character information so that it can be used.
     * @param membershipId
     * @param withDefinitions
     * @return AccountItemsResponse
     * @throws DestinyApiClientException
     */
    public AccountItemsResponse getAccountItems(String membershipId, boolean withDefinitions) throws DestinyApiClientException {
        try {
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Items" + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            AccountItemsResponse response = this._mapper.readValue(data, AccountItemsResponse.class);
            if (response.ErrorCode != 1) throw new DestinyApiClientException(response.ErrorStatus + ". " + response.Message);
            return response;
        } catch (Exception e) {
            throw new DestinyApiClientException(e);
        }
    }

    /**
     * Returns information about all items on the for the supplied Destiny Membership ID, and a minimal set of character information so that it can be used.
     * @param membershipId
     * @return AccountItemsResponse
     * @throws DestinyApiClientException
     */
    public AccountItemsResponse getAccountItems(String membershipId) throws DestinyApiClientException {
        return this.getAccountItems(membershipId, false);
    }
}
