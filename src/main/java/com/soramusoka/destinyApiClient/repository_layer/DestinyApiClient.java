package com.soramusoka.destinyApiClient.repository_layer;

import com.soramusoka.destinyApiClient.dto_layer.ApiClientException;
import com.soramusoka.destinyApiClient.dto_layer.character_stats.CharacterStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.ActivityType;
import com.soramusoka.destinyApiClient.dto_layer.common.MembershipType;
import com.soramusoka.destinyApiClient.dto_layer.common.PeriodType;
import com.soramusoka.destinyApiClient.dto_layer.common.StatGroupType;
import com.soramusoka.destinyApiClient.dto_layer.account_items.AccountItemsResponse;
import com.soramusoka.destinyApiClient.dto_layer.account_stats.AccountStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.account_summary.AccountSummaryResponse;
import com.soramusoka.destinyApiClient.dto_layer.account_triumphs.AccountTriumphsResponse;
import com.soramusoka.destinyApiClient.dto_layer.activity_history_stats.ActivityHistoryStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.aggregate_activity_stats.AggregateActivityStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_activities.CharacterActivitiesResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_inventory.CharacterInventoryResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_progression.CharacterProgressionResponse;
import com.soramusoka.destinyApiClient.dto_layer.inventory_item.InventoryItemResponse;
import com.soramusoka.destinyApiClient.dto_layer.user_info.UserInfoResponse;
import com.soramusoka.destinyApiClient.dto_layer.membership_id_response.MembershipIdResponse;
import com.soramusoka.destinyApiClient.dto_layer.post_game_carnage_report.PostGameCarnageReportResponse;
import com.soramusoka.destinyApiClient.dto_layer.stats_definition.StatsDefinitionResponse;
import com.soramusoka.destinyApiClient.dto_layer.unique_weapons_stats.UniqueWeaponsStatsResponse;
import com.soramusoka.destinyApiClient.service_layer.IRequest;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class DestinyApiClient {
    private MembershipType _membershipType = null;

    public String ApiRoot = "http://www.bungie.net/Platform/Destiny";
    public IRequest Request;
    public ObjectMapper Mapper = null;

    public DestinyApiClient(IRequest request, MembershipType membershipType) {
        this.Mapper = new ObjectMapper();
        this.Request = request;
        this._membershipType = membershipType;
    }

    public DestinyApiClient(IRequest request, ObjectMapper objectMapper, MembershipType membershipType) {
        this.Mapper = objectMapper;
        this.Request = request;
        this._membershipType = membershipType;
    }

    private String formUrl(String url) {
        return this.ApiRoot + url;
    }

    /**
     * Returns a list of Destiny memberships given a full Gamertag or PSN ID.
     *
     * @param displayName
     * @return UserInfoResponse
     * @throws ApiClientException
     */
    public UserInfoResponse getUserInfo(String displayName) throws ApiClientException {
        try {
            String url = this.formUrl("/SearchDestinyPlayer/" + this._membershipType.getValue() + "/" + displayName);
            String data = this.Request.getUrl(url);

            UserInfoResponse response = this.Mapper.readValue(data, UserInfoResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Returns the numerical id of a player based on their display name, zero if not found.
     *
     * @param displayName
     * @param ignorecase
     * @return MembershipIdResponse
     * @throws ApiClientException
     */
    public MembershipIdResponse getMembershipId(String displayName, boolean ignorecase) throws ApiClientException {
        try {
            String query = "?ignorecase=" + ignorecase;
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Stats/GetMembershipIdByDisplayName/" + displayName + query);
            String data = this.Request.getUrl(url);

            MembershipIdResponse response = this.Mapper.readValue(data, MembershipIdResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Returns the numerical id of a player based on their display name, zero if not found.
     *
     * @param displayName
     * @return MembershipIdResponse
     * @throws ApiClientException
     */
    public MembershipIdResponse getMembershipIdByDisplayName(String displayName) throws ApiClientException {
        return this.getMembershipId(displayName, false);
    }

    /**
     * Returns Destiny account information for the supplied membership in a compact summary form.
     *
     * @param membershipId
     * @param withDefinitions
     * @return AccountSummaryResponse
     * @throws ApiClientException
     */
    public AccountSummaryResponse getAccountSummary(String membershipId, boolean withDefinitions) throws ApiClientException {
        try {
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Summary" + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            AccountSummaryResponse response = this.Mapper.readValue(data, AccountSummaryResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Returns Destiny account information for the supplied membership in a compact summary form.
     *
     * @param membershipId
     * @return AccountSummaryResponse
     * @throws ApiClientException
     */
    public AccountSummaryResponse getAccountSummary(String membershipId) throws ApiClientException {
        return this.getAccountSummary(membershipId, false);
    }

    /**
     * Gets historical stats definitions.
     *
     * @return StatsDefinitionResponse
     * @throws ApiClientException
     */
    public StatsDefinitionResponse getStatsDefinition() throws ApiClientException {
        try {
            String url = this.formUrl("/Stats/Definition/");
            String data = this.Request.getUrl(url);

            StatsDefinitionResponse response = this.Mapper.readValue(data, StatsDefinitionResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Provides the progression details for the supplied character.
     *
     * @param membershipId
     * @param characterId
     * @param withDefinitions
     * @return CharacterProgressionResponse
     * @throws ApiClientException
     */
    public CharacterProgressionResponse getCharacterProgression(String membershipId, String characterId, boolean withDefinitions) throws ApiClientException {
        try {
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Character/" + characterId + "/Progression" + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            CharacterProgressionResponse response = this.Mapper.readValue(data, CharacterProgressionResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Provides the progression details for the supplied character.
     *
     * @param membershipId
     * @param characterId
     * @return CharacterProgressionResponse
     * @throws ApiClientException
     */
    public CharacterProgressionResponse getCharacterProgression(String membershipId, String characterId) throws ApiClientException {
        return this.getCharacterProgression(membershipId, characterId, false);
    }

    /**
     * Retrieve the inventory for the supplied character.
     *
     * @param membershipId
     * @param characterId
     * @param withDefinitions
     * @return CharacterActivitiesResponse
     * @throws ApiClientException
     */
    public CharacterActivitiesResponse getCharacterActivities(String membershipId, String characterId, boolean withDefinitions) throws ApiClientException {
        try {
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Character/" + characterId + "/Activities" + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            CharacterActivitiesResponse response = this.Mapper.readValue(data, CharacterActivitiesResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Retrieve the inventory for the supplied character.
     *
     * @param membershipId
     * @param characterId
     * @return CharacterActivitiesResponse
     * @throws ApiClientException
     */
    public CharacterActivitiesResponse getCharacterActivities(String membershipId, String characterId) throws ApiClientException {
        return this.getCharacterActivities(membershipId, characterId, false);
    }

    /**
     * Returns summary information for the inventory for the supplied character.
     *
     * @param membershipId
     * @param characterId
     * @param withDefinitions
     * @return CharacterInventoryResponse
     * @throws ApiClientException
     */
    public CharacterInventoryResponse getCharacterInventorySummary(String membershipId, String characterId, boolean withDefinitions) throws ApiClientException {
        try {
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Character/" + characterId + "/Inventory/Summary" + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            CharacterInventoryResponse response = this.Mapper.readValue(data, CharacterInventoryResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Returns summary information for the inventory for the supplied character.
     *
     * @param membershipId
     * @param characterId
     * @return CharacterInventoryResponse
     * @throws ApiClientException
     */
    public CharacterInventoryResponse getCharacterInventorySummary(String membershipId, String characterId) throws ApiClientException {
        return this.getCharacterInventorySummary(membershipId, characterId, false);
    }

    /**
     * Gets activity history stats for indicated character.
     *
     * @param membershipId
     * @param characterId
     * @param count
     * @param page
     * @param mode
     * @param withDefinitions
     * @return ActivityHistoryStatsResponse
     * @throws ApiClientException
     */
    public ActivityHistoryStatsResponse getActivityHistoryStats(String membershipId, String characterId, int count, int page, ActivityType mode, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions +
                    "&page=" + page +
                    "&count=" + count +
                    "&mode=" + (mode == null ? ActivityType.None.getValue() : mode.getValue());

            String url = this.formUrl("/Stats/ActivityHistory/" + this._membershipType.getValue() + "/" + membershipId + "/" + characterId + "/?" + query);
            String data = this.Request.getUrl(url);

            ActivityHistoryStatsResponse response = this.Mapper.readValue(data, ActivityHistoryStatsResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Gets activity history stats for indicated character.
     *
     * @param membershipId
     * @param characterId
     * @param count
     * @param page
     * @param mode
     * @return ActivityHistoryStatsResponse
     * @throws ApiClientException
     */
    public ActivityHistoryStatsResponse getActivityHistoryStats(String membershipId, String characterId, int count, int page, ActivityType mode) throws ApiClientException {
        return this.getActivityHistoryStats(membershipId, characterId, count, page, mode, false);
    }

    /**
     * Gets activity history stats for indicated character.
     *
     * @param membershipId
     * @param characterId
     * @param count
     * @param page
     * @return ActivityHistoryStatsResponse
     * @throws ApiClientException
     */
    public ActivityHistoryStatsResponse getActivityHistoryStats(String membershipId, String characterId, int count, int page) throws ApiClientException {
        return this.getActivityHistoryStats(membershipId, characterId, count, page, ActivityType.None, false);
    }

    /**
     * Gets all activities the character has participated in together with aggregate statistics for those activities.
     *
     * @param membershipId
     * @param characterId
     * @param withDefinitions
     * @return AggregateActivityStatsResponse
     * @throws ApiClientException
     */
    public AggregateActivityStatsResponse getAggregateActivityStats(String membershipId, String characterId, boolean withDefinitions) throws ApiClientException {
        try {
            String url = this.formUrl("/Stats/AggregateActivityStats/" + this._membershipType.getValue() + "/" + membershipId + "/" + characterId + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            AggregateActivityStatsResponse response = this.Mapper.readValue(data, AggregateActivityStatsResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Gets all activities the character has participated in together with aggregate statistics for those activities.
     *
     * @param membershipId
     * @param characterId
     * @return AggregateActivityStatsResponse
     * @throws ApiClientException
     */
    public AggregateActivityStatsResponse getAggregateActivityStats(String membershipId, String characterId) throws ApiClientException {
        return this.getAggregateActivityStats(membershipId, characterId, false);
    }

    /**
     * Returns information about all items on the for the supplied Destiny Membership ID, and a minimal set of character information so that it can be used.
     *
     * @param membershipId
     * @param withDefinitions
     * @return AccountItemsResponse
     * @throws ApiClientException
     */
    public AccountItemsResponse getAccountItems(String membershipId, boolean withDefinitions) throws ApiClientException {
        try {
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Items" + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            AccountItemsResponse response = this.Mapper.readValue(data, AccountItemsResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Returns information about all items on the for the supplied Destiny Membership ID, and a minimal set of character information so that it can be used.
     *
     * @param membershipId
     * @return AccountItemsResponse
     * @throws ApiClientException
     */
    public AccountItemsResponse getAccountItems(String membershipId) throws ApiClientException {
        return this.getAccountItems(membershipId, false);
    }

    /**
     * Gets aggregate historical stats organized around each character for a given account.
     *
     * @param membershipId
     * @param groups
     * @return AccountStatsResponse
     * @throws ApiClientException
     */
    public AccountStatsResponse getAccountStats(String membershipId, StatGroupType groups) throws ApiClientException {
        try {
            String query = "?groups=" + groups.getValue();
            String url = this.formUrl("/Stats/Account/" + this._membershipType.getValue() + "/" + membershipId + query);
            String data = this.Request.getUrl(url);

            AccountStatsResponse response = this.Mapper.readValue(data, AccountStatsResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Gets details about unique weapon usage, including all exotic weapons.
     *
     * @param membershipId
     * @param characterId
     * @param withDefinitions
     * @return UniqueWeaponsStatsResponse
     * @throws ApiClientException
     */
    public UniqueWeaponsStatsResponse getUniqueWeaponsStats(String membershipId, String characterId, boolean withDefinitions) throws ApiClientException {
        try {
            String url = this.formUrl("/Stats/UniqueWeapons/" + this._membershipType.getValue() + "/" + membershipId + "/" + characterId + "?definitions=" + withDefinitions);
            String data = this.Request.getUrl(url);

            UniqueWeaponsStatsResponse response = this.Mapper.readValue(data, UniqueWeaponsStatsResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Gets details about unique weapon usage, including all exotic weapons.
     *
     * @param membershipId
     * @param characterId
     * @return UniqueWeaponsStatsResponse
     * @throws ApiClientException
     */
    public UniqueWeaponsStatsResponse getUniqueWeaponsStats(String membershipId, String characterId) throws ApiClientException {
        return this.getUniqueWeaponsStats(membershipId, characterId, false);
    }

    /**
     * Provides Triumphs for a given Destiny account.
     *
     * @param membershipId
     * @param withDefinitions
     * @return AccountTriumphsResponse
     * @throws ApiClientException
     */
    public AccountTriumphsResponse getAccountTriumphs(String membershipId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "?definitions=" + withDefinitions;
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Triumphs" + query);
            String data = this.Request.getUrl(url);

            AccountTriumphsResponse response = this.Mapper.readValue(data, AccountTriumphsResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Provides Triumphs for a given Destiny account.
     *
     * @param membershipId
     * @return AccountTriumphsResponse
     * @throws ApiClientException
     */
    public AccountTriumphsResponse getAccountTriumphs(String membershipId) throws ApiClientException {
        return this.getAccountTriumphs(membershipId, false);
    }

    /**
     * Gets the available post game carnage report for the activity ID.
     *
     * @param activityHashId
     * @param withDefinitions
     * @return PostGameCarnageReportResponse
     * @throws ApiClientException
     */
    public PostGameCarnageReportResponse getPostGameCarnageReport(long activityHashId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "?definitions=" + withDefinitions;
            String url = this.formUrl("/Stats/PostGameCarnageReport/" + Long.toString(activityHashId) + query);
            String data = this.Request.getUrl(url);

            PostGameCarnageReportResponse response = this.Mapper.readValue(data, PostGameCarnageReportResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Gets the available post game carnage report for the activity ID.
     *
     * @param activityHashId
     * @return PostGameCarnageReportResponse
     * @throws ApiClientException
     */
    public PostGameCarnageReportResponse getPostGameCarnageReport(long activityHashId) throws ApiClientException {
        return this.getPostGameCarnageReport(activityHashId, false);
    }

    /**
     * Retrieve the details of a Destiny Item.
     *
     * @param membershipId
     * @param characterId
     * @param itemInstanceId
     * @param withDefinitions
     * @return InventoryItemResponse
     * @throws ApiClientException
     */
    public InventoryItemResponse getInventoryItem(String membershipId, String characterId, String itemInstanceId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "?definitions=" + withDefinitions;
            String url = this.formUrl("/" + this._membershipType.getValue() + "/Account/" + membershipId + "/Character/" + characterId + "/Inventory/" + itemInstanceId + query);
            String data = this.Request.getUrl(url);

            InventoryItemResponse response = this.Mapper.readValue(data, InventoryItemResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Retrieve the details of a Destiny Item.
     *
     * @param membershipId
     * @param characterId
     * @param itemInstanceId
     * @return InventoryItemResponse
     * @throws ApiClientException
     */
    public InventoryItemResponse getInventoryItem(String membershipId, String characterId, String itemInstanceId) throws ApiClientException {
        return this.getInventoryItem(membershipId, characterId, itemInstanceId, false);
    }


    /**
     * Gets historical stats for indicated character.
     *
     * @param membershipId
     * @param characterId
     * @param modes
     * @param groups
     * @param period
     * @param monthstart
     * @param monthend
     * @param daystart
     * @param dayend
     * @return CharacterStatsResponse
     * @throws ApiClientException
     */
    public CharacterStatsResponse getCharacterStats(String membershipId, String characterId,
                                                    ActivityType modes, StatGroupType groups, PeriodType period,
                                                    String monthstart, String monthend,
                                                    String daystart, String dayend) throws ApiClientException {
        try {
            String query = "?groups=" + groups.getValue() +
                    "&modes=" + modes.getValue() +
                    "&period=" + period.getValue() +
                    "$monthstart=" + monthstart +
                    "$monthend=" + monthend +
                    "$daystart=" + daystart +
                    "$dayend=" + dayend;

            String url = this.formUrl("/Stats/" + this._membershipType.getValue() + "/" + membershipId + "/" + characterId + query);
            String data = this.Request.getUrl(url);

            CharacterStatsResponse response = this.Mapper.readValue(data, CharacterStatsResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }
}