package com.example.datastoreexample.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.app.UserPrefs
import com.example.datastoreexample.data.PreferencesKeys.PERSON_AGE
import com.example.datastoreexample.data.PreferencesKeys.PERSON_NAME
import com.example.datastoreexample.domain.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PersonRepositoryImpl(
    private val protoDataStore: DataStore<UserPrefs.Person>,
    private val prefDataStore: DataStore<Preferences>
): PersonRepository {

    /**
     * Proto DataStore
     */
    override suspend fun updateAgeProto(age: Int) {
        protoDataStore.updateData { preferences ->
            preferences.toBuilder().setAge(age).build()
        }
    }

    override suspend fun updateNameProto(name: String) {
        protoDataStore.updateData { preferences ->
            preferences.toBuilder().setName(name).build()
        }
    }

    override fun readAgeProto(): Flow<Int> =
        protoDataStore.data.map {
            it.age
        }

    override fun readNameProto(): Flow<String> =
        protoDataStore.data.map {
            it.name
        }

    /**
     * Preferences DataStore
     */
    override suspend fun updateAgePref(age: Int) {
        prefDataStore.edit { preferences ->
            preferences[PERSON_AGE] = age
        }
    }

    override suspend fun updateNamePref(name: String) {
        prefDataStore.edit { preferences ->
            preferences[PERSON_NAME] = name
        }
    }

    override fun readAgePref(): Flow<Int> =
        prefDataStore.data.map { preferences ->
            preferences[PERSON_AGE] ?: 0
        }


    override fun readNamePref(): Flow<String> =
        prefDataStore.data.map { preferences ->
            preferences[PERSON_NAME] ?: ""
        }
}