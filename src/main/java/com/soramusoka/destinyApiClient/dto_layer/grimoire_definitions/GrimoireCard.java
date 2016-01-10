package com.soramusoka.destinyApiClient.dto_layer.grimoire_definitions;

public class GrimoireCard extends BaseGrimoireDefinition {
    public int score;
    public String statName;

    public long cardId;
    public String cardName;
    public String cardDescription;
    public String cardIntro;
    public String cardLabel;
    public String cardIntroAttribution;

    public String bonusName;
    public String bonusDescription;
    public GrimoireRank bonusRank;

    public String unlockHowToText;
    public int rarity;
    public long unlockFlagHash;

    public int points;
    public int totalPoints;

    public double value;
    public double threshold;

    public Image smallImage;

    public GrimoireStat[] statisticCollection;
}