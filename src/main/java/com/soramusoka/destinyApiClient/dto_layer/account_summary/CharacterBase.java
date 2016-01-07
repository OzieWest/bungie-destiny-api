package com.soramusoka.destinyApiClient.dto_layer.account_summary;

import java.util.Date;

public class CharacterBase {
    public String membershipId;
    public int membershipType;
    public String characterId;
    public Date dateLastPlayed;
    public String minutesPlayedThisSession;
    public String minutesPlayedTotal;
    public int powerLevel;
    public long raceHash;
    public long genderHash;
    public long classHash;
    public long currentActivityHash;
    public long lastCompletedStoryHash;
    public int grimoireScore;
    public int genderType;
    public int classType;
    public long buildStatGroupHash;
    public StatGroup stats;
    public Customization customization;
    public PeerView peerView;
}
