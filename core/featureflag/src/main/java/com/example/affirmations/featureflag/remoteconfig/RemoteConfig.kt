package com.example.affirmations.featureflag.remoteconfig

interface RemoteConfig {
    fun init()
    fun load()
    fun getBoolean(key: String): Boolean
    fun getString()
}