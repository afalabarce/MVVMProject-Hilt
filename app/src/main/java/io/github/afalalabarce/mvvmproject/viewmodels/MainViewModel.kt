package io.github.afalalabarce.mvvmproject.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.afalalabarce.mvvmproject.domain.usecase.example.ExampleEntityUseCase
import io.github.afalalabarce.mvvmproject.domain.usecase.settings.AppSettingsUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: ExampleEntityUseCase,
    private val settingsUseCase: AppSettingsUseCase
): ViewModel() {
}