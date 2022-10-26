package com.cursosandroidant.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.cursosandroidant.list.pojos.ItemEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainInteractor {
    //val items: LiveData<MutableList<ItemEntity>> = ListApplication.database.itemDao().getAllItems()
    val items: LiveData<MutableList<ItemEntity>> = liveData {
        val itemsLiveData = ListApplication.database.itemDao().getAllItems()
        emitSource(itemsLiveData)
    }

    suspend fun addItem(itemEntity: ItemEntity) = withContext(Dispatchers.IO) {
        try {
            ListApplication.database.itemDao().addItem(itemEntity)
        } catch (e: Exception) {
            throw Exception("Error al insertar.")
        }
    }

    suspend fun updateItem(itemEntity: ItemEntity) = withContext(Dispatchers.IO){
        try {
            val result = ListApplication.database.itemDao().updateItem(itemEntity)
            if (result == 0) throw Exception("Error al actualizar.")
        } catch (e: Exception) {
            throw Exception("Error grave al actualizar.")
        }
    }
}