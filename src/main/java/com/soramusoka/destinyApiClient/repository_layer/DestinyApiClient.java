package com.soramusoka.destinyApiClient.repository_layer;

import com.soramusoka.destinyApiClient.dto_layer.ApiClientException;
import com.soramusoka.destinyApiClient.dto_layer.account_grimoire.AccountGrimoireResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_stats.CharacterStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.*;
import com.soramusoka.destinyApiClient.dto_layer.account_items.AccountItemsResponse;
import com.soramusoka.destinyApiClient.dto_layer.account_stats.AccountStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.account_summary.AccountSummaryResponse;
import com.soramusoka.destinyApiClient.dto_layer.account_triumphs.AccountTriumphsResponse;
import com.soramusoka.destinyApiClient.dto_layer.activity_history_stats.ActivityHistoryStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.aggregate_activity_stats.AggregateActivityStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_activities.CharacterActivitiesResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_inventory.CharacterInventoryResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_progression.CharacterProgressionResponse;
import com.soramusoka.destinyApiClient.dto_layer.grimoire_definitions.GrimoireDefinitionsResponse;
import com.soramusoka.destinyApiClient.dto_layer.inventory_item.InventoryItemResponse;
import com.soramusoka.destinyApiClient.dto_layer.talent_node_steps.TalentNodeStepsResponse;
import com.soramusoka.destinyApiClient.dto_layer.user_info.UserInfoResponse;
import com.soramusoka.destinyApiClient.dto_layer.membership_id_response.MembershipIdResponse;
import com.soramusoka.destinyApiClient.dto_layer.post_game_carnage_report.PostGameCarnageReportResponse;
import com.soramusoka.destinyApiClient.dto_layer.stats_definition.StatsDefinitionResponse;
import com.soramusoka.destinyApiClient.dto_layer.unique_weapons_stats.UniqueWeaponsStatsResponse;
import com.soramusoka.destinyApiClient.service_layer.IRequest;
import org.codehaus.jackson.map.ObjectMapper;

import java.text.MessageFormat;

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

    private String formUrl(String pattern, Object... arr) {
        return this.ApiRoot + MessageFormat.format(pattern, arr);
    }

    /**
     * Returns a list of Destiny memberships given a full Gamertag or PSN ID.
     *
     * @param displayName The full gamertag or PSN id of the player. Spaces and case are ignored.
     * @return UserInfoResponse
     * @throws ApiClientException
     */
    public UserInfoResponse getUserInfo(String displayName) throws ApiClientException {
        try {
            String url = this.formUrl("/SearchDestinyPlayer/{0}/{1}", this._membershipType.getValue(), displayName);
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
     * @param displayName The full gamertag or PSN id of the player. Spaces and case are ignored.
     * @param ignorecase  Default is false when not specified. True to cause a caseless search to be used.
     * @return MembershipIdResponse
     * @throws ApiClientException
     */
    public MembershipIdResponse getMembershipId(String displayName, boolean ignorecase) throws ApiClientException {
        try {
            String query = "ignorecase=" + ignorecase;
            String url = this.formUrl("/{0}/Stats/GetMembershipIdByDisplayName/{1}?{2}", this._membershipType.getValue(), displayName, query);
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
     * @param displayName The full gamertag or PSN id of the player. Spaces and case are ignored.
     * @return MembershipIdResponse
     * @throws ApiClientException
     */
    public MembershipIdResponse getMembershipIdByDisplayName(String displayName) throws ApiClientException {
        return this.getMembershipId(displayName, false);
    }

    /**
     * Returns Destiny account information for the supplied membership in a compact summary form.
     *
     * @param membershipId    Destiny membership ID.
     * @param withDefinitions If False, will not return definition information. If False, will not return definition information.
     * @return AccountSummaryResponse
     * @throws ApiClientException
     */
    public AccountSummaryResponse getAccountSummary(String membershipId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions;
            String url = this.formUrl("/{0}/Account/{1}/Summary?{2}", this._membershipType.getValue(), membershipId, query);
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
     * @param membershipId Destiny membership ID.
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
     * @param membershipId    Destiny membership ID.
     * @param characterId     ID of the character.
     * @param withDefinitions If False, will not return definition information.
     * @return CharacterProgressionResponse
     * @throws ApiClientException
     */
    public CharacterProgressionResponse getCharacterProgression(String membershipId, String characterId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions;
            String url = this.formUrl("/{0}/Account/{1}/Character/{2}/Progression?{3}", this._membershipType.getValue(), membershipId, characterId, query);
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
     * @param membershipId Destiny membership ID.
     * @param characterId  ID of the character.
     * @return CharacterProgressionResponse
     * @throws ApiClientException
     */
    public CharacterProgressionResponse getCharacterProgression(String membershipId, String characterId) throws ApiClientException {
        return this.getCharacterProgression(membershipId, characterId, false);
    }

    /**
     * Retrieve the inventory for the supplied character.
     *
     * @param membershipId    Destiny membership ID.
     * @param characterId     ID of the character.
     * @param withDefinitions If False, will not return definition information.
     * @return CharacterActivitiesResponse
     * @throws ApiClientException
     */
    public CharacterActivitiesResponse getCharacterActivities(String membershipId, String characterId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions;
            String url = this.formUrl("/{0}/Account/{1}/Character/{2}/Activities?{3}", this._membershipType.getValue(), membershipId, characterId, query);
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
     * @param membershipId Destiny membership ID.
     * @param characterId  ID of the character.
     * @return CharacterActivitiesResponse
     * @throws ApiClientException
     */
    public CharacterActivitiesResponse getCharacterActivities(String membershipId, String characterId) throws ApiClientException {
        return this.getCharacterActivities(membershipId, characterId, false);
    }

    /**
     * Returns summary information for the inventory for the supplied character.
     *
     * @param membershipId    Destiny membership ID.
     * @param characterId     ID of the character.
     * @param withDefinitions If False, will not return definition information.
     * @return CharacterInventoryResponse
     * @throws ApiClientException
     */
    public CharacterInventoryResponse getCharacterInventorySummary(String membershipId, String characterId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions;
            String url = this.formUrl("/{0}/Account/{1}/Character/{2}/Inventory/Summary?{3}", this._membershipType.getValue(), membershipId, characterId, query);
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
     * @param membershipId Destiny membership ID.
     * @param characterId  ID of the character.
     * @return CharacterInventoryResponse
     * @throws ApiClientException
     */
    public CharacterInventoryResponse getCharacterInventorySummary(String membershipId, String characterId) throws ApiClientException {
        return this.getCharacterInventorySummary(membershipId, characterId, false);
    }

    /**
     * Gets activity history stats for indicated character.
     *
     * @param membershipId    Destiny membership ID.
     * @param characterId     ID of the character.
     * @param count           Number of rows to return
     * @param page            Page number to return, starting with 0.
     * @param mode            A filter for the activity mode to be returned. None returns all activities.
     *                        Values: None, Story, Strike, Raid, AllPvP, Patrol, AllPvE, PvPIntroduction, ThreeVsThree,
     *                        Control, Lockdown, Team, FreeForAll, Nightfall, Heroic, AllStrikes, IronBanner, AllArena,
     *                        Arena, ArenaChallenge, TrialsOfOsiris, Elimination, Rift, Mayhem, ZoneControl, Racing
     * @param withDefinitions If False, will not return definition information.
     * @return ActivityHistoryStatsResponse
     * @throws ApiClientException
     */
    public ActivityHistoryStatsResponse getActivityHistoryStats(String membershipId, String characterId, int count, int page, ActivityType mode, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions +
                    "&page=" + page +
                    "&count=" + count +
                    "&mode=" + (mode == null ? ActivityType.None.getValue() : mode.getValue());

            String url = this.formUrl("/Stats/ActivityHistory/{0}/{1}/{2}/?{3}", this._membershipType.getValue(), membershipId, characterId, query);
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
     * @param membershipId Destiny membership ID.
     * @param characterId  ID of the character.
     * @param count        Number of rows to return
     * @param page         Page number to return, starting with 0.
     * @param mode         A filter for the activity mode to be returned. None returns all activities.
     *                     Values: None, Story, Strike, Raid, AllPvP, Patrol, AllPvE, PvPIntroduction, ThreeVsThree,
     *                     Control, Lockdown, Team, FreeForAll, Nightfall, Heroic, AllStrikes, IronBanner, AllArena,
     *                     Arena, ArenaChallenge, TrialsOfOsiris, Elimination, Rift, Mayhem, ZoneControl, Racing
     * @return ActivityHistoryStatsResponse
     * @throws ApiClientException
     */
    public ActivityHistoryStatsResponse getActivityHistoryStats(String membershipId, String characterId, int count, int page, ActivityType mode) throws ApiClientException {
        return this.getActivityHistoryStats(membershipId, characterId, count, page, mode, false);
    }

    /**
     * Gets activity history stats for indicated character.
     *
     * @param membershipId Destiny membership ID.
     * @param characterId  ID of the character.
     * @param count        Number of rows to return
     * @param page         Page number to return, starting with 0.
     * @return ActivityHistoryStatsResponse
     * @throws ApiClientException
     */
    public ActivityHistoryStatsResponse getActivityHistoryStats(String membershipId, String characterId, int count, int page) throws ApiClientException {
        return this.getActivityHistoryStats(membershipId, characterId, count, page, ActivityType.None, false);
    }

    /**
     * Gets all activities the character has participated in together with aggregate statistics for those activities.
     *
     * @param membershipId    Destiny membership ID.
     * @param characterId     ID of the character.
     * @param withDefinitions If False, will not return definition information.
     * @return AggregateActivityStatsResponse
     * @throws ApiClientException
     */
    public AggregateActivityStatsResponse getAggregateActivityStats(String membershipId, String characterId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions;
            String url = this.formUrl("/Stats/AggregateActivityStats/{0}/{1}/{2}?{3}", this._membershipType.getValue(), membershipId, characterId, query);
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
     * @param membershipId Destiny membership ID.
     * @param characterId  ID of the character.
     * @return AggregateActivityStatsResponse
     * @throws ApiClientException
     */
    public AggregateActivityStatsResponse getAggregateActivityStats(String membershipId, String characterId) throws ApiClientException {
        return this.getAggregateActivityStats(membershipId, characterId, false);
    }

    /**
     * Returns information about all items on the for the supplied Destiny Membership ID,
     * and a minimal set of character information so that it can be used.
     *
     * @param membershipId    Destiny membership ID.
     * @param withDefinitions If False, will not return definition information.
     * @return AccountItemsResponse
     * @throws ApiClientException
     */
    public AccountItemsResponse getAccountItems(String membershipId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions;
            String url = this.formUrl("/{0}/Account/{1}/Items?{2}", this._membershipType.getValue(), membershipId, query);
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
     * Returns information about all items on the for the supplied Destiny Membership ID,
     * and a minimal set of character information so that it can be used.
     *
     * @param membershipId Destiny membership ID.
     * @return AccountItemsResponse
     * @throws ApiClientException
     */
    public AccountItemsResponse getAccountItems(String membershipId) throws ApiClientException {
        return this.getAccountItems(membershipId, false);
    }

    /**
     * Gets aggregate historical stats organized around each character for a given account.
     *
     * @param membershipId Destiny membership ID.
     * @param groups       Groups of stats to include, otherwise only general stats are returned.
     *                     Comma separated list is allowed. Values: General, Weapons, Medals, Enemies.
     * @return AccountStatsResponse
     * @throws ApiClientException
     */
    public AccountStatsResponse getAccountStats(String membershipId, StatGroupType groups) throws ApiClientException {
        try {
            String query = "groups=" + groups.getValue();
            String url = this.formUrl("/Stats/Account/{0}/{1}?{2}", this._membershipType.getValue(), membershipId, query);
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
     * @param membershipId    Destiny membership ID.
     * @param characterId     ID of the character.
     * @param withDefinitions If False, will not return definition information.
     * @return UniqueWeaponsStatsResponse
     * @throws ApiClientException
     */
    public UniqueWeaponsStatsResponse getUniqueWeaponsStats(String membershipId, String characterId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions;
            String url = this.formUrl("/Stats/UniqueWeapons/{0}/{1}/{2}?{3}", this._membershipType.getValue(), membershipId, characterId, query);
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
     * @param membershipId Destiny membership ID.
     * @param characterId  ID of the character.
     * @return UniqueWeaponsStatsResponse
     * @throws ApiClientException
     */
    public UniqueWeaponsStatsResponse getUniqueWeaponsStats(String membershipId, String characterId) throws ApiClientException {
        return this.getUniqueWeaponsStats(membershipId, characterId, false);
    }

    /**
     * Provides Triumphs for a given Destiny account.
     *
     * @param membershipId    Destiny membership ID.
     * @param withDefinitions If False, will not return definition information.
     * @return AccountTriumphsResponse
     * @throws ApiClientException
     */
    public AccountTriumphsResponse getAccountTriumphs(String membershipId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions;
            String url = this.formUrl("/{0}/Account/{1}/Triumphs?{2}", this._membershipType.getValue(), membershipId, query);
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
     * @param membershipId Destiny membership ID.
     * @return AccountTriumphsResponse
     * @throws ApiClientException
     */
    public AccountTriumphsResponse getAccountTriumphs(String membershipId) throws ApiClientException {
        return this.getAccountTriumphs(membershipId, false);
    }

    /**
     * Gets the available post game carnage report for the activity ID.
     *
     * @param activityHashId  The ID of the activity whose PGCR is requested.
     * @param withDefinitions If False, will not return definition information.
     * @return PostGameCarnageReportResponse
     * @throws ApiClientException
     */
    public PostGameCarnageReportResponse getPostGameCarnageReport(long activityHashId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions;
            String url = this.formUrl("/Stats/PostGameCarnageReport/{0}?{1}", Long.toString(activityHashId), query);
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
     * @param activityHashId The ID of the activity whose PGCR is requested.
     * @return PostGameCarnageReportResponse
     * @throws ApiClientException
     */
    public PostGameCarnageReportResponse getPostGameCarnageReport(long activityHashId) throws ApiClientException {
        return this.getPostGameCarnageReport(activityHashId, false);
    }

    /**
     * Retrieve the details of a Destiny Item.
     *
     * @param membershipId    Destiny membership ID.
     * @param characterId     ID of the character.
     * @param itemInstanceId  The Instance ID of the destiny item. Not the Reference ID, pay attention.
     * @param withDefinitions If False, will not return definition information.
     * @return InventoryItemResponse
     * @throws ApiClientException
     */
    public InventoryItemResponse getInventoryItem(String membershipId, String characterId, String itemInstanceId, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions;
            String url = this.formUrl("/{0}/Account/{1}/Character/{2}/Inventory/{3}?{4}", this._membershipType.getValue(), membershipId, characterId, itemInstanceId, query);
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
     * @param membershipId   Destiny membership ID.
     * @param characterId    ID of the character.
     * @param itemInstanceId The Instance ID of the destiny item. Not the Reference ID, pay attention.
     * @return InventoryItemResponse
     * @throws ApiClientException
     */
    public InventoryItemResponse getInventoryItem(String membershipId, String characterId, String itemInstanceId) throws ApiClientException {
        return this.getInventoryItem(membershipId, characterId, itemInstanceId, false);
    }


    /**
     * Gets historical stats for indicated character.
     *
     * @param membershipId Destiny membership ID.
     * @param characterId  ID of the character.
     * @param modes        Game modes to return. Values: None, Story, Strike, Raid, AllPvP, Patrol, AllPvE,
     *                     PvPIntroduction, ThreeVsThree, Control, Lockdown, Team, FreeForAll, Nightfall, Heroic,
     *                     AllStrikes, IronBanner, AllArena, Arena, ArenaChallenge, TrialsOfOsiris, Elimination,
     *                     Rift, Mayhem, ZoneControl, Racing
     * @param groups       Group of stats to include, otherwise only general stats are returned.
     *                     Comma separated list is allowed. Values: General, Weapons, Medals, Enemies
     * @param period       Indicates a specific period type to return. Optional. May be: Daily, Monthly,
     *                     AllTime, or Activity
     * @param monthstart   First month to return when monthly stats are requested. Use the format YYYY-MM.
     * @param monthend     Last month to return when monthly stats are requested. Use the format YYYY-MM.
     * @param daystart     First day to return when daily stats are requested. Use the format YYYY-MM-DD
     * @param dayend       Last day to return when daily stats are requested. Use the format YYYY-MM-DD.
     * @return CharacterStatsResponse
     * @throws ApiClientException
     */
    public CharacterStatsResponse getCharacterStats(String membershipId, String characterId,
                                                    ActivityType modes, StatGroupType groups, PeriodType period,
                                                    String monthstart, String monthend,
                                                    String daystart, String dayend) throws ApiClientException {
        try {
            String query = "groups=" + groups.getValue() +
                    "&modes=" + modes.getValue() +
                    "&period=" + period.getValue() +
                    "&monthstart=" + monthstart +
                    "&monthend=" + monthend +
                    "&daystart=" + daystart +
                    "&dayend=" + dayend;

            String url = this.formUrl("/Stats/{0}/{1}/{2}?{3}", this._membershipType.getValue(), membershipId, characterId, query);
            String data = this.Request.getUrl(url);

            CharacterStatsResponse response = this.Mapper.readValue(data, CharacterStatsResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Gets Grimoire definitions.
     *
     * @return GrimoireDefinitionsResponse
     * @throws ApiClientException
     */
    public GrimoireDefinitionsResponse getGrimoireDefinitions() throws ApiClientException {
        try {
            String url = this.formUrl("/Vanguard/Grimoire/Definition/");
            String data = this.Request.getUrl(url);

            GrimoireDefinitionsResponse response = this.Mapper.readValue(data, GrimoireDefinitionsResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Gets someone else's Grimoire.
     *
     * @param membershipId    Destiny membership ID.
     * @param single          Indicates data for a single card should be returned.
     * @param flavour         Indicates flavour stats should be included with player card data.
     * @param withDefinitions If False, will not return definition information.
     * @return AccountGrimoireResponse
     * @throws ApiClientException
     */
    public AccountGrimoireResponse getGrimoire(String membershipId, boolean single, boolean flavour, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "definitions=" + withDefinitions;
            String url = this.formUrl("/Vanguard/Grimoire/{0}/{1}?{2}", this._membershipType.getValue(), membershipId, query);
            String data = this.Request.getUrl(url);

            AccountGrimoireResponse response = this.Mapper.readValue(data, AccountGrimoireResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Gets someone else's Grimoire.
     *
     * @param membershipId Destiny membership ID.
     * @param single       Indicates data for a single card should be returned.
     * @param flavour      Indicates flavour stats should be included with player card data.
     * @return AccountGrimoireResponse
     * @throws ApiClientException
     */
    public AccountGrimoireResponse getGrimoire(String membershipId, boolean single, boolean flavour) throws ApiClientException {
        return this.getGrimoire(membershipId, single, flavour, false);
    }

    /**
     * Gets a page list of Destiny talent node steps, ordered by the step name.
     *
     * @param count              Number of rows to return. Use 10, 25, 50, 100, 500
     * @param page               Page number to return, starting with 0.
     * @param name               Name of items to return (partial match, no case). Omit for all items.
     * @param weaponPerformance  Node steps in one of these categories, omit for all steps. RateOfFire, Damage, Accuracy,
     *                           Range, Zoom, Recoil, Ready, Reload, HairTrigger, AmmoAndMagazine, TrackingAndDetonation,
     *                           ShotgunSpread, ChargeTime
     * @param lightAbilities     Node steps in one of these categories, omit for all steps. Grenades, Melee,
     *                           MovementModes, Orbs, SuperEnergy, SuperMods
     * @param direction          Order to sort steps (by name): Ascending or Descending
     * @param impactEffects      Node steps in one of these categories, omit for all steps. ArmorPiercing, Ricochet,
     *                           Flinch, CollateralDamage, Disorient, HighlightTarget
     * @param guardianAttributes Node steps in one of these categories, omit for all steps. Stats, Shields, Health,
     *                           Revive, AimUnderFire, Radar, Invisibility, Reputations
     * @param damageTypes        Node steps in one of these categories, omit for all steps. Kinetic, Arc, Solar, Void
     * @param withDefinitions    If False, will not return definition information.
     * @return TalentNodeStepsResponse
     * @throws ApiClientException
     */
    public TalentNodeStepsResponse getTalentNodeSteps(int count, int page, String name, WeaponPerformanceType weaponPerformance,
                                                      LightAbilityType lightAbilities, DirectionType direction,
                                                      ImpactEffectType impactEffects, AttributeType guardianAttributes,
                                                      DamageType damageTypes, boolean withDefinitions) throws ApiClientException {
        try {
            String query = "count=" + count + "&page=" + page + "&name=" + name + "&definitions=" + withDefinitions;

            if (direction != null) query += "&direction=" + direction.getValue();
            if (damageTypes != null) query += "&damageTypes=" + damageTypes.getValue();
            if (impactEffects != null) query += "&impactEffects=" + impactEffects.getValue();
            if (guardianAttributes != null) query += "&guardianAttributes=" + guardianAttributes.getValue();
            if (lightAbilities != null) query += "&lightAbilities=" + lightAbilities.getValue();
            if (weaponPerformance != null) query += "&weaponPerformance=" + weaponPerformance.getValue();

            String url = this.formUrl("/Explorer/TalentNodeSteps?{0}", query);
            String data = this.Request.getUrl(url);

            TalentNodeStepsResponse response = this.Mapper.readValue(data, TalentNodeStepsResponse.class);
            if (response.ErrorCode != 1)
                throw new ApiClientException(response.Message, response.ErrorStatus, response.ErrorCode);
            return response;
        } catch (Exception e) {
            throw new ApiClientException(e);
        }
    }

    /**
     * Gets a page list of Destiny talent node steps, ordered by the step name.
     *
     * @param count           Number of rows to return. Use 10, 25, 50, 100, 500
     * @param page            Page number to return, starting with 0.
     * @param name            Name of items to return (partial match, no case). Omit for all items.
     * @param withDefinitions If False, will not return definition information.
     * @return TalentNodeStepsResponse
     * @throws ApiClientException
     */
    public TalentNodeStepsResponse getTalentNodeSteps(int count, int page, String name, boolean withDefinitions) throws ApiClientException {
        return this.getTalentNodeSteps(count, page, name, null, null, null, null, null, null, withDefinitions);
    }
}