package com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions;

import com.soramusoka.destinyApiClient.dto_layer.common.BaseDefinition;

public class PerkDefinition extends BaseDefinition {
    public String displayDescription;
    public String displayName;
    public double perkHash;
    public String displayIcon;
    public boolean isDisplayable;
    public PerkGroups perkGroups;
    public String perkIdentifier;
}
