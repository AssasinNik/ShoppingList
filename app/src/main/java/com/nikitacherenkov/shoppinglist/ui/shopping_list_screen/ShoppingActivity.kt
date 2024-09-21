package com.nikitacherenkov.shoppinglist.ui.shopping_list_screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nikitacherenkov.shoppinglist.R
import com.nikitacherenkov.shoppinglist.data.db.ShoppingDatabase
import com.nikitacherenkov.shoppinglist.data.db.entities.ShoppingEntity
import com.nikitacherenkov.shoppinglist.data.repositories.ShoppingRepository
import com.nikitacherenkov.shoppinglist.other.ShoppingItemAdapter

class ShoppingActivity : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shopping)

        val db = ShoppingDatabase(this)
        val repository = ShoppingRepository(db = db)
        val factory = ShoppingViewModelFactory(repository = repository)
        val viewModel = ViewModelProviders.of(this, factory)[ShoppingListScreenViewModel::class.java]

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

       val rvShoppingItems = findViewById<RecyclerView>(R.id.rvShoppingItems)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this) { shoppingItems ->
            adapter.items = shoppingItems
            adapter.notifyDataSetChanged()
        }

        val flBt = findViewById<FloatingActionButton>(R.id.flBt)

        flBt.setOnClickListener{
            AddShoppingItemDialog(context = this,
                object: AddDialogListener{
                    override fun onAddButtonClicked(item: ShoppingEntity) {
                        viewModel.upsert(item)
                    }
                }).show()
        }
    }
}