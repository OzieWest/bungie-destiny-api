package com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions;

import com.soramusoka.destinyApiClient.dto_layer.common.BaseDefinition;

public class TalentGridDefinition extends BaseDefinition {
    public double gridHash;
    public int maxGridLevel;
    public int gridLevelPerColumn;
    public double progressionHash;
    public TalentGridNode[] nodes;
    public int calcMaxGridLevel;
    public int calcProgressToMaxLevel;
    public ExclusiveSet[] exclusiveSets;
    public int[] independentNodeIndexes;
}
