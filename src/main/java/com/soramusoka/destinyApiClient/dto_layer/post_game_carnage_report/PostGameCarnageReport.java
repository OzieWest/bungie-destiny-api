package com.soramusoka.destinyApiClient.dto_layer.post_game_carnage_report;

import com.soramusoka.destinyApiClient.dto_layer.activity_history_stats.ActivityDetails;

import java.util.Date;

public class PostGameCarnageReport {
    public Date period;
    public ActivityDetails activityDetails;
    public PostGameCarnageReportEntry[] entries;
    public Object[] teams;
}
