package com.soramusoka.destinyApiClient.dto_layer.grimoire_definitions;

public class GrimoireCard extends BaseGrimoireDefinition {
    public long cardId;
    public String cardName;
    public String cardDescription;
    public String cardIntro;
    public String cardLabel;
    public String cardIntroAttribution;
    public String unlockHowToText;
    public String bonusName;
    public String bonusDescription;
    public GrimoireRank bonusRank;
    public int rarity;
    public long unlockFlagHash;
    public int points;
    public int totalPoints;
    public GrimoireStat[] statisticCollection;
}