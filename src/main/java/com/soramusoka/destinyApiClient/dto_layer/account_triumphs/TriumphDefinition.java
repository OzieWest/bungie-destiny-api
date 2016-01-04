package com.soramusoka.destinyApiClient.dto_layer.account_triumphs;

import com.soramusoka.destinyApiClient.dto_layer.common.BaseDefinition;

public class TriumphDefinition extends BaseDefinition {
    public String identifier;
    public String title;
    public String subtitle;
    public String iconPath;
    public boolean hasProgress;
    public int minimumProgress;
    public int maximumProgress;
    public double lockdownUnlockHash;
}
