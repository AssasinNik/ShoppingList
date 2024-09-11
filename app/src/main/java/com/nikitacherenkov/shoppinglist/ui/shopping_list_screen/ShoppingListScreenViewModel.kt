package com.nikitacherenkov.shoppinglist.ui.shopping_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikitacherenkov.shoppinglist.data.db.entities.ShoppingEntity
import com.nikitacherenkov.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingListScreenViewModel(
    private val repository: ShoppingRepository
): ViewModel() {

    private fun upsert(item : ShoppingEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.upsert(item)
        }
    }

    private fun delete(item : ShoppingEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(item)
        }
    }

    private fun getAllShoppingItems(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllShoppingItems()
        }
    }
}