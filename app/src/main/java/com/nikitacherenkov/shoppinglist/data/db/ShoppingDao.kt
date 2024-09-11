package com.nikitacherenkov.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.nikitacherenkov.shoppinglist.data.db.entities.ShoppingEntity

@Dao
interface ShoppingDao {

    @Upsert
    suspend fun upsert(item: ShoppingEntity)

    @Delete
    suspend fun delete(item: ShoppingEntity)

    @Query("SELECT * FROM shopping_items")
    suspend fun getAllShoppingItems(): LiveData<List<ShoppingEntity>>
}