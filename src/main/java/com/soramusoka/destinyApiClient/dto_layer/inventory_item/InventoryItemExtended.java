package com.soramusoka.destinyApiClient.dto_layer.inventory_item;

import com.soramusoka.destinyApiClient.dto_layer.common.BaseInventoryItem;
import com.soramusoka.destinyApiClient.dto_layer.common.LevelProgression;
import com.soramusoka.destinyApiClient.dto_layer.common.StatItem;

import java.util.LinkedHashMap;

public class InventoryItemExtended extends BaseInventoryItem {
    public int damageTypeNodeIndex;
    public int damageTypeStepIndex;
    public int bindStatus;
    public boolean isEquipped;
    public String itemInstanceId;
    public int itemLevel;
    public int stackSize;
    public int qualityLevel;
    public StatItem[] stats;
    public StatItem primaryStat;
    public boolean canEquip;
    public int equipRequiredLevel;
    public double unlockFlagHashRequiredToEquip;
    public int cannotEquipReason;
    public LevelProgression progression;
    public double talentGridHash;
    public InventoryItemTalentNode[] nodes;
    public boolean useCustomDyes;
    public LinkedHashMap<String, Integer> artRegions;
    public boolean isEquipment;
    public boolean isGridComplete;
    public InventoryItemPerk[] perks;
    public int location;
    public int transferStatus;
    public boolean locked;
    public boolean lockable;
    public Object[] objectives;
    public int state;
}
