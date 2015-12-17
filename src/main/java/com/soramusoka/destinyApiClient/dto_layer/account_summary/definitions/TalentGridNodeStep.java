package com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions;

public class TalentGridNodeStep {
    public int stepIndex;
    public double nodeStepHash;
    public String nodeStepName;
    public String nodeStepDescription;
    public String interactionDescription;
    public String icon;
    public int damageType;
    public double damageTypeHash;
    public ActivationRequirement activationRequirement;
    public boolean canActivateNextStep;
    public int nextStepIndex;
    public boolean isNextStepRandom;
    public double[] perkHashes;
    public int startProgressionBarAtProgress;
    public double[] statHashes;
    public boolean affectsQuality;
    public int trueStepIndex;
    public int truePropertyIndex;
    public boolean affectsLevel;
    public PerkGroups stepGroups;
}
