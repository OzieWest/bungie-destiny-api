package com.soramusoka.destinyApiClient;

import org.json.JSONArray;

import java.lang.*;
import java.util.ArrayList;

public class AccountSummary {
    public String membershipId;
    public Integer membershipType;
    public String clanName;
    public Integer grimoireScore;
    public JSONArray vendorReceipts;
    public Integer versions;
    public ArrayList<Character> characters;
}
