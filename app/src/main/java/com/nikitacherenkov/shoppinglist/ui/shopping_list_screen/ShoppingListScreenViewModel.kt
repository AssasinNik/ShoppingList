package com.nikitacherenkov.shoppinglist.ui.shopping_list_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikitacherenkov.shoppinglist.data.db.entities.ShoppingEntity
import com.nikitacherenkov.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingListScreenViewModel(
    private val repository: ShoppingRepository
): ViewModel() {

    fun upsert(item : ShoppingEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.upsert(item)
        }
    }

    fun delete(item : ShoppingEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(item)
        }
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}