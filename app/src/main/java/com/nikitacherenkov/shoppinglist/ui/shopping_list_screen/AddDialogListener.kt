package com.nikitacherenkov.shoppinglist.ui.shopping_list_screen

import com.nikitacherenkov.shoppinglist.data.db.entities.ShoppingEntity

interface AddDialogListener {
    fun onAddButtonClicked(item : ShoppingEntity)
}