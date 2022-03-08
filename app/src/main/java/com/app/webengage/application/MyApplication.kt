package com.app.webengage.application

import android.app.Application
import android.graphics.Color
import com.app.webengage.BuildConfig
import com.app.webengage.R
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree
import com.webengage.sdk.android.WebEngageConfig
import com.webengage.sdk.android.WebEngageActivityLifeCycleCallbacks
import com.google.firebase.messaging.FirebaseMessaging
import com.webengage.sdk.android.WebEngage



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
            .setPushSmallIcon(R.drawable.ic_back)
            .setPushLargeIcon(R.drawable.ic_back)
            .setPushAccentColor(Color.parseColor("#ff0000"))
            .build()
        registerActivityLifecycleCallbacks(
            WebEngageActivityLifeCycleCallbacks(
                this,
                webEngageConfig
            )
        )

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            try {
                val token: String? = task.result
                WebEngage.get().setRegistrationID(token)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }
}
