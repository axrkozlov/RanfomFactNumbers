package com.example.ranfomfactnumbers.numbers.data.cache

import android.content.Context
import androidx.room.Room

interface CacheModule {

    fun provideDatabase(): NumbersDatabase

    class Base(private val context: Context) : CacheModule {

        private val database: NumbersDatabase by lazy {
            Room.databaseBuilder(context, NumbersDatabase::class.java, "numbers_database")
                .fallbackToDestructiveMigration()
                .build()
        }

        override fun provideDatabase() = database

    }

}