package com.example.datastoreexample.data

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.app.UserPrefs.*
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

/**
 * File Name
 */
const val PERSON_PROTO_NAME = "person_proto"

/**
 * Serializer
 */
object PersonSerializer : Serializer<Person> {
    override val defaultValue: Person = Person.getDefaultInstance()
    override suspend fun readFrom(input: InputStream): Person {
        try {
            return Person.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: Person, output: OutputStream) = t.writeTo(output)
}