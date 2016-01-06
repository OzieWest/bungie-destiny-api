package com.soramusoka.destinyApiClient;

import com.soramusoka.destinyApiClient.dto_layer.common.ActivityType;
import com.soramusoka.destinyApiClient.dto_layer.common.MembershipType;
import com.soramusoka.destinyApiClient.dto_layer.common.StatGroupType;
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
        Logger logger = getLogger("main");

        String apiKey = cmd.getOptionValue("apikey");
        String userName = cmd.getOptionValue("username");

        // TESTS
        MembershipType type = MembershipType.PLAYSTATION;
        Request request = new Request(apiKey);
        DestinyApiClient destinyApiClient = new DestinyApiClient(request, type);

        destinyApiClient.getUserInfoByDisplayName("soramusoka");
        Thread.sleep(100);
        destinyApiClient.getAccountSummary("4611686018428868193", true);
        Thread.sleep(100);
        destinyApiClient.getCharacterProgression("4611686018428868193", "2305843009345925219", true);
        Thread.sleep(100);
        destinyApiClient.getCharacterActivities("4611686018428868193", "2305843009345925219", true);
        Thread.sleep(100);
        destinyApiClient.getCharacterInventorySummary("4611686018428868193", "2305843009345925219", true);
        Thread.sleep(100);
        destinyApiClient.getActivityHistoryStats("4611686018428868193", "2305843009345925219", 100, 0, ActivityType.Story,  true);
        Thread.sleep(100);
        destinyApiClient.getAggregateActivityStats("4611686018428868193", "2305843009345925219", true);
        Thread.sleep(100);
        destinyApiClient.getAccountItems("4611686018428868193", true);
        Thread.sleep(100);
        ArrayList<StatGroupType> types = new ArrayList<>();
        types.add(StatGroupType.Medals);
        types.add(StatGroupType.Enemies);
        types.add(StatGroupType.General);
        types.add(StatGroupType.Values);
        types.add(StatGroupType.Weapons);
        destinyApiClient.getAccountStats("4611686018428868193", types);
        Thread.sleep(100);
        destinyApiClient.getAccountStats("4611686018428868193", StatGroupType.Enemies);
        Thread.sleep(100);
        destinyApiClient.getUniqueWeaponsStats("4611686018428868193", "2305843009345925219", true);
        Thread.sleep(100);
        destinyApiClient.getAccountTriumphs("4611686018428868193", true);
        Thread.sleep(100);
        destinyApiClient.getPostGameCarnageReport("2330516073", true);
        Thread.sleep(100);
        destinyApiClient.getPostGameCarnageReport("2659248071", true);
        Thread.sleep(100);
        destinyApiClient.getPostGameCarnageReport("3393673804", true);
        Thread.sleep(100);
        destinyApiClient.getPostGameCarnageReport("4079642014", true);
        Thread.sleep(100);
        destinyApiClient.getPostGameCarnageReport("2326253031", true);
        Thread.sleep(100);
        destinyApiClient.getPostGameCarnageReport("167419252", true);
        Thread.sleep(100);
        destinyApiClient.getMembershipIdByDisplayName("soramusoka", true);

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
