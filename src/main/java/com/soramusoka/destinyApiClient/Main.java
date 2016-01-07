package com.soramusoka.destinyApiClient;

import com.soramusoka.destinyApiClient.dto_layer.account_items.AccountItemsResponse;
import com.soramusoka.destinyApiClient.dto_layer.account_summary.*;
import com.soramusoka.destinyApiClient.dto_layer.account_summary.Character;
import com.soramusoka.destinyApiClient.dto_layer.account_triumphs.AccountTriumphsResponse;
import com.soramusoka.destinyApiClient.dto_layer.activity_history_stats.ActivityHistoryStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.aggregate_activity_stats.AggregateActivityStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_activities.CharacterActivitiesResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_activities.CharacterActivity;
import com.soramusoka.destinyApiClient.dto_layer.character_inventory.CharacterInventoryResponse;
import com.soramusoka.destinyApiClient.dto_layer.character_progression.CharacterProgressionResponse;
import com.soramusoka.destinyApiClient.dto_layer.common.ActivityType;
import com.soramusoka.destinyApiClient.dto_layer.common.InventoryItem;
import com.soramusoka.destinyApiClient.dto_layer.common.MembershipType;
import com.soramusoka.destinyApiClient.dto_layer.common.StatGroupType;
import com.soramusoka.destinyApiClient.dto_layer.unique_weapons_stats.UniqueWeaponsStatsResponse;
import com.soramusoka.destinyApiClient.dto_layer.user_info.UserInfo;
import com.soramusoka.destinyApiClient.dto_layer.user_info.UserInfoResponse;
import com.soramusoka.destinyApiClient.repository_layer.DestinyApiClient;
import com.soramusoka.destinyApiClient.service_layer.Request;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        CommandLine cmd = getConfig(args);
        // Logger logger = getLogger("main");

        String apiKey = cmd.getOptionValue("apikey");
        String userName = cmd.getOptionValue("username");

        // TESTS
        MembershipType type = MembershipType.PLAYSTATION;
        Request request = new Request(apiKey);
        DestinyApiClient destinyApiClient = new DestinyApiClient(request, type);

        System.out.println("Start");

        UserInfoResponse userInfoResponse = destinyApiClient.getUserInfoByDisplayName("soramusoka");
        for (UserInfo userInfo : userInfoResponse.Response) {
            String membershipId = userInfo.membershipId;

            Thread.sleep(100); 
            AccountItemsResponse accountItemsResponse
                    = destinyApiClient.getAccountItems(membershipId, true);

            Thread.sleep(100); 
            ArrayList<StatGroupType> types = new ArrayList<>();
            types.add(StatGroupType.Medals);
            types.add(StatGroupType.Enemies);
            types.add(StatGroupType.General);
            types.add(StatGroupType.Values);
            types.add(StatGroupType.Weapons);
            destinyApiClient.getAccountStats(membershipId, types);

            Thread.sleep(100); 
            AccountTriumphsResponse accountTriumphsResponse
                    = destinyApiClient.getAccountTriumphs(membershipId, true);

            Thread.sleep(100);
            AccountSummaryResponse accountSummaryResponse = destinyApiClient.getAccountSummary(membershipId, true);

            for (Character character : accountSummaryResponse.Response.data.characters) {
                String characterId = character.characterBase.characterId;

                Thread.sleep(100);
                CharacterProgressionResponse characterProgressionResponse
                        = destinyApiClient.getCharacterProgression(membershipId, characterId, true);

                Thread.sleep(100);
                CharacterActivitiesResponse characterActivitiesResponse
                        = destinyApiClient.getCharacterActivities(membershipId, characterId, true);

                for (CharacterActivity characterActivity : characterActivitiesResponse.Response.data.available) {
                    Thread.sleep(100);
                    destinyApiClient.getPostGameCarnageReport(characterActivity.activityHash, true);
                }

                Thread.sleep(100); 
                ActivityHistoryStatsResponse activityHistoryStatsResponse
                        = destinyApiClient.getActivityHistoryStats(membershipId, characterId, 10, 0, ActivityType.Story, true);

                Thread.sleep(100); 
                AggregateActivityStatsResponse aggregateActivityStatsResponse
                        = destinyApiClient.getAggregateActivityStats(membershipId, characterId, true);

                Thread.sleep(100); 
                UniqueWeaponsStatsResponse uniqueWeaponsStatsResponse
                        = destinyApiClient.getUniqueWeaponsStats(membershipId, characterId, true);

                Thread.sleep(100); 
                CharacterInventoryResponse characterInventoryResponse
                        = destinyApiClient.getCharacterInventorySummary(membershipId, characterId, true);

                InventoryItem[] items = characterInventoryResponse.Response.data.items;
                for (InventoryItem item : items) {
                    Thread.sleep(100); 
                    String itemId = item.itemId;
                    destinyApiClient.getInventoryItem(membershipId, characterId, itemId, true);
                }
            }
        }
        System.out.println("Done");
    }

    public static CommandLine getConfig(String[] args) throws Exception {
        Options options = new Options();
        options.addOption("username", "username", true, "");
        options.addOption("apikey", "apikey", true, "");
        CommandLineParser optionsParser = new DefaultParser();
        return optionsParser.parse(options, args);
    }

    private static Logger getLogger(String appName) throws Exception {
        try {
            Properties log4jProperties = new Properties();
            log4jProperties.setProperty("log4j.logger." + appName, "DEBUG, myConsoleAppender");
            log4jProperties.setProperty("log4j.appender.myConsoleAppender", "org.apache.log4j.ConsoleAppender");
            log4jProperties.setProperty("log4j.appender.myConsoleAppender.layout", "org.apache.log4j.PatternLayout");
            log4jProperties.setProperty("log4j.appender.myConsoleAppender.layout.ConversionPattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
            PropertyConfigurator.configure(log4jProperties);
            return Logger.getLogger(appName);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }
}
