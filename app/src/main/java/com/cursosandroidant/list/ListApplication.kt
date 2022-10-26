package com.cursosandroidant.list

import android.app.Application
import androidx.room.Room

class ListApplication : Application() {
    companion object{
        lateinit var database: ListDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this,
            ListDatabase::class.java,
            "ListDatabase")
            .build()
    }
}