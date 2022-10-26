package com.cursosandroidant.list.pojos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ItemEntity")
data class ItemEntity(@PrimaryKey(autoGenerate = true) var id: Long = 0,
                      var text: String,
                      var isFavorite: Boolean = false)
