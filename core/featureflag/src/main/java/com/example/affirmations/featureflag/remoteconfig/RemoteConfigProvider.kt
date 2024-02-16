package com.example.affirmations.featureflag.remoteconfig

import com.example.affirmations.featureflag.remoteconfig.FirebaseRemoteConfig
import com.example.affirmations.featureflag.remoteconfig.HuaweiRemoteConfig
import com.example.affirmations.featureflag.remoteconfig.RemoteConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteConfigProvider @Inject constructor(){
    val remoteConfig: RemoteConfig
    init {
        remoteConfig = if (true) {
            FirebaseRemoteConfig()
        } else {
            HuaweiRemoteConfig()
        }
    }
}