package com.cursosandroidant.list

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cursosandroidant.list.pojos.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
abstract class ListDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}