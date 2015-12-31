package com.soramusoka.destinyApiClient.dto_layer;

public enum ActivityType {
    None("None"),
    Story("Story"),
    Strike("Strike"),
    Raid("Raid"),
    AllPvP("AllPvP"),
    Patrol("Patrol"),
    AllPvE("AllPvE"),
    PvPIntroduction("PvPIntroduction"),
    ThreeVsThree("ThreeVsThree"),
    Control("Control"),
    Lockdown("Lockdown"),
    Team("Team"),
    FreeForAll("FreeForAll"),
    Nightfall("Nightfall"),
    Heroic("Heroic"),
    AllStrikes("AllStrikes"),
    IronBanner("IronBanner"),
    AllArena("AllArena"),
    Arena("Arena"),
    ArenaChallenge("ArenaChallenge"),
    TrialsOfOsiris("TrialsOfOsiris"),
    Elimination("Elimination"),
    Rift("Rift"),
    Mayhem("Mayhem"),
    ZoneControl("ZoneControl"),
    Racing("Racing");

    private final String _value;

    private ActivityType(String value) {
        this._value = value;
    }

    public String getValue() {
        return this._value;
    }
}
