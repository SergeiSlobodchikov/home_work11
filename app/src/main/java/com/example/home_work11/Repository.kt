package com.example.home_work11

import android.content.Context
import android.content.Context.MODE_PRIVATE


private const val PREFERENCE_NAME = "prefs_name"
private const val  KEY_STRING_NAME = "KEY_STRING"

class Repository(context: Context) {
    private var text: String? = null
    private val sharedPref = context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)

    fun getDataFromSharedPreference(): String? {
        return sharedPref.getString(KEY_STRING_NAME, null)
    }

    fun getDataFromLocalVariable(): String? {
        return text
    }

    fun saveText(text: String) {
        this.text = text
        sharedPref.edit().putString(KEY_STRING_NAME, text).apply()
    }

    fun clearText() {
        this.text = null
        sharedPref.edit().remove(KEY_STRING_NAME).apply()
    }

    fun getText(): String? {
        return if (text != null) {
            text
        } else {
            getDataFromSharedPreference()
        }
    }
}