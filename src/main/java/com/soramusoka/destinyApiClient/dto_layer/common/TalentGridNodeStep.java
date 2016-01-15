package com.soramusoka.destinyApiClient.dto_layer.common;

import com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions.ActivationRequirement;
import com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions.PerkGroups;

public class TalentGridNodeStep extends BaseDefinition {
    public int stepIndex;
    public long nodeStepHash;
    public String nodeStepName;
    public String nodeStepDescription;
    public String interactionDescription;
    public String icon;
    public int damageType;
    public long damageTypeHash;
    public ActivationRequirement activationRequirement;
    public boolean canActivateNextStep;
    public int nextStepIndex;
    public boolean isNextStepRandom;
    public long[] perkHashes;
    public int startProgressionBarAtProgress;
    public long[] statHashes;
    public boolean affectsQuality;
    public int trueStepIndex;
    public int truePropertyIndex;
    public boolean affectsLevel;
    public PerkGroups stepGroups;
}
