package com.nikitacherenkov.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nikitacherenkov.shoppinglist.R
import com.nikitacherenkov.shoppinglist.data.db.entities.ShoppingEntity
import com.nikitacherenkov.shoppinglist.ui.shopping_list_screen.ShoppingListScreenViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingEntity> = listOf(),
    private val viewModel: ShoppingListScreenViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem= items[position]

        val ivDelete = holder.itemView.findViewById<ImageView>(R.id.delete)
        val ivAdd = holder.itemView.findViewById<ImageView>(R.id.plus)
        val ivRemove = holder.itemView.findViewById<ImageView>(R.id.minus)


        holder.itemView.findViewById<TextView>(R.id.name).text = curShoppingItem.name
        holder.itemView.findViewById<TextView>(R.id.amount).text = curShoppingItem.amount.toString()

        ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }
        ivAdd.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }
        ivRemove.setOnClickListener {
            if (curShoppingItem.amount > 0){
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}