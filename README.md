# destiny-api-library

### Usage

```java
int membershipType = 2; // 1 - xbox, 2 - ps
DestinyApiClient destinyApiClient = new DestinyApiClient(request, membershipType);
```

##### Returns a list of Destiny memberships given a full Gamertag or PSN ID
Endpoint: http://www.bungie.net/Platform/Destiny/SearchDestinyPlayer/{membershipType}/{displayName}/
```java
MembershipId[] result = destinyApiClient.getMembershipId(userName);
```

##### Returns Destiny account information for the supplied membership in a compact summary form.
Endpoint: http://www.bungie.net/Platform/Destiny/{membershipType}/Account/{destinyMembershipId}/Summary/

```java
AccountSummary result = destinyApiClient.getAccountSummary(membershipId, withDefinitions);
```

##### Gets historical stats definitions.
Endpoint: http://www.bungie.net/Platform/Destiny/Stats/Definition/
```java
StatsDefinitionGroup result = destinyApiClient.getStatsDefinition()
```

##### Retrieve the inventory for the supplied character.
Endpoint: http://www.bungie.net/Platform/Destiny/{membershipType}/Account/{destinyMembershipId}/Character/{characterId}/Activities/
```java
CharacterActivities result = destinyApiClient.getCharacterActivities(membershipId, characterId);
```

##### Provides the progression details for the supplied character.
Endpoint: http://www.bungie.net/Platform/Destiny/{membershipType}/Account/{destinyMembershipId}/Character/{characterId}/Progression/
```java
CharacterProgression result = destinyApiClient.getCharacterProgression(membershipId, characterId);
```

##### Returns summary information for the inventory for the supplied character.
Endpoint: http://www.bungie.net/Platform/Destiny/{membershipType}/Account/{destinyMembershipId}/Character/{characterId}/Inventory/Summary/
```java
CharacterInventoryGroup result = destinyApiClient.getCharacterInventory(membershipId, characterId);
```

