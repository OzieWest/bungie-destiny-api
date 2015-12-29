package com.soramusoka.destinyApiClient.dto_layer.activity_history_stats;

import com.soramusoka.destinyApiClient.dto_layer.common.ActivityHistoryValueGroup;

import java.util.Date;

public class ActivityHistoryStat {
    public Date period;
    public ActivityDetails activityDetails;
    public ActivityHistoryValueGroup values;
}
