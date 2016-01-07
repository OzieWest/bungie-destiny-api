package com.soramusoka.destinyApiClient.dto_layer.character_progression;

import com.soramusoka.destinyApiClient.dto_layer.common.LevelProgression;

public class CharacterProgression {
    public int baseCharacterLevel;
    public boolean isPrestigeLevel;
    public long factionProgressionHash;
    public float percentToNextLevel;
    public LevelProgression levelProgression;
    public LevelProgression[] progressions;
}
