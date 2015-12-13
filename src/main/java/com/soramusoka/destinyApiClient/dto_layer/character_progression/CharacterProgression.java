package com.soramusoka.destinyApiClient.dto_layer.character_progression;

import com.soramusoka.destinyApiClient.dto_layer.common.LevelProgression;

public class CharacterProgression {
    public Integer baseCharacterLevel;
    public Boolean isPrestigeLevel;
    public Double factionProgressionHash;
    public Float percentToNextLevel;
    public LevelProgression levelProgression;
    public Progression[] progressions;
}
