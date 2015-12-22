package com.soramusoka.destinyApiClient.dto_layer.common;

import com.soramusoka.destinyApiClient.dto_layer.common.BaseDefinition;
import com.soramusoka.destinyApiClient.dto_layer.common.ProgressionStepDefinition;

public class CharacterProgressionDefinition extends BaseDefinition {
    public double progressionHash;
    public String name;
    public int scope;
    public boolean repeatLastStep;
    public ProgressionStepDefinition[] steps;
    public String identifier;
    public String icon;
}
