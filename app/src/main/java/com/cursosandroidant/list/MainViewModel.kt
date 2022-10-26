package com.cursosandroidant.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursosandroidant.list.pojos.ItemEntity
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var interactor = MainInteractor()

    val items = interactor.items

    val errorMsg: MutableLiveData<String> = MutableLiveData()

    fun addItem(itemEntity: ItemEntity){
        viewModelScope.launch {
            try {
                interactor.addItem(itemEntity)
            } catch (e: Exception) {
                errorMsg.value = e.message
            }
        }
    }

    fun updateItem(itemEntity: ItemEntity){
        viewModelScope.launch {
            itemEntity.isFavorite = !itemEntity.isFavorite

            try {
                interactor.updateItem(itemEntity)
            } catch (e: Exception) {
                errorMsg.value = e.message
            }
        }
    }
}