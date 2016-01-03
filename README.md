# destiny-api-library
http://www.bungie.net/Platform/Destiny/help

### Usage

```java
MembershipType type = MembershipType.PLAYSTATION;
DestinyApiClient destinyApiClient = new DestinyApiClient(request, type);

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

// Returns information about all items on the for the supplied Destiny Membership ID, and a minimal set of character information so that it can be used.
destinyApiClient.getAccountItems(membershipId, withDefinitions);

// Gets aggregate historical stats organized around each character for a given account.
destinyApiClient.getAccountStats(membershipId, groups);

// Gets details about unique weapon usage, including all exotic weapons.
destinyApiClient.getUniqueWeaponsStats(membershipId, characterId, withDefinitions);

// others in progress...
```
