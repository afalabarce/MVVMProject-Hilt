package io.github.afalalabarce.mvvmproject.domain.usecase.settings

import io.github.afalalabarce.mvvmproject.data.datastore.PreferencesDatastoreRepository
import javax.inject.Inject

class AppSettingsUseCase @Inject constructor(
    private val appPreferencesRepository: PreferencesDatastoreRepository
) {

}