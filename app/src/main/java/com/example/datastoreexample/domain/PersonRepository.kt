package com.example.datastoreexample.domain

import kotlinx.coroutines.flow.Flow

interface PersonRepository {

    /**
     * Proto DataStore
     */
    suspend fun updateAgeProto(age: Int)

    suspend fun updateNameProto(name: String)

    fun readAgeProto(): Flow<Int>

    fun readNameProto(): Flow<String>

    /**
     * Preferences DataStore
     */
    suspend fun updateAgePref(age: Int)

    suspend fun updateNamePref(name: String)

    fun readAgePref(): Flow<Int>

    fun readNamePref(): Flow<String>
}