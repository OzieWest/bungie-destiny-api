package com.soramusoka.destinyApiClient.dto_layer.account_summary;

import java.util.LinkedHashMap;

public class ItemSource {
    public int expansionIndex;
    public int level;
    public int minQuality;
    public int maxQuality;
    public int minLevelRequired;
    public int maxLevelRequired;
    public int exclusivity;
    public LinkedHashMap<String, ComputedStat> computedStats;
    public double[] sourceHashes;
    public int[] spawnIndexes;
}
