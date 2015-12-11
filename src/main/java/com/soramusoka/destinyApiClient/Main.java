package com.soramusoka.destinyApiClient;

import com.soramusoka.destinyApiClient.dto_layer.account_summary.AccountSummary;
import com.soramusoka.destinyApiClient.dto_layer.membership_id.MembershipId;
import com.soramusoka.destinyApiClient.repository_layer.DestinyApiClient;
import com.soramusoka.destinyApiClient.service_layer.Request;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        CommandLine cmd = getConfig(args);
        Logger logger = getLogger("main");

        String apiKey = cmd.getOptionValue("apikey");
        String userName = cmd.getOptionValue("username");

        Request request = new Request(apiKey, getLogger("Request"));
        DestinyApiClient destinyApiClient = new DestinyApiClient(request, 2);
        MembershipId[] membershipIdArray = destinyApiClient.getMembershipId(userName);

        if (membershipIdArray.length == 0) {
            logger.info("Didn't find any users with that name");
        } else {
            MembershipId membershipId = membershipIdArray[0];
            AccountSummary accountSummary = destinyApiClient.getAccountSummary(membershipId.membershipId);
            logger.info(accountSummary.characters.length);
        }
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
