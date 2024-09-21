package com.nikitacherenkov.shoppinglist.ui.shopping_list_screen

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import androidx.core.text.isDigitsOnly
import com.nikitacherenkov.shoppinglist.R
import com.nikitacherenkov.shoppinglist.data.db.entities.ShoppingEntity

class AddShoppingItemDialog(
    context: Context,
    var addDialogListener: AddDialogListener
) : AppCompatDialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        val btAdd = findViewById<Button>(R.id.btAdd)

        btAdd?.setOnClickListener {
            val edName = findViewById<EditText>(R.id.edName)
            val edAmount = findViewById<EditText>(R.id.edAmount)
            val edCategory = findViewById<EditText>(R.id.edCategory)
            val name = edName?.text.toString()
            val amount = edAmount?.text.toString()
            val category = edCategory?.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context, "Please all data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                if(amount.isDigitsOnly()){
                    val item = ShoppingEntity(name, category, amount.toInt())
                    addDialogListener.onAddButtonClicked(item)
                    dismiss()
                }
                else{
                    Toast.makeText(context, "Amount must be digit", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }
        }

        val ivClose = findViewById<ImageView>(R.id.ivClose)

        ivClose?.setOnClickListener {
            cancel()
        }
    }
}