package com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions;

public class TalentGridNode {
    public int nodeIndex;
    public double nodeHash;
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
    public double originalNodeHash;
    public TalentGridNodeStep[] steps;
    public Requirement randomActivationRequirement;
}
