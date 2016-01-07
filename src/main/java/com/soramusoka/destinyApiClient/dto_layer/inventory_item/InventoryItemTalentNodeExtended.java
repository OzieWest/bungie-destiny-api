package com.soramusoka.destinyApiClient.dto_layer.inventory_item;

public class InventoryItemTalentNodeExtended extends InventoryItemTalentNode {
    public int nodeIndex;
    public String stateId;
    public UpgradeMaterial[] materialsToUpgrade;
    public int activationGridLevel;
    public double progressPercent;
}
