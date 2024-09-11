package com.nikitacherenkov.shoppinglist.ui.shopping_list_screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.nikitacherenkov.shoppinglist.R
import com.nikitacherenkov.shoppinglist.data.db.ShoppingDatabase
import com.nikitacherenkov.shoppinglist.data.repositories.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shopping)

        val db = ShoppingDatabase(this)
        val repository = ShoppingRepository(db = db)
        val factory = ShoppingViewModelFactory(repository = repository)
        val viewModel = ViewModelProviders.of(this, factory)[ShoppingListScreenViewModel::class.java]
    }
}