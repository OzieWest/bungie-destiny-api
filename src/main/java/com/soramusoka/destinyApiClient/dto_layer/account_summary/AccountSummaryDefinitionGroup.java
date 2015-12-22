package com.soramusoka.destinyApiClient.dto_layer.account_summary;

import com.soramusoka.destinyApiClient.dto_layer.account_summary.definitions.*;
import com.soramusoka.destinyApiClient.dto_layer.common.CharacterProgressionDefinition;

import java.util.LinkedHashMap;

public class AccountSummaryDefinitionGroup {
    public LinkedHashMap<String, RaceDefinition> races;
    public LinkedHashMap<String, GenderDefinition> genders;
    public LinkedHashMap<String, ClassDefinition> classes;
    public LinkedHashMap<String, ActivityDefinition> activities;
    public LinkedHashMap<String, DestinationDefinition> destinations;
    public LinkedHashMap<String, PlaceDefinition> places;
    public LinkedHashMap<String, ActivityTypeDefinition> activityTypes;
    public LinkedHashMap<String, ItemDefinition> items;
    public LinkedHashMap<String, BucketDefinition> buckets;
    public LinkedHashMap<String, StatDefinition> stats;
    public LinkedHashMap<String, PerkDefinition> perks;
    public LinkedHashMap<String, TalentGridDefinition> talentGrids;
    public LinkedHashMap<String, StatGroupDefinition> statGroups;
    public Object progressionMappings;
    public LinkedHashMap<String, ItemCategoryDefinition> itemCategories;
    public LinkedHashMap<String, SourceDefinition> sources;
    public Object objectives;
    public LinkedHashMap<String, CharacterProgressionDefinition> progressions;
    public LinkedHashMap<String, DamageTypeDefinition> damageTypes;
    public Object materialRequirements;
    public Object unlockValues;
    public Object vendorDetails;
    public Object locations;
    public Object factions;
    public Object events;
    public Object vendorCategories;
    public Object vendorSummaries;
    public Object books;
    public Object activityBundles;
    public Object flags;
}
