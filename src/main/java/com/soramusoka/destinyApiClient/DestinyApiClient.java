package com.soramusoka.destinyApiClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class DestinyApiClient {
    public IRequest Request;
    private String _hostName = "http://www.bungie.net";
    private String _rootPath = "/Platform/Destiny";
    private Integer _platform = 2;

    public DestinyApiClient(IRequest request, Integer platform) {
        this.Request = request;
        this._platform = platform;
    }

    private String formUrl(String url) {
        return this._hostName + this._rootPath + url;
    }

    public String getMembershipId(String userName) throws Exception {
        String urlSearchDestinyPlayer = formUrl("/SearchDestinyPlayer/" + this._platform + "/" + userName);

        String data = this.Request.getUrl(urlSearchDestinyPlayer);
        JSONObject rootObject = new JSONObject(data);
        this.validateResponse(rootObject);

        JSONArray jsonResponse = rootObject.getJSONArray("Response");

        JSONObject obj = jsonResponse.getJSONObject(0);
        return obj.getString("membershipId");
    }

    public AccountSummary getAccountSummary(String membershipId) throws Exception {
        String urlAccountSummary = this.formUrl("/" + this._platform + "/Account/" + membershipId);

        String data = this.Request.getUrl(urlAccountSummary);
        JSONObject rootObject = new JSONObject(data);
        this.validateResponse(rootObject);

        JSONObject responseObject = rootObject.getJSONObject("Response");
        JSONObject dataObject = responseObject.getJSONObject("data");

        AccountSummary accountSummary = new AccountSummary();
        accountSummary.membershipId = dataObject.getString("membershipId");
        accountSummary.membershipType = dataObject.getInt("membershipType");
        accountSummary.clanName = dataObject.getString("clanName");
        accountSummary.grimoireScore = dataObject.getInt("grimoireScore");
        accountSummary.vendorReceipts = dataObject.getJSONArray("vendorReceipts");
        accountSummary.versions = dataObject.getInt("versions");

        JSONArray jsonCharacters = dataObject.getJSONArray("characters");

        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < jsonCharacters.length(); i++) {
            JSONObject jsonCharacter = jsonCharacters.getJSONObject(i);

            Character character = new Character();
            character.baseCharacterLevel = jsonCharacter.getInt("baseCharacterLevel");
            character.characterLevel = jsonCharacter.getInt("characterLevel");
            character.backgroundPath = jsonCharacter.getString("backgroundPath");
            character.percentToNextLevel = jsonCharacter.getInt("percentToNextLevel");
            character.isPrestigeLevel = jsonCharacter.getBoolean("isPrestigeLevel");
            character.emblemPath = jsonCharacter.getString("emblemPath");
            character.emblemHash = jsonCharacter.getInt("emblemHash");
            characters.add(character);
        }
        accountSummary.characters = characters;

        return accountSummary;
    }

    // TODO: change it!
    private void validateResponse(JSONObject obj) throws Exception {
        Integer ErrorCode = obj.getInt("ErrorCode");
        if (ErrorCode != 1) {
            String ErrorStatus = obj.getString("ErrorStatus");
            String Message = obj.getString("Message");
            throw new Exception(ErrorStatus + ": " + Message);
        }
    }
}
