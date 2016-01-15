package com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions;

import com.soramusoka.destinyApiClient.dto_layer.common.TalentGridNodeStep;

public class TalentGridNode {
    public int nodeIndex;
    public long nodeHash;
    public int row;
    public int column;
    public int[] prerequisiteNodeIndexes;
    public int binaryPairNodeIndex;
    public boolean autoUnlocks;
    public boolean lastStepRepeats;
    public boolean isRandom;
    public boolean isRandomRepurchasable;
    public int[] exlusiveWithNodes;
    public int randomStartProgressionBarAtProgression;
    public long originalNodeHash;
    public TalentGridNodeStep[] steps;
    public Requirement randomActivationRequirement;
}
