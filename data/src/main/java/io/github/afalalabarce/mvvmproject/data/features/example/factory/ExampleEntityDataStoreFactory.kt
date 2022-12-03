package io.github.afalalabarce.mvvmproject.data.features.example.factory

import io.github.afalalabarce.mvvmproject.data.features.example.interfaces.ExampleDataStore
import javax.inject.Inject

class ExampleEntityDataStoreFactory @Inject constructor(
    private val cacheDataStore: ExampleDataStore,
    private val remoteDataStore: ExampleDataStore,
) {
    fun getCacheDataStore(): ExampleDataStore = this.cacheDataStore
    fun getRemoteDataStore(): ExampleDataStore = this.remoteDataStore
}