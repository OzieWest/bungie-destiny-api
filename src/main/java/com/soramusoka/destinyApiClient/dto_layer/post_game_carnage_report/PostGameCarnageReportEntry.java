package com.soramusoka.destinyApiClient.dto_layer.post_game_carnage_report;

import com.soramusoka.destinyApiClient.dto_layer.common.StatGroupOf;
import com.soramusoka.destinyApiClient.dto_layer.common.StatValue;
import com.soramusoka.destinyApiClient.dto_layer.unique_weapons_stats.UniqueWeaponsStatGroup;

public class PostGameCarnageReportEntry {
    public int standing;
    public StatValue score;
    public PostGameCarnageReportEntryPlayer player;
    public String characterId;
    public StatGroupOf<StatValue> values;
    public UniqueWeaponsStatGroup extended;
}