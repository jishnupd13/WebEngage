package com.app.webengage.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject


/** Created by Jishnu P Dileep on 26-05-2021 */

class PreferenceHandler @Inject constructor(
    val sharedPreferences: SharedPreferences
) {

    var userToken: String
        get() = sharedPreferences.getString("token", "") ?: ""
        set(value) = sharedPreferences.edit { putString("token", value) }

    var webEngageId: String
        get() = sharedPreferences.getString("webEngageId", "") ?: ""
        set(value) = sharedPreferences.edit { putString("webEngageId", value) }

    var userDetailsInitialized: Boolean
        get() = sharedPreferences.getBoolean("userDetailsInitialized",false)
        set(value) = sharedPreferences.edit { putBoolean("userDetailsInitialized", value) }
}