package com.soramusoka.destinyApiClient.dto_layer.account_summary;

import com.soramusoka.destinyApiClient.dto_layer.common.LevelProgression;

public class Character {
    public String emblemPath;
    public String backgroundPath;
    public long emblemHash;
    public int characterLevel;
    public int baseCharacterLevel;
    public boolean isPrestigeLevel;
    public float percentToNextLevel;
    public LevelProgression levelProgression;
    public CharacterBase characterBase;
}
