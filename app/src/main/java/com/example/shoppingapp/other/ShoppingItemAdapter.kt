package com.example.shoppingapp.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.R
import com.example.shoppingapp.data.database.entity.ShoppingItemEntity
import com.example.shoppingapp.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var item: List<ShoppingItemEntity>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {


    //Inflate out Item XML
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    //Define Recyclerview Size
    override fun getItemCount(): Int {
        return item.size
    }

    //Bind Data to the Views
    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = item[position]

        holder.itemView.findViewById<TextView>(R.id.tvName).text = currentShoppingItem.name
        holder.itemView.findViewById<TextView>(R.id.tvAmount).text = "${currentShoppingItem.amount}"

        holder.itemView.findViewById<ImageView>(R.id.ivDelete).setOnClickListener {
            viewModel.deleteShoppingItem(currentShoppingItem)
        }

        holder.itemView.findViewById<ImageView>(R.id.ivPlus).setOnClickListener {
            currentShoppingItem.amount++
            viewModel.insertShoppingItem(currentShoppingItem)
        }

        holder.itemView.findViewById<ImageView>(R.id.ivMinus).setOnClickListener {
            if(currentShoppingItem.amount > 0) {
                currentShoppingItem.amount--
                viewModel.insertShoppingItem(currentShoppingItem)
            }
        }
    }

    //View Holder Class which holds the itemView
    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}