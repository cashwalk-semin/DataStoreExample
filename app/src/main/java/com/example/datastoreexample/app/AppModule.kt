package com.example.datastoreexample.app

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.app.UserPrefs
import com.example.datastoreexample.data.PERSON_PREFERENCES_NAME
import com.example.datastoreexample.data.PERSON_PROTO_NAME
import com.example.datastoreexample.data.PersonRepositoryImpl
import com.example.datastoreexample.data.PersonSerializer
import com.example.datastoreexample.domain.PersonRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val Context.personProtoDataStore: DataStore<UserPrefs.Person> by dataStore(
    fileName = PERSON_PROTO_NAME,
    serializer = PersonSerializer
)

val Context.personPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
    name = PERSON_PREFERENCES_NAME
)


val appModule = module {

    single<PersonRepository> { PersonRepositoryImpl(androidContext().personProtoDataStore, androidContext().personPreferencesDataStore) }
}