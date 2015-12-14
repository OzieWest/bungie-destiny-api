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
    public double raceHash;
    public double genderHash;
    public double classHash;
    public int currentActivityHash;
    public int lastCompletedStoryHash;
    public int grimoireScore;
    public int genderType;
    public int classType;
    public double buildStatGroupHash;
    public StatGroup stats;
    public Customization customization;
    public PeerView peerView;
}
