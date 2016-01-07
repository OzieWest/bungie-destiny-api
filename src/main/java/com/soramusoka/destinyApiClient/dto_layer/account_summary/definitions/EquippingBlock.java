package com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions;

import com.soramusoka.destinyApiClient.dto_layer.account_summary.Dyes;

public class EquippingBlock {
    public int weaponSandboxPatternIndex;
    public int gearArtArrangementIndex;
    public Dyes[] defaultDyes;
    public Object[] lockedDyes;
    public Object[] customDyes;
    public CustomDyeExpression customDyeExpression;
    public long weaponPatternHash;
    public Arrangement[] arrangements;
}
