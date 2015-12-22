package com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions;

import com.soramusoka.destinyApiClient.dto_layer.account_summary.RewardGroup;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseDefinition;

public class ActivityDefinition extends BaseDefinition {
    public double activityHash;
    public String activityName;
    public String activityDescription;
    public String icon;
    public String releaseIcon;
    public int releaseTime;
    public int activityLevel;
    public double completionFlagHash;
    public int activityPower;
    public int minParty;
    public int maxParty;
    public int maxPlayers;
    public double destinationHash;
    public double placeHash;
    public double activityTypeHash;
    public int tier;
    public String pgcrImage;
    public RewardGroup[] rewards;
    public SkullDefinition[] skulls;
    public boolean isPlaylist;
}
