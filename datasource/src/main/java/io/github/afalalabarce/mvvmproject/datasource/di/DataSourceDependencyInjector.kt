package io.github.afalalabarce.mvvmproject.datasource.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.afalalabarce.mvvmproject.datasource.BuildConfig
import io.github.afalalabarce.mvvmproject.datasource.cache.dao.AppDatabaseDao
import io.github.afalalabarce.mvvmproject.datasource.cache.db.AppDatabase
import io.github.afalalabarce.mvvmproject.datasource.datastore.PreferencesDataStore
import io.github.afalalabarce.mvvmproject.datasource.remote.service.AppRemoteService
import io.github.afalalabarce.mvvmproject.datasource.remote.service.interfaces.AccessTokenProvider
import io.github.afalalabarce.mvvmproject.datasource.remote.service.providers.AccessTokenProviderImpl
import io.github.afalalabarce.mvvmproject.model.utilities.iif
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceDependencyInjector {
    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context):AppDatabase = Room.databaseBuilder(context,
        AppDatabase::class.java,
        AppDatabase.DATABASE_NAME
    ).addMigrations(*AppDatabase.migrations.toTypedArray())
        .enableMultiInstanceInvalidation()
        .build()

    @Singleton
    @Provides
    fun providesAppDao(database: AppDatabase): AppDatabaseDao = database.dao()

    @Singleton
    @Provides
    fun providesPreferenceDataStore(@ApplicationContext context: Context): PreferencesDataStore = PreferencesDataStore(context)

    @Provides
    fun providesAccessToken(): AccessTokenProvider = AccessTokenProviderImpl()

    @Singleton
    @Provides
    fun providesRetrofit(accessTokenProvider: AccessTokenProvider): AppRemoteService = Retrofit.Builder()
        .baseUrl((BuildConfig.DEBUG).iif({ AppRemoteService.BASE_DEBUG_API_URL}, { AppRemoteService.BASE_API_URL } ))
        .addConverterFactory(GsonConverterFactory.create(AppRemoteService.makeGson()))
        .client(AppRemoteService.makeOkHttpClient(accessTokenProvider))
        .build().create(AppRemoteService::class.java)
}