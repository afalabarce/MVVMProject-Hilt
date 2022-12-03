package io.github.afalalabarce.mvvmproject.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.afalalabarce.mvvmproject.data.datastore.PreferencesDatastoreRepository
import io.github.afalalabarce.mvvmproject.data.features.example.factory.ExampleEntityDataStoreFactory
import io.github.afalalabarce.mvvmproject.domain.usecase.example.ExampleEntityUseCase
import io.github.afalalabarce.mvvmproject.domain.usecase.settings.AppSettingsUseCase

@Module
@InstallIn(SingletonComponent::class)
object DomainDependencyInjector {
    @Provides
    fun providesAppSettingsUseCase(repository: PreferencesDatastoreRepository): AppSettingsUseCase = AppSettingsUseCase(repository)

    @Provides
    fun providesExampleEntityUseCase(factory: ExampleEntityDataStoreFactory): ExampleEntityUseCase = ExampleEntityUseCase(factory)
}