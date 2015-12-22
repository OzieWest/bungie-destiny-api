package com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions;

import com.soramusoka.destinyApiClient.dto_layer.common.BaseDefinition;

public class BucketDefinition extends BaseDefinition {
    public double bucketHash;
    public String bucketName;
    public String bucketDescription;
    public int scope;
    public int category;
    public int bucketOrder;
    public String bucketIdentifier;
    public int itemCount;
    public int location;
    public boolean hasTransferDestination;
    public boolean enabled;
}
