package com.app.mymainapp.application

import android.app.Application
import com.app.mymainapp.BuildConfig
import com.app.mymainapp.R
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree
import com.webengage.sdk.android.WebEngageConfig;
import com.webengage.sdk.android.WebEngageActivityLifeCycleCallbacks;


@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }

        val webEngageConfig = WebEngageConfig.Builder()
            .setWebEngageKey(getString(R.string.licenseKey))
            .setDebugMode(true) // only in development mode
            .setSessionDestroyTime(40) //Value to be set in seconds
            .build()
        registerActivityLifecycleCallbacks(
            WebEngageActivityLifeCycleCallbacks(
                this,
                webEngageConfig
            )
        )
    }
}
