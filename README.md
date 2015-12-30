# destiny-api-library
http://www.bungie.net/Platform/Destiny/help

### Usage

```java
int membershipType = 2; // 1 - xbox, 2 - ps
DestinyApiClient destinyApiClient = new DestinyApiClient(request, membershipType);

// Returns a list of Destiny memberships given a full Gamertag or PSN ID
destinyApiClient.getMembershipId(userName);

// Returns Destiny account information for the supplied membership in a compact summary form.
destinyApiClient.getAccountSummary(membershipId, withDefinitions);

// Gets historical stats definitions.
destinyApiClient.getStatsDefinition()

// Retrieve the inventory for the supplied character.
destinyApiClient.getCharacterActivities(membershipId, characterId);

// Provides the progression details for the supplied character.
destinyApiClient.getCharacterProgression(membershipId, characterId);

// Returns summary information for the inventory for the supplied character.
destinyApiClient.getCharacterInventory(membershipId, characterId);

// Gets activity history stats for indicated character.
destinyApiClient.getActivityHistoryStats(membershipId, characterId, count, page, mode, withDefinitions);

// Gets all activities the character has participated in together with aggregate statistics for those activities.
destinyApiClient.getAggregateActivityStats(membershipId, characterId, withDefinitions);

// others in progress...
```