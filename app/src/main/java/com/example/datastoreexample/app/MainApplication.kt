package com.example.datastoreexample.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            // android context 설정
            androidContext(this@MainApplication.applicationContext)

            // modules setting
            modules(
                listOf(
                    appModule
                )
            )
        }
    }
}