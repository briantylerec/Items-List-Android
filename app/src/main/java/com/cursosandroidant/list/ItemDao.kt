package com.cursosandroidant.list

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cursosandroidant.list.pojos.ItemEntity

@Dao
interface ItemDao {
    @Query("SELECT * FROM ItemEntity")
    fun getAllItems(): LiveData<MutableList<ItemEntity>>

    @Insert
    suspend fun addItem(itemEntity: ItemEntity): Long

    @Update
    suspend fun updateItem(itemEntity: ItemEntity): Int
}