package com.example.ranfomfactnumbers.main

import android.app.Application
import com.example.ranfomfactnumbers.main.di.coreModule
import com.example.ranfomfactnumbers.numbers.di.numbersModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(coreModule, numbersModule))
        }
    }

}