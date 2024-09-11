package com.nikitacherenkov.shoppinglist.data.repositories

import com.nikitacherenkov.shoppinglist.data.db.ShoppingDatabase
import com.nikitacherenkov.shoppinglist.data.db.entities.ShoppingEntity

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingEntity) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingEntity) = db.getShoppingDao().delete(item)

    suspend fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}