package com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions;

public class ProgressionDefinition extends BaseDefinition {
    public double progressionHash;
    public String name;
    public int scope;
    public String identifier;
    public boolean repeatLastStep;
    public String icon;
    public ProgressionStepDefinition[] steps;
}
