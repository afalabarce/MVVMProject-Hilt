package io.github.afalalabarce.mvvmproject.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.afalalabarce.mvvmproject.data.datastore.PreferencesDatastoreRepository
import io.github.afalalabarce.mvvmproject.data.features.example.factory.ExampleEntityDataStoreFactory
import io.github.afalalabarce.mvvmproject.data.features.example.implementation.ExampleCacheDataStoreImpl
import io.github.afalalabarce.mvvmproject.data.features.example.implementation.ExampleRemoteDataStoreImpl
import io.github.afalalabarce.mvvmproject.data.features.example.interfaces.ExampleDataStore
import io.github.afalalabarce.mvvmproject.datasource.cache.db.AppDatabase
import io.github.afalalabarce.mvvmproject.datasource.datastore.PreferencesDataStore
import io.github.afalalabarce.mvvmproject.datasource.remote.service.AppRemoteService
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object DataDependencyInjector {
    @Provides
    fun providesPreferenceRepository(dataStore: PreferencesDataStore): PreferencesDatastoreRepository = PreferencesDatastoreRepository(dataStore)

    @Provides
    @Named("remote")
    fun providesRemoteExampleDataStore(
        appRemoteService: AppRemoteService,
        appDatabase: AppDatabase
    ): ExampleDataStore = ExampleRemoteDataStoreImpl(appRemoteService, appDatabase)

    @Provides
    @Named("cache")
    fun providesCacheExampleDataStore(appDatabase: AppDatabase): ExampleDataStore = ExampleCacheDataStoreImpl(appDatabase)

    @Provides
    fun providesExampleEntityDataStoreFactory(
        @Named("cache") cache: ExampleDataStore,
        @Named("remote") remote: ExampleDataStore
    ): ExampleEntityDataStoreFactory = ExampleEntityDataStoreFactory(cache, remote)
}