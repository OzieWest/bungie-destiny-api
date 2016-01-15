package com.soramusoka.destinyApiClient.dto_layer.talent_node_steps;

import com.soramusoka.destinyApiClient.dto_layer.common.TalentGridNodeStep;
import com.soramusoka.destinyApiClient.dto_layer.common.PerkDefinition;
import com.soramusoka.destinyApiClient.dto_layer.common.StatDefinition;

import java.util.LinkedHashMap;

public class TalentNodeStepsSummary {
    public LinkedHashMap<String, TalentGridNodeStep> nodeSteps;
    public LinkedHashMap<String, PerkDefinition> perks;
    public LinkedHashMap<String, StatDefinition> stats;
}
