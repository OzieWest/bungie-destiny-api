package com.soramusoka.destinyApiClient.dto_layer.account_summary;

import java.util.Date;

public class CharacterBase {
    public String membershipId;
    public Integer membershipType;
    public String characterId;
    public Date dateLastPlayed;
    public String minutesPlayedThisSession;
    public String minutesPlayedTotal;
    public Integer powerLevel;
    public Double raceHash;
    public Double genderHash;
    public Double classHash;
    public Integer currentActivityHash;
    public Integer lastCompletedStoryHash;
    public Integer grimoireScore;
    public Integer genderType;
    public Integer classType;
    public Double buildStatGroupHash;
    public StatGroup stats;
    public Customization customization;
    public PeerView peerView;
}
