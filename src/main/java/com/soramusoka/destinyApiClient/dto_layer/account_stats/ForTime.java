package com.soramusoka.destinyApiClient.dto_layer.account_stats;

import com.soramusoka.destinyApiClient.dto_layer.activity_history_stats.ActivityHistoryStat;

public class ForTime<T> {
    public T allTime;
    public ActivityHistoryStat[] monthly;
    public ActivityHistoryStat[] daily;
}
