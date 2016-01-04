package com.soramusoka.destinyApiClient.dto_layer.account_triumphs;

import com.soramusoka.destinyApiClient.dto_layer.common.BaseDefinition;

import java.util.Date;

public class TriumphDefinitionGroup extends BaseDefinition {
    public double triumphSetHash;
    public String identifier;
    public int order;
    public String title;
    public String iconPath;
    public String incompleteSubtitle;
    public String incompleteDetails;
    public String completedSubtitle;
    public String completedDetails;
    public String lockedSubtitle;
    public String lockedDetails;
    public Date lockdownDate;
    public int lockdownUnlockHash;
    public TriumphDefinition[] triumphs;
}
