package io.github.afalalabarce.mvvmproject

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CustomApplication: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
    }
}