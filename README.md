# destiny-api-library

### Usage

###### init
```java
int type = 2; // 1 - xbox, 2 - ps
DestinyApiClient destinyApiClient = new DestinyApiClient(request, 2);
```

###### Returns a list of Destiny memberships given a full Gamertag or PSN ID
```java
MembershipId[] result = destinyApiClient.getMembershipId(userName);
```

###### Returns Destiny account information for the supplied membership in a compact summary form.
```java
AccountSummary result = destinyApiClient.getAccountSummary(membershipId);
```

###### Gets historical stats definitions.
```java
StatsDefinitionGroup result = destinyApiClient.getStatsDefinition()
```

###### Retrieve the inventory for the supplied character.
```java
CharacterActivities result = destinyApiClient.getCharacterActivities(membershipId, characterId);
```

###### Provides the progression details for the supplied character.
```java
CharacterProgression result = destinyApiClient.getCharacterProgression(membershipId, characterId);
```

###### Returns summary information for the inventory for the supplied character.
```java
CharacterInventoryGroup result = destinyApiClient.getCharacterInventory(membershipId, characterId);
```

