package com.soramusoka.destinyApiClient.dto_layer.character_inventory;

import com.soramusoka.destinyApiClient.dto_layer.common.StatItem;

public class CharacterInventory {
    public double itemHash;
    public String itemId;
    public int quantity;
    public int damageType;
    public double damageTypeHash;
    public boolean isGridComplete;
    public int transferStatus;
    public int state;
    public int characterIndex;
    public double bucketHash;
    public StatItem primaryStat;
}
