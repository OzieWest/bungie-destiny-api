package com.soramusoka.destinyApiClient.dto_layer.inventory_item;

import com.soramusoka.destinyApiClient.dto_layer.common.StatItem;

import java.util.LinkedHashMap;

public class InventoryItemSummary {
    public InventoryItemExtended item;
    public InventoryItemTalentNodeExtended[] talentNodes;
    public LinkedHashMap<String, StatsOnNodes> statsOnNodes;
    public StatItem[] characterStatsToDisplay;
    public double[] materialItemHashes;
    public LinkedHashMap<String, Integer> materialQuantities;
}
