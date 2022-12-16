package com.example.datastoreexample.data

import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

/**
 * File Name
 */
const val PERSON_PREFERENCES_NAME = "person_preferences"

/**
 * Preferences Key
 */
object PreferencesKeys {
    val PERSON_NAME = stringPreferencesKey("person_name")
    val PERSON_AGE = intPreferencesKey("person_age")
}