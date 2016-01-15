package com.soramusoka.destinyApiClient.dto_layer.common;

import com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions.PerkGroups;
import com.soramusoka.destinyApiClient.dto_layer.common.BaseDefinition;

public class PerkDefinition extends BaseDefinition {
    public long perkHash;
    public String perkIdentifier;
    public String displayDescription;
    public String displayName;
    public String displayIcon;
    public boolean isDisplayable;
    public PerkGroups perkGroups;
}
