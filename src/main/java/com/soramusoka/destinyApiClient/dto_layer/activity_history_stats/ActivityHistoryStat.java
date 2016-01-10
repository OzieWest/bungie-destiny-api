package com.soramusoka.destinyApiClient.dto_layer.activity_history_stats;

import com.soramusoka.destinyApiClient.dto_layer.common.StatValue;

import java.util.Date;
import java.util.LinkedHashMap;

public class ActivityHistoryStat {
    public Date period;
    public ActivityDetails activityDetails;
    public LinkedHashMap<String, StatValue> values;
}
