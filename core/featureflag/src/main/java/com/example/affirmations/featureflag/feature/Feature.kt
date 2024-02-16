package com.example.affirmations.featureflag.feature

import com.example.affirmations.featureflag.features.FeatureFlag
import com.example.affirmations.featureflag.remoteconfig.RemoteConfigProvider
import com.example.affirmations.preferences.Preferences
import javax.inject.Inject

class Feature @Inject constructor(
    private val preferences: Preferences,
    private val remoteConfigProvider: RemoteConfigProvider
){
    private val remoteConfig = remoteConfigProvider.remoteConfig

    fun available(featureFlag: FeatureFlag): Boolean{
        return preferences.getBoolean(featureFlag.key) || remoteConfig.getBoolean(featureFlag.key)
    }
}