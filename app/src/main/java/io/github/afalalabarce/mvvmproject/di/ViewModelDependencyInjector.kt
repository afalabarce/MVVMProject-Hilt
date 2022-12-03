package io.github.afalalabarce.mvvmproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.github.afalalabarce.mvvmproject.domain.usecase.example.ExampleEntityUseCase
import io.github.afalalabarce.mvvmproject.domain.usecase.settings.AppSettingsUseCase
import io.github.afalalabarce.mvvmproject.viewmodels.MainViewModel

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelDependencyInjector {
    @Provides
    fun providesAppViewModel(exampleEntityUseCase: ExampleEntityUseCase, settingsUseCase: AppSettingsUseCase): MainViewModel = MainViewModel(exampleEntityUseCase, settingsUseCase)
}