package com.soramusoka.destinyApiClient.dto_layer.common;

public class CharacterProgressionDefinition extends BaseDefinition {
    public double progressionHash;
    public String name;
    public int scope;
    public boolean repeatLastStep;
    public String identifier;
    public String icon;
    public String description;
    public String source;
    public ProgressionStepDefinition[] steps;
}
