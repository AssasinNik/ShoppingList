package com.nikitacherenkov.shoppinglist.data.db.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingEntity (
    @PrimaryKey
    @ColumnInfo(name = "itemName")
    val name: String,
    @ColumnInfo(name = "itemCategory")
    val category: String,
    @ColumnInfo(name = "itemAmount")
    var amount: Int,
)