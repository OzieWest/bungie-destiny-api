package com.soramusoka.destinyApiClient.dto_layer.account_grimoire;

import com.soramusoka.destinyApiClient.dto_layer.grimoire_definitions.GrimoireCard;

public class AccountGrimoire {
    public int score;
    public GrimoireCard[] cardCollection;
    public Object[] cardsToHide;
    public GrimoireCard[] bonuses;
}
